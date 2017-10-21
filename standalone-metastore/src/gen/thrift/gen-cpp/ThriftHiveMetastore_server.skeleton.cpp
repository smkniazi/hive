// This autogenerated skeleton file illustrates how to build a server.
// You should copy it to another filename to avoid overwriting it.

#include "ThriftHiveMetastore.h"
#include <thrift/protocol/TBinaryProtocol.h>
#include <thrift/server/TSimpleServer.h>
#include <thrift/transport/TServerSocket.h>
#include <thrift/transport/TBufferTransports.h>

using namespace ::apache::thrift;
using namespace ::apache::thrift::protocol;
using namespace ::apache::thrift::transport;
using namespace ::apache::thrift::server;

using boost::shared_ptr;

using namespace  ::Apache::Hadoop::Hive;

class ThriftHiveMetastoreHandler : virtual public ThriftHiveMetastoreIf {
 public:
  ThriftHiveMetastoreHandler() {
    // Your initialization goes here
  }

  void getMetaConf(std::string& _return, const std::string& key) {
    // Your implementation goes here
    printf("getMetaConf\n");
  }

  void setMetaConf(const std::string& key, const std::string& value) {
    // Your implementation goes here
    printf("setMetaConf\n");
  }

  void create_database(const Database& database) {
    // Your implementation goes here
    printf("create_database\n");
  }

  void get_database(Database& _return, const std::string& name) {
    // Your implementation goes here
    printf("get_database\n");
  }

  void drop_database(const std::string& name, const bool deleteData, const bool cascade) {
    // Your implementation goes here
    printf("drop_database\n");
  }

  void get_databases(std::vector<std::string> & _return, const std::string& pattern) {
    // Your implementation goes here
    printf("get_databases\n");
  }

  void get_all_databases(std::vector<std::string> & _return) {
    // Your implementation goes here
    printf("get_all_databases\n");
  }

  void alter_database(const std::string& dbname, const Database& db) {
    // Your implementation goes here
    printf("alter_database\n");
  }

  void get_type(Type& _return, const std::string& name) {
    // Your implementation goes here
    printf("get_type\n");
  }

  bool create_type(const Type& type) {
    // Your implementation goes here
    printf("create_type\n");
  }

  bool drop_type(const std::string& type) {
    // Your implementation goes here
    printf("drop_type\n");
  }

  void get_type_all(std::map<std::string, Type> & _return, const std::string& name) {
    // Your implementation goes here
    printf("get_type_all\n");
  }

  void get_fields(std::vector<FieldSchema> & _return, const std::string& db_name, const std::string& table_name) {
    // Your implementation goes here
    printf("get_fields\n");
  }

  void get_fields_with_environment_context(std::vector<FieldSchema> & _return, const std::string& db_name, const std::string& table_name, const EnvironmentContext& environment_context) {
    // Your implementation goes here
    printf("get_fields_with_environment_context\n");
  }

  void get_schema(std::vector<FieldSchema> & _return, const std::string& db_name, const std::string& table_name) {
    // Your implementation goes here
    printf("get_schema\n");
  }

  void get_schema_with_environment_context(std::vector<FieldSchema> & _return, const std::string& db_name, const std::string& table_name, const EnvironmentContext& environment_context) {
    // Your implementation goes here
    printf("get_schema_with_environment_context\n");
  }

  void create_table(const Table& tbl) {
    // Your implementation goes here
    printf("create_table\n");
  }

  void create_table_with_environment_context(const Table& tbl, const EnvironmentContext& environment_context) {
    // Your implementation goes here
    printf("create_table_with_environment_context\n");
  }

  void create_table_with_constraints(const Table& tbl, const std::vector<SQLPrimaryKey> & primaryKeys, const std::vector<SQLForeignKey> & foreignKeys, const std::vector<SQLUniqueConstraint> & uniqueConstraints, const std::vector<SQLNotNullConstraint> & notNullConstraints) {
    // Your implementation goes here
    printf("create_table_with_constraints\n");
  }

  void drop_constraint(const DropConstraintRequest& req) {
    // Your implementation goes here
    printf("drop_constraint\n");
  }

