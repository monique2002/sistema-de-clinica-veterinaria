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

	<spring:url value="/veterinario/tratamento/cadastrar/salva"
		var="cadastrar"></spring:url>


	<div class="div-tratamento"
		style="border-radius: 5px; width: 450px; height: 500px; margin-left: 35%; margin-top: 5%; padding-left: 10px; padding-right: 10px; padding-top: 2.8%; background-color: white; box-shadow: 0px 3px 5px 1px rgba(184, 175, 184, 1);">

		<h1 align="center" style="padding-bottom: 5px">Cadastro Tratamento</h1>
		
		<form:form modelAttribute="tratamento" action="${cadastrar}">
			<form:hidden path="id" />
			
			<div class="form-group">
				<label for="tratamento">Dosagem</label>
				<input type="text" name="dosagem" id="dosagem" class="form-control" value="${tratamento.dosagem}" />

			</div>
			
			<div class="form-group">
				<label for="tratamento">Horario</label>
				<input type="text" name="horario" id="horario" class="form-control" value="${tratamento.horario}" />
			</div>
			<div class="form-floating">
				<form:select path="medicamento.id"  cssClass="form-control mt-2">
						
					<option  selected disabled>Escolha o medicamento</option>
						<c:forEach var="medicamentoAtt" items="${medicamentos}">
							<form:option value="${medicamentoAtt.id}">${medicamentoAtt.nome}</form:option>
						</c:forEach>
				
				</form:select >
			</div>
			<div class="form-floating">
					<form:select path="consulta.id"  cssClass="form-control mt-2">
						
						<option  selected disabled>Escolha a consulta</option>
						<c:forEach var="consultaAtt" items="${consultas}">
							<form:option value="${consultaAtt.id}">${consultaAtt.dataHora}</form:option>
						</c:forEach>
						
					</form:select >
			</div>

			<button class="btn btn-outline-success" type="submit"
				style="margin-top: 30px; width: 95%; margin-left: 10px;">
				Cadastrar</button>

			<button href="../"class="btn btn-outline-success" type="submit"
				style="margin-top: 30px; width: 95%; margin-left: 10px;">
				Voltar</button>
		</form:form>

	</div>

	<jsp:include page="../comum/rodape.jsp"></jsp:include>



	<script type="text/javascript" src="/js/jquery.js"></script>
	<script type="text/javascript" src="/js/bootstrap.min.js"></script>



</body>
</html>