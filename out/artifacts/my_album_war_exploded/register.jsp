<%--
  Created by IntelliJ IDEA.
  User: Julia
  Date: 17.05.2016
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Fotoalbum</title>
    <link rel="stylesheet" media="all" type="text/css" href="styles/css/style.css">
</head>
<body>
<form id="form" method="get" action="register">
    <h1>Registration form</h1>
    <fieldset id="inputs">
        <input id="login" name = "login" type="text"  placeholder="Login" autofocus required>
        <input id="mail" name = "mail" type="text" placeholder="Email" required>
        <input id="password" name = "password" type="password" placeholder="Password" required>
    </fieldset>
    <fieldset id="actions">
        <a style="float: left" href="login.jsp">Back</a>
        <input style="float: right" type="submit" id="submit" value="Sign Up">
    </fieldset>
</form>
</body>

</html>
