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
<form id="form" method="get" action="login">
    <h1>Login form</h1>
    <fieldset id="inputs">
        <input id="login"  name = "login" type="text" placeholder="Login" autofocus required>
        <input id="password" name = "password" type="password" placeholder="Password" required>
    </fieldset>
    <fieldset id="actions">
        <input type="submit" id="submit" value="Sign In"><a href="register.jsp">     Sign Up</a>

    </fieldset>
</form>
</body>

</html>
