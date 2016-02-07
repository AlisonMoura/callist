<%@ page import="com.redick.persistencia.entidade.Usuario" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% Usuario usuarioLogado = (Usuario) session.getAttribute("usuario"); %>

<head>
    <link rel="stylesheet" href="/css/menu.css">
    <link rel="stylesheet" href="/css/reset.css">
</head>
<nav class="nav-menu">

    <div class="brad">
        <h1><%= usuarioLogado.getNome() %></h1>
    </div>

    <ul>
        <li><a href="/logout">Sair</a></li>
        <li><a href="/usuario/novo">Cadastro de usuário</a></li>
        <li><a href="/usuario/lista-usuarios">Lista de usuários</a></li>
        <li><a href="/aluno/novo">Cadastro de aluno</a></li>
        <li><a href="/aluno/lista-alunos">Lista de alunos</a></li>
        <li><a href="/home">Home</a></li>
    </ul>

</nav>