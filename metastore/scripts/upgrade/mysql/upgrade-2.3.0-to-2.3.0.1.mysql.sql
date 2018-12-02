SELECT 'Upgrading MetaStore schema from 2.3.0 to 2.3.0.1' AS ' ';

SOURCE 041-HOPSWORKS-683.mysql.sql;

UPDATE VERSION SET SCHEMA_VERSION='2.3.0.1', VERSION_COMMENT='Hive release version 2.3.0.1' where VER_ID=1;
SELECT 'Finished upgrading MetaStore schema from 2.3.0 to 2.3.0.1' AS ' ';

