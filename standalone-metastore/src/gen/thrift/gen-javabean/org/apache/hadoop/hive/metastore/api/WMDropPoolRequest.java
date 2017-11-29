/**
 * Autogenerated by Thrift Compiler (0.9.3)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package org.apache.hadoop.hive.metastore.api;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import javax.annotation.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked"})
@Generated(value = "Autogenerated by Thrift Compiler (0.9.3)")
public class WMDropPoolRequest implements org.apache.thrift.TBase<WMDropPoolRequest, WMDropPoolRequest._Fields>, java.io.Serializable, Cloneable, Comparable<WMDropPoolRequest> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("WMDropPoolRequest");

  private static final org.apache.thrift.protocol.TField RESOURCE_PLAN_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("resourcePlanName", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField POOL_PATH_FIELD_DESC = new org.apache.thrift.protocol.TField("poolPath", org.apache.thrift.protocol.TType.STRING, (short)2);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new WMDropPoolRequestStandardSchemeFactory());
    schemes.put(TupleScheme.class, new WMDropPoolRequestTupleSchemeFactory());
  }

  private String resourcePlanName; // optional
  private String poolPath; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    RESOURCE_PLAN_NAME((short)1, "resourcePlanName"),
    POOL_PATH((short)2, "poolPath");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // RESOURCE_PLAN_NAME
          return RESOURCE_PLAN_NAME;
        case 2: // POOL_PATH
          return POOL_PATH;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final _Fields optionals[] = {_Fields.RESOURCE_PLAN_NAME,_Fields.POOL_PATH};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.RESOURCE_PLAN_NAME, new org.apache.thrift.meta_data.FieldMetaData("resourcePlanName", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.POOL_PATH, new org.apache.thrift.meta_data.FieldMetaData("poolPath", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(WMDropPoolRequest.class, metaDataMap);
  }

  public WMDropPoolRequest() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public WMDropPoolRequest(WMDropPoolRequest other) {
    if (other.isSetResourcePlanName()) {
      this.resourcePlanName = other.resourcePlanName;
    }
    if (other.isSetPoolPath()) {
      this.poolPath = other.poolPath;
    }
  }

  public WMDropPoolRequest deepCopy() {
    return new WMDropPoolRequest(this);
  }

  @Override
  public void clear() {
    this.resourcePlanName = null;
    this.poolPath = null;
  }

  public String getResourcePlanName() {
    return this.resourcePlanName;
  }

  public void setResourcePlanName(String resourcePlanName) {
    this.resourcePlanName = resourcePlanName;
  }

  public void unsetResourcePlanName() {
    this.resourcePlanName = null;
  }

  /** Returns true if field resourcePlanName is set (has been assigned a value) and false otherwise */
  public boolean isSetResourcePlanName() {
    return this.resourcePlanName != null;
  }

  public void setResourcePlanNameIsSet(boolean value) {
    if (!value) {
      this.resourcePlanName = null;
    }
  }

  public String getPoolPath() {
    return this.poolPath;
  }

  public void setPoolPath(String poolPath) {
    this.poolPath = poolPath;
  }

  public void unsetPoolPath() {
    this.poolPath = null;
  }

  /** Returns true if field poolPath is set (has been assigned a value) and false otherwise */
  public boolean isSetPoolPath() {
    return this.poolPath != null;
  }

  public void setPoolPathIsSet(boolean value) {
    if (!value) {
      this.poolPath = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case RESOURCE_PLAN_NAME:
      if (value == null) {
        unsetResourcePlanName();
      } else {
        setResourcePlanName((String)value);
      }
      break;

    case POOL_PATH:
      if (value == null) {
        unsetPoolPath();
      } else {
        setPoolPath((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case RESOURCE_PLAN_NAME:
      return getResourcePlanName();

    case POOL_PATH:
      return getPoolPath();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case RESOURCE_PLAN_NAME:
      return isSetResourcePlanName();
    case POOL_PATH:
      return isSetPoolPath();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof WMDropPoolRequest)
      return this.equals((WMDropPoolRequest)that);
    return false;
  }

  public boolean equals(WMDropPoolRequest that) {
    if (that == null)
      return false;

    boolean this_present_resourcePlanName = true && this.isSetResourcePlanName();
    boolean that_present_resourcePlanName = true && that.isSetResourcePlanName();
    if (this_present_resourcePlanName || that_present_resourcePlanName) {
      if (!(this_present_resourcePlanName && that_present_resourcePlanName))
        return false;
      if (!this.resourcePlanName.equals(that.resourcePlanName))
        return false;
    }

    boolean this_present_poolPath = true && this.isSetPoolPath();
    boolean that_present_poolPath = true && that.isSetPoolPath();
    if (this_present_poolPath || that_present_poolPath) {
      if (!(this_present_poolPath && that_present_poolPath))
        return false;
      if (!this.poolPath.equals(that.poolPath))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_resourcePlanName = true && (isSetResourcePlanName());
    list.add(present_resourcePlanName);
    if (present_resourcePlanName)
      list.add(resourcePlanName);

    boolean present_poolPath = true && (isSetPoolPath());
    list.add(present_poolPath);
    if (present_poolPath)
      list.add(poolPath);

    return list.hashCode();
  }

  @Override
  public int compareTo(WMDropPoolRequest other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetResourcePlanName()).compareTo(other.isSetResourcePlanName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetResourcePlanName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.resourcePlanName, other.resourcePlanName);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetPoolPath()).compareTo(other.isSetPoolPath());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPoolPath()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.poolPath, other.poolPath);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("WMDropPoolRequest(");
    boolean first = true;

    if (isSetResourcePlanName()) {
      sb.append("resourcePlanName:");
      if (this.resourcePlanName == null) {
        sb.append("null");
      } else {
        sb.append(this.resourcePlanName);
      }
      first = false;
    }
    if (isSetPoolPath()) {
      if (!first) sb.append(", ");
      sb.append("poolPath:");
      if (this.poolPath == null) {
        sb.append("null");
      } else {
        sb.append(this.poolPath);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class WMDropPoolRequestStandardSchemeFactory implements SchemeFactory {
    public WMDropPoolRequestStandardScheme getScheme() {
      return new WMDropPoolRequestStandardScheme();
    }
  }

  private static class WMDropPoolRequestStandardScheme extends StandardScheme<WMDropPoolRequest> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, WMDropPoolRequest struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // RESOURCE_PLAN_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.resourcePlanName = iprot.readString();
              struct.setResourcePlanNameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // POOL_PATH
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.poolPath = iprot.readString();
              struct.setPoolPathIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, WMDropPoolRequest struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.resourcePlanName != null) {
        if (struct.isSetResourcePlanName()) {
          oprot.writeFieldBegin(RESOURCE_PLAN_NAME_FIELD_DESC);
          oprot.writeString(struct.resourcePlanName);
          oprot.writeFieldEnd();
        }
      }
      if (struct.poolPath != null) {
        if (struct.isSetPoolPath()) {
          oprot.writeFieldBegin(POOL_PATH_FIELD_DESC);
          oprot.writeString(struct.poolPath);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class WMDropPoolRequestTupleSchemeFactory implements SchemeFactory {
    public WMDropPoolRequestTupleScheme getScheme() {
      return new WMDropPoolRequestTupleScheme();
    }
  }

  private static class WMDropPoolRequestTupleScheme extends TupleScheme<WMDropPoolRequest> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, WMDropPoolRequest struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetResourcePlanName()) {
        optionals.set(0);
      }
      if (struct.isSetPoolPath()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetResourcePlanName()) {
        oprot.writeString(struct.resourcePlanName);
      }
      if (struct.isSetPoolPath()) {
        oprot.writeString(struct.poolPath);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, WMDropPoolRequest struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        struct.resourcePlanName = iprot.readString();
        struct.setResourcePlanNameIsSet(true);
      }
      if (incoming.get(1)) {
        struct.poolPath = iprot.readString();
        struct.setPoolPathIsSet(true);
      }
    }
  }

}