  void add_primary_key(const AddPrimaryKeyRequest& req) {
    // Your implementation goes here
    printf("add_primary_key\n");
  }

  void add_foreign_key(const AddForeignKeyRequest& req) {
    // Your implementation goes here
    printf("add_foreign_key\n");
  }

  void add_unique_constraint(const AddUniqueConstraintRequest& req) {
    // Your implementation goes here
    printf("add_unique_constraint\n");
  }

  void add_not_null_constraint(const AddNotNullConstraintRequest& req) {
    // Your implementation goes here
    printf("add_not_null_constraint\n");
  }

  void drop_table(const std::string& dbname, const std::string& name, const bool deleteData) {
    // Your implementation goes here
    printf("drop_table\n");
  }

  void drop_table_with_environment_context(const std::string& dbname, const std::string& name, const bool deleteData, const EnvironmentContext& environment_context) {
    // Your implementation goes here
    printf("drop_table_with_environment_context\n");
  }

  void truncate_table(const std::string& dbName, const std::string& tableName, const std::vector<std::string> & partNames) {
    // Your implementation goes here
    printf("truncate_table\n");
  }

  void get_tables(std::vector<std::string> & _return, const std::string& db_name, const std::string& pattern) {
    // Your implementation goes here
    printf("get_tables\n");
  }

  void get_tables_by_type(std::vector<std::string> & _return, const std::string& db_name, const std::string& pattern, const std::string& tableType) {
    // Your implementation goes here
    printf("get_tables_by_type\n");
  }

  void get_table_meta(std::vector<TableMeta> & _return, const std::string& db_patterns, const std::string& tbl_patterns, const std::vector<std::string> & tbl_types) {
    // Your implementation goes here
    printf("get_table_meta\n");
  }

  void get_all_tables(std::vector<std::string> & _return, const std::string& db_name) {
    // Your implementation goes here
    printf("get_all_tables\n");
  }

  void get_table(Table& _return, const std::string& dbname, const std::string& tbl_name) {
    // Your implementation goes here
    printf("get_table\n");
  }

  void get_table_objects_by_name(std::vector<Table> & _return, const std::string& dbname, const std::vector<std::string> & tbl_names) {
    // Your implementation goes here
    printf("get_table_objects_by_name\n");
  }

  void get_table_req(GetTableResult& _return, const GetTableRequest& req) {
    // Your implementation goes here
    printf("get_table_req\n");
  }

  void get_table_objects_by_name_req(GetTablesResult& _return, const GetTablesRequest& req) {
    // Your implementation goes here
    printf("get_table_objects_by_name_req\n");
  }

  void get_table_names_by_filter(std::vector<std::string> & _return, const std::string& dbname, const std::string& filter, const int16_t max_tables) {
    // Your implementation goes here
    printf("get_table_names_by_filter\n");
  }

  void alter_table(const std::string& dbname, const std::string& tbl_name, const Table& new_tbl) {
    // Your implementation goes here
    printf("alter_table\n");
  }

  void alter_table_with_environment_context(const std::string& dbname, const std::string& tbl_name, const Table& new_tbl, const EnvironmentContext& environment_context) {
    // Your implementation goes here
    printf("alter_table_with_environment_context\n");
  }

  void alter_table_with_cascade(const std::string& dbname, const std::string& tbl_name, const Table& new_tbl, const bool cascade) {
    // Your implementation goes here
    printf("alter_table_with_cascade\n");
  }

  void add_partition(Partition& _return, const Partition& new_part) {
    // Your implementation goes here
    printf("add_partition\n");
  }

  void add_partition_with_environment_context(Partition& _return, const Partition& new_part, const EnvironmentContext& environment_context) {
    // Your implementation goes here
    printf("add_partition_with_environment_context\n");
  }

  int32_t add_partitions(const std::vector<Partition> & new_parts) {
    // Your implementation goes here
    printf("add_partitions\n");
  }

  int32_t add_partitions_pspec(const std::vector<PartitionSpec> & new_parts) {
    // Your implementation goes here
    printf("add_partitions_pspec\n");
  }

