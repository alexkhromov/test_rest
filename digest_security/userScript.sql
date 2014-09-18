DROP USER test1rest CASCADE;
CREATE USER test1rest IDENTIFIED BY test1rest;
grant connect, resource, dba to test1rest;
connect test1rest/test1rest;
exit;