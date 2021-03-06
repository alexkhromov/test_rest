declare
PERSONID NUMBER;
begin
  EXECUTE IMMEDIATE 'select PERSON_ID_SEQUENCE.nextval from dual' INTO PERSONID;
  EXECUTE IMMEDIATE 'INSERT INTO PERSON ( ID, NAME, AGE, HIREDATE, POSITION, EXPERIENCE, SALARY ) VALUES ( :1, ''John Smith'', 40, TO_DATE( ''2011-02-01'',''YYYY-MM-DD'' ), ''Project Manager'', 15, 1000 )'
  USING PERSONID;
  
  EXECUTE IMMEDIATE 'select PERSON_ID_SEQUENCE.nextval from dual' INTO PERSONID;
  EXECUTE IMMEDIATE 'INSERT INTO PERSON ( ID, NAME, AGE, HIREDATE, POSITION, EXPERIENCE, SALARY ) VALUES ( :1, ''James Bond'', 45, TO_DATE( ''2010-10-10'',''YYYY-MM-DD'' ), ''Java Developer'', 20, 1200 )'
  USING PERSONID; 

  EXECUTE IMMEDIATE 'select PERSON_ID_SEQUENCE.nextval from dual' INTO PERSONID;
  EXECUTE IMMEDIATE 'INSERT INTO PERSON ( ID, NAME, AGE, HIREDATE, POSITION, EXPERIENCE, SALARY ) VALUES ( :1, ''Andrew Erlicson'', 35, TO_DATE( ''2012-05-17'',''YYYY-MM-DD'' ), ''MondoDB DBA'', 12, 1500 )'
  USING PERSONID;  

  EXECUTE IMMEDIATE 'select PERSON_ID_SEQUENCE.nextval from dual' INTO PERSONID;
  EXECUTE IMMEDIATE 'INSERT INTO PERSON ( ID, NAME, AGE, HIREDATE, POSITION, EXPERIENCE, SALARY ) VALUES ( :1, ''John Hoffman'', 30, TO_DATE( ''2014-07-22'',''YYYY-MM-DD'' ), ''Senior Java Developer'', 10, 2000 )'
  USING PERSONID;  

  EXECUTE IMMEDIATE 'select PERSON_ID_SEQUENCE.nextval from dual' INTO PERSONID;
  EXECUTE IMMEDIATE 'INSERT INTO PERSON ( ID, NAME, AGE, HIREDATE, POSITION, EXPERIENCE, SALARY ) VALUES ( :1, ''Alex Khromov'', 33, TO_DATE( ''2014-08-04'',''YYYY-MM-DD'' ), ''Junior Java Developer'', 11, 900 )'
  USING PERSONID;

  EXECUTE IMMEDIATE 'INSERT INTO USERS ( USERNAME, USERPASSWORD ) VALUES ( ''restful'', ''restful'' )';
  EXECUTE IMMEDIATE 'INSERT INTO USERS ( USERNAME, USERPASSWORD ) VALUES ( ''restcust'', ''restcust'' )';

  EXECUTE IMMEDIATE 'INSERT INTO ROLE ( ROLENAME) VALUES ( ''restful'' )';
  EXECUTE IMMEDIATE 'INSERT INTO ROLE ( ROLENAME) VALUES ( ''restcust'' )';

  EXECUTE IMMEDIATE 'INSERT INTO USERROLE ( USERNAME, ROLENAME ) VALUES ( ''restful'', ''restful'' )';
  EXECUTE IMMEDIATE 'INSERT INTO USERROLE ( USERNAME, ROLENAME ) VALUES ( ''restcust'', ''restcust'' )';
end;
/