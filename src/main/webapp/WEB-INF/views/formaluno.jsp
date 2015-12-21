<%@ page import="com.redick.persistencia.entidade.Aluno" %>
<%@ page import="com.redick.persistencia.entidade.Endereco" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cadastro de aluno</title>

    <script type="text/javascript">

    </script>

</head>
<body>

<jsp:include page="/includes/menu.jsp"/>

<h1 style="text-align: center">Cadastro</h1>

<br/>
<br/>
<br/>

<form action="/aluno/salvar" method="post">

    <fieldset>
        <legend>Dados pessoal</legend>

        Nome:
        <input name="nome" type="text"/><br/>
        Idade:
        <input name="idade" type="number"/><br/>
        CPF:
        <input name="cpf" type="text"/><br/>
        RG:
        <input name="rg" type="text"/><br/>

        <fieldset>
            <legend>Endereço</legend>

            CEP:
            <input name="endereco.cep" type="text"/><br/>
            Tipo do Logradouro:
            <input name="endereco.tipoLogradouro" type="text"/><br/>
            Logradouro:
            <input name="endereco.logradouro" type="text"/><br/>
            Número:
            <input name="endereco.numero" type="number"><br/>
            Estado:
            <input name="endereco.estado" type="text"/><br/>
            Cidade:
            <input name="endereco.cidade" type="text"/><br/>
            Bairro:
            <input name="endereco.bairro" type="text"/><br/>

        </fieldset>
        <br/>
        <br/>
        <br/>

        <input type="submit" value="Salvar" onclick="salvar()"/>
    </fieldset>
</form>

</body>
</html>
