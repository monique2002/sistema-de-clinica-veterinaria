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

	<spring:url value="/funcionario/consulta/cadastrar/salvar"
		var="cadastrar"></spring:url>
		
	<c:if test="${not empty erroCadastro}">
			<div class="alert alert-danger" id ="divMensagemLogin" role="alert">
				${erroCadastro}
			</div>
	</c:if>
	
	

	<div class="div-consulta"
		style="border-radius: 5px; width: 60%; height: 580px; margin-left: 20%; margin-top: 1%; padding-left: 10px; padding-right: 10px; padding-top: 2.8%; background-color: white; box-shadow: 0px 3px 5px 1px rgba(184, 175, 184, 1);">

		<h1 align="center" style="padding-bottom: 5px">Cadastro Consulta</h1>
		
		<form:form modelAttribute="consulta" action="${cadastrar}">
			<form:hidden path="id"/>
			
			<div class="form-group">
				<label for="consulta">Data/Hora da Consulta</label>
				<input type="datetime-local" name="dataHora" id="dataHora" class="form-control" value="${consulta.dataHora}" />
			</div>
			
			<div class="form-group">
				<label for="consulta">Modalidade da Consulta</label>
				<input type="text" name="modalidade" id="modalidade" placeholder="Ex:Emergencial/Hora Marcada" class="form-control" value="${consulta.modalidade}" />
			</div>
			
			<div class="form-group">
				<label for="consulta">Valor da Consulta</label>
				<input type="text" name="valorConsulta" id="valorConsulta" class="form-control" placeholder="Ex:111.21" value="${consulta.valorConsulta}" />
			</div>

			<div class="form-floating">
				<form:select path="animal.id" cssClass="form-control mt-2">
					<option selected disabled>Escolha o animal</option>
					<c:forEach var="animaisAtt" items="${animais}">
						<form:option value="${animaisAtt.id}">${animaisAtt.nome}</form:option>
					</c:forEach>
				</form:select>
			</div>

			<div class="form-floating">
				<form:select path="veterinario.crvm" cssClass="form-control mt-2">
					<option selected disabled>Escolha o Veterinario</option>
					<c:forEach var="vetsAtt" items="${veterinarios}">
						<form:option value="${vetsAtt.crvm}">${vetsAtt.nome}</form:option>
					</c:forEach>
				</form:select>
			</div>
			
			<a href="/funcionario/animal/cadastrar" class="btn btn-outline-success" style="  margin-top: 10px">Cadastre um novo animal</a>
			

			<button class="btn btn-outline-success" type="submit"
				style="margin-left: 10px; margin-top: 10px">
				Cadastrar</button>
				
			<a href="/funcionario/consulta/carregar"class="btn btn-outline-success" type="submit"
				style="  margin-left: 10px; margin-top: 10px">
				Voltar</a>
		</form:form>

	</div>

	<jsp:include page="../comum/rodape.jsp"></jsp:include>



	<script type="text/javascript" src="/js/jquery.js"></script>
	<script type="text/javascript" src="/js/bootstrap.min.js"></script>



</body>
</html>