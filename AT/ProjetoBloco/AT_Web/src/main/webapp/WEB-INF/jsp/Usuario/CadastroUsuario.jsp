<%--
  Created by IntelliJ IDEA.
  User: tauan
  Date: 10/6/2021
  Time: 1:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
<div class="container">
    <%String mensagem = (String)request.getAttribute("mensagem"); %>

    <%if(mensagem != null){%>
    <div class="alert alert-danger">
        <strong>Login inválido!</strong></br> <%=mensagem%>.
    </div>
    <%}%>
    <form action="/login/CadastroUsuario" method="post">
        <div class="form-group">
            <input type="radio" id="tipoUsuario" name="tipoUsuario" value="Empresa">
            <label for="tipoUsuario"> Empresa</label><br>
            <input type="radio" id="tipoUsuario2" name="tipoUsuario" value="Candidato">
            <label for="tipoUsuario2"> Candidato</label><br>
        </div>
        <div class="form-group">
            <label for="nome">Nome:</label>
            <input type="text" class="form-control" name="nome" id="nome">
        </div>
        <div class="form-group">
            <label for="cpf">CPF:</label>
            <input type="text" class="form-control" name="cpf" id="cpf">
        </div>
        <div class="form-group">
            <label for="email">E-mail</label>
            <input type="email" class="form-control" name="email" id="email">
        </div>
        <div class="form-group">
            <label for="senha">Senha:</label>
            <input type="password" class="form-control" name="senha" id="senha">
        </div>
        <button type="submit" class="btn btn-default">Enviar</button>
    </form>
</div>
</body>
</html>
