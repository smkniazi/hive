package org.apache.hadoop.hive.metastore;

import org.apache.hadoop.hive.conf.HiveConf;
import org.apache.hadoop.hive.metastore.api.MetaException;
import org.apache.hadoop.hive.metastore.model.helper.InodeHelper;
import org.apache.hadoop.hive.metastore.model.helper.InodePK;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;

import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

public class TestInodeHelper {

  private HiveConf hiveConf = null;
  private InodeHelper inodeHelper = null;
  private Connection conn = null;

  @Before
  public void setUp() throws Exception {
    hiveConf = new HiveConf(this.getClass());

    // Insert fake data into the database
    conn = DriverManager.getConnection(hiveConf.getVar(HiveConf.ConfVars.HOPSDBURLKEY),
        hiveConf.getVar(HiveConf.ConfVars.METASTORE_CONNECTION_USER_NAME),
        hiveConf.getVar(HiveConf.ConfVars.METASTOREPWD));
    Statement stmt = conn.createStatement();
    stmt.execute("insert into hdfs_inodes(partition_id, parent_id, name, id, size, quota_enabled, is_dir, under_construction) " +
                    "values (0,0,\"\", 1, 0, 0, 1, 0)," +
                    "(3564026, 1, \"tmp\", 2, 0, 0, 1, 0),"+
                    "(111578566, 1, \"user\", 3, 0, 0, 1, 0),"+
                    "(3, 3, \"glassfish\", 4, 0, 0, 1, 0)," +
                    "(4, 4, \"warehouse\", 12, 0, 0, 1, 0)");
    stmt.close();
    inodeHelper = InodeHelper.getInstance();
  }

  @After
  public void tearDown() throws Exception{
    Statement stmt = conn.createStatement();
    stmt.execute("delete from hdfs_inodes");
    stmt.close();
    conn.close();
  }

  @Test
  public void TestTmp() throws MetaException{
    InodePK inodePk = inodeHelper.getInodePK("hdfs://10.0.2.15:8020/tmp");
    Assert.assertEquals(inodePk, new InodePK(3564026, 1, "tmp"));
  }

  @Test
  public void TestEmpty() throws MetaException{
    InodePK inodePk = inodeHelper.getInodePK(null);
    Assert.assertEquals(inodePk, new InodePK());
  }

  @Test
  public void TestRandom() throws MetaException{
    String path = "hdfs://10.0.2.15/user/glassfish/warehouse/";
    InodePK inodePk = inodeHelper.getInodePK(path);
    Assert.assertEquals(inodePk, new InodePK(4,4,"warehouse"));
  }
}
