<%@ page import="com.redick.persistencia.entidade.Aluno" %>
<%@ page import="com.redick.persistencia.entidade.Endereco" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cadastro de aluno</title>
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
            <input id="cep" name="endereco.cep" type="text" onblur="buscarPorCep()"/><br/>
            Tipo do Logradouro:
            <input id="tipoLogradouro" name="endereco.tipoLogradouro" type="text"/><br/>
            Logradouro:
            <input id="logradouro" name="endereco.logradouro" type="text"/><br/>
            Número:
            <input id="numero" name="endereco.numero" type="number"><br/>
            Estado:
            <input id="estado" name="endereco.estado" type="text"/><br/>
            Cidade:
            <input id="cidade" name="endereco.cidade" type="text"/><br/>
            Bairro:
            <input id="bairro" name="endereco.bairro" type="text"/><br/>

        </fieldset>
        <br/>
        <br/>
        <br/>

        <input type="submit" value="Salvar" onclick="salvar()"/>
    </fieldset>
</form>

<script type="text/javascript">
    function buscarPorCep(){
        var xmlHttp = new XMLHttpRequest();
        var cep = document.getElementById("cep").value;
        var url = "http://cep.republicavirtual.com.br/web_cep.php?cep="+cep+"&formato=json";
        xmlHttp.open( "GET", url , false ); // false for synchronous request
        xmlHttp.send( null );
        var endereco =  JSON.parse(xmlHttp.responseText);

        document.getElementById("logradouro").value = endereco.logradouro;
        document.getElementById("tipoLogradouro").value = endereco.tipo_logradouro;
        document.getElementById("bairro").value = endereco.bairro;
        document.getElementById("cidade").value = endereco.cidade;
        document.getElementById("estado").value = endereco.uf;
    }
</script>
</body>
</html>
