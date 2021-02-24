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
	
	<div class="div-login"
		style="border-radius: 5px; width: 50%; height: 500px;  margin-left:25% ;margin-top: 20px;   background-color: white; box-shadow: 0px 3px 5px 1px rgba(184, 175, 184, 1);">
		<h1 class="mt-2 pt-3 pb-2" align="center" style="color:green;">Agenda de Consultas</h1>
		<c:if test="${not empty consultas}">
			<table class="table " >
				<tr>
					<th> Modalidade </th>
					<th> Animal </th>
					<th> Cliente </th>
					<th> Horario</th>
					<th> Valor Consulta</th>
		
				</tr>
				<c:forEach var="consulta" items="${consultas}">
					<tr>
						<td>${consulta.modalidade}</td>
						<td>${consulta.animal.nome}</td>
						<td>${consulta.animal.nomeResponsavel}</td>
						<td>${consulta.dataHora}</td>
						<td>${consulta.valorConsulta}</td>
						
				
					</tr>
				</c:forEach>
			</table>
		</c:if>
		<c:if test="${empty consultas}">
			<h6>Agenda vazia :)</h6>

		</c:if>
	</div>
	
	
	
	
	<jsp:include page="../comum/rodape.jsp"></jsp:include>
	
	<script type="text/javascript" src="/js/jquery.js"></script>
	<script type="text/javascript" src="/js/bootstrap.min.js"></script>

	
</body>
</html>