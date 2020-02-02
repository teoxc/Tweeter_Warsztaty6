<%--
  Created by IntelliJ IDEA.
  User: teo
  Date: 01.02.2020
  Time: 17:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="resources/css/style.css">
    <title>Zaloguj się</title>
    <meta charset="UTF-8">
</head>
<body>
<div id="header"></div><%@ include file="fragments/header.jsp"%></body>
<h1>Zaloguj się</h1>
    <form method="post" action="login">
        <%
            String loginError = (String) request.getAttribute("loginError");
            if (loginError == "true"){%>
        <span style="color:red">Błędna nazwa użytkownika lub hasło</span><br/><%
        }
        %>
        Nazwa użytkownika: <input type="text" name="userName"/><br/><br/>
        Hasło: <input type="password" name="password"/><br/><br/>
        <input type="submit" value="Zaloguj"/>
    </form>
</body>
</html>
