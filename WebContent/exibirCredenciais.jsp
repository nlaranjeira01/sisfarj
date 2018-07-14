<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Credenciais</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.css"></link>
	
	<style>
		body{
			background-color: rgb(249,249,249);
		}
		#title{
			margin-top:5%;
			font-size: 50px;
			font-weight: bold;
		}
		
		#menu{
			width: 90%;
		}
		
		.form{
			width: 20%;
			margin-left:46.5%;
			
		}
				
	</style>

</head>
<body>
	<%
		int login = (Integer) request.getAttribute("login");
		String senha = (String) request.getAttribute("senha");
		String tipoUsuario = (String) request.getAttribute("tipoUsuario");
	%>
	<div align='center'>
		<p id='title'>Suas credenciais</p>

	</div>
	<div align='center'>
		<p>
			Suas credenciais de
			<%=tipoUsuario%>: <br /> <br /> Login:
			<%=login%><br /> Senha:
			<%=senha%>
			<br /> <br />
		<p />

	</div>

	<p />
	<div align='center'>
		<form method='get' action="menu.jsp">
			<div align='center'>
				<button type="submit" class="btn btn-primary btn-lg">Voltar</button>
			</div>
		</form>
	</div>


</body>
</html>