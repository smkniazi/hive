package org.apache.hive.service.auth;

import org.apache.hadoop.hive.conf.HiveConf;
import org.apache.hive.service.rpc.thrift.TCLIService;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSocket;
import javax.security.cert.X509Certificate;
import java.net.InetAddress;
import java.net.Socket;


public class TSSLBasedProcessor<I extends TCLIService.Iface> extends TSetIpAddressProcessor<TCLIService.Iface> {
  private static final Logger LOGGER = LoggerFactory.getLogger(TSetIpAddressProcessor.class.getName());
  private HiveConf hiveConf = null;

  public TSSLBasedProcessor(TCLIService.Iface iface, HiveConf hiveConf) {
    super(iface);
    this.hiveConf = hiveConf;
  }

  @Override
  protected void setUserName(final TProtocol in) throws TException {

    // Do not check the certificates if the username has already been set for this connection
    if (THREAD_LOCAL_USER_NAME.get() != null) {
      return;
    }

    try {
      TTransport transport = in.getTransport();
      Socket socket = ((TSocket) transport).getSocket();
      X509Certificate[] certs = ((SSLSocket) socket).getSession().getPeerCertificateChain();

      // Make sure it's 2 way ssl, i.e. client certificate is available
      if (certs.length == 0) {
        throw new TException("Missing certificates");
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
      throw new TException(e);
    }
  }
}