  void append_partition(Partition& _return, const std::string& db_name, const std::string& tbl_name, const std::vector<std::string> & part_vals) {
    // Your implementation goes here
    printf("append_partition\n");
  }

  void add_partitions_req(AddPartitionsResult& _return, const AddPartitionsRequest& request) {
    // Your implementation goes here
    printf("add_partitions_req\n");
  }

  void append_partition_with_environment_context(Partition& _return, const std::string& db_name, const std::string& tbl_name, const std::vector<std::string> & part_vals, const EnvironmentContext& environment_context) {
    // Your implementation goes here
    printf("append_partition_with_environment_context\n");
  }

  void append_partition_by_name(Partition& _return, const std::string& db_name, const std::string& tbl_name, const std::string& part_name) {
    // Your implementation goes here
    printf("append_partition_by_name\n");
  }

  void append_partition_by_name_with_environment_context(Partition& _return, const std::string& db_name, const std::string& tbl_name, const std::string& part_name, const EnvironmentContext& environment_context) {
    // Your implementation goes here
    printf("append_partition_by_name_with_environment_context\n");
  }

  bool drop_partition(const std::string& db_name, const std::string& tbl_name, const std::vector<std::string> & part_vals, const bool deleteData) {
    // Your implementation goes here
    printf("drop_partition\n");
  }

  bool drop_partition_with_environment_context(const std::string& db_name, const std::string& tbl_name, const std::vector<std::string> & part_vals, const bool deleteData, const EnvironmentContext& environment_context) {
    // Your implementation goes here
    printf("drop_partition_with_environment_context\n");
  }

  bool drop_partition_by_name(const std::string& db_name, const std::string& tbl_name, const std::string& part_name, const bool deleteData) {
    // Your implementation goes here
    printf("drop_partition_by_name\n");
  }

  bool drop_partition_by_name_with_environment_context(const std::string& db_name, const std::string& tbl_name, const std::string& part_name, const bool deleteData, const EnvironmentContext& environment_context) {
    // Your implementation goes here
    printf("drop_partition_by_name_with_environment_context\n");
  }

  void drop_partitions_req(DropPartitionsResult& _return, const DropPartitionsRequest& req) {
    // Your implementation goes here
    printf("drop_partitions_req\n");
  }

  void get_partition(Partition& _return, const std::string& db_name, const std::string& tbl_name, const std::vector<std::string> & part_vals) {
    // Your implementation goes here
    printf("get_partition\n");
  }

  void exchange_partition(Partition& _return, const std::map<std::string, std::string> & partitionSpecs, const std::string& source_db, const std::string& source_table_name, const std::string& dest_db, const std::string& dest_table_name) {
    // Your implementation goes here
    printf("exchange_partition\n");
  }

  void exchange_partitions(std::vector<Partition> & _return, const std::map<std::string, std::string> & partitionSpecs, const std::string& source_db, const std::string& source_table_name, const std::string& dest_db, const std::string& dest_table_name) {
    // Your implementation goes here
    printf("exchange_partitions\n");
  }

  void get_partition_with_auth(Partition& _return, const std::string& db_name, const std::string& tbl_name, const std::vector<std::string> & part_vals, const std::string& user_name, const std::vector<std::string> & group_names) {
    // Your implementation goes here
    printf("get_partition_with_auth\n");
  }

  void get_partition_by_name(Partition& _return, const std::string& db_name, const std::string& tbl_name, const std::string& part_name) {
    // Your implementation goes here
    printf("get_partition_by_name\n");
  }

  void get_partitions(std::vector<Partition> & _return, const std::string& db_name, const std::string& tbl_name, const int16_t max_parts) {
    // Your implementation goes here
    printf("get_partitions\n");
  }

  void get_partitions_with_auth(std::vector<Partition> & _return, const std::string& db_name, const std::string& tbl_name, const int16_t max_parts, const std::string& user_name, const std::vector<std::string> & group_names) {
    // Your implementation goes here
    printf("get_partitions_with_auth\n");
  }

  void get_partitions_pspec(std::vector<PartitionSpec> & _return, const std::string& db_name, const std::string& tbl_name, const int32_t max_parts) {
    // Your implementation goes here
    printf("get_partitions_pspec\n");
  }

