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

	<spring:url value="/funcionario/consulta/cadastrar" var="cadastrar"></spring:url>
	<spring:url value="/funcionario/consulta/alterar" var="alterar"></spring:url>
	
	<h1 align="center" class="mt-5" style="color:green;]">Consulta</h1>
	
		
	<c:if test="${not empty erroLogin}">
			<div class="alert alert-danger" id ="divMensagemLogin" role="alert">
				${erroLogin}
			</div>
	</c:if>
	
	<c:if test="${not empty consultas}">
		<table class="table" style=" ">
			<tr>
				<th> Modalidade </th>
				<th> Veterinário </th>
				<th> Animal </th>
				<th> Cliente </th>
				<th> CPF Cliente </th>
				<th> Horario</th>
				<th> Valor Consulta</th>
	
			</tr>
			<c:forEach var="consulta" items="${consultas}">
				<tr>
					<td>${consulta.modalidade}</td>
					<td>${consulta.veterinario.nome}</td>
					<td>${consulta.animal.nome}</td>
					<td>${consulta.animal.nomeResponsavel}</td>
					<td>${consulta.animal.cpfResponsavel}</td>
					<td>${consulta.dataHora}</td>
					<td>${consulta.valorConsulta}</td>
					
			
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