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
public class AddPrimaryKeyRequest implements org.apache.thrift.TBase<AddPrimaryKeyRequest, AddPrimaryKeyRequest._Fields>, java.io.Serializable, Cloneable, Comparable<AddPrimaryKeyRequest> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("AddPrimaryKeyRequest");

  private static final org.apache.thrift.protocol.TField PRIMARY_KEY_COLS_FIELD_DESC = new org.apache.thrift.protocol.TField("primaryKeyCols", org.apache.thrift.protocol.TType.LIST, (short)1);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new AddPrimaryKeyRequestStandardSchemeFactory());
    schemes.put(TupleScheme.class, new AddPrimaryKeyRequestTupleSchemeFactory());
  }

  private List<SQLPrimaryKey> primaryKeyCols; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    PRIMARY_KEY_COLS((short)1, "primaryKeyCols");

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
        case 1: // PRIMARY_KEY_COLS
          return PRIMARY_KEY_COLS;
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
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.PRIMARY_KEY_COLS, new org.apache.thrift.meta_data.FieldMetaData("primaryKeyCols", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, SQLPrimaryKey.class))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(AddPrimaryKeyRequest.class, metaDataMap);
  }

  public AddPrimaryKeyRequest() {
  }

  public AddPrimaryKeyRequest(
    List<SQLPrimaryKey> primaryKeyCols)
  {
    this();
    this.primaryKeyCols = primaryKeyCols;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public AddPrimaryKeyRequest(AddPrimaryKeyRequest other) {
    if (other.isSetPrimaryKeyCols()) {
      List<SQLPrimaryKey> __this__primaryKeyCols = new ArrayList<SQLPrimaryKey>(other.primaryKeyCols.size());
      for (SQLPrimaryKey other_element : other.primaryKeyCols) {
        __this__primaryKeyCols.add(new SQLPrimaryKey(other_element));
      }
      this.primaryKeyCols = __this__primaryKeyCols;
    }
  }

  public AddPrimaryKeyRequest deepCopy() {
    return new AddPrimaryKeyRequest(this);
  }

  @Override
  public void clear() {
    this.primaryKeyCols = null;
  }

  public int getPrimaryKeyColsSize() {
    return (this.primaryKeyCols == null) ? 0 : this.primaryKeyCols.size();
  }

  public java.util.Iterator<SQLPrimaryKey> getPrimaryKeyColsIterator() {
    return (this.primaryKeyCols == null) ? null : this.primaryKeyCols.iterator();
  }

  public void addToPrimaryKeyCols(SQLPrimaryKey elem) {
    if (this.primaryKeyCols == null) {
      this.primaryKeyCols = new ArrayList<SQLPrimaryKey>();
    }
    this.primaryKeyCols.add(elem);
  }

  public List<SQLPrimaryKey> getPrimaryKeyCols() {
    return this.primaryKeyCols;
  }

  public void setPrimaryKeyCols(List<SQLPrimaryKey> primaryKeyCols) {
    this.primaryKeyCols = primaryKeyCols;
  }

  public void unsetPrimaryKeyCols() {
    this.primaryKeyCols = null;
  }

  /** Returns true if field primaryKeyCols is set (has been assigned a value) and false otherwise */
  public boolean isSetPrimaryKeyCols() {
    return this.primaryKeyCols != null;
  }

  public void setPrimaryKeyColsIsSet(boolean value) {
    if (!value) {
      this.primaryKeyCols = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case PRIMARY_KEY_COLS:
      if (value == null) {
        unsetPrimaryKeyCols();
      } else {
        setPrimaryKeyCols((List<SQLPrimaryKey>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case PRIMARY_KEY_COLS:
      return getPrimaryKeyCols();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case PRIMARY_KEY_COLS:
      return isSetPrimaryKeyCols();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof AddPrimaryKeyRequest)
      return this.equals((AddPrimaryKeyRequest)that);
    return false;
  }

  public boolean equals(AddPrimaryKeyRequest that) {
    if (that == null)
      return false;

    boolean this_present_primaryKeyCols = true && this.isSetPrimaryKeyCols();
    boolean that_present_primaryKeyCols = true && that.isSetPrimaryKeyCols();
    if (this_present_primaryKeyCols || that_present_primaryKeyCols) {
      if (!(this_present_primaryKeyCols && that_present_primaryKeyCols))
        return false;
      if (!this.primaryKeyCols.equals(that.primaryKeyCols))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_primaryKeyCols = true && (isSetPrimaryKeyCols());
    list.add(present_primaryKeyCols);
    if (present_primaryKeyCols)
      list.add(primaryKeyCols);

    return list.hashCode();
  }

  @Override
  public int compareTo(AddPrimaryKeyRequest other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetPrimaryKeyCols()).compareTo(other.isSetPrimaryKeyCols());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPrimaryKeyCols()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.primaryKeyCols, other.primaryKeyCols);
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
    StringBuilder sb = new StringBuilder("AddPrimaryKeyRequest(");
    boolean first = true;

    sb.append("primaryKeyCols:");
    if (this.primaryKeyCols == null) {
      sb.append("null");
    } else {
      sb.append(this.primaryKeyCols);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (!isSetPrimaryKeyCols()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'primaryKeyCols' is unset! Struct:" + toString());
    }

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

  private static class AddPrimaryKeyRequestStandardSchemeFactory implements SchemeFactory {
    public AddPrimaryKeyRequestStandardScheme getScheme() {
      return new AddPrimaryKeyRequestStandardScheme();
    }
  }

  private static class AddPrimaryKeyRequestStandardScheme extends StandardScheme<AddPrimaryKeyRequest> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, AddPrimaryKeyRequest struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // PRIMARY_KEY_COLS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list352 = iprot.readListBegin();
                struct.primaryKeyCols = new ArrayList<SQLPrimaryKey>(_list352.size);
                SQLPrimaryKey _elem353;
                for (int _i354 = 0; _i354 < _list352.size; ++_i354)
                {
                  _elem353 = new SQLPrimaryKey();
                  _elem353.read(iprot);
                  struct.primaryKeyCols.add(_elem353);
                }
                iprot.readListEnd();
              }
              struct.setPrimaryKeyColsIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, AddPrimaryKeyRequest struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.primaryKeyCols != null) {
        oprot.writeFieldBegin(PRIMARY_KEY_COLS_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.primaryKeyCols.size()));
          for (SQLPrimaryKey _iter355 : struct.primaryKeyCols)
          {
            _iter355.write(oprot);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class AddPrimaryKeyRequestTupleSchemeFactory implements SchemeFactory {
    public AddPrimaryKeyRequestTupleScheme getScheme() {
      return new AddPrimaryKeyRequestTupleScheme();
    }
  }

  private static class AddPrimaryKeyRequestTupleScheme extends TupleScheme<AddPrimaryKeyRequest> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, AddPrimaryKeyRequest struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      {
        oprot.writeI32(struct.primaryKeyCols.size());
        for (SQLPrimaryKey _iter356 : struct.primaryKeyCols)
        {
          _iter356.write(oprot);
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, AddPrimaryKeyRequest struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      {
        org.apache.thrift.protocol.TList _list357 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
        struct.primaryKeyCols = new ArrayList<SQLPrimaryKey>(_list357.size);
        SQLPrimaryKey _elem358;
        for (int _i359 = 0; _i359 < _list357.size; ++_i359)
        {
          _elem358 = new SQLPrimaryKey();
          _elem358.read(iprot);
          struct.primaryKeyCols.add(_elem358);
        }
      }
      struct.setPrimaryKeyColsIsSet(true);
    }
  }

}

