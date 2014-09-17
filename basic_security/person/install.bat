@echo off
set currentDirectory=%cd%

sqlplus / as sysdba @%currentDirectory%\userScript.sql 
exit|sqlplus test1rest/test1rest @%currentDirectory%\dbScript.sql
exit|sqlplus test1rest/test1rest @%currentDirectory%\insertScript.sql

mvn clean install
pause