<%@ page import="java.util.List" %>
<%@ page import="com.redick.persistencia.entidade.Curso" %>
<%--
  Created by IntelliJ IDEA.
  User: alisonmoura
  Date: 05/08/15
  Time: 00:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lista de cursos</title>
</head>
<body>

<%@ include file="../../includes/menu.jsp" %>

<%
  String msg = (String) request.getAttribute("msg");
  List<Curso> lista = (List) request.getAttribute("lista-cursos");
%>

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
    <td>Título</td>
  </tr>
  </thead>
  <tbody style="border: 1px solid black;background-color: rgba(0,0,0,.3);">

  <% for (Curso curso : lista) { %>
  <tr>
    <td><%= curso.getTitulo() %></td>
  </tr>
  <% } %>

  </tbody>
</table>

<% }else { %>

<h2 style="text-align: center">Não há cursos cadastrados</h2>

<% } %>

</body>
</html>
