<%--
  Created by IntelliJ IDEA.
  User: tauan
  Date: 10/7/2021
  Time: 5:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cadastro de vaga</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
<div class="container">
<form action="/Vaga" method="post">
    <div class="form-group">
        <label for="descricao">Descrição</label>
        <input type="text" class="form-control" id="descricao" name="descricao" aria-describedby="descricao" placeholder="Descrição">
    </div>
    <div class="form-group">
        <label for="requisitos">Requisitos</label>
        <input type="text" class="form-control" id="requisitos" name="requisitos" aria-describedby="requisitos" placeholder="Requisitos">
    </div>
    <button type="submit" class="btn btn-primary">Enviar</button>
</form>
</div>
</body>

</html>
