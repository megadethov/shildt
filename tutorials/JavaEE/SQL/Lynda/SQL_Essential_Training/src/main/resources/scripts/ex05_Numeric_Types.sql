-- 01 numeric types
-- database.db

-- demonstrates comparing two REAL numbers
/*SELECT A, B, A = B FROM
  ( SELECT ( ( .1 + .2 ) * 10 ) as A,
           ( 1.0 + 2.0 ) as B );*/

-- same demonstration using SQLite CAST function
/*SELECT A, B, A = B FROM
  ( SELECT ( CAST(.1 AS REAL) + CAST(.2 AS REAL) ) * CAST(10 AS REAL) as A,
           ( CAST(1 AS REAL) + CAST(2 AS REAL) ) as B );*/

# todo it's not work with MySQL

-- 02 typeof---------------------------------------------------------------------------------
-- :memory:

SELECT TYPEOF( 1 + 1 );
SELECT TYPEOF( 1 + 1.0 );
SELECT TYPEOF('panda');
SELECT TYPEOF('panda' + 'koala');

# todo it's not work with MySQL

-- 03 INTEGER division----------------------------------------------------------------------
-- :memory:

SELECT 1 / 2;
SELECT 1.0 / 2;
SELECT 17 / 5;
SELECT 17 / 5, 17 % 5;

-- 04 ROUND()------------------------------------------------------------------------------
-- :memory:

SELECT 2.55555;
SELECT ROUND(2.55555);
SELECT ROUND(2.55555, 3);
SELECT ROUND(2.55555, 0);