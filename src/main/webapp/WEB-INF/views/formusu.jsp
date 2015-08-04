<%--
  Created by IntelliJ IDEA.
  User: alisonmoura
  Date: 03/08/15
  Time: 23:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cadastro de usuário</title>
</head>
<body>
<%@ include file="../../includes/menu.jsp" %>

<form action="/usuario/cadastrar" method="post" style="width: 200px; margin: 100px auto auto auto;">
  <fieldset legend="Dados do usuário">

    <label for="inptNome">Nome: </label>
    <input id="inptNome" type="text" name="nome"/><br/>

    <label for="inptLogin">Login: </label>
    <input id="inptLogin" type="text" name="login"/><br/>

    <label for="inptSenha">Senha: </label>
    <input id="inptSenha" type="password" name="senha"><br/><br/><br/>

    <input type="submit" value="Salvar"/>

  </fieldset>
</form>

</body>
</html>
