<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="servlets.AtualizarAtleta" %>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alterar Atleta</title>
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
		<form method='post' action="updateAtleta">
		
			<%
			String nome = (String)request.getAttribute("nome");
			Date dataEntradaAssoc = (Date)request.getAttribute("dataEntradaAssoc");
			int nOficio = (int)request.getAttribute("nOficio");
			Date dataOficio= (Date)request.getAttribute("dataOficio");
			int matricula = (int)request.getAttribute("matricula");
			
			out.println("<div class='form-group'>");
			out.println("<label for='nome'>Nome:</label><input class='form-control' value = \"" + nome + "\" name=\"nome\"required>");
			out.println("</div>");
			out.println("<div class='form-group'>");
			out.println("<label for='dataEntradaAssoc'>Data de Entrada na Associação:</label><input class='form-control' value = \"" + dataEntradaAssoc + "\" name=\"dataEntradaAssoc\"required>");
			out.println("</div>");
			out.println("<div class='form-group'>");
			out.println("<label for='nOficio'>Número do Ofício:</label><input class='form-control' value = \"" + nOficio + "\" name=\"nOficio\"required>");
			out.println("</div>");
			out.println("<div class='form-group'>");
			out.println("<label for='dataOficio'>Data do Oficio:</label><input class='form-control' value = \"" + dataOficio + "\" name=\"dataOficio\"required>");
			out.println("</div>");
	
			out.println("<input type='hidden' name='matricula' value=\""+ matricula +"\" >");
			out.println("<input type='hidden' name='nome' value=\""+ nome +"\" >");
			out.println("<input type='hidden' name='dataEntradaAssoc' value=\""+ dataEntradaAssoc +"\" >");
			out.println("<input type='hidden' name='nOficio' value=\""+ nOficio +"\" >");
			out.println("<input type='hidden' name='dataOficio' value=\""+ dataOficio +"\" >");
			
			out.println("<div align='center'><br>");
			out.println("<button type='submit' class='btn btn-primary btn-lg'>Enviar</button>");
			out.println("</div>");
			%>
		</form> 
	</div>
</body>
</html>