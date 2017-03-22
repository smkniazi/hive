package org.apache.hadoop.hive.metastore;

import org.apache.hadoop.hive.conf.HiveConf;
import org.apache.hadoop.hive.metastore.model.helper.InodeHelper;
import org.apache.hadoop.hive.metastore.model.helper.InodePK;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;

public class TestInodeHelper {

  private HiveConf hiveConf = null;
  private InodeHelper inodeHelper = null;

  @Before
  public void setUp() throws Exception {
    hiveConf = new HiveConf(this.getClass());
    hiveConf.setVar(HiveConf.ConfVars.HOPSDBURLKEY, "jdbc:mysql://bbc1.sics.se:13010/hops");
    hiveConf.setVar(HiveConf.ConfVars.METASTOREPWD, "hive");
    hiveConf.setVar(HiveConf.ConfVars.METASTORE_CONNECTION_USER_NAME, "hive");

    inodeHelper = InodeHelper.getInstance();
    inodeHelper.initConnections(hiveConf);
  }

  @Test
  public void TestTmp() {
    InodePK inodePk = inodeHelper.getInodePK("hdfs://10.0.2.15:8020/tmp");
    Assert.assertEquals(inodePk, new InodePK(3564026, 1, "tmp"));
  }

  @Test
  public void TestEmpty() {
    InodePK inodePk = inodeHelper.getInodePK(null);
    Assert.assertEquals(inodePk, new InodePK());
  }

  @Test
  public void TestRandom() {
    String path = "hdfs://10.0.2.15/user/glassfish/glassfish/warehouse/";
    InodePK inodePk = inodeHelper.getInodePK(path);
    Assert.assertEquals(inodePk, new InodePK(17,17,"warehouse"));
  }
}
