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
	
	<spring:url value="/funcionario/exame/cadastrar" var="cadastrar"></spring:url>
	<spring:url value="/funcionario/exame/deleta" var="deletar"></spring:url>
	<spring:url value="/funcionario/exame/alterar" var="alterar"></spring:url>
	
	<h1 align="center">Exame</h1>
	<c:if test="${not empty exames}">
		<table class="table" style="width: 60%; margin-left: 20%">
			<tr>
				<th width="5%">Nome</th>
				<th width="15%">Observações</th>
				<th colspan="2" width="30%">Ações</th>
			</tr>
			<c:forEach var="exame" items="${exames}">
				<tr>
					<td>${exame.nome}</td>
					<td>${exame.obs}</td>

					<td><a href="${alterar}/${exame.id}" class="btn btn-warning">Alterar</a></td>
					<td><a href="${deletar}/${exame.id}"
						onclick="return confirm('Deseja deletar esse produto? ')"
						class="btn btn-danger">Apagar</a></td>
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