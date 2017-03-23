package org.apache.hadoop.hive.metastore.model.helper;

import org.apache.hadoop.hive.conf.HiveConf;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import org.apache.hadoop.hive.metastore.api.MetaException;
import org.apache.hadoop.yarn.webapp.hamlet.HamletSpec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;

/**
 * This class helps retrieve the inode id given the path of the file/directory
 */

public class InodeHelper {

  /**
   * STATIC VARIABLES FOR HOPS
   * //TODO: SET THEM IN THE CONFIGURATION FILE.
   */
  private static final int ROOT_DIR_PARTITION_KEY = 0;
  private static final short ROOT_DIR_DEPTH = 0;
  private static final int RANDOM_PARTITIONING_MAX_LEVEL = 1;
  private static final int ROOT_INODE_ID = 1;

  private final Logger logger = LoggerFactory.getLogger(InodeHelper.class.getName());

  private static InodeHelper instance = null;

  private static HiveConf hiveConf = null;
  private static DataSource connPool = null;

  public static InodeHelper getInstance() {
    if (instance == null) {
      instance = new InodeHelper();
    }

    return instance;
  }

  private InodeHelper() {}

  public synchronized void initConnections(HiveConf conf) {
    if (connPool != null) { return; }

    // Setup connections.
    hiveConf = conf;
    HikariConfig config = new HikariConfig();
    config.setJdbcUrl(hiveConf.getVar(HiveConf.ConfVars.HOPSDBURLKEY));
    config.setUsername(hiveConf.getVar(HiveConf.ConfVars.METASTORE_CONNECTION_USER_NAME));
    config.setPassword(hiveConf.getVar(HiveConf.ConfVars.METASTOREPWD));

    connPool = new HikariDataSource(config);
  }

  private Connection getDbConn() throws SQLException {
    //Rety to get a connection up to 10 times
    int rc = 10;
    Connection dbConn = null;
    while (true) {
      try {
        dbConn = connPool.getConnection();
        return dbConn;
      } catch (SQLException e){
        if (dbConn != null && !dbConn.isClosed()) {
          dbConn.close();
        }
        if ((--rc) <= 0) throw e;
        logger.error("There is a problem with a connection from the pool, retrying", e);
      }
    }
  }

  public InodePK getInodePK(String path) throws MetaException{

    // Check for null paths (Virtual view case)
    if (path == null){
      return new InodePK();
    }

    // Check for empty strings.
    if (path.equals("")) {
      return new InodePK();
    }

    // Strip ip address and port hdfs://ip:port/path
    int pathSlashIdx = path.indexOf('/', 7);
    path = path.substring(pathSlashIdx, path.length());

    // Get connection from the pool
    Connection dbConn = null;
    try {
      dbConn = getDbConn();
    } catch (SQLException e) {
      throw new MetaException(e.getMessage());
    }

    int inodeId = getInodeID(dbConn, path);
    InodePK pk = findInodePK(dbConn, inodeId);

    try {
      dbConn.close();
    } catch (SQLException e) {
      throw new MetaException(e.getMessage());
    }

    return pk;
  }

  private int getInodeID(Connection dbConn, String path) throws MetaException{
    // Get the path components
    String[] p;
    if (path.charAt(0) == '/') {
      p = path.substring(1).split("/");
    } else {
      p = path.split("/");
    }

    if (p.length < 1) {
      return -1;
    }

    //Get the right root node
    int curr = getRootNode(dbConn, p[0]);
    if (curr == -1) {
      try {
        dbConn.close();
      } catch (SQLException e) { }
      throw new MetaException("Could not resolve inode at path: " + path);
    }

    //Move down the path
    for (int i = 1; i < p.length; i++) {
      int partitionId = calculatePartitionId(curr, p[i], i+1);
      int next = findByInodePK(dbConn, curr, p[i], partitionId);
      if (next == -1) {
        try {
          dbConn.close();
        } catch (SQLException e) { }
        throw new MetaException("Could not resolve inode at path: " + path);
      } else {
        curr = next;
      }
    }

    return curr;
  }

  private int getRootNode(Connection conn, String name) throws MetaException{
    int partitionId = calculatePartitionId(ROOT_INODE_ID, name, ROOT_DIR_DEPTH + 1);
    return findByInodePK(conn, ROOT_INODE_ID, name, partitionId);
  }

  private int findByInodePK(Connection conn, int parentId, String name, int partitionId) throws MetaException{
    PreparedStatement stmt = null;
    ResultSet rs = null;
    try {
      stmt = conn.prepareStatement(
          "SELECT id FROM hdfs_inodes WHERE partition_id = ? " +
              " and parent_id = ? " +
              " and name = ?");
      stmt.setInt(1, partitionId);
      stmt.setInt(2, parentId);
      stmt.setString(3, name);
      rs = stmt.executeQuery();
      if (rs.next()) {
        return rs.getInt("id");
      }
    } catch (SQLException e) {
      throw new MetaException(e.getMessage());
    } finally {
      try {
        if (rs != null) {
          rs.close();
        }
        if (stmt != null) {
          stmt.close();
        }
      } catch (SQLException e) {
        throw new MetaException(e.getMessage());
      }
    }

    return -1;
  }

  private InodePK findInodePK(Connection dbConn, int id) throws MetaException{
    PreparedStatement stmt = null;
    ResultSet rs = null;
    try {
      stmt = dbConn.prepareStatement(
          "SELECT partition_id, parent_id, name FROM hdfs_inodes WHERE id = ?");
      stmt.setInt(1, id);
      rs = stmt.executeQuery();
      if (rs.next()) {
        return new InodePK(rs.getInt("partition_id"),
            rs.getInt("parent_id"),
            rs.getString("name"));
      }
    } catch (SQLException e) {
      throw new MetaException(e.getMessage());
    } finally {
      try{
        if (rs != null) {
            rs.close();
        }
        if (stmt != null) {
            stmt.close();
        }
      } catch (SQLException e) {
        throw new MetaException(e.getMessage());
      }
    }

    return new InodePK();
  }

  private int calculatePartitionId(int parentId, String name, int depth) {
    if (depth <= RANDOM_PARTITIONING_MAX_LEVEL) {
      if (depth == ROOT_DIR_DEPTH) {
        return ROOT_DIR_PARTITION_KEY;
      } else {
        return (name + parentId).hashCode();
      }
    } else {
      return parentId;
    }
  }
}