  void get_partition_names(std::vector<std::string> & _return, const std::string& db_name, const std::string& tbl_name, const int16_t max_parts) {
    // Your implementation goes here
    printf("get_partition_names\n");
  }

  void get_partition_values(PartitionValuesResponse& _return, const PartitionValuesRequest& request) {
    // Your implementation goes here
    printf("get_partition_values\n");
  }

  void get_partitions_ps(std::vector<Partition> & _return, const std::string& db_name, const std::string& tbl_name, const std::vector<std::string> & part_vals, const int16_t max_parts) {
    // Your implementation goes here
    printf("get_partitions_ps\n");
  }

  void get_partitions_ps_with_auth(std::vector<Partition> & _return, const std::string& db_name, const std::string& tbl_name, const std::vector<std::string> & part_vals, const int16_t max_parts, const std::string& user_name, const std::vector<std::string> & group_names) {
    // Your implementation goes here
    printf("get_partitions_ps_with_auth\n");
  }

  void get_partition_names_ps(std::vector<std::string> & _return, const std::string& db_name, const std::string& tbl_name, const std::vector<std::string> & part_vals, const int16_t max_parts) {
    // Your implementation goes here
    printf("get_partition_names_ps\n");
  }

  void get_partitions_by_filter(std::vector<Partition> & _return, const std::string& db_name, const std::string& tbl_name, const std::string& filter, const int16_t max_parts) {
    // Your implementation goes here
    printf("get_partitions_by_filter\n");
  }

  void get_part_specs_by_filter(std::vector<PartitionSpec> & _return, const std::string& db_name, const std::string& tbl_name, const std::string& filter, const int32_t max_parts) {
    // Your implementation goes here
    printf("get_part_specs_by_filter\n");
  }

  void get_partitions_by_expr(PartitionsByExprResult& _return, const PartitionsByExprRequest& req) {
    // Your implementation goes here
    printf("get_partitions_by_expr\n");
  }

  int32_t get_num_partitions_by_filter(const std::string& db_name, const std::string& tbl_name, const std::string& filter) {
    // Your implementation goes here
    printf("get_num_partitions_by_filter\n");
  }

  void get_partitions_by_names(std::vector<Partition> & _return, const std::string& db_name, const std::string& tbl_name, const std::vector<std::string> & names) {
    // Your implementation goes here
    printf("get_partitions_by_names\n");
  }

  void alter_partition(const std::string& db_name, const std::string& tbl_name, const Partition& new_part) {
    // Your implementation goes here
    printf("alter_partition\n");
  }

  void alter_partitions(const std::string& db_name, const std::string& tbl_name, const std::vector<Partition> & new_parts) {
    // Your implementation goes here
    printf("alter_partitions\n");
  }

  void alter_partitions_with_environment_context(const std::string& db_name, const std::string& tbl_name, const std::vector<Partition> & new_parts, const EnvironmentContext& environment_context) {
    // Your implementation goes here
    printf("alter_partitions_with_environment_context\n");
  }

  void alter_partition_with_environment_context(const std::string& db_name, const std::string& tbl_name, const Partition& new_part, const EnvironmentContext& environment_context) {
    // Your implementation goes here
    printf("alter_partition_with_environment_context\n");
  }

  void rename_partition(const std::string& db_name, const std::string& tbl_name, const std::vector<std::string> & part_vals, const Partition& new_part) {
    // Your implementation goes here
    printf("rename_partition\n");
  }

  bool partition_name_has_valid_characters(const std::vector<std::string> & part_vals, const bool throw_exception) {
    // Your implementation goes here
    printf("partition_name_has_valid_characters\n");
  }

  void get_config_value(std::string& _return, const std::string& name, const std::string& defaultValue) {
    // Your implementation goes here
    printf("get_config_value\n");
  }

  void partition_name_to_vals(std::vector<std::string> & _return, const std::string& part_name) {
    // Your implementation goes here
    printf("partition_name_to_vals\n");
  }

  void partition_name_to_spec(std::map<std::string, std::string> & _return, const std::string& part_name) {
    // Your implementation goes here
    printf("partition_name_to_spec\n");
  }

