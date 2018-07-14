<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Identificação</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.css"></link>

	<style>
		body{
			background-color: rgb(249,249,249);
		}
		#title{
			margin-top:5%;
			font-size: 40px;
			font-weight: bold;
		}	
		
		#form{
			width: 20%;
			margin-left:40%;
		}
	</style>
</head>
<body>

	<%
		String opcao = request.getParameter("opcao");
	%>
	
	<p align='center' id='title'>Identificação</p>
	<div id='form'>
		<form action = "IdentificarUsuario" method = "post">
			<input type = "hidden" name = "opcao" value = "<%=opcao%>"/>
			<div class="form-group">
				<label for="loginUsuario">Matricula:</label>
				<input id="loginUsuario" type="text" class="form-control" name="loginUsuario" required>
			</div>
			
			<div class="form-group">
				<label for="senhaUsuario">Senha:</label>
				<input id="senhaUsuario" type="password" class="form-control" name="senhaUsuario" required>
			</div>

			<div align='center'>
				<button type="submit" class="btn btn-primary btn-lg">Entrar</button>
			</div>
		</form>
	</div>
</body>
</html>