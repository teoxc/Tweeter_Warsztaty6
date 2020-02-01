<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: teo
  Date: 01.02.2020
  Time: 17:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="resources/css/style.css">
    <title>Zarejestruj się</title>
    <meta charset="UTF-8">
</head>
<body>
<div id="header"></div><%@ include file="fragments/header.jsp"%></body>
<h1>Zarejestruj się</h1>
<form:form method="post" modelAttribute="user">
    Nazwa użytkownika: <form:input type = "text" path="userName"/><form:errors path="userName" style="color: red"/>
    <%
        String loginError = (String) request.getAttribute("duplicatedUserName");
        if (loginError == "true"){%>
            <span style="color:red">Nazwa zajęta</span><%
        }
    %><br/><br/>

    Hasło: <form:input path="password" type="password"/><form:errors path="password" style="color: red"/><br/><br/>
    Imię: <form:input path="firstName" type="text"/><form:errors path="firstName" style="color: red"/><br/><br/>
    Nazwisko: <form:input path="lastName" type="text"/><form:errors path="lastName" style="color: red"/><br/><br/>
    Adres e-mail: <form:input path="email" type="email"/><form:errors path="email" style="color: red"/>
    <%
        String emailError = (String) request.getAttribute("duplicatedEmail");
        if (emailError == "true"){%>
    <span style="color:red">Email zajęty</span><%
    }
    %><br/><br/>
    <input type="submit" value="Wyślij">
</form:form>

</body>
</html>