  void markPartitionForEvent(const std::string& db_name, const std::string& tbl_name, const std::map<std::string, std::string> & part_vals, const PartitionEventType::type eventType) {
    // Your implementation goes here
    printf("markPartitionForEvent\n");
  }

  bool isPartitionMarkedForEvent(const std::string& db_name, const std::string& tbl_name, const std::map<std::string, std::string> & part_vals, const PartitionEventType::type eventType) {
    // Your implementation goes here
    printf("isPartitionMarkedForEvent\n");
  }

  void add_index(Index& _return, const Index& new_index, const Table& index_table) {
    // Your implementation goes here
    printf("add_index\n");
  }

  void alter_index(const std::string& dbname, const std::string& base_tbl_name, const std::string& idx_name, const Index& new_idx) {
    // Your implementation goes here
    printf("alter_index\n");
  }

  bool drop_index_by_name(const std::string& db_name, const std::string& tbl_name, const std::string& index_name, const bool deleteData) {
    // Your implementation goes here
    printf("drop_index_by_name\n");
  }

  void get_index_by_name(Index& _return, const std::string& db_name, const std::string& tbl_name, const std::string& index_name) {
    // Your implementation goes here
    printf("get_index_by_name\n");
  }

  void get_indexes(std::vector<Index> & _return, const std::string& db_name, const std::string& tbl_name, const int16_t max_indexes) {
    // Your implementation goes here
    printf("get_indexes\n");
  }

  void get_index_names(std::vector<std::string> & _return, const std::string& db_name, const std::string& tbl_name, const int16_t max_indexes) {
    // Your implementation goes here
    printf("get_index_names\n");
  }

  void get_primary_keys(PrimaryKeysResponse& _return, const PrimaryKeysRequest& request) {
    // Your implementation goes here
    printf("get_primary_keys\n");
  }

  void get_foreign_keys(ForeignKeysResponse& _return, const ForeignKeysRequest& request) {
    // Your implementation goes here
    printf("get_foreign_keys\n");
  }

  void get_unique_constraints(UniqueConstraintsResponse& _return, const UniqueConstraintsRequest& request) {
    // Your implementation goes here
    printf("get_unique_constraints\n");
  }

  void get_not_null_constraints(NotNullConstraintsResponse& _return, const NotNullConstraintsRequest& request) {
    // Your implementation goes here
    printf("get_not_null_constraints\n");
  }

  bool update_table_column_statistics(const ColumnStatistics& stats_obj) {
    // Your implementation goes here
    printf("update_table_column_statistics\n");
  }

  bool update_partition_column_statistics(const ColumnStatistics& stats_obj) {
    // Your implementation goes here
    printf("update_partition_column_statistics\n");
  }

  void get_table_column_statistics(ColumnStatistics& _return, const std::string& db_name, const std::string& tbl_name, const std::string& col_name) {
    // Your implementation goes here
    printf("get_table_column_statistics\n");
  }

  void get_partition_column_statistics(ColumnStatistics& _return, const std::string& db_name, const std::string& tbl_name, const std::string& part_name, const std::string& col_name) {
    // Your implementation goes here
    printf("get_partition_column_statistics\n");
  }

  void get_table_statistics_req(TableStatsResult& _return, const TableStatsRequest& request) {
    // Your implementation goes here
    printf("get_table_statistics_req\n");
  }

  void get_partitions_statistics_req(PartitionsStatsResult& _return, const PartitionsStatsRequest& request) {
    // Your implementation goes here
    printf("get_partitions_statistics_req\n");
  }

  void get_aggr_stats_for(AggrStats& _return, const PartitionsStatsRequest& request) {
    // Your implementation goes here
    printf("get_aggr_stats_for\n");
  }

  bool set_aggr_stats_for(const SetPartitionsStatsRequest& request) {
    // Your implementation goes here
    printf("set_aggr_stats_for\n");
  }

  bool delete_partition_column_statistics(const std::string& db_name, const std::string& tbl_name, const std::string& part_name, const std::string& col_name) {
    // Your implementation goes here
    printf("delete_partition_column_statistics\n");
  }

