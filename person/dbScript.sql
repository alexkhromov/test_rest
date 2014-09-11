begin
  EXECUTE IMMEDIATE 'create table PERSON( ID NUMBER PRIMARY KEY, NAME VARCHAR2( 255 CHAR ), AGE NUMBER, HIREDATE DATE, POSITION VARCHAR2( 255 CHAR ), EXPERIENCE NUMBER, SALARY NUMBER )';
  
  EXECUTE IMMEDIATE 'create sequence PERSON_ID_SEQUENCE start with 1 increment by 1';
end;
/