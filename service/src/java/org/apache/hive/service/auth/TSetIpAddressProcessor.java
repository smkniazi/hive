/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.hive.service.auth;

import org.apache.hadoop.hive.conf.HiveConf;
import org.apache.hive.service.rpc.thrift.TCLIService;
import org.apache.hive.service.rpc.thrift.TCLIService.Iface;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLException;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import java.net.InetAddress;
import java.net.Socket;
import javax.security.cert.X509Certificate;

/**
 * This class is responsible for setting the ipAddress for operations executed via HiveServer2.
 * <p>
 * <ul>
 * <li>IP address is only set for operations that calls listeners with hookContext</li>
 * <li>IP address is only set if the underlying transport mechanism is socket</li>
 * </ul>
 * </p>
 *
 * @see org.apache.hadoop.hive.ql.hooks.ExecuteWithHookContext
 */
public class TSetIpAddressProcessor<I extends Iface> extends TCLIService.Processor<Iface> {

  private static final Logger LOGGER = LoggerFactory.getLogger(TSetIpAddressProcessor.class.getName());
  private HiveConf hiveConf = null;

  public TSetIpAddressProcessor(Iface iface) {
    super(iface);
    hiveConf = new HiveConf(this.getClass());
  }

  @Override
  public boolean process(final TProtocol in, final TProtocol out) throws TException {
    setIpAddress(in);
    setUserName(in);
    try {
      return super.process(in, out);
    } finally {
      THREAD_LOCAL_USER_NAME.remove();
      THREAD_LOCAL_IP_ADDRESS.remove();
    }
  }

  private void setUserName(final TProtocol in) throws TException {
    TTransport transport = in.getTransport();
    Socket socket = getUnderlyingSocketFromTransport(transport).getSocket();
    if (transport instanceof TSaslServerTransport) {
      String userName = ((TSaslServerTransport) transport).getSaslServer().getAuthorizationID();
      THREAD_LOCAL_USER_NAME.set(userName);
    } else if (socket instanceof SSLSocket){
      try {
        X509Certificate[] certs = ((SSLSocket) socket).getSession().getPeerCertificateChain();

        // Make sure it's 2 way ssl, i.e. client certificate is available
        if (certs.length == 0) {
          return;
        }
        // Client certificate is always the first
        String DN = certs[0].getSubjectDN().getName();
        String[] dnTokens = DN.split(",");
        String[] cnTokens = dnTokens[0].split("=", 2);
        if (cnTokens.length != 2) {
          throw new TException("Cannot authenticate the user: Unrecognized CN format");
        }

        if (cnTokens[1].contains("__")) {
          // The certificate is in the format projectName__userName
          THREAD_LOCAL_USER_NAME.set(cnTokens[1]);
        } else {
          InetAddress hostnameIp = null;
          try {
            // Hostname resolution and check against the ip of the machine doing the request
            hostnameIp = InetAddress.getByName(cnTokens[1]);
          } catch (java.net.UnknownHostException ex) {
            LOGGER.error("Cannot resolve machine address: ", ex);
            throw new TException("Cannot authenticate the user");
          }

          if (!hostnameIp.getHostAddress().equals(THREAD_LOCAL_IP_ADDRESS.get())) {
            // The requests doesn't come from the same machine of the certificate.
            // Something shady is happening here. Do not authenticate the user.
            LOGGER.error("Superuser request coming from a different host");
            throw new TException("Cannot authenticate the user");
          }

          // Operate as superuser
          THREAD_LOCAL_USER_NAME.set(hiveConf.getVar(HiveConf.ConfVars.HIVE_SUPER_USER));
        }
      } catch (SSLException e) {
        /* Peer not verified. If HOPS auth method, user might be trying to authenticate using username/password
        * Don't set the username, if no username/password is provide during open session then throws an exception */
      }
    }

  }

  protected void setIpAddress(final TProtocol in) {
    TTransport transport = in.getTransport();
    TSocket tSocket = getUnderlyingSocketFromTransport(transport);
    if (tSocket == null) {
      LOGGER.warn("Unknown Transport, cannot determine ipAddress");
    } else {
      THREAD_LOCAL_IP_ADDRESS.set(tSocket.getSocket().getInetAddress().getHostAddress());
    }
  }

  private TSocket getUnderlyingSocketFromTransport(TTransport transport) {
    while (transport != null) {
      if (transport instanceof TSaslServerTransport) {
        transport = ((TSaslServerTransport) transport).getUnderlyingTransport();
      }
      if (transport instanceof TSaslClientTransport) {
        transport = ((TSaslClientTransport) transport).getUnderlyingTransport();
      }
      if (transport instanceof TSocket) {
        return (TSocket) transport;
      }
    }
    return null;
  }

  private static final ThreadLocal<String> THREAD_LOCAL_IP_ADDRESS = new ThreadLocal<String>() {
    @Override
    protected String initialValue() {
      return null;
    }
  };

  private static final ThreadLocal<String> THREAD_LOCAL_USER_NAME = new ThreadLocal<String>() {
    @Override
    protected String initialValue() {
      return null;
    }
  };

  public static String getUserIpAddress() {
    return THREAD_LOCAL_IP_ADDRESS.get();
  }

  public static String getUserName() {
    return THREAD_LOCAL_USER_NAME.get();
  }
}
