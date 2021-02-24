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
<body style="background-color:#F0FFFF;">

	<spring:url value="/index/login" var="enviar"></spring:url>
	
	<div style="float:left; width:500px; margin-top:10%; margin-left:15%">
		<h1 class="display-4 fw-bolder" >Arca de Noé</h1>
		<h5 class="display-6 fst-italic" >Gerencimento interno para controle da clinica veterinária Arca de Noé</h5>
	</div>

	<div class="div-login"
		style="border-radius: 5px; width: 450px; height: 300px; float: right; margin-right: 50px; margin-top: 10%; padding-left: 10px; padding-right: 10px; padding-top: 2.8%; background-color: white; box-shadow: 0px 3px 5px 1px rgba(184, 175, 184, 1);">
		<h5>Escolha o seu tipo de usuario</h5>
		
		<form:form action="${enviar}">

			<select name="tipoUsuario" style="width: 98%;height:40px">
				<c:forEach var="tipo" items="${tipoUsuario}">
					<option value="${tipo.id}">${tipo.nome}</option>
				</c:forEach>
			</select>

			<button class="btn btn-outline-success" type="submit"
				style="margin-top: 20%; width: 98%; margin-left: 7px;">
				Logar</button>

		</form:form>

	</div>

	<jsp:include page="comum/rodape.jsp"></jsp:include>

	<!-- <div class="card">
		<h5 class="card-header">Featured</h5>
		<div class="card-body">
			<h5 class="card-title">Special title treatment</h5>
			<p class="card-text">With supporting text below as a natural
				lead-in to additional content.</p>
			<a href="#" class="btn btn-primary">Go somewhere</a>
		</div>
	</div> -->

	<script type="text/javascript" src="/js/jquery.js"></script>
	<script type="text/javascript" src="/js/bootstrap.min.js"></script>
	
	
</body>
</html>