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
	
	<jsp:include page="../comum/navbarVet.jsp"></jsp:include>
		
		<h2 style="margin-top:10%;" align="center">BEM VINDO VETERINÁRIO(A)</h2>
		<h4 align="center">Aqui você pode ter acesso a sua agenda de consulta, </h4>
		<h4 align="center">e cadastrar  um tratamento para consultas ja existentes.</h4>
	
		<a href="/veterinario/agenda"
			class="btn btn-success" type="submit"
			style="margin-left: 40%; margin-top: 10px;width:120px"> Agenda</a>
		
		<a href="/veterinario/tratamento/carrega"class="btn btn-success" type="submit"
					style="  margin-left: 10px; margin-top: 10px;width:120px">
					Tratamento</a>
					
	<jsp:include page="../comum/rodape.jsp"></jsp:include>
	
	<script type="text/javascript" src="/js/jquery.js"></script>
	<script type="text/javascript" src="/js/bootstrap.min.js"></script>

	
</body>
</html>