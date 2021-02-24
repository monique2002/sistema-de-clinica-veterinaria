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
<body>
	<spring:url value="/veterinario/tratamento/carrega" var="tratamento"></spring:url>
	<spring:url value="/veterinario/agenda" var="agenda"></spring:url>
	<spring:url value="/veterinario/carrega" var="home"></spring:url>
	
	<nav class="navbar navbar-expand-lg navbar-dark bg-success">
		<a class="navbar-brand" href="${home}">Arca de Noé</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item me-2"><a class="nav-link active "
					aria-current="page" href="${home}">Home</a></li>
				<li class="nav-item me-2"><a class="nav-link active "
					aria-current="page" href="${tratamento}">Tratamento</a></li>
				<li class="nav-item me-2"><a class="nav-link active "
					aria-current="page" href="${agenda}">Agenda</a></li>
				<li class="nav-item">
				    <a class="nav-link active " href="/index" tabindex="-1" aria-disabled="true" style="margin-left:1050px; font-size:20px">Sair</a>  </li>
			</ul>
		
		</div>
	</nav>


</body>
</html>