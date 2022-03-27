<%--
  Created by IntelliJ IDEA.
  User: tauan
  Date: 10/6/2021
  Time: 1:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List" %>
<%@ page import="br.edu.infnet.AT_Web.domain.Vaga" %>
<html>
<head>
    <title>Vaga Home</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
<c:import url="/WEB-INF/jsp/menu.jsp"/>

<div class="container">

    <form action="/Vaga/Cadastrar" method="get">
        <button type="submit" class="btn btn-link">Incluir</button>
    </form>

    <hr>
    <%List<Vaga> listaCorridas = (List<Vaga>) request.getAttribute("lista"); %>
    <%if(listaCorridas != null && listaCorridas.size() > 0){%>
    <h4>Vagas cadastradas: <%=listaCorridas.size()%>!</h4>

    <hr>
    <%String mensagem = (String) request.getAttribute("mensagem"); %>
    <%if(mensagem != null){%>
    <div class="alert alert-success">
        <strong>Sucesso!</strong> ${mensagem}
    </div>
    <%}%>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Id</th>
            <th>Descricao</th>
            <th>Data Cadastro</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <% for(Vaga vaga : listaCorridas){%>
        <tr>
            <td><%=vaga.getId()%></td>
            <td><%=vaga.getDescricao()%></td>
            <td><%=vaga.getDataCadastro()%></td>
            <td><a href="/Vaga/<%=vaga.getId()%>/excluir">Excluir</a></td>
        </tr>
        <%}%>
        </tbody>
    </table>
    <%}%>

    <%if(listaCorridas == null || listaCorridas.size() == 0){%>
    <%String mensagem = (String) request.getAttribute("mensagem"); %>
    <%if(mensagem != null){%>
    <div class="alert alert-success">
        <strong>Sucesso!</strong> ${mensagem}
    </div>
    <%}%>
    <hr>
    <h4>Não há vagas cadastradas!!!</h4>
    <%}%>
</div>
</html>
