environment: Win 8, Java 8, Oracle XE 11.2.0.2.0, Tomcat 8.0.17



****SETUP JAVA********************************************************************
-add new environment variable: name: JAVA_HOME
                               value: C:\Program Files\Java\jdk1.8.0_25 ( example ) 

-add to environment variable path: value: %JAVA_HOME%\bin
**********************************************************************************



****SETUP TOMCAT******************************************************************
-add new environment variable: name: CATALINA_HOME
                               value: C:\J2EE\Tomcat_8.0.17 ( example ) 

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

-open %CATALINA_HOME%\conf\server.xml and add into
 <Realm className="org.apache.catalina.realm.LockOutRealm"></Realm> section
 next lines:

    <Realm className="org.apache.catalina.realm.MemoryRealm" digest="MD5"/>

	<Realm  className="org.apache.catalina.realm.JDBCRealm" digest="MD5"
             driverName="oracle.jdbc.OracleDriver"
	     connectionURL="jdbc:oracle:thin:@//localhost:1521/XE"
             connectionName="test1rest" connectionPassword="test1rest"
             userTable="USERS" userNameCol="USERNAME" userCredCol="USERPASSWORD"
             userRoleTable="USERROLE" roleNameCol="ROLENAME"/>

-open %CATALINA_HOME%\conf\tomcat-users.xml and add into <tomcat-users></tomcat-users>
 section next lines:

	<role rolename="digestfile"/>
	<user username="managerScript" password="Babc123" roles="manager-script"/>
	<user username="digest2" password="b0b122bd869878f34a2a85877c429dd8" roles="digestfile"/>

-for Tomcat 6 or below open person\pom.xml and change line:
	
	<url>http://localhost:8085/manager/text</url>

	to:

	<url>http://localhost:8085/manager/</url>

-setup Tomcat as a service:
	
	next command will install the service named 'Tomcat8'
	C:\> service.bat install
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
-database configuration in person\web\src\main\resources\spring\Database.xml 
**********************************************************************************



****INSTALL AND RUN PROJECT*******************************************************
-open person\install.bat  and configure next line:

	sqlplus / as sysdba @%currentDirectory%\userScript.sql 

	with your DBA account ( in case using different DB )

-run install.bat and link http://localhost:8085/person/rest/
**********************************************************************************       
