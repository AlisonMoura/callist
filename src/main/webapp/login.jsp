<%--
  Created by IntelliJ IDEA.
  User: alisonmoura
  Date: 27/07/15
  Time: 12:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login - Callist</title>
</head>
<body>

<% String msg = (String) request.getAttribute("msg"); %>

<% if (msg != null && !msg.isEmpty()) { %>

<div>
    <h4><%= msg %></h4>
</div>

<%}%>

<div style="margin: auto; width: 200px;">

    <h1 style="text-align: center">LOGE-SE</h1>

    <form action="/login" method="post" style="margin: 100px auto auto auto;">
        <fieldset>
            <label for="inptLogin">Login: </label><input type="text" name="login" id="inptLogin"/><br/>
            <label for="inptSenha">Senha: </label> <input type="password" name="senha" id="inptSenha"/><br/>
            <input type="submit" value="Login" style="margin: auto"/>
        </fieldset>
    </form>
</div>

</body>
</html>
