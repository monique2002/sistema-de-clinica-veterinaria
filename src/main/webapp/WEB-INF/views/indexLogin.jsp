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

	<spring:url value="/indexLogin/logar" var="enviar"></spring:url>
	<c:if test="${not empty erroLogin}">
			<div class="alert alert-danger" id ="divMensagemLogin" role="alert">
				${erroLogin}
			</div>
		</c:if>
	<div style="float:left; width:500px; margin-top:10%; margin-left:15%">
		<h1 class="display-4 fw-bolder" >Arca de Noé</h1>
		<h5 class="display-6 fst-italic" >Gerencimento interno para controle da clinica veterinária Arca de Noé</h5>
	</div>
		

	<div class="div-login"
		style="border-radius: 5px; width: 450px; height: 300px; float: right; margin-right: 50px; margin-top: 10%; padding-left: 10px; padding-right: 10px; padding-top: 2.8%; background-color: white; box-shadow: 0px 3px 5px 1px rgba(184, 175, 184, 1);">

		
		<form:form action="${enviar}">
					
			<div class="form-group">
				<label for="email">Email</label> 
				<input type="text" name="email" id="email" class="form-control" />
			</div>

			<div class="form-group">
				<label for="senha">Senha</label> 
				<input type="password" name="senha"	id="senha" class="form-control" maxlength="500" />
			</div>
	
			<button class="btn btn-outline-success" type="submit"
				style="margin-top: 30px; width: 95%; margin-left: 10px;">
				Logar</button>

		</form:form>

	</div>
	
	<jsp:include page="comum/rodape.jsp"></jsp:include>



	<script type="text/javascript" src="/js/jquery.js"></script>
	<script type="text/javascript" src="/js/bootstrap.min.js"></script>

	<script type="text/javascript">
		$(document).ready(function() {

			$('#divMensagemLogin').delay(3000).fadeOut('slow');

		});
	</script>

</body>
</html>