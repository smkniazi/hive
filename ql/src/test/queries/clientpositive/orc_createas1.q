set hive.vectorized.execution.enabled=false;
set hive.mapred.mode=nonstrict;
set mapred.max.split.size=100;
set mapred.min.split.size=1;
set hive.input.format=org.apache.hadoop.hive.ql.io.HiveInputFormat;

DROP TABLE orc_createas1a;
DROP TABLE orc_createas1b;
DROP TABLE orc_createas1c;

CREATE TABLE orc_createas1a (key INT, value STRING)
    PARTITIONED BY (ds string);
INSERT OVERWRITE TABLE orc_createas1a PARTITION (ds='1')
    SELECT * FROM src;
INSERT OVERWRITE TABLE orc_createas1a PARTITION (ds='2')
    SELECT * FROM src;

EXPLAIN CREATE TABLE orc_createas1b
    STORED AS ORC AS
    SELECT * FROM src;

CREATE TABLE orc_createas1b
    STORED AS ORC AS
    SELECT * FROM src;

EXPLAIN SELECT * FROM orc_createas1b ORDER BY key LIMIT 5;

SELECT * FROM orc_createas1b ORDER BY key LIMIT 5;

EXPLAIN
    CREATE TABLE orc_createas1c
    STORED AS ORC AS 
        SELECT key, value, PMOD(HASH(key), 50) as part
        FROM orc_createas1a;
CREATE TABLE orc_createas1c
    STORED AS ORC AS 
        SELECT key, value, PMOD(HASH(key), 50) as part
        FROM orc_createas1a;

SELECT SUM(HASH(c)) FROM (
    SELECT TRANSFORM(key, value) USING 'tr \t _' AS (c)
    FROM orc_createas1a
) t;
SELECT SUM(HASH(c)) FROM (
    SELECT TRANSFORM(key, value) USING 'tr \t _' AS (c)
    FROM orc_createas1c
) t;

DROP TABLE orc_createas1a;
DROP TABLE orc_createas1b;
DROP TABLE orc_createas1c;