  bool delete_table_column_statistics(const std::string& db_name, const std::string& tbl_name, const std::string& col_name) {
    // Your implementation goes here
    printf("delete_table_column_statistics\n");
  }

  void create_function(const Function& func) {
    // Your implementation goes here
    printf("create_function\n");
  }

  void drop_function(const std::string& dbName, const std::string& funcName) {
    // Your implementation goes here
    printf("drop_function\n");
  }

  void alter_function(const std::string& dbName, const std::string& funcName, const Function& newFunc) {
    // Your implementation goes here
    printf("alter_function\n");
  }

  void get_functions(std::vector<std::string> & _return, const std::string& dbName, const std::string& pattern) {
    // Your implementation goes here
    printf("get_functions\n");
  }

  void get_function(Function& _return, const std::string& dbName, const std::string& funcName) {
    // Your implementation goes here
    printf("get_function\n");
  }

  void get_all_functions(GetAllFunctionsResponse& _return) {
    // Your implementation goes here
    printf("get_all_functions\n");
  }

  bool create_role(const Role& role) {
    // Your implementation goes here
    printf("create_role\n");
  }

  bool drop_role(const std::string& role_name) {
    // Your implementation goes here
    printf("drop_role\n");
  }

  void get_role_names(std::vector<std::string> & _return) {
    // Your implementation goes here
    printf("get_role_names\n");
  }

  bool grant_role(const std::string& role_name, const std::string& principal_name, const PrincipalType::type principal_type, const std::string& grantor, const PrincipalType::type grantorType, const bool grant_option) {
    // Your implementation goes here
    printf("grant_role\n");
  }

  bool revoke_role(const std::string& role_name, const std::string& principal_name, const PrincipalType::type principal_type) {
    // Your implementation goes here
    printf("revoke_role\n");
  }

  void list_roles(std::vector<Role> & _return, const std::string& principal_name, const PrincipalType::type principal_type) {
    // Your implementation goes here
    printf("list_roles\n");
  }

  void grant_revoke_role(GrantRevokeRoleResponse& _return, const GrantRevokeRoleRequest& request) {
    // Your implementation goes here
    printf("grant_revoke_role\n");
  }

  void get_principals_in_role(GetPrincipalsInRoleResponse& _return, const GetPrincipalsInRoleRequest& request) {
    // Your implementation goes here
    printf("get_principals_in_role\n");
  }

  void get_role_grants_for_principal(GetRoleGrantsForPrincipalResponse& _return, const GetRoleGrantsForPrincipalRequest& request) {
    // Your implementation goes here
    printf("get_role_grants_for_principal\n");
  }

  void get_privilege_set(PrincipalPrivilegeSet& _return, const HiveObjectRef& hiveObject, const std::string& user_name, const std::vector<std::string> & group_names) {
    // Your implementation goes here
    printf("get_privilege_set\n");
  }

  void list_privileges(std::vector<HiveObjectPrivilege> & _return, const std::string& principal_name, const PrincipalType::type principal_type, const HiveObjectRef& hiveObject) {
    // Your implementation goes here
    printf("list_privileges\n");
  }

  bool grant_privileges(const PrivilegeBag& privileges) {
    // Your implementation goes here
    printf("grant_privileges\n");
  }

  bool revoke_privileges(const PrivilegeBag& privileges) {
    // Your implementation goes here
    printf("revoke_privileges\n");
  }

  void grant_revoke_privileges(GrantRevokePrivilegeResponse& _return, const GrantRevokePrivilegeRequest& request) {
    // Your implementation goes here
    printf("grant_revoke_privileges\n");
  }

  void set_ugi(std::vector<std::string> & _return, const std::string& user_name, const std::vector<std::string> & group_names) {
    // Your implementation goes here
    printf("set_ugi\n");
  }

  void set_crypto(const std::string& key_store, const std::string& key_store_password, const std::string& trust_store, const std::string& trust_store_password) {
    // Your implementation goes here
    printf("set_crypto\n");
  }

  void get_delegation_token(std::string& _return, const std::string& token_owner, const std::string& renewer_kerberos_principal_name) {
    // Your implementation goes here
    printf("get_delegation_token\n");
  }

