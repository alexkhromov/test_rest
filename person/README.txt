environment: Win 7, Java 7, Oracle XE 11.2.0.2.0, Tomcat 7.0.47



****SETUP JAVA********************************************************************
-add new environment variable: name: JAVA_HOME
                               value: C:\Program Files\Java\jdk1.7.0_45 ( example ) 

-add to environment variable path: value: %JAVA_HOME%\bin
**********************************************************************************



****SETUP TOMCAT******************************************************************
-add new environment variable: name: CATALINA_HOME
                               value: C:\J2EE\Tomcat_7.0.47 ( example ) 

-add to environment variable path: value: %CATALINA_HOME%\bin

-add new environment variable: name: CATALINA_OPTS
                               value: -Duser.language=en -Duser.region=us
                                      -Xms128m -Xmx1024m
                                      -XX:PermSize=64m -XX:MaxPermSize=256m

-open %CATALINA_HOME%\conf\server.xml and update in <Service name="Catalina"></Service>
 section connector represents an endpoint by which requests are received
 and responses are returned:
	
	<Connector port="8085" protocol="HTTP/1.1" 
		connectionTimeout="20000" 
		redirectPort="8443"
		URIEncoding="UTF-8"/>

-open %CATALINA_HOME%\conf\tomcat-users.xml and add into <tomcat-users></tomcat-users>
 section next lines:
	
	<user username="managerScript" password="Babc123" roles="manager-script"/>

-for Tomcat 6 or below open person\pom.xml and change line:
	
	<url>http://localhost:8085/manager/text</url>

	to:

	<url>http://localhost:8085/manager/</url>
**********************************************************************************



****SETUP MAVEN*******************************************************************
-add new environment variable: name: M2_HOME
                               value: C:\J2EE\Maven ( example ) 

-add to environment variable path: value: %M2_HOME%\bin

-open %M2_HOME%\conf\settings.xml and add into <servers></servers> section 
 next lines:
	
	<server>
		<id>localhost-server</id>
		<username>managerScript</username>
		<password>Babc123</password>
	</server>
**********************************************************************************



****SETUP ORACLE******************************************************************
-add new environment variable: name: NLS_LANG
                               value: AMERICAN_AMERICA.CL8MSWIN1251 
**********************************************************************************



****SETUP PROJECT*****************************************************************
-database configuration in scand-test-khromov\web\src\main\resources\spring\Database.xml 
**********************************************************************************



****INSTALL AND RUN PROJECT*******************************************************
-open scand-test-khromov\install.bat  and configure next line:

	sqlplus / as sysdba @%currentDirectory%\userScript.sql 

	with your DBA account ( in case using different DB )

-run install.bat and open link http://localhost:8085/person/
**********************************************************************************       
