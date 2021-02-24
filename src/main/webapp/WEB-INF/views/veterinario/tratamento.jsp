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
	<jsp:include page="../comum/navbarVet.jsp"></jsp:include>
	
	<spring:url value="/veterinario/tratamento/cadastrar" var="cadastrar"></spring:url>

	<h1 align="center">Tratamento</h1>
	<c:if test="${not empty tratamentos}">
		<table class="table" style="width: 60%; margin-left: 20%">
			<tr>
				<th>Dosagem</th>
				<th>Horario</th>
				<th>Medicamento</th>
				<th>Horario Consulta</th>
			</tr>
			<c:forEach var="tratamento" items="${tratamentos}">
				<tr>
					<td>${tratamento.dosagem}</td>
					<td>${tratamento.horario}</td>
					<td>${tratamento.medicamento.nome}</td>
					<td>${tratamento.consulta.dataHora}</td>
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