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

	<spring:url value="/funcionario/veterinario/cadastrar" var="cadastrar"></spring:url>
	<spring:url value="/funcionario/veterinario/deleta" var="deletar"></spring:url>
	<spring:url value="/funcionario/veterinario/alterar" var="alterar"></spring:url>
	
	<h1 align="center" class="mt-5" style="color:green;]">Veterinário</h1>
	<c:if test="${not empty veterinarios}">
		<table class="table" style=" ">
			<tr>
				<th >CRVM</th>
				<th >Nome</th>
				<th> Telefone</th>
				<th >Endereço</th>
	
				<th colspan="2" width="10%">Ações </th>
			</tr>
			<c:forEach var="veterinario" items="${veterinarios}">
				<tr>
					<td>${veterinario.crvm}</td>
					<td>${veterinario.nome}</td>
					<td>${veterinario.telefone}</td>
					<td>${veterinario.endereco.cep} / N° ${veterinario.endereco.numero}</td>
					
					<td><a href="${alterar}/${veterinario.crvm}" class= "btn btn-warning">Alterar</a></td>
				
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