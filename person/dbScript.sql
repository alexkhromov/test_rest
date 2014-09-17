begin
  EXECUTE IMMEDIATE 'create table PERSON ( ID NUMBER PRIMARY KEY, NAME VARCHAR2 ( 255 CHAR ), AGE NUMBER, HIREDATE DATE, POSITION VARCHAR2 ( 255 CHAR ), EXPERIENCE NUMBER, SALARY NUMBER )';
  
  EXECUTE IMMEDIATE 'create sequence PERSON_ID_SEQUENCE start with 1 increment by 1';

  EXECUTE IMMEDIATE 'create table USERS ( USERNAME VARCHAR2 ( 255 CHAR ) NOT NULL, USERPASSWORD VARCHAR2 ( 255 CHAR ) NOT NULL, PRIMARY KEY ( USERNAME ) )';
  EXECUTE IMMEDIATE 'create table ROLE ( ROLENAME VARCHAR2 ( 255 CHAR ) NOT NULL, PRIMARY KEY ( ROLENAME ) )';
  EXECUTE IMMEDIATE 'create table USERROLE ( USERNAME VARCHAR2 ( 255 CHAR ) NOT NULL, ROLENAME VARCHAR2 ( 255 CHAR ) NOT NULL )';

  EXECUTE IMMEDIATE 'alter table USERROLE add foreign key ( USERNAME ) references USERS ( USERNAME ) on delete cascade';
  EXECUTE IMMEDIATE 'alter table USERROLE add foreign key ( ROLENAME ) references ROLE ( ROLENAME ) on delete cascade';
end;
/