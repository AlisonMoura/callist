<%@ page import="java.util.List" %>
<%@ page import="com.redick.persistencia.entidade.Aluno" %>
<%--
  Created by IntelliJ IDEA.
  User: alisonmoura
  Date: 04/08/15
  Time: 12:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Lista de alunos</title>
</head>
<body>

<%--Pegando a lista de alunos no request--%>
<% List<Aluno> lista = (List) request.getAttribute("listaalunos"); %>

<%--Fazendo o include do menu--%>
<%@ include file="../../includes/menu.jsp" %>

<% String msg = (String) request.getAttribute("msg"); %>

<% if (msg != null && !msg.isEmpty()) { %>

<div>
    <h4><%= msg %></h4>
</div>

<%}%>

<h1 style="text-align: center;">Lista de Alunos</h1>

<br/><br/><br/>

<% if (lista.size() > 0) { %>

<table style="margin: auto">

    <thead>
    <tr>
        <td>ID</td>
        <td>Nome</td>
        <td>CPF</td>
    </tr>
    </thead>
    <tbody style="border: 1px solid black;background-color: rgba(0,0,0,.3);">

    <% for (Aluno aluno : lista) { %>
    <tr>
        <td><%= aluno.getId() %>
        </td>
        <td><%= aluno.getNome() %>
        </td>
        <td><%= aluno.getCpf() %>
        </td>
    </tr>
    <% } %>

    </tbody>
</table>

<% }else { %>

<h2 style="text-align: center">Não há alunos cadastrados</h2>

<% } %>
</body>
</html>
