<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Home</title>
    <style type="text/css">

        .tab { margin-left: 40px; }

    </style>
</head>
<body>
<h1>
    Person application is deployed!
</h1>

<p> The time on the server is ${it.serverTime}. </p>
<hr/>
<h3>Use any program for testing rest-services and next commands: </h3>
<p>DELETE http://localhost:8085/person/rest/data/delete/{personID} / HEADERS: Content-Type, Accept, Authorization </p>
<p>GET http://localhost:8085/person/rest/data/get / HEADERS: Content-Type, Accept </p>
<p>GET http://localhost:8085/person/rest/data/get/{personID} / HEADERS: Content-Type, Accept </p>
<p>POST http://localhost:8085/person/rest/data/add / HEADERS: Content-Type, Accept / BODY: person structure</p>
<p>PUT http://localhost:8085/person/rest/data/update/{personID} / HEADERS: Content-Type, Accept, Authorization / BODY: person structure</p>
<hr/>
<h3>Person structure JSON example: </h3>
<p>{</p>
    <p class="tab">"age": "33",</p>
    <p class="tab">"experience": "3",</p>
    <p class="tab">"hireDate": "2014-09-01T00:00:00-05:00",</p>
    <p class="tab">"name": "Александр Хромов",</p>
    <p class="tab">"position": "Java Developer",</p>
    <p class="tab">"salary": "1050"</p>
<p>}</p>
<hr/>
<h3>Person structure XML example: </h3>
<p>&lt;person&gt;<br>
    <p class="tab">&lt;age&gt;28&lt;/age&gt;</p>
    <p class="tab">&lt;experience&gt;3&lt;/experience&gt;</p>
    <p class="tab">&lt;hireDate&gt;2011-02-01T00:00:00-05:00&lt;/hireDate&gt;</p>
    <p class="tab">&lt;name&gt;Дмитрий Силкович&lt;/name&gt;</p>
    <p class="tab">&lt;position&gt;DBA&lt;/position&gt;</p>
    <p class="tab">&lt;salary&gt;1000&lt;/salary&gt;</p>
<p>&lt;/person&gt;</p>
</body>
</html>
