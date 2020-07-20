DELIMITER $$
alter table  COLUMNS_V2 drop foreign key COLUMNS_V2_FK1$$

alter table CTLGS drop foreign key `DB_SD_FK`, add constraint `CTLGS_SD_FK` foreign key (`SD_ID`) REFERENCES `SDS` (`SD_ID`) ON DELETE CASCADE ON UPDATE RESTRICT$$

alter table `SD_PARAMS` drop foreign key `SD_PARAMS_FK1`$$

alter table `SERDE_PARAMS`  drop foreign key `SERDE_PARAMS_FK2`$$

alter table `TABLE_PARAMS` drop foreign key `TABLE_PARAMS_FK1`$$

alter table `TABLE_PARAMS` add KEY `TPTIDIndex` (`TBL_ID`)$$

alter table `TBLS` drop foreign key `TBLS_FK1`, drop foreign key `TBLS_FK2`$$

alter table `TAB_COL_STATS` drop foreign key `TAB_COL_STATS_FK`$$

alter table `TAB_COL_STATS` add KEY `TCSTIDIndex` (`TBL_ID`) $$

alter table `PART_COL_STATS` drop foreign key `PART_COL_STATS_FK`$$

alter table `PART_COL_STATS` add   KEY `PartIndex` (`PART_ID`)$$

drop PROCEDURE if exists drop_schema_version_fks$$

CREATE PROCEDURE drop_schema_version_fks()
BEGIN
  DECLARE FK varchar(100) DEFAULT "";
  DECLARE finished INTEGER DEFAULT 0;
  DECLARE test varchar(100) DEFAULT "fun";

  DECLARE curFKs CURSOR FOR
     SELECT `CONSTRAINT_NAME` FROM information_schema.TABLE_CONSTRAINTS WHERE CONSTRAINT_TYPE="FOREIGN KEY" AND
`TABLE_NAME`="SCHEMA_VERSION" AND `CONSTRAINT_SCHEMA`="metastore";

  DECLARE CONTINUE HANDLER
    FOR NOT FOUND SET finished = 1;

  OPEN curFKs;

  deleteFKs: LOOP
    FETCH curFKs INTO FK;

    IF finished = 1 THEN
      LEAVE deleteFKs;
    END IF;

    SET @alter_statement=CONCAT('ALTER TABLE SCHEMA_VERSION DROP FOREIGN KEY `',FK,'`');

    PREPARE stmt1 FROM @alter_statement;
    EXECUTE stmt1;
    DEALLOCATE PREPARE stmt1;


  END LOOP deleteFKs;
  CLOSE curFKs;

END$$

CALL  drop_schema_version_fks()$$

drop PROCEDURE if exists drop_schema_version_fks$$

ALTER TABLE `SCHEMA_VERSION` ADD KEY `SIIndex` (`SCHEMA_ID`)$$

ALTER TABLE `SCHEMA_VERSION` ADD KEY `SERDEIDIndex` (`SERDE_ID`)$$

ALTER TABLE `SCHEMA_VERSION` ADD KEY `CDIDIndex` (`CD_ID`)$$



