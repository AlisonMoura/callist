<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <link type="text/css" rel="stylesheet" href="css/reset.css">
    <link type="text/css" rel="stylesheet" href="css/login.css">
    <title>Login - Callist</title>
</head>
<body>

<% String msg = (String) request.getAttribute("msg"); %>

<% if (msg != null && !msg.isEmpty()) { %>

<div class="msg">
    <h4><%= msg %></h4>
</div>

<%}%>

<div class="form-login">

    <h1>LOGIN</h1>

    <form action="/login" method="post">
        <input type="text" name="login" id="inptLogin" placeholder="usuário"/>
        <input type="password" name="senha" id="inptSenha" placeholder="senha"/>
        <input type="submit" value="Login"/>
    </form>
</div>

</body>
</html>
