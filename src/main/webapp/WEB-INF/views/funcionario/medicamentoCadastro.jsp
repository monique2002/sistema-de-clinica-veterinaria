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

	<spring:url value="/funcionario/medicamento/cadastrar/salva"
		var="cadastrar"></spring:url>


	<div class="div-medicamento"
		style="border-radius: 5px; width: 450px; height: 400px; margin-left: 35%; margin-top: 5%; padding-left: 10px; padding-right: 10px; padding-top: 2.8%; background-color: white; box-shadow: 0px 3px 5px 1px rgba(184, 175, 184, 1);">
			
		<h1 align="center" style="padding-bottom: 5px">Cadastro Medicamento</h1>
		
		<form:form modelAttribute="medicamento" action="${cadastrar}">
			<form:hidden path="id" />
			
			<div class="form-group">
				<label for="medicamento">Medicamento</label>
				<input type="text" name="nome" id="nome" required="required" class="form-control" value="${medicamento.nome}" />

			</div>
			<div class="form-group">
				<label for="medicamento">Contra-Indicações</label>
				<input type="text" name="contraIndicacao" required="required" id="contraIndicacao" class="form-control" value="${medicamento.contraIndicacao}" />

			</div>

			<button class="btn btn-outline-success" type="submit"
				style="margin-top: 30px; width: 95%; margin-left: 10px;">
				Cadastrar</button>

			<a href="/funcionario/medicamento/carrega"class="btn btn-outline-success" type="submit"
				style="margin-top: 30px; width: 95%; margin-left: 10px;">
				Voltar</a>
				
		</form:form>

	</div>

	<jsp:include page="../comum/rodape.jsp"></jsp:include>



	<script type="text/javascript" src="/js/jquery.js"></script>
	<script type="text/javascript" src="/js/bootstrap.min.js"></script>



</body>
</html>