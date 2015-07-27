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

<form action="logar" method="post" style="margin: auto">
  <label for="inptLogin">Login: </label><input type="text" name="login" id="inptLogin"/>
  <label for="inptSenha">Senha: </label> <input type="password" name="senha" id="inptSenha"/>
  <input type="submit" value="Login"/>
</form>

</body>
</html>
