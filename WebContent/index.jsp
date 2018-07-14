<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="servlets.CriaAssociacao" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SISFARJ</title>
</head>
<body>
 	<div id='cadastraAssociacao'>
 		<p>Cadastra Associação</p>
		<form method='post' action="criarAssociacao">
		  Nome:<br>
		  <input type="text" name="nome" required>
		  <br>
		  Sigla:<br>
		  <input type="text" name="sigla" required>
		  <br>
		  Telefone:<br>
		  <input type="text" name="telefone" required>
		  <br>
		  Endereço:<br>
		  <input type="text" name="endereco" required>
		  <br>
		  Data:<br>
		  <input type="text" name="data" required>
		  <br>
		  Numero do Comprovante de Pagamento:<br>
		  <input type="text" name="nComprovante" required>
		  <br>
		  Numero do Oficio:<br>
		  <input type="text" name="nOficio" required>
		  <br><br>
		  <input type="submit" value="Submit" required>
		</form> 
	</div>
	
	<div id='cadastraAtleta'>
		<p>Cadastra Atleta</p>
		<form method='post' action="criaAtleta">
		  Nome:<br>
		  <input type="text" name="nome">
		  <br>
		  Número:<br>
		  <input type="text" name="numero" >
		  <br>
		  Data de nascimento:<br>
		  <input type="text" name="nascimento">
		  <br>
		  Data de entrada:<br>
		  <input type="text" name="dataEntrada" >
		  <br>
		  Data do oficio:<br>
		  <input type="text" name="dataOficio">
		  <br>
		  Matricula da associação:<br>
		  <input type="text" name="matriculaAssociacao" >
		  <br>
		  Numero do comprovante de pagamento:<br>
		  <input type="text" name="nComprovante">
		  <br><br>
		  <input type="submit" value="Submit">
		</form> 
	</div>
</body>
</html>