/*
The following changes are related to Migration to NDB8
The following changes are implemented using procedures 
so that database upgrades do not fail as these changes 
might be applied twice. First at the time of manually 
migrationg NDB and later by karamel. 
*/
DELIMITER $$

SELECT 'Upgrading MetaStore schema from 3.0.0.5 to 3.0.0.6' AS ' '$$

/*
    DROP_FOREIGN_KEY_IF_EXISTS
*/
DROP PROCEDURE IF EXISTS DROP_FOREIGN_KEY_IF_EXISTS$$

CREATE PROCEDURE DROP_FOREIGN_KEY_IF_EXISTS(IN tableName VARCHAR(128), IN constraintName VARCHAR(128))
BEGIN
    IF EXISTS(
        SELECT * FROM information_schema.TABLE_CONSTRAINTS
        WHERE 
            TABLE_SCHEMA    = DATABASE()     AND
            TABLE_NAME      = tableName      AND
            CONSTRAINT_NAME = constraintName AND
            CONSTRAINT_TYPE = 'FOREIGN KEY')
    THEN
        SET @query = CONCAT('ALTER TABLE ', DATABASE(), ".", tableName, ' DROP FOREIGN KEY ', constraintName);
        PREPARE stmt FROM @query; 
        EXECUTE stmt; 
        DEALLOCATE PREPARE stmt; 
    ELSE
        SELECT concat('Unable to delete foreign key as it does not exist. Foreign Key: ', constraintName) AS ' ';
    END IF; 
END$$

/*
    CREATE_KEY_IF_NOT_EXISTS 
*/
DROP PROCEDURE IF EXISTS CREATE_KEY_IF_NOT_EXISTS$$

CREATE PROCEDURE CREATE_KEY_IF_NOT_EXISTS(IN tableName VARCHAR(128), IN keyName VARCHAR(128), IN tableColumn VARCHAR(128))
BEGIN
    IF EXISTS(
        SELECT * FROM information_schema.STATISTICS 
        WHERE 
            TABLE_SCHEMA  = DATABASE()      AND
            TABLE_NAME    = tableName       AND
            INDEX_NAME    = keyName
        )
    THEN
        SELECT concat('Unable to create KEY as it already exist. KEY: ', keyName) AS ' ';
    ELSE
        SET @query = CONCAT('ALTER TABLE ', DATABASE(), ".", tableName, ' ADD KEY ', keyName, '(', tableColumn, ')');
        PREPARE stmt FROM @query; 
        EXECUTE stmt; 
        DEALLOCATE PREPARE stmt; 
    END IF; 
END$$

/*
    CREATE_FOREIGN_KEY_IF_NOT_EXISTS
*/
DROP PROCEDURE IF EXISTS CREATE_FOREIGN_KEY_IF_NOT_EXISTS$$

CREATE PROCEDURE CREATE_FOREIGN_KEY_IF_NOT_EXISTS(
    IN tableName VARCHAR(128),
    IN tableColumn VARCHAR(128),
    IN constraintName VARCHAR(128),
    IN constraintTable VARCHAR(128),
    IN contraintColumn VARCHAR(128))
BEGIN
    IF EXISTS(
        SELECT * FROM information_schema.TABLE_CONSTRAINTS
        WHERE 
            TABLE_SCHEMA    = DATABASE()     AND
            TABLE_NAME      = tableName      AND
            CONSTRAINT_NAME = constraintName AND
            CONSTRAINT_TYPE = 'FOREIGN KEY')
    THEN
        SELECT concat('Unable to create foreign key as it already exists. Foreign Key: ', constraintName) AS ' ';
    ELSE
        SET @query = CONCAT('ALTER TABLE ', DATABASE(), ".", tableName, ' ADD CONSTRAINT ', constraintName, ' FOREIGN KEY (', tableColumn, ') REFERENCES ', constraintTable, '(', contraintColumn, ') ', '  ON DELETE CASCADE ON UPDATE RESTRICT'  );
        PREPARE stmt FROM @query; 
        EXECUTE stmt; 
        DEALLOCATE PREPARE stmt; 
    END IF; 
END$$

CALL DROP_FOREIGN_KEY_IF_EXISTS('COLUMNS_V2', 'COLUMNS_V2_FK1')$$

CALL DROP_FOREIGN_KEY_IF_EXISTS('CTLGS', 'DB_SD_FK')$$
CALL CREATE_FOREIGN_KEY_IF_NOT_EXISTS('CTLGS', 'SD_ID', 'CTLGS_SK_FK', 'SDS', 'SD_ID')$$

CALL DROP_FOREIGN_KEY_IF_EXISTS('SD_PARAMS', 'SD_PARAMS_FK1')$$

CALL DROP_FOREIGN_KEY_IF_EXISTS('SERDE_PARAMS', 'SERDE_PARAMS_FK2')$$

CALL DROP_FOREIGN_KEY_IF_EXISTS('TABLE_PARAMS', 'TABLE_PARAMS_FK1')$$
CALL CREATE_KEY_IF_NOT_EXISTS('TABLE_PARAMS', 'TPTIDIndex', 'TBL_ID')$$

CALL DROP_FOREIGN_KEY_IF_EXISTS('TBLS', 'TBLS_FK1')$$
CALL DROP_FOREIGN_KEY_IF_EXISTS('TBLS', 'TBLS_FK2')$$

CALL DROP_FOREIGN_KEY_IF_EXISTS('TAB_COL_STATS', 'TAB_COL_STATS_FK')$$
CALL CREATE_KEY_IF_NOT_EXISTS('TAB_COL_STATS', 'TCSTIDIndex', 'TBL_ID')$$

CALL DROP_FOREIGN_KEY_IF_EXISTS('PART_COL_STATS', 'PART_COL_STATS_FK')$$
CALL CREATE_KEY_IF_NOT_EXISTS('PART_COL_STATS', 'PartIndex', 'PART_ID')$$

DROP PROCEDURE IF EXISTS DROP_SCHEMA_VERSION_FKS$$

CREATE PROCEDURE DROP_SCHEMA_VERSION_FKS()
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

CALL  DROP_SCHEMA_VERSION_FKS()$$

CALL CREATE_KEY_IF_NOT_EXISTS('SCHEMA_VERSION', 'SIIndex', 'SCHEMA_ID')$$
CALL CREATE_KEY_IF_NOT_EXISTS('SCHEMA_VERSION', 'SERDEIDIndex', 'SERDE_ID')$$
CALL CREATE_KEY_IF_NOT_EXISTS('SCHEMA_VERSION', 'CDIDIndex', 'CD_ID')$$

DROP PROCEDURE IF EXISTS DROP_FOREIGN_KEY_IF_EXISTS$$

DROP PROCEDURE IF EXISTS CREATE_FOREIGN_KEY_IF_NOT_EXISTS$$

DROP PROCEDURE IF EXISTS DROP_SCHEMA_VERSION_FKS$$

-- These lines need to be last.  Insert any changes above.
UPDATE VERSION SET SCHEMA_VERSION='3.0.0.6', VERSION_COMMENT='Hive release version 3.0.0.6' where VER_ID=1$$
SELECT 'Finished upgrading MetaStore schema from 3.0.0.5 to 3.0.0.6' AS ' '$$

DELIMITER ;
