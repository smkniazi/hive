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
public class WMGetAllResourcePlanResponse implements org.apache.thrift.TBase<WMGetAllResourcePlanResponse, WMGetAllResourcePlanResponse._Fields>, java.io.Serializable, Cloneable, Comparable<WMGetAllResourcePlanResponse> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("WMGetAllResourcePlanResponse");

  private static final org.apache.thrift.protocol.TField RESOURCE_PLANS_FIELD_DESC = new org.apache.thrift.protocol.TField("resourcePlans", org.apache.thrift.protocol.TType.LIST, (short)1);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new WMGetAllResourcePlanResponseStandardSchemeFactory());
    schemes.put(TupleScheme.class, new WMGetAllResourcePlanResponseTupleSchemeFactory());
  }

  private List<WMResourcePlan> resourcePlans; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    RESOURCE_PLANS((short)1, "resourcePlans");

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
        case 1: // RESOURCE_PLANS
          return RESOURCE_PLANS;
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
  private static final _Fields optionals[] = {_Fields.RESOURCE_PLANS};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.RESOURCE_PLANS, new org.apache.thrift.meta_data.FieldMetaData("resourcePlans", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, WMResourcePlan.class))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(WMGetAllResourcePlanResponse.class, metaDataMap);
  }

  public WMGetAllResourcePlanResponse() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public WMGetAllResourcePlanResponse(WMGetAllResourcePlanResponse other) {
    if (other.isSetResourcePlans()) {
      List<WMResourcePlan> __this__resourcePlans = new ArrayList<WMResourcePlan>(other.resourcePlans.size());
      for (WMResourcePlan other_element : other.resourcePlans) {
        __this__resourcePlans.add(new WMResourcePlan(other_element));
      }
      this.resourcePlans = __this__resourcePlans;
    }
  }

  public WMGetAllResourcePlanResponse deepCopy() {
    return new WMGetAllResourcePlanResponse(this);
  }

  @Override
  public void clear() {
    this.resourcePlans = null;
  }

  public int getResourcePlansSize() {
    return (this.resourcePlans == null) ? 0 : this.resourcePlans.size();
  }

  public java.util.Iterator<WMResourcePlan> getResourcePlansIterator() {
    return (this.resourcePlans == null) ? null : this.resourcePlans.iterator();
  }

  public void addToResourcePlans(WMResourcePlan elem) {
    if (this.resourcePlans == null) {
      this.resourcePlans = new ArrayList<WMResourcePlan>();
    }
    this.resourcePlans.add(elem);
  }

  public List<WMResourcePlan> getResourcePlans() {
    return this.resourcePlans;
  }

  public void setResourcePlans(List<WMResourcePlan> resourcePlans) {
    this.resourcePlans = resourcePlans;
  }

  public void unsetResourcePlans() {
    this.resourcePlans = null;
  }

  /** Returns true if field resourcePlans is set (has been assigned a value) and false otherwise */
  public boolean isSetResourcePlans() {
    return this.resourcePlans != null;
  }

  public void setResourcePlansIsSet(boolean value) {
    if (!value) {
      this.resourcePlans = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case RESOURCE_PLANS:
      if (value == null) {
        unsetResourcePlans();
      } else {
        setResourcePlans((List<WMResourcePlan>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case RESOURCE_PLANS:
      return getResourcePlans();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case RESOURCE_PLANS:
      return isSetResourcePlans();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof WMGetAllResourcePlanResponse)
      return this.equals((WMGetAllResourcePlanResponse)that);
    return false;
  }

  public boolean equals(WMGetAllResourcePlanResponse that) {
    if (that == null)
      return false;

    boolean this_present_resourcePlans = true && this.isSetResourcePlans();
    boolean that_present_resourcePlans = true && that.isSetResourcePlans();
    if (this_present_resourcePlans || that_present_resourcePlans) {
      if (!(this_present_resourcePlans && that_present_resourcePlans))
        return false;
      if (!this.resourcePlans.equals(that.resourcePlans))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_resourcePlans = true && (isSetResourcePlans());
    list.add(present_resourcePlans);
    if (present_resourcePlans)
      list.add(resourcePlans);

    return list.hashCode();
  }

  @Override
  public int compareTo(WMGetAllResourcePlanResponse other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetResourcePlans()).compareTo(other.isSetResourcePlans());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetResourcePlans()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.resourcePlans, other.resourcePlans);
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
    StringBuilder sb = new StringBuilder("WMGetAllResourcePlanResponse(");
    boolean first = true;

    if (isSetResourcePlans()) {
      sb.append("resourcePlans:");
      if (this.resourcePlans == null) {
        sb.append("null");
      } else {
        sb.append(this.resourcePlans);
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

  private static class WMGetAllResourcePlanResponseStandardSchemeFactory implements SchemeFactory {
    public WMGetAllResourcePlanResponseStandardScheme getScheme() {
      return new WMGetAllResourcePlanResponseStandardScheme();
    }
  }

  private static class WMGetAllResourcePlanResponseStandardScheme extends StandardScheme<WMGetAllResourcePlanResponse> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, WMGetAllResourcePlanResponse struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // RESOURCE_PLANS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list778 = iprot.readListBegin();
                struct.resourcePlans = new ArrayList<WMResourcePlan>(_list778.size);
                WMResourcePlan _elem779;
                for (int _i780 = 0; _i780 < _list778.size; ++_i780)
                {
                  _elem779 = new WMResourcePlan();
                  _elem779.read(iprot);
                  struct.resourcePlans.add(_elem779);
                }
                iprot.readListEnd();
              }
              struct.setResourcePlansIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, WMGetAllResourcePlanResponse struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.resourcePlans != null) {
        if (struct.isSetResourcePlans()) {
          oprot.writeFieldBegin(RESOURCE_PLANS_FIELD_DESC);
          {
            oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.resourcePlans.size()));
            for (WMResourcePlan _iter781 : struct.resourcePlans)
            {
              _iter781.write(oprot);
            }
            oprot.writeListEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class WMGetAllResourcePlanResponseTupleSchemeFactory implements SchemeFactory {
    public WMGetAllResourcePlanResponseTupleScheme getScheme() {
      return new WMGetAllResourcePlanResponseTupleScheme();
    }
  }

  private static class WMGetAllResourcePlanResponseTupleScheme extends TupleScheme<WMGetAllResourcePlanResponse> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, WMGetAllResourcePlanResponse struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetResourcePlans()) {
        optionals.set(0);
      }
      oprot.writeBitSet(optionals, 1);
      if (struct.isSetResourcePlans()) {
        {
          oprot.writeI32(struct.resourcePlans.size());
          for (WMResourcePlan _iter782 : struct.resourcePlans)
          {
            _iter782.write(oprot);
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, WMGetAllResourcePlanResponse struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(1);
      if (incoming.get(0)) {
        {
          org.apache.thrift.protocol.TList _list783 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
          struct.resourcePlans = new ArrayList<WMResourcePlan>(_list783.size);
          WMResourcePlan _elem784;
          for (int _i785 = 0; _i785 < _list783.size; ++_i785)
          {
            _elem784 = new WMResourcePlan();
            _elem784.read(iprot);
            struct.resourcePlans.add(_elem784);
          }
        }
        struct.setResourcePlansIsSet(true);
      }
    }
  }

}

