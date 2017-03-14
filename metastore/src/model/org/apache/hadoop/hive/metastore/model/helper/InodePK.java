package org.apache.hadoop.hive.metastore.model.helper;

public class InodePK {
  public Integer partitionId;
  public Integer parentId;
  public String name;

  public InodePK(Integer partitionId, Integer parentId, String name) {
    this.partitionId = partitionId;
    this.parentId = parentId;
    this.name = name;
  }

  public InodePK() {
    this.partitionId = null;
    this.parentId = null;
    this.name = null;
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof InodePK)){
      return false;
    } else {
      InodePK oPk = (InodePK) (o);
      if (this.partitionId != null) {
        return this.partitionId.equals(oPk.partitionId) && this.parentId.equals(oPk.parentId) && this.name.equals(oPk.name);
      } else {
        return oPk.partitionId == null && oPk.parentId == null && oPk.name == null;
      }
    }
  }
}
