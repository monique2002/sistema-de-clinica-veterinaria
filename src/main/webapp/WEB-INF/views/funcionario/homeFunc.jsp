<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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


	<spring:url value="/funcionario/especie/carrega" var="especie"></spring:url>
	<spring:url value="/funcionario/exame" var="exame"></spring:url>
	<spring:url value="/funcionario/medicamento" var="medicamento"></spring:url>
	
		<h2 style="margin-top:10%;" align="center">BEM VINDO FUNCIONÁRIO</h2>
		<h4 align="center">Aqui você pode através do menu ter controle e </h4>
		<h4 align="center">realizar cadastro das entidades envolvendo a clínica,</h4>
		<h4 align="center">com intuito de facilitar o controle e automatização.</h4>
	

	<jsp:include page="../comum/rodape.jsp"></jsp:include>

	<script type="text/javascript" src="/js/jquery.js"></script>
	<script type="text/javascript" src="/js/bootstrap.min.js"></script>

	<script type="text/javascript">
		$(document).ready(function() {

			$('#divMensagemLogin').delay(3000).fadeOut('slow');

		});
	</script>

</body>
</html>