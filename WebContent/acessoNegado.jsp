<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Acesso Negado</title>
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
	<div align='center'>
		<p id='title'>Acesso não permitido</p>
	
	</div>
	<div align='center'>
		<p>Você não tem permissão para acessar essa função.<p/>
	</div>

		<div align='center'>
			<form method='get' action="menu.jsp">
				<div align='center'>
					<button type="submit" class="btn btn-primary btn-lg">Voltar</button>
				</div>
			</form>
		</div>

</body>
</html>