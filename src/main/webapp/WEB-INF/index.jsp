<%--
  Created by IntelliJ IDEA.
  User: teo
  Date: 28.01.2020
  Time: 15:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="resources/css/style.css">
    <title>Strona główna</title>
    <meta charset="UTF-8">
</head>
<body>
<div id="header"></div><%@ include file="fragments/header.jsp"%></body>
<h1>Witaj na Tweeterze! ${currentUser.getUserName()}</h1><br/><br/>

<form method="post" action="newTweet">
    <textarea name="content" id="tweetText" placeholder="Czym chcesz podzieliś się ze światem???" cols="60" rows="3"
              minlength="1" maxlength="140"></textarea>
    <input type="submit" value="Wyślij"/>
</form>

</body>
</html>
