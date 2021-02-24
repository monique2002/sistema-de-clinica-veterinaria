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

	<spring:url value="/funcionario/veterinario/cadastrar/salva" var="cadastrar"></spring:url>
	

	<div class="div-veterinario"
		style="border-radius: 5px; width: 70%; height: 700px; margin-left: 10%; margin-top: 1%; padding-left: 10px; padding-right: 10px; padding-top: 2.8%; background-color: white; box-shadow: 0px 3px 5px 1px rgba(184, 175, 184, 1);">

		<h1 align="center" style="padding-bottom: 5px">Cadastro Veterinario</h1>

		
		<form:form modelAttribute="veterinario" action="${cadastrar}">
			
			
			<form:hidden path="tipoUsuario" value="1"/>
			
			<div class="input-group flex-nowrap mt-2 ">
					
				<span class="input-group-text mt-2">CRVM</span>
				
				<c:if test="${not empty desabilita}">
					<input type="text" name="crvm" id="crvm" disabled="disabled" required="required" placeholder="Cadastre o CRVM do veterinario" class="form-control mt-2" value="${veterinario.crvm}" />
					<form:hidden path="crvm"/>
				</c:if>
				<c:if test="${empty desabilita}">
					<input type="text" name="crvm" id="crvm"  required="required" placeholder="Cadastre o CRVM do veterinario" class="form-control mt-2" value="${veterinario.crvm}" />
				</c:if>
			
				<input type="text" name="nome" id="nome" required="required" placeholder="Cadastre o nome do veterinario" class="form-control mt-2" value="${veterinario.nome}" />
			</div>
			
			<div class="input-group flex-nowrap mt-2 ">
				<input type="text" name="email" id="email" required="required" placeholder="Cadastre o e-mail do veterinario" class="form-control mt-2" value="${veterinario.email}" />
			</div>
			
			<div class="input-group flex-nowrap mt-2 ">
				<input type="password" name="senha" id="senha" required="required" placeholder="Cadastre a senha do veterinario" class="form-control mt-2" value="${veterinario.senha}" />
			</div>
			
			<div class="input-group flex-nowrap mt-2 ">
				<input type="text" name="telefone" id="telefone" required="required" placeholder="Cadastre o telefone do veterinario" class="form-control mt-2" value="${veterinario.telefone}" />
			</div>
			
			
			<div class="input-group flex-nowrap mt-2 ">
				<form:input class="form-control mt-2" required="required" path="endereco.logradouro" placeholder="Digite o logradouro" value="${endereco.logradouro}" />
			</div>

			<div class="input-group flex-nowrap mt-2 ">
				<span class="input-group-text mt-2">CEP</span>
				<form:input class="form-control mt-2" required="required" path="endereco.cep"	value="${endereco.cep}" />

				<span class="input-group-text mt-2">Número</span>
				<form:input class="form-control mt-2"  required="required" path="endereco.numero" value="${endereco.numero}" />
			</div>

			<button class="btn btn-outline-success" type = "submit"
				style="margin-top: 30px; width: 95%; margin-left: 10px;">
				Cadastrar</button>

			<a href="/funcionario/veterinario/carregar" class="btn btn-outline-success" type="submit" style="margin-top: 30px; width: 95%; margin-left: 10px;"> Voltar</a>
		
		</form:form>

	</div>

	<jsp:include page="../comum/rodape.jsp"></jsp:include>



	<script type="text/javascript" src="/js/jquery.js"></script>
	<script type="text/javascript" src="/js/bootstrap.min.js"></script>



</body>
</html>