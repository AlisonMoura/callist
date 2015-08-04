<%@ page import="java.util.List" %>
<%@ page import="com.redick.persistencia.entidade.Usuario" %>
<%--
  Created by IntelliJ IDEA.
  User: alisonmoura
  Date: 14/07/15
  Time: 23:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lista de Usuários</title>
</head>
<body>

<% List<Usuario> lista = (List) request.getAttribute("listausuarios"); %>

<%@ include file="../../includes/menu.jsp" %>

<h1 style="text-align: center">Lista de Usuários</h1>

<br/><br/><br/>

<!-- Se a lista tiver, pelo menos um usuário, então renderiza a tabela -->
<% if (lista.size() > 0) { %>

<table style="margin: auto">
    <thead>
    <tr>
        <td>ID</td>
        <td>Nome</td>
        <td>Login</td>
        <td>Senha</td>
    </tr>
    </thead>
    <tbody style="border: 1px solid black;background-color: rgba(0,0,0,.3)">

    <% for (Usuario usu : lista) { %>
    <tr>
        <td><%= usu.getId() %>
        </td>
        <td><%= usu.getNome() %>
        </td>
        <td><%= usu.getLogin() %>
        </td>
        <td><%= usu.getSenha() %>
        </td>
    </tr>

    <%}%>

    </tbody>

</table>

<!-- Se a lista estiver vazia, então exibe um texto dizendo que não há usuários cadastrados -->
<%} else {%>

<h2 style="margin: auto;text-align: center">Não há usuários cadastrados!</h2>

<%}%>

</body>
</html>
