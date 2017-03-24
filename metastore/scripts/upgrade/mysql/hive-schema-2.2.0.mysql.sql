-- MySQL dump 10.13  Distrib 5.7.17, for Linux (x86_64)
--
-- Host: 193.10.64.11    Database: hive_test
-- ------------------------------------------------------
-- Server version	5.7.17-ndb-7.5.5-cluster-gpl

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `BUCKETING_COLS`
--

DROP TABLE IF EXISTS `BUCKETING_COLS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `BUCKETING_COLS` (
  `SD_ID` bigint(20) NOT NULL,
  `BUCKET_COL_NAME` varchar(255) CHARACTER SET latin1 COLLATE latin1_bin DEFAULT NULL,
  `INTEGER_IDX` int(11) NOT NULL,
  PRIMARY KEY (`SD_ID`,`INTEGER_IDX`),
  KEY `BUCKETING_COLS_N49` (`SD_ID`),
  CONSTRAINT `BCK_SD_FK` FOREIGN KEY (`SD_ID`) REFERENCES `SDS` (`SD_ID`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE=ndbcluster DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `CDS`
--

DROP TABLE IF EXISTS `CDS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CDS` (
  `CD_ID` bigint(20) NOT NULL,
  PRIMARY KEY (`CD_ID`)
) ENGINE=ndbcluster DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `COLUMNS_V2`
--

DROP TABLE IF EXISTS `COLUMNS_V2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `COLUMNS_V2` (
  `CD_ID` bigint(20) NOT NULL,
  `COMMENT` varchar(256) CHARACTER SET latin1 COLLATE latin1_bin DEFAULT NULL,
  `COLUMN_NAME` varchar(128) CHARACTER SET latin1 COLLATE latin1_bin NOT NULL,
  `TYPE_NAME` varchar(4000) CHARACTER SET latin1 COLLATE latin1_bin NOT NULL,
  `INTEGER_IDX` int(11) NOT NULL,
  PRIMARY KEY (`CD_ID`,`COLUMN_NAME`),
  KEY `COLUMNS_V2_N49` (`CD_ID`),
  CONSTRAINT `COLUMN_CDS_FK` FOREIGN KEY (`CD_ID`) REFERENCES `CDS` (`CD_ID`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE=ndbcluster DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `DATABASE_PARAMS`
--

DROP TABLE IF EXISTS `DATABASE_PARAMS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `DATABASE_PARAMS` (
  `DB_ID` bigint(20) NOT NULL,
  `PARAM_KEY` varchar(180) CHARACTER SET latin1 COLLATE latin1_bin NOT NULL,
  `PARAM_VALUE` varchar(4000) CHARACTER SET latin1 COLLATE latin1_bin DEFAULT NULL,
  PRIMARY KEY (`DB_ID`,`PARAM_KEY`),
  KEY `DATABASE_PARAMS_N49` (`DB_ID`),
  CONSTRAINT `DB_PARAMS_DBS_FK` FOREIGN KEY (`DB_ID`) REFERENCES `DBS` (`DB_ID`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE=ndbcluster DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `DBS`
--

DROP TABLE IF EXISTS `DBS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `DBS` (
  `DB_ID` bigint(20) NOT NULL,
  `DESC` varchar(4000) CHARACTER SET latin1 COLLATE latin1_bin DEFAULT NULL,
  `NAME` varchar(128) CHARACTER SET latin1 COLLATE latin1_bin DEFAULT NULL,
  `OWNER_NAME` varchar(128) CHARACTER SET latin1 COLLATE latin1_bin DEFAULT NULL,
  `OWNER_TYPE` varchar(10) CHARACTER SET latin1 COLLATE latin1_bin DEFAULT NULL,
  `SD_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`DB_ID`),
  UNIQUE KEY `UNIQUE_DATABASE` (`NAME`),
  KEY `DBS_N49` (`SD_ID`),
  CONSTRAINT `DB_SD_FK` FOREIGN KEY (`SD_ID`) REFERENCES `SDS` (`SD_ID`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE=ndbcluster DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `DB_PRIVS`
--

DROP TABLE IF EXISTS `DB_PRIVS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `DB_PRIVS` (
  `DB_GRANT_ID` bigint(20) NOT NULL,
  `CREATE_TIME` int(11) NOT NULL,
  `DB_ID` bigint(20) DEFAULT NULL,
  `GRANT_OPTION` smallint(6) NOT NULL,
  `GRANTOR` varchar(128) CHARACTER SET latin1 COLLATE latin1_bin DEFAULT NULL,
  `GRANTOR_TYPE` varchar(128) CHARACTER SET latin1 COLLATE latin1_bin DEFAULT NULL,
  `PRINCIPAL_NAME` varchar(128) CHARACTER SET latin1 COLLATE latin1_bin DEFAULT NULL,
  `PRINCIPAL_TYPE` varchar(128) CHARACTER SET latin1 COLLATE latin1_bin DEFAULT NULL,
  `DB_PRIV` varchar(128) CHARACTER SET latin1 COLLATE latin1_bin DEFAULT NULL,
  PRIMARY KEY (`DB_GRANT_ID`),
  UNIQUE KEY `DBPRIVILEGEINDEX` (`DB_ID`,`PRINCIPAL_NAME`,`PRINCIPAL_TYPE`,`DB_PRIV`,`GRANTOR`,`GRANTOR_TYPE`),
  KEY `DB_PRIVS_N49` (`DB_ID`),
  CONSTRAINT `DB_PRIVS_DBS_FK` FOREIGN KEY (`DB_ID`) REFERENCES `DBS` (`DB_ID`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE=ndbcluster DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `FUNCS`
--

DROP TABLE IF EXISTS `FUNCS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `FUNCS` (
  `FUNC_ID` bigint(20) NOT NULL,
  `CLASS_NAME` varchar(4000) CHARACTER SET latin1 COLLATE latin1_bin DEFAULT NULL,
  `CREATE_TIME` int(11) NOT NULL,
  `DB_ID` bigint(20) DEFAULT NULL,
  `FUNC_NAME` varchar(128) CHARACTER SET latin1 COLLATE latin1_bin DEFAULT NULL,
  `FUNC_TYPE` int(11) NOT NULL,
  `OWNER_NAME` varchar(128) CHARACTER SET latin1 COLLATE latin1_bin DEFAULT NULL,
  `OWNER_TYPE` varchar(10) CHARACTER SET latin1 COLLATE latin1_bin DEFAULT NULL,
  PRIMARY KEY (`FUNC_ID`),
  UNIQUE KEY `UNIQUEFUNCTION` (`FUNC_NAME`,`DB_ID`),
  KEY `FUNCS_N49` (`DB_ID`),
  CONSTRAINT `FUNC_DB_FK` FOREIGN KEY (`DB_ID`) REFERENCES `DBS` (`DB_ID`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE=ndbcluster DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `FUNC_RU`
--

DROP TABLE IF EXISTS `FUNC_RU`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `FUNC_RU` (
  `FUNC_ID` bigint(20) NOT NULL,
  `RESOURCE_TYPE` int(11) NOT NULL,
  `RESOURCE_URI` varchar(4000) CHARACTER SET latin1 COLLATE latin1_bin DEFAULT NULL,
  `INTEGER_IDX` int(11) NOT NULL,
  PRIMARY KEY (`FUNC_ID`,`INTEGER_IDX`),
  KEY `FUNC_RU_N49` (`FUNC_ID`),
  CONSTRAINT `FUNC_RU_FUNCS_FK` FOREIGN KEY (`FUNC_ID`) REFERENCES `FUNCS` (`FUNC_ID`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE=ndbcluster DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `GLOBAL_PRIVS`
--

DROP TABLE IF EXISTS `GLOBAL_PRIVS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `GLOBAL_PRIVS` (
  `USER_GRANT_ID` bigint(20) NOT NULL,
  `CREATE_TIME` int(11) NOT NULL,
  `GRANT_OPTION` smallint(6) NOT NULL,
  `GRANTOR` varchar(128) CHARACTER SET latin1 COLLATE latin1_bin DEFAULT NULL,
  `GRANTOR_TYPE` varchar(128) CHARACTER SET latin1 COLLATE latin1_bin DEFAULT NULL,
  `PRINCIPAL_NAME` varchar(128) CHARACTER SET latin1 COLLATE latin1_bin DEFAULT NULL,
  `PRINCIPAL_TYPE` varchar(128) CHARACTER SET latin1 COLLATE latin1_bin DEFAULT NULL,
  `USER_PRIV` varchar(128) CHARACTER SET latin1 COLLATE latin1_bin DEFAULT NULL,
  PRIMARY KEY (`USER_GRANT_ID`),
  UNIQUE KEY `GLOBALPRIVILEGEINDEX` (`PRINCIPAL_NAME`,`PRINCIPAL_TYPE`,`USER_PRIV`,`GRANTOR`,`GRANTOR_TYPE`)
) ENGINE=ndbcluster DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `IDXS`
--

DROP TABLE IF EXISTS `IDXS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `IDXS` (
  `INDEX_ID` bigint(20) NOT NULL,
  `CREATE_TIME` int(11) NOT NULL,
  `DEFERRED_REBUILD` bit(1) NOT NULL,
  `INDEX_HANDLER_CLASS` varchar(4000) CHARACTER SET latin1 COLLATE latin1_bin DEFAULT NULL,
  `INDEX_NAME` varchar(128) CHARACTER SET latin1 COLLATE latin1_bin DEFAULT NULL,
  `INDEX_TBL_ID` bigint(20) DEFAULT NULL,
  `LAST_ACCESS_TIME` int(11) NOT NULL,
  `ORIG_TBL_ID` bigint(20) DEFAULT NULL,
  `SD_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`INDEX_ID`),
  UNIQUE KEY `UNIQUEINDEX` (`INDEX_NAME`,`ORIG_TBL_ID`),
  KEY `IDXS_N51` (`INDEX_TBL_ID`),
  KEY `IDXS_N50` (`ORIG_TBL_ID`),
  KEY `IDXS_N49` (`SD_ID`),
  CONSTRAINT `IDX_TBL_IDX_FK` FOREIGN KEY (`INDEX_TBL_ID`) REFERENCES `TBLS` (`TBL_ID`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `TBL_IDX_FK` FOREIGN KEY (`ORIG_TBL_ID`) REFERENCES `TBLS` (`TBL_ID`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `SD_IDX_FK` FOREIGN KEY (`SD_ID`) REFERENCES `SDS` (`SD_ID`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE=ndbcluster DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `INDEX_PARAMS`
--

DROP TABLE IF EXISTS `INDEX_PARAMS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `INDEX_PARAMS` (
  `INDEX_ID` bigint(20) NOT NULL,
  `PARAM_KEY` varchar(256) CHARACTER SET latin1 COLLATE latin1_bin NOT NULL,
  `PARAM_VALUE` varchar(4000) CHARACTER SET latin1 COLLATE latin1_bin DEFAULT NULL,
  PRIMARY KEY (`INDEX_ID`,`PARAM_KEY`),
  KEY `INDEX_PARAMS_N49` (`INDEX_ID`),
  CONSTRAINT `IDX_PARAMS_ID_FK` FOREIGN KEY (`INDEX_ID`) REFERENCES `IDXS` (`INDEX_ID`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE=ndbcluster DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `KEY_CONSTRAINTS`
--

DROP TABLE IF EXISTS `KEY_CONSTRAINTS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `KEY_CONSTRAINTS` (
  `CONSTRAINT_NAME` varchar(255) CHARACTER SET latin1 COLLATE latin1_bin NOT NULL,
  `POSITION` int(11) NOT NULL,
  `CHILD_CD_ID` bigint(20) DEFAULT NULL,
  `CHILD_INTEGER_IDX` int(11) DEFAULT NULL,
  `CHILD_TBL_ID` bigint(20) DEFAULT NULL,
  `CONSTRAINT_TYPE` int(11) NOT NULL,
  `DELETE_RULE` int(11) DEFAULT NULL,
  `ENABLE_VALIDATE_RELY` int(11) NOT NULL,
  `PARENT_CD_ID` bigint(20) DEFAULT NULL,
  `PARENT_INTEGER_IDX` int(11) DEFAULT NULL,
  `PARENT_TBL_ID` bigint(20) DEFAULT NULL,
  `UPDATE_RULE` int(11) DEFAULT NULL,
  PRIMARY KEY (`CONSTRAINT_NAME`,`POSITION`),
  KEY `KEY_CONSTRAINTS_N50` (`CHILD_CD_ID`),
  KEY `KEY_CONSTRAINTS_N51` (`PARENT_CD_ID`),
  KEY `KEY_CONSTRAINTS_N52` (`CHILD_TBL_ID`),
  KEY `KEY_CONSTRAINTS_N49` (`PARENT_TBL_ID`),
  CONSTRAINT `KEY_CONSTRAINTS_FK1` FOREIGN KEY (`CHILD_CD_ID`) REFERENCES `CDS` (`CD_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `KEY_CONSTRAINTS_FK3` FOREIGN KEY (`PARENT_CD_ID`) REFERENCES `CDS` (`CD_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `KEY_CONSTRAINTS_FK2` FOREIGN KEY (`CHILD_TBL_ID`) REFERENCES `TBLS` (`TBL_ID`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `KEY_CONSTRAINTS_FK4` FOREIGN KEY (`PARENT_TBL_ID`) REFERENCES `TBLS` (`TBL_ID`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=ndbcluster DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `MASTER_KEYS`
--

DROP TABLE IF EXISTS `MASTER_KEYS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `MASTER_KEYS` (
  `KEY_ID` int(11) NOT NULL,
  `MASTER_KEY` varchar(767) CHARACTER SET latin1 COLLATE latin1_bin DEFAULT NULL,
  PRIMARY KEY (`KEY_ID`)
) ENGINE=ndbcluster DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `PARTITIONS`
--

DROP TABLE IF EXISTS `PARTITIONS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PARTITIONS` (
  `PART_ID` bigint(20) NOT NULL,
  `CREATE_TIME` int(11) NOT NULL,
  `LAST_ACCESS_TIME` int(11) NOT NULL,
  `PART_NAME` varchar(767) CHARACTER SET latin1 COLLATE latin1_bin DEFAULT NULL,
  `SD_ID` bigint(20) DEFAULT NULL,
  `TBL_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`PART_ID`),
  UNIQUE KEY `UNIQUEPARTITION` (`PART_NAME`,`TBL_ID`),
  KEY `PARTITIONS_N50` (`SD_ID`),
  KEY `PARTITIONS_N49` (`TBL_ID`),
  CONSTRAINT `PART_TBL_FK` FOREIGN KEY (`TBL_ID`) REFERENCES `TBLS` (`TBL_ID`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `PART_SDS_FK` FOREIGN KEY (`SD_ID`) REFERENCES `SDS` (`SD_ID`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE=ndbcluster DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `PARTITION_KEYS`
--

DROP TABLE IF EXISTS `PARTITION_KEYS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PARTITION_KEYS` (
  `TBL_ID` bigint(20) NOT NULL,
  `PKEY_COMMENT` varchar(4000) CHARACTER SET latin1 COLLATE latin1_bin DEFAULT NULL,
  `PKEY_NAME` varchar(128) CHARACTER SET latin1 COLLATE latin1_bin NOT NULL,
  `PKEY_TYPE` varchar(767) CHARACTER SET latin1 COLLATE latin1_bin NOT NULL,
  `INTEGER_IDX` int(11) NOT NULL,
  PRIMARY KEY (`TBL_ID`,`PKEY_NAME`),
  KEY `PARTITION_KEYS_N49` (`TBL_ID`),
  CONSTRAINT `PKEY_TBL_FK` FOREIGN KEY (`TBL_ID`) REFERENCES `TBLS` (`TBL_ID`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE=ndbcluster DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `PARTITION_KEY_VALS`
--

DROP TABLE IF EXISTS `PARTITION_KEY_VALS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PARTITION_KEY_VALS` (
  `PART_ID` bigint(20) NOT NULL,
  `PART_KEY_VAL` varchar(255) CHARACTER SET latin1 COLLATE latin1_bin DEFAULT NULL,
  `INTEGER_IDX` int(11) NOT NULL,
  PRIMARY KEY (`PART_ID`,`INTEGER_IDX`),
  KEY `PARTITION_KEY_VALS_N49` (`PART_ID`),
  CONSTRAINT `PART_KEY_VAL_PART_FK` FOREIGN KEY (`PART_ID`) REFERENCES `PARTITIONS` (`PART_ID`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE=ndbcluster DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `PARTITION_PARAMS`
--

DROP TABLE IF EXISTS `PARTITION_PARAMS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PARTITION_PARAMS` (
  `PART_ID` bigint(20) NOT NULL,
  `PARAM_KEY` varchar(256) CHARACTER SET latin1 COLLATE latin1_bin NOT NULL,
  `PARAM_VALUE` varchar(4000) CHARACTER SET latin1 COLLATE latin1_bin DEFAULT NULL,
  PRIMARY KEY (`PART_ID`,`PARAM_KEY`),
  KEY `PARTITION_PARAMS_N49` (`PART_ID`),
  CONSTRAINT `PART_PARAMS_PART_KF` FOREIGN KEY (`PART_ID`) REFERENCES `PARTITIONS` (`PART_ID`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE=ndbcluster DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `PART_COL_PRIVS`
--

DROP TABLE IF EXISTS `PART_COL_PRIVS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PART_COL_PRIVS` (
  `PART_COLUMN_GRANT_ID` bigint(20) NOT NULL,
  `COLUMN_NAME` varchar(128) CHARACTER SET latin1 COLLATE latin1_bin DEFAULT NULL,
  `CREATE_TIME` int(11) NOT NULL,
  `GRANT_OPTION` smallint(6) NOT NULL,
  `GRANTOR` varchar(128) CHARACTER SET latin1 COLLATE latin1_bin DEFAULT NULL,
  `GRANTOR_TYPE` varchar(128) CHARACTER SET latin1 COLLATE latin1_bin DEFAULT NULL,
  `PART_ID` bigint(20) DEFAULT NULL,
  `PRINCIPAL_NAME` varchar(128) CHARACTER SET latin1 COLLATE latin1_bin DEFAULT NULL,
  `PRINCIPAL_TYPE` varchar(128) CHARACTER SET latin1 COLLATE latin1_bin DEFAULT NULL,
  `PART_COL_PRIV` varchar(128) CHARACTER SET latin1 COLLATE latin1_bin DEFAULT NULL,
  PRIMARY KEY (`PART_COLUMN_GRANT_ID`),
  KEY `PARTITIONCOLUMNPRIVILEGEINDEX` (`PART_ID`,`COLUMN_NAME`,`PRINCIPAL_NAME`,`PRINCIPAL_TYPE`,`PART_COL_PRIV`,`GRANTOR`,`GRANTOR_TYPE`),
  KEY `PART_COL_PRIVS_N49` (`PART_ID`),
  CONSTRAINT `PART_PRIVS_PART_FK` FOREIGN KEY (`PART_ID`) REFERENCES `PARTITIONS` (`PART_ID`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE=ndbcluster DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `PART_COL_STATS`
--

DROP TABLE IF EXISTS `PART_COL_STATS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PART_COL_STATS` (
  `CS_ID` bigint(20) NOT NULL,
  `AVG_COL_LEN` double DEFAULT NULL,
  `COLUMN_NAME` varchar(128) CHARACTER SET latin1 COLLATE latin1_bin NOT NULL,
  `COLUMN_TYPE` varchar(128) CHARACTER SET latin1 COLLATE latin1_bin NOT NULL,
  `DB_NAME` varchar(128) CHARACTER SET latin1 COLLATE latin1_bin NOT NULL,
  `BIG_DECIMAL_HIGH_VALUE` varchar(255) CHARACTER SET latin1 COLLATE latin1_bin DEFAULT NULL,
  `BIG_DECIMAL_LOW_VALUE` varchar(255) CHARACTER SET latin1 COLLATE latin1_bin DEFAULT NULL,
  `DOUBLE_HIGH_VALUE` double DEFAULT NULL,
  `DOUBLE_LOW_VALUE` double DEFAULT NULL,
  `LAST_ANALYZED` bigint(20) NOT NULL,
  `LONG_HIGH_VALUE` bigint(20) DEFAULT NULL,
  `LONG_LOW_VALUE` bigint(20) DEFAULT NULL,
  `MAX_COL_LEN` bigint(20) DEFAULT NULL,
  `NUM_DISTINCTS` bigint(20) DEFAULT NULL,
  `NUM_FALSES` bigint(20) DEFAULT NULL,
  `NUM_NULLS` bigint(20) NOT NULL,
  `NUM_TRUES` bigint(20) DEFAULT NULL,
  `PART_ID` bigint(20) DEFAULT NULL,
  `PARTITION_NAME` varchar(767) CHARACTER SET latin1 COLLATE latin1_bin NOT NULL,
  `TABLE_NAME` varchar(128) CHARACTER SET latin1 COLLATE latin1_bin NOT NULL,
  PRIMARY KEY (`CS_ID`),
  KEY `PART_COL_STATS_N49` (`PART_ID`),
  CONSTRAINT `PART_COL_STATS_PART_FK` FOREIGN KEY (`PART_ID`) REFERENCES `PARTITIONS` (`PART_ID`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE=ndbcluster DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `PART_PRIVS`
--

DROP TABLE IF EXISTS `PART_PRIVS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PART_PRIVS` (
  `PART_GRANT_ID` bigint(20) NOT NULL,
  `CREATE_TIME` int(11) NOT NULL,
  `GRANT_OPTION` smallint(6) NOT NULL,
  `GRANTOR` varchar(128) CHARACTER SET latin1 COLLATE latin1_bin DEFAULT NULL,
  `GRANTOR_TYPE` varchar(128) CHARACTER SET latin1 COLLATE latin1_bin DEFAULT NULL,
  `PART_ID` bigint(20) DEFAULT NULL,
  `PRINCIPAL_NAME` varchar(128) CHARACTER SET latin1 COLLATE latin1_bin DEFAULT NULL,
  `PRINCIPAL_TYPE` varchar(128) CHARACTER SET latin1 COLLATE latin1_bin DEFAULT NULL,
  `PART_PRIV` varchar(128) CHARACTER SET latin1 COLLATE latin1_bin DEFAULT NULL,
  PRIMARY KEY (`PART_GRANT_ID`),
  KEY `PART_PRIVS_N49` (`PART_ID`),
  KEY `PARTPRIVILEGEINDEX` (`PART_ID`,`PRINCIPAL_NAME`,`PRINCIPAL_TYPE`,`PART_PRIV`,`GRANTOR`,`GRANTOR_TYPE`),
  CONSTRAINT `PART_PRIVS_PART_FK` FOREIGN KEY (`PART_ID`) REFERENCES `PARTITIONS` (`PART_ID`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE=ndbcluster DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `ROLES`
--

DROP TABLE IF EXISTS `ROLES`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ROLES` (
  `ROLE_ID` bigint(20) NOT NULL,
  `CREATE_TIME` int(11) NOT NULL,
  `OWNER_NAME` varchar(128) CHARACTER SET latin1 COLLATE latin1_bin DEFAULT NULL,
  `ROLE_NAME` varchar(128) CHARACTER SET latin1 COLLATE latin1_bin DEFAULT NULL,
  PRIMARY KEY (`ROLE_ID`),
  UNIQUE KEY `ROLEENTITYINDEX` (`ROLE_NAME`)
) ENGINE=ndbcluster DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `ROLE_MAP`
--

DROP TABLE IF EXISTS `ROLE_MAP`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ROLE_MAP` (
  `ROLE_GRANT_ID` bigint(20) NOT NULL,
  `ADD_TIME` int(11) NOT NULL,
  `GRANT_OPTION` smallint(6) NOT NULL,
  `GRANTOR` varchar(128) CHARACTER SET latin1 COLLATE latin1_bin DEFAULT NULL,
  `GRANTOR_TYPE` varchar(128) CHARACTER SET latin1 COLLATE latin1_bin DEFAULT NULL,
  `PRINCIPAL_NAME` varchar(128) CHARACTER SET latin1 COLLATE latin1_bin DEFAULT NULL,
  `PRINCIPAL_TYPE` varchar(128) CHARACTER SET latin1 COLLATE latin1_bin DEFAULT NULL,
  `ROLE_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ROLE_GRANT_ID`),
  UNIQUE KEY `USERROLEMAPINDEX` (`PRINCIPAL_NAME`,`ROLE_ID`,`GRANTOR`,`GRANTOR_TYPE`),
  KEY `ROLE_MAP_N49` (`ROLE_ID`),
  CONSTRAINT `ROLE_MAP_FK1` FOREIGN KEY (`ROLE_ID`) REFERENCES `ROLES` (`ROLE_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=ndbcluster DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `SERDES`
--

DROP TABLE IF EXISTS `SERDES`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `SERDES` (
  `SERDE_ID` bigint(20) NOT NULL,
  `NAME` varchar(128) CHARACTER SET latin1 COLLATE latin1_bin DEFAULT NULL,
  `SLIB` varchar(4000) CHARACTER SET latin1 COLLATE latin1_bin DEFAULT NULL,
  PRIMARY KEY (`SERDE_ID`)
) ENGINE=ndbcluster DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `SDS`
--

DROP TABLE IF EXISTS `SDS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `SDS` (
  `SD_ID` bigint(20) NOT NULL,
  `CD_ID` bigint(20) DEFAULT NULL,
  `INPUT_FORMAT` varchar(4000) CHARACTER SET latin1 COLLATE latin1_bin DEFAULT NULL,
  `IS_COMPRESSED` bit(1) NOT NULL,
  `IS_STOREDASSUBDIRECTORIES` bit(1) NOT NULL,
  `LOCATION` varchar(4000) CHARACTER SET latin1 COLLATE latin1_bin DEFAULT NULL,
  `NAME` varchar(255) DEFAULT NULL,
  `NUM_BUCKETS` int(11) NOT NULL,
  `OUTPUT_FORMAT` varchar(4000) CHARACTER SET latin1 COLLATE latin1_bin DEFAULT NULL,
  `PARENT_ID` int(11) DEFAULT NULL,
  `PARTITION_ID` int(11) DEFAULT NULL,
  `SERDE_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`SD_ID`),
  KEY `SDS_N50` (`SERDE_ID`),
  KEY `SDS_N49` (`CD_ID`),
  CONSTRAINT `SDS_FK1` FOREIGN KEY (`CD_ID`) REFERENCES `CDS` (`CD_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `SDS_FK2` FOREIGN KEY (`SERDE_ID`) REFERENCES `SERDES` (`SERDE_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `INODE_SDS_FK` FOREIGN KEY (`PARTITION_ID`, `PARENT_ID`, `NAME`) REFERENCES `hops`.`hdfs_inodes` (`partition_id`, `parent_id`, `name`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=ndbcluster DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `SD_PARAMS`
--

DROP TABLE IF EXISTS `SD_PARAMS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `SD_PARAMS` (
  `SD_ID` bigint(20) NOT NULL,
  `PARAM_KEY` varchar(256) CHARACTER SET latin1 COLLATE latin1_bin NOT NULL,
  `PARAM_VALUE` varchar(4000) CHARACTER SET latin1 COLLATE latin1_bin DEFAULT NULL,
  PRIMARY KEY (`SD_ID`,`PARAM_KEY`),
  KEY `SD_PARAMS_N49` (`SD_ID`),
  CONSTRAINT `PARAMS_SD_FK` FOREIGN KEY (`SD_ID`) REFERENCES `SDS` (`SD_ID`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE=ndbcluster DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `SEQUENCE_TABLE`
--

DROP TABLE IF EXISTS `SEQUENCE_TABLE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `SEQUENCE_TABLE` (
  `SEQUENCE_NAME` varchar(255) CHARACTER SET latin1 COLLATE latin1_bin NOT NULL,
  `NEXT_VAL` bigint(20) NOT NULL,
  PRIMARY KEY (`SEQUENCE_NAME`)
) ENGINE=ndbcluster DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `SERDE_PARAMS`
--

DROP TABLE IF EXISTS `SERDE_PARAMS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `SERDE_PARAMS` (
  `SERDE_ID` bigint(20) NOT NULL,
  `PARAM_KEY` varchar(256) CHARACTER SET latin1 COLLATE latin1_bin NOT NULL,
  `PARAM_VALUE` varchar(4000) CHARACTER SET latin1 COLLATE latin1_bin DEFAULT NULL,
  PRIMARY KEY (`SERDE_ID`,`PARAM_KEY`),
  KEY `SERDE_PARAMS_N49` (`SERDE_ID`),
  CONSTRAINT `SERDE_PARAMS_FK` FOREIGN KEY (`SERDE_ID`) REFERENCES `SERDES` (`SERDE_ID`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE=ndbcluster DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `SKEWED_COL_NAMES`
--

DROP TABLE IF EXISTS `SKEWED_COL_NAMES`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `SKEWED_COL_NAMES` (
  `SD_ID` bigint(20) NOT NULL,
  `SKEWED_COL_NAME` varchar(255) CHARACTER SET latin1 COLLATE latin1_bin DEFAULT NULL,
  `INTEGER_IDX` int(11) NOT NULL,
  PRIMARY KEY (`SD_ID`,`INTEGER_IDX`),
  KEY `SKEWED_COL_NAMES_N49` (`SD_ID`),
  CONSTRAINT `SK_COL_NAME_SDS_FK` FOREIGN KEY (`SD_ID`) REFERENCES `SDS` (`SD_ID`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE=ndbcluster DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `SKEWED_COL_VALUE_LOC_MAP`
--

DROP TABLE IF EXISTS `SKEWED_COL_VALUE_LOC_MAP`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `SKEWED_COL_VALUE_LOC_MAP` (
  `SD_ID` bigint(20) NOT NULL,
  `STRING_LIST_ID_KID` bigint(20) NOT NULL,
  `LOCATION` varchar(4000) CHARACTER SET latin1 COLLATE latin1_bin DEFAULT NULL,
  PRIMARY KEY (`SD_ID`,`STRING_LIST_ID_KID`),
  KEY `SKEWED_COL_VALUE_LOC_MAP_N50` (`STRING_LIST_ID_KID`),
  KEY `SKEWED_COL_VALUE_LOC_MAP_N49` (`SD_ID`),
  CONSTRAINT `SKEWED_COL_VALUE_LOC_MAP_FK1` FOREIGN KEY (`STRING_LIST_ID_KID`) REFERENCES `SKEWED_STRING_LIST` (`STRING_LIST_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `SKVAL_SD_FK` FOREIGN KEY (`SD_ID`) REFERENCES `SDS` (`SD_ID`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE=ndbcluster DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `SKEWED_STRING_LIST`
--

DROP TABLE IF EXISTS `SKEWED_STRING_LIST`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `SKEWED_STRING_LIST` (
  `STRING_LIST_ID` bigint(20) NOT NULL,
  PRIMARY KEY (`STRING_LIST_ID`)
) ENGINE=ndbcluster DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `SKEWED_STRING_LIST_VALUES`
--

DROP TABLE IF EXISTS `SKEWED_STRING_LIST_VALUES`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `SKEWED_STRING_LIST_VALUES` (
  `STRING_LIST_ID` bigint(20) NOT NULL,
  `STRING_LIST_VALUE` varchar(255) CHARACTER SET latin1 COLLATE latin1_bin DEFAULT NULL,
  `INTEGER_IDX` int(11) NOT NULL,
  PRIMARY KEY (`STRING_LIST_ID`,`INTEGER_IDX`),
  KEY `SKEWED_STRING_LIST_VALUES_N49` (`STRING_LIST_ID`),
  CONSTRAINT `SKEWED_STRING_LIST_VALUES_FK` FOREIGN KEY (`STRING_LIST_ID`) REFERENCES `SKEWED_STRING_LIST` (`STRING_LIST_ID`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE=ndbcluster DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `SKEWED_VALUES`
--

DROP TABLE IF EXISTS `SKEWED_VALUES`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `SKEWED_VALUES` (
  `SD_ID_OID` bigint(20) NOT NULL,
  `STRING_LIST_ID_EID` bigint(20) DEFAULT NULL,
  `INTEGER_IDX` int(11) NOT NULL,
  PRIMARY KEY (`SD_ID_OID`,`INTEGER_IDX`),
  KEY `SKEWED_VALUES_N50` (`STRING_LIST_ID_EID`),
  KEY `SKEWED_VALUES_N49` (`SD_ID_OID`),
  CONSTRAINT `SKEWED_VALUES_FK2` FOREIGN KEY (`STRING_LIST_ID_EID`) REFERENCES `SKEWED_STRING_LIST` (`STRING_LIST_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `SKEWED_VALUES_FK1` FOREIGN KEY (`SD_ID_OID`) REFERENCES `SDS` (`SD_ID`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=ndbcluster DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `SORT_COLS`
--

DROP TABLE IF EXISTS `SORT_COLS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `SORT_COLS` (
  `SD_ID` bigint(20) NOT NULL,
  `COLUMN_NAME` varchar(128) CHARACTER SET latin1 COLLATE latin1_bin DEFAULT NULL,
  `ORDER` int(11) NOT NULL,
  `INTEGER_IDX` int(11) NOT NULL,
  PRIMARY KEY (`SD_ID`,`INTEGER_IDX`),
  KEY `SORT_COLS_N49` (`SD_ID`),
  CONSTRAINT `SORT_SD_FK` FOREIGN KEY (`SD_ID`) REFERENCES `SDS` (`SD_ID`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE=ndbcluster DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `TABLE_PARAMS`
--

DROP TABLE IF EXISTS `TABLE_PARAMS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TABLE_PARAMS` (
  `TBL_ID` bigint(20) NOT NULL,
  `PARAM_KEY` varchar(256) CHARACTER SET latin1 COLLATE latin1_bin NOT NULL,
  `PARAM_VALUE` varchar(4000) CHARACTER SET latin1 COLLATE latin1_bin DEFAULT NULL,
  PRIMARY KEY (`TBL_ID`,`PARAM_KEY`),
  KEY `TABLE_PARAMS_N49` (`TBL_ID`),
  CONSTRAINT `PARAM_TBL_FK` FOREIGN KEY (`TBL_ID`) REFERENCES `TBLS` (`TBL_ID`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE=ndbcluster DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `TAB_COL_STATS`
--

DROP TABLE IF EXISTS `TAB_COL_STATS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TAB_COL_STATS` (
  `CS_ID` bigint(20) NOT NULL,
  `AVG_COL_LEN` double DEFAULT NULL,
  `COLUMN_NAME` varchar(128) CHARACTER SET latin1 COLLATE latin1_bin NOT NULL,
  `COLUMN_TYPE` varchar(128) CHARACTER SET latin1 COLLATE latin1_bin NOT NULL,
  `DB_NAME` varchar(128) CHARACTER SET latin1 COLLATE latin1_bin NOT NULL,
  `BIG_DECIMAL_HIGH_VALUE` varchar(255) CHARACTER SET latin1 COLLATE latin1_bin DEFAULT NULL,
  `BIG_DECIMAL_LOW_VALUE` varchar(255) CHARACTER SET latin1 COLLATE latin1_bin DEFAULT NULL,
  `DOUBLE_HIGH_VALUE` double DEFAULT NULL,
  `DOUBLE_LOW_VALUE` double DEFAULT NULL,
  `LAST_ANALYZED` bigint(20) NOT NULL,
  `LONG_HIGH_VALUE` bigint(20) DEFAULT NULL,
  `LONG_LOW_VALUE` bigint(20) DEFAULT NULL,
  `MAX_COL_LEN` bigint(20) DEFAULT NULL,
  `NUM_DISTINCTS` bigint(20) DEFAULT NULL,
  `NUM_FALSES` bigint(20) DEFAULT NULL,
  `NUM_NULLS` bigint(20) NOT NULL,
  `NUM_TRUES` bigint(20) DEFAULT NULL,
  `TBL_ID` bigint(20) DEFAULT NULL,
  `TABLE_NAME` varchar(128) CHARACTER SET latin1 COLLATE latin1_bin NOT NULL,
  PRIMARY KEY (`CS_ID`),
  KEY `TAB_COL_STATS_N49` (`TBL_ID`),
  CONSTRAINT `COL_STATS_TBL_FK` FOREIGN KEY (`TBL_ID`) REFERENCES `TBLS` (`TBL_ID`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE=ndbcluster DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `TBLS`
--

DROP TABLE IF EXISTS `TBLS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TBLS` (
  `TBL_ID` bigint(20) NOT NULL,
  `CREATE_TIME` int(11) NOT NULL,
  `DB_ID` bigint(20) DEFAULT NULL,
  `LAST_ACCESS_TIME` int(11) NOT NULL,
  `OWNER` varchar(767) CHARACTER SET latin1 COLLATE latin1_bin DEFAULT NULL,
  `RETENTION` int(11) NOT NULL,
  `IS_REWRITE_ENABLED` bit(1) NOT NULL,
  `SD_ID` bigint(20) DEFAULT NULL,
  `TBL_NAME` varchar(128) CHARACTER SET latin1 COLLATE latin1_bin DEFAULT NULL,
  `TBL_TYPE` varchar(128) CHARACTER SET latin1 COLLATE latin1_bin DEFAULT NULL,
  `VIEW_EXPANDED_TEXT` text,
  `VIEW_ORIGINAL_TEXT` text,
  PRIMARY KEY (`TBL_ID`),
  UNIQUE KEY `UNIQUETABLE` (`TBL_NAME`,`DB_ID`),
  KEY `TBLS_N50` (`DB_ID`),
  KEY `TBLS_N49` (`SD_ID`),
  CONSTRAINT `TBL_DB_FK` FOREIGN KEY (`DB_ID`) REFERENCES `DBS` (`DB_ID`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `TBL_SD_FK` FOREIGN KEY (`SD_ID`) REFERENCES `SDS` (`SD_ID`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE=ndbcluster DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `TBL_COL_PRIVS`
--

DROP TABLE IF EXISTS `TBL_COL_PRIVS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TBL_COL_PRIVS` (
  `TBL_COLUMN_GRANT_ID` bigint(20) NOT NULL,
  `COLUMN_NAME` varchar(128) CHARACTER SET latin1 COLLATE latin1_bin DEFAULT NULL,
  `CREATE_TIME` int(11) NOT NULL,
  `GRANT_OPTION` smallint(6) NOT NULL,
  `GRANTOR` varchar(128) CHARACTER SET latin1 COLLATE latin1_bin DEFAULT NULL,
  `GRANTOR_TYPE` varchar(128) CHARACTER SET latin1 COLLATE latin1_bin DEFAULT NULL,
  `PRINCIPAL_NAME` varchar(128) CHARACTER SET latin1 COLLATE latin1_bin DEFAULT NULL,
  `PRINCIPAL_TYPE` varchar(128) CHARACTER SET latin1 COLLATE latin1_bin DEFAULT NULL,
  `TBL_COL_PRIV` varchar(128) CHARACTER SET latin1 COLLATE latin1_bin DEFAULT NULL,
  `TBL_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`TBL_COLUMN_GRANT_ID`),
  KEY `TABLECOLUMNPRIVILEGEINDEX` (`TBL_ID`,`COLUMN_NAME`,`PRINCIPAL_NAME`,`PRINCIPAL_TYPE`,`TBL_COL_PRIV`,`GRANTOR`,`GRANTOR_TYPE`),
  KEY `TBL_COL_PRIVS_N49` (`TBL_ID`),
  CONSTRAINT `COL_PRIVS_TBL_FK` FOREIGN KEY (`TBL_ID`) REFERENCES `TBLS` (`TBL_ID`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE=ndbcluster DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `TBL_PRIVS`
--

DROP TABLE IF EXISTS `TBL_PRIVS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TBL_PRIVS` (
  `TBL_GRANT_ID` bigint(20) NOT NULL,
  `CREATE_TIME` int(11) NOT NULL,
  `GRANT_OPTION` smallint(6) NOT NULL,
  `GRANTOR` varchar(128) CHARACTER SET latin1 COLLATE latin1_bin DEFAULT NULL,
  `GRANTOR_TYPE` varchar(128) CHARACTER SET latin1 COLLATE latin1_bin DEFAULT NULL,
  `PRINCIPAL_NAME` varchar(128) CHARACTER SET latin1 COLLATE latin1_bin DEFAULT NULL,
  `PRINCIPAL_TYPE` varchar(128) CHARACTER SET latin1 COLLATE latin1_bin DEFAULT NULL,
  `TBL_PRIV` varchar(128) CHARACTER SET latin1 COLLATE latin1_bin DEFAULT NULL,
  `TBL_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`TBL_GRANT_ID`),
  KEY `TABLEPRIVILEGEINDEX` (`TBL_ID`,`PRINCIPAL_NAME`,`PRINCIPAL_TYPE`,`TBL_PRIV`,`GRANTOR`,`GRANTOR_TYPE`),
  KEY `TBL_PRIVS_N49` (`TBL_ID`),
  CONSTRAINT `PRIVS_TBL_FK` FOREIGN KEY (`TBL_ID`) REFERENCES `TBLS` (`TBL_ID`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE=ndbcluster DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `VERSION`
--

DROP TABLE IF EXISTS `VERSION`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `VERSION` (
  `VER_ID` bigint(20) NOT NULL,
  `SCHEMA_VERSION` varchar(127) CHARACTER SET latin1 COLLATE latin1_bin NOT NULL,
  `VERSION_COMMENT` varchar(255) CHARACTER SET latin1 COLLATE latin1_bin NOT NULL,
  PRIMARY KEY (`VER_ID`)
) ENGINE=ndbcluster DEFAULT CHARSET=latin1;

-- ----------------------------
-- Indexes
-- ----------------------------

CREATE INDEX PCS_STATS_IDX ON PART_COL_STATS (DB_NAME,TABLE_NAME,COLUMN_NAME,PARTITION_NAME) USING BTREE;
CREATE INDEX `CONSTRAINTS_PARENT_TABLE_ID_INDEX` ON KEY_CONSTRAINTS (`PARENT_TBL_ID`) USING BTREE;

-- ----------------------------
-- Transaction and Lock Tables
-- ----------------------------
SOURCE hive-txn-schema-2.2.0.mysql.sql;

-- -----------------------------------------------------------------
-- Record schema version. Should be the last step in the init script
-- -----------------------------------------------------------------
INSERT INTO VERSION (VER_ID, SCHEMA_VERSION, VERSION_COMMENT) VALUES (1, '2.2.0', 'Hive release version 2.2.0');

/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-03-12 22:26:19
