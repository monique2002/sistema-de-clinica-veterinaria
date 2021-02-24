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
	<spring:url value="/funcionario/especie/carrega" var="especie"></spring:url>
	<spring:url value="/funcionario/exame/carrega" var="exame"></spring:url>
	<spring:url value="/funcionario" var="homeFunc"></spring:url>
	<spring:url value="/funcionario/medicamento/carrega" var="medicamento"></spring:url>
	<spring:url value="/funcionario/animal/carregar" var="animal"></spring:url>
	<spring:url value="/funcionario/veterinario/carregar" var="veterinario"></spring:url>
	<spring:url value="/funcionario/consulta/carregar" var="consulta"></spring:url>

	<nav class="navbar navbar-expand-lg navbar-dark bg-success">
		<div class="container-fluid">
			<a class="navbar-brand" href="${homeFunc}">Arca de Noé</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNav"
				aria-controls="navbarNav" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link active "
						aria-current="page" href="${homeFunc}">Home</a></li>

					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#"
						id="navbarScrollingDropdown" role="button"
						data-bs-toggle="dropdown" aria-expanded="false"> Itens Tratamento</a>
						<ul class="dropdown-menu"
							aria-labelledby="navbarScrollingDropdown">
							<li><a class="dropdown-item" href="${exame}">Exame</a></li>
							<li><a class="dropdown-item" href="${medicamento}">Medicamento</a></li>
							
						</ul>
					</li>
						<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#"
						id="navbarScrollingDropdown" role="button"
						data-bs-toggle="dropdown" aria-expanded="false"> Itens Animal</a>
						<ul class="dropdown-menu"
							aria-labelledby="navbarScrollingDropdown">
							<li><a class="dropdown-item" href="${especie}">Especie</a></li>
							
						</ul>
					</li>
						<li class="nav-item"><a class="nav-link" href="${veterinario}">Veterinario</a></li>
						<li class="nav-item"><a class="nav-link" href="${animal}">Animal</a></li>
						<li class="nav-item"><a class="nav-link" href="${consulta}">Consultas</a></li>
						<li class="nav-item"><a class="nav-link active" href="/index" style="font-size:20px; margin-left:700px;">Sair</a></li>
						
					</ul>
				

			</div>
		</div>

	</nav>


</body>
</html>