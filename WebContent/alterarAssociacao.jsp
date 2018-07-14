<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="servlets.AtualizarAssociacao" %>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alterar Associação</title>
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
	<p align='center' id='title'>Informações</p>
	<div id='form'>
		<form method='post' action="updateAssociacao">
		
			<%
			String nome = (String)request.getAttribute("nome");
			String sigla = (String)request.getAttribute("sigla");
			Date data = (Date)request.getAttribute("data");
			String telefone = (String)request.getAttribute("telefone");
			String endereco = (String)request.getAttribute("endereco");
			int nComprovante = (int)request.getAttribute("nComprovante");
			int nOficio = (int)request.getAttribute("nOficio");
			int matricula = (int)request.getAttribute("matricula");
			
			out.println("<div class='form-group'>");
			out.println("<label for='nome'>Nome:</label><input class='form-control' value = \"" + nome + "\" name=\"nome\"required>");
			out.println("</div>");
			out.println("<div class='form-group'>");
			out.println("<label for='sigla'>Sigla:</label><input class='form-control' value = \"" + sigla + "\" name=\"sigla\"required>");
			out.println("</div>");
			out.println("<div class='form-group'>");
			out.println("<label for='data'>Data:</label><input class='form-control' value = \"" + data + "\" name=\"data\"required>");
			out.println("</div>");
			out.println("<div class='form-group'>");
			out.println("<label for='nOficio'>Número do ofício:</label><input class='form-control' value = \"" + nOficio + "\" name=\"nOficio\"required>");
			out.println("</div>");

			out.println("<input type='hidden' name='matricula' value=\""+ matricula +"\" >");
			out.println("<input type='hidden' name='telefone' value=\""+ telefone +"\" >");
			out.println("<input type='hidden' name='endereco' value=\""+ endereco +"\" >");
			out.println("<input type='hidden' name='nComprovante' value=\""+ nComprovante +"\" >");
			
			out.println("<div align='center'><br>");
			out.println("<button type='submit' class='btn btn-primary btn-lg'>Enviar</button>");
			out.println("</div>");
			%>
		</form> 
	</div>
</body>
</html>