<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Arca de Noe</title>
<link href="/css/bootstrap.min.css" rel="stylesheet" />
</head>
<body style="background-color: #F0FFFF;">
	<jsp:include page="../comum/navbar.jsp"></jsp:include>

	<spring:url value="/funcionario/animal/cadastrar" var="cadastrar"></spring:url>
	<spring:url value="/funcionario/animal/alterar" var="alterar"></spring:url>
	
	<h1 align="center" class="mt-5" style="color:green;]">Animal</h1>
	<c:if test="${not empty animais}">
		<table class="table" style=" ">
			<tr>
				<th >Nome</th>
				<th >Raça</th>
				<th >Idade</th>
				<th> Espécie</th>
				<th >CPF Dono</th>
				<th >Nome Dono</th>
				<th >Telefone Dono</th>
				<th >Endereço</th>
				
				<th colspan="2" width="10%">Ações </th>
			</tr>
			<c:forEach var="animal" items="${animais}">
				<tr>
					<td>${animal.nome}</td>
					<td>${animal.raca}</td>
					<td>${animal.anoIdade}.${animal.mesIdade} meses</td>
					<td>${animal.especie.nome}</td>
					<td>${animal.cpfResponsavel}</td>
					<td>${animal.nomeResponsavel}</td>
					<td>${animal.telResponsavel}</td>
					<td>${animal.endereco.cep} / N° ${animal.endereco.numero}</td>
					
					<td><a href="${alterar}/${animal.id}" class= "btn btn-warning">Alterar</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<a href="${cadastrar}" class="btn btn-success"
		style="margin-top: 30px; width: 60%; margin-left: 20%;">Cadastrar</a>


	<jsp:include page="../comum/rodape.jsp"></jsp:include>



	<script type="text/javascript" src="/js/jquery.js"></script>
	<script type="text/javascript" src="/js/bootstrap.min.js"></script>

	

</body>
</html>