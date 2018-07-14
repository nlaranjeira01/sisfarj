<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="servlets.CriaAssociacao" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Criar Associação</title>
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
 	<div id='cadastraAssociacao'>
 		<p align='center' id='title'>Cadastrar Associação</p>
		<div id='form'>
			<form method='post' action="criarAssociacao">
				<div class="form-group">
					<label for="nome">Nome:</label> <input type="text"
						class="form-control" name="nome" required>
				</div>
				<div class="form-group">
					<label for="sigla">Sigla:</label> <input type="text"
						class="form-control" name="sigla" required>
				</div>
				<div class="form-group">
					<label for="telefone">Telefone:</label> <input type="text"
						class="form-control" name="telefone" required>
				</div>
				<div class="form-group">
					<label for="endereco">Endereço:</label> <input type="text"
						class="form-control" name="endereco" required>
				</div>
				<div class="form-group">
					<label for="data">Data:</label> <input type="text"
						class="form-control" name="data" required>
				</div>
				<div class="form-group">
					<label for="nComprovante">Numero do Comprovante de
						Pagamento:</label> <input type="text" class="form-control"
						name="nComprovante" required>
				</div>
				<div class="form-group">
					<label for="nOficio">Numero do Oficio:</label> <input type="text"
						class="form-control" name="nOficio" required>
				</div>
				<div align='center'>
					<button type="submit" class="btn btn-primary btn-lg">Enviar</button><br><br>
					<button type="button" onclick="window.location.href='menu.jsp'" class="btn btn-primary">Voltar</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>
