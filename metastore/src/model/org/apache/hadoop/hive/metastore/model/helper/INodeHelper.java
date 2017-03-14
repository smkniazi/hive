package org.apache.hadoop.hive.metastore.model;

/**
 * This class helps retrieve the inode id given the path of the file/directory
 */

public class INodeHelper {

  private class
  public static Inode getInode(String path) {
    // Get the path components
    String[] p;
    if (path.charAt(0) == '/') {
      p = path.substring(1).split("/");
    } else {
      p = path.split("/");
    }

    if (p.length < 1) {
      return null;
    }

    //Get the right root node
    Inode curr = getRootNode(p[0]);
    if (curr == null) {
      logger.log(Level.WARNING, "Could not resolve root inode at path: {0}", path);
      return null;
    }

    //Move down the path
    for (int i = 1; i < p.length; i++) {
      int partitionId = HopsUtils.calculatePartitionId(curr.getId(), p[i], i+1);
      Inode next = findByInodePK(curr, p[i], partitionId);
      if (next == null) {
        logger.log(Level.WARNING, "Could not resolve inode at path: {0} and path-component " + i, path);
        return null;
      } else {
        curr = next;
      }
    }
    return curr;
  }

  private Inode getRootNode(String name) {
    int partitionId = HopsUtils.calculatePartitionId(HopsUtils.ROOT_INODE_ID, name, HopsUtils.ROOT_DIR_DEPTH + 1);
    TypedQuery<Inode> query = em.createNamedQuery("Inode.findRootByName",
        Inode.class);
    query.setParameter("name", name);
    query.setParameter("parentId", HopsUtils.ROOT_INODE_ID);
    query.setParameter("partitionId", partitionId);
    try {
      //Sure to give a single result because all children of same parent "null"
      //so name is unique
      return query.getSingleResult();
    } catch (NoResultException e) {
      logger.log(Level.WARNING,
          "Could not resolve root inode with name: {0} and partition_id"
              + partitionId, name);
      return null;
    }
  }

}
