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

package org.apache.hadoop.hive.metastore;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hive.conf.HiveConf;
import org.apache.hadoop.hive.metastore.api.MetaException;
import org.apache.hadoop.hive.metastore.model.helper.InodeHelper;
import org.apache.hadoop.hive.metastore.model.helper.InodePK;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.*;

public class TestInodeHelper {

  private InodeHelper inodeHelper = null;
  private HiveConf hiveConf = null;

  @Before
  public void setUp() throws Exception {
    hiveConf = new HiveConf(this.getClass());
    inodeHelper = InodeHelper.getInstance();
  }

  @After
  public void tearDown() throws Exception{

  }

  @Test
  public void TestTmp() throws MetaException{
    InodePK inodePk = inodeHelper.getInodePK("hdfs://0.0.0.0:0/tmp");
    Assert.assertEquals("tmp", inodePk.name);
    Assert.assertEquals(new Long(1), inodePk.parentId);
  }

  @Test
  public void TestEmpty() throws MetaException{
    InodePK inodePk = inodeHelper.getInodePK(null);
    Assert.assertEquals(inodePk, new InodePK());
  }

  @Test
  public void TestRandom() throws MetaException, SQLException {
    Warehouse wh = new Warehouse(hiveConf);
    // Create directory in the warehouse
    Path path = new Path(wh.getWhRoot(), "testdir");
    wh.mkdirs(path, true);

    // Resolve the inode
    InodePK inodePk = inodeHelper.getInodePK(path.toString());

    // Assert the dir is correct and that the parent is the warehouse dir
    Assert.assertEquals("testdir", inodePk.name);

    Connection conn = DriverManager.getConnection(hiveConf.getVar(HiveConf.ConfVars.HOPSDBURLKEY),
        hiveConf.getVar(HiveConf.ConfVars.METASTORE_CONNECTION_USER_NAME),
        hiveConf.getVar(HiveConf.ConfVars.METASTOREPWD));

    PreparedStatement stmt = conn.prepareStatement(
          "SELECT id FROM hdfs_inodes WHERE id = ?" +
              " and name = ?");
    stmt.setLong(1, inodePk.parentId);
    stmt.setString(2, wh.getWhRoot().getName());
    ResultSet rs = stmt.executeQuery();

    if (!rs.next()) {
      throw new MetaException("Parent inode not found");
    }

    rs.close();
    stmt.close();
  }
}