  int64_t renew_delegation_token(const std::string& token_str_form) {
    // Your implementation goes here
    printf("renew_delegation_token\n");
  }

  void cancel_delegation_token(const std::string& token_str_form) {
    // Your implementation goes here
    printf("cancel_delegation_token\n");
  }

  bool add_token(const std::string& token_identifier, const std::string& delegation_token) {
    // Your implementation goes here
    printf("add_token\n");
  }

  bool remove_token(const std::string& token_identifier) {
    // Your implementation goes here
    printf("remove_token\n");
  }

  void get_token(std::string& _return, const std::string& token_identifier) {
    // Your implementation goes here
    printf("get_token\n");
  }

  void get_all_token_identifiers(std::vector<std::string> & _return) {
    // Your implementation goes here
    printf("get_all_token_identifiers\n");
  }

  int32_t add_master_key(const std::string& key) {
    // Your implementation goes here
    printf("add_master_key\n");
  }

  void update_master_key(const int32_t seq_number, const std::string& key) {
    // Your implementation goes here
    printf("update_master_key\n");
  }

  bool remove_master_key(const int32_t key_seq) {
    // Your implementation goes here
    printf("remove_master_key\n");
  }

  void get_master_keys(std::vector<std::string> & _return) {
    // Your implementation goes here
    printf("get_master_keys\n");
  }

  void get_open_txns(GetOpenTxnsResponse& _return) {
    // Your implementation goes here
    printf("get_open_txns\n");
  }

  void get_open_txns_info(GetOpenTxnsInfoResponse& _return) {
    // Your implementation goes here
    printf("get_open_txns_info\n");
  }

  void open_txns(OpenTxnsResponse& _return, const OpenTxnRequest& rqst) {
    // Your implementation goes here
    printf("open_txns\n");
  }

  void abort_txn(const AbortTxnRequest& rqst) {
    // Your implementation goes here
    printf("abort_txn\n");
  }

  void abort_txns(const AbortTxnsRequest& rqst) {
    // Your implementation goes here
    printf("abort_txns\n");
  }

  void commit_txn(const CommitTxnRequest& rqst) {
    // Your implementation goes here
    printf("commit_txn\n");
  }

  void lock(LockResponse& _return, const LockRequest& rqst) {
    // Your implementation goes here
    printf("lock\n");
  }

  void check_lock(LockResponse& _return, const CheckLockRequest& rqst) {
    // Your implementation goes here
    printf("check_lock\n");
  }

  void unlock(const UnlockRequest& rqst) {
    // Your implementation goes here
    printf("unlock\n");
  }

  void show_locks(ShowLocksResponse& _return, const ShowLocksRequest& rqst) {
    // Your implementation goes here
    printf("show_locks\n");
  }

  void heartbeat(const HeartbeatRequest& ids) {
    // Your implementation goes here
    printf("heartbeat\n");
  }

  void heartbeat_txn_range(HeartbeatTxnRangeResponse& _return, const HeartbeatTxnRangeRequest& txns) {
    // Your implementation goes here
    printf("heartbeat_txn_range\n");
  }

  void compact(const CompactionRequest& rqst) {
    // Your implementation goes here
    printf("compact\n");
  }

  void compact2(CompactionResponse& _return, const CompactionRequest& rqst) {
    // Your implementation goes here
    printf("compact2\n");
  }

  void show_compact(ShowCompactResponse& _return, const ShowCompactRequest& rqst) {
    // Your implementation goes here
    printf("show_compact\n");
  }

  void add_dynamic_partitions(const AddDynamicPartitions& rqst) {
    // Your implementation goes here
    printf("add_dynamic_partitions\n");
  }

  void get_next_notification(NotificationEventResponse& _return, const NotificationEventRequest& rqst) {
    // Your implementation goes here
    printf("get_next_notification\n");
  }

  void get_current_notificationEventId(CurrentNotificationEventId& _return) {
    // Your implementation goes here
    printf("get_current_notificationEventId\n");
  }

  void get_notification_events_count(NotificationEventsCountResponse& _return, const NotificationEventsCountRequest& rqst) {
    // Your implementation goes here
    printf("get_notification_events_count\n");
  }

