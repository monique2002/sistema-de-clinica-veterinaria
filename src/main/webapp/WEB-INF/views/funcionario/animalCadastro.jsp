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

	<spring:url value="/funcionario/animal/cadastrar/salva"
		var="cadastrar"></spring:url>
	

	<div class="div-animal"
		style="border-radius: 5px; width: 40%; height: 700px; margin-left: 30%; margin-top: 1%; padding-left: 10px; padding-right: 10px; padding-top: 2.8%; background-color: white; box-shadow: 0px 3px 5px 1px rgba(184, 175, 184, 1);">

		<h1 align="center" style="padding-bottom: 5px">Cadastro Animal
			Cliente</h1>

		<form:form modelAttribute="animal" action="${cadastrar}">

			<form:hidden path="id" />

			<div class="input-group flex-nowrap mt-2 ">

				<input type="text" name="nome" id="nome" required="required" placeholder="Nome" class="form-control mt-2" value="${animal.nome}" /> 
				<input type="text" name="raca" id="raca" required="required" placeholder="Raça" class="form-control mt-2" value="${animal.raca}" /> 
			
			</div>
			<div class="form">
					<h6 class="mt-2">Escolha a espécie</h6>
					<form:select path="especie.id"  cssClass="form-control mt-2">
						<c:forEach var="especiesAtt" items="${especies}">
							<form:option  required="required" value="${especiesAtt.id}">${especiesAtt.nome}</form:option>
						</c:forEach>
				
					</form:select >
			</div>

			<div class="input-group flex-nowrap mt-2 ">
				 <span class="input-group-text mt-2">Idade em anos</span>
				 <input	type="text" required="required" name="anoIdade" id="anoIdade" class="form-control mt-2" value="${animal.anoIdade}" style="width: 60px" /> 
				 
				 <span class="input-group-text mt-2">Idade em meses</span> 
				 <input	type="text" required="required" name="mesIdade" id="mesIdade" placeholder="Idade em Meses" class="form-control mt-2" value="${animal.mesIdade}" />
			</div>

			<div class="input-group flex-nowrap mt-5 ">
				<input type="text" required="required" name="nomeResponsavel" id="nomeResponsavel" placeholder="Nome Responsavel" class="form-control mt-2" value="${animal.nomeResponsavel}" />
			</div>

			<div class="input-group flex-nowrap mt-2 ">
				<span class="input-group-text mt-2">CPF Responsavel</span> 
				<input 	type="text" required="required" name="cpfResponsavel" id="cpfResponsavel" class="form-control mt-2" value="${animal.cpfResponsavel}" /> 
				
				<span	class="input-group-text mt-2">Tel:. Responsavel</span> 
				<input type="text" required="required" name="telResponsavel" id="telResponsavel" class="form-control mt-2" value="${animal.telResponsavel}" />
			</div>

			<div class="input-group flex-nowrap mt-2 ">
				<form:input required="required" class="form-control mt-2" path="endereco.logradouro" placeholder="Digite o logradouro" value="${endereco.logradouro}" />
			</div>

			<div class="input-group flex-nowrap mt-2 ">
				<span class="input-group-text mt-2">CEP</span>
				<form:input  class="form-control mt-2" path="endereco.cep"	value="${endereco.cep}" />

				<span class="input-group-text mt-2">Número</span>
				<form:input required="required" class="form-control mt-2" path="endereco.numero" value="${endereco.numero}" />
			</div>
			<a href="/funcionario/especie/cadastrar" class="btn btn-outline-success" style="  margin-top: 10px">Cadastre uma nova espécie</a>
			<button class="btn btn-outline-success" type = "submit"
				style="margin-top: 10px; margin-left: 10px;">
				Cadastrar</button>
			
			<a href="/funcionario/animal/carregar" class="btn btn-outline-success" type="submit" style="margin-top: 10px; margin-left: 10px;"> Voltar</a>
		
		</form:form>

	</div>

	<jsp:include page="../comum/rodape.jsp"></jsp:include>



	<script type="text/javascript" src="/js/jquery.js"></script>
	<script type="text/javascript" src="/js/bootstrap.min.js"></script>



</body>
</html>