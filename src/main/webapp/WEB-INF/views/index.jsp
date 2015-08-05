<%@ page import="com.redick.persistencia.entidade.Usuario" %>
<%--
  Created by IntelliJ IDEA.
  User: alisonmoura
  Date: 12/07/15
  Time: 11:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Callist - Presença faz falta</title>
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.3/angular.min.js"/>
</head>
<body>

<% Usuario usuarioLogado = (Usuario) session.getAttribute("usuario"); %>

<%@ include file="../../includes/menu.jsp" %>

<h1>Olá <%= usuarioLogado.getNome()%>!</h1>

</body>
</html>