  void fire_listener_event(FireEventResponse& _return, const FireEventRequest& rqst) {
    // Your implementation goes here
    printf("fire_listener_event\n");
  }

  void flushCache() {
    // Your implementation goes here
    printf("flushCache\n");
  }

  void cm_recycle(CmRecycleResponse& _return, const CmRecycleRequest& request) {
    // Your implementation goes here
    printf("cm_recycle\n");
  }

  void get_file_metadata_by_expr(GetFileMetadataByExprResult& _return, const GetFileMetadataByExprRequest& req) {
    // Your implementation goes here
    printf("get_file_metadata_by_expr\n");
  }

  void get_file_metadata(GetFileMetadataResult& _return, const GetFileMetadataRequest& req) {
    // Your implementation goes here
    printf("get_file_metadata\n");
  }

  void put_file_metadata(PutFileMetadataResult& _return, const PutFileMetadataRequest& req) {
    // Your implementation goes here
    printf("put_file_metadata\n");
  }

  void clear_file_metadata(ClearFileMetadataResult& _return, const ClearFileMetadataRequest& req) {
    // Your implementation goes here
    printf("clear_file_metadata\n");
  }

  void cache_file_metadata(CacheFileMetadataResult& _return, const CacheFileMetadataRequest& req) {
    // Your implementation goes here
    printf("cache_file_metadata\n");
  }

  void get_next_write_id(GetNextWriteIdResult& _return, const GetNextWriteIdRequest& req) {
    // Your implementation goes here
    printf("get_next_write_id\n");
  }

  void finalize_write_id(FinalizeWriteIdResult& _return, const FinalizeWriteIdRequest& req) {
    // Your implementation goes here
    printf("finalize_write_id\n");
  }

  void heartbeat_write_id(HeartbeatWriteIdResult& _return, const HeartbeatWriteIdRequest& req) {
    // Your implementation goes here
    printf("heartbeat_write_id\n");
  }

  void get_valid_write_ids(GetValidWriteIdsResult& _return, const GetValidWriteIdsRequest& req) {
    // Your implementation goes here
    printf("get_valid_write_ids\n");
  }

  void get_metastore_db_uuid(std::string& _return) {
    // Your implementation goes here
    printf("get_metastore_db_uuid\n");
  }

  void create_resource_plan(WMCreateResourcePlanResponse& _return, const WMCreateResourcePlanRequest& request) {
    // Your implementation goes here
    printf("create_resource_plan\n");
  }

  void get_resource_plan(WMGetResourcePlanResponse& _return, const WMGetResourcePlanRequest& request) {
    // Your implementation goes here
    printf("get_resource_plan\n");
  }

  void get_all_resource_plans(WMGetAllResourcePlanResponse& _return, const WMGetAllResourcePlanRequest& request) {
    // Your implementation goes here
    printf("get_all_resource_plans\n");
  }

  void alter_resource_plan(WMAlterResourcePlanResponse& _return, const WMAlterResourcePlanRequest& request) {
    // Your implementation goes here
    printf("alter_resource_plan\n");
  }

  void validate_resource_plan(WMValidateResourcePlanResponse& _return, const WMValidateResourcePlanRequest& request) {
    // Your implementation goes here
    printf("validate_resource_plan\n");
  }

  void drop_resource_plan(WMDropResourcePlanResponse& _return, const WMDropResourcePlanRequest& request) {
    // Your implementation goes here
    printf("drop_resource_plan\n");
  }

};

int main(int argc, char **argv) {
  int port = 9090;
  shared_ptr<ThriftHiveMetastoreHandler> handler(new ThriftHiveMetastoreHandler());
  shared_ptr<TProcessor> processor(new ThriftHiveMetastoreProcessor(handler));
  shared_ptr<TServerTransport> serverTransport(new TServerSocket(port));
  shared_ptr<TTransportFactory> transportFactory(new TBufferedTransportFactory());
  shared_ptr<TProtocolFactory> protocolFactory(new TBinaryProtocolFactory());

  TSimpleServer server(processor, serverTransport, transportFactory, protocolFactory);
  server.serve();
  return 0;
}

