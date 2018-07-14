<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="servlets.CriaAtleta" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Criar Atleta</title>
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
	<div id='cadastraAtleta'>
		<p align='center' id='title'>Cadastrar Atleta</p>
		<div id='form'>
			<form method='post' action="criaAtleta">
				<div class="form-group">
					<label for="nome">Nome:</label> <input type="text"
						class="form-control" name="nome" required>
				</div>
				<div class="form-group">
					<label for="numero">Número do Ofício:</label> <input type="text"
						class="form-control" name="nOficio" required>
				</div>
				<div class="form-group">
					<label for="nascimento">Data de nascimento:</label> <input type="text"
						class="form-control" name="nascimento" required>
				</div>
				<div class="form-group">
					<label for="dataEntrada">Data de entrada:</label> <input type="text"
						class="form-control" name="dataEntrada" required>
				</div>
				<div class="form-group">
					<label for="dataOficio">Data do oficio:</label> <input type="text"
						class="form-control" name="dataOficio" required>
				</div>
				<div class="form-group">
					<label for="matriculaAssociacao">Matricula da associação:</label> <input type="text"
						class="form-control"
						name="matriculaAssociacao" required>
				</div>
				<div class="form-group">
					<label for="nComprovante">Numero do comprovante de pagamento:</label> <input type="text"
						class="form-control" name="nComprovante" required>
				</div>
				<div align='center'>
					<button type="submit" class="btn btn-primary btn-lg">Enviar</button>
					<br>
					<br>
					<button type="button" onclick="window.location.href='menu.jsp'"
						class="btn btn-primary">Voltar</button>
				</div>
			</form>
		</div>
	</div>
	
</body>
</html>