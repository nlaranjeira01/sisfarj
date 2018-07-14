<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="servlets.ListarAssociacao" %>
<%@ page import="java.util.List" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Associações</title>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css"></link>
	
	<style>
		body{
			background-color: rgb(249,249,249);
		}
		#title{
			margin-top:2%;
			font-size: 50px;
			font-weight: bold;
		}
		
		#filiarAssociacao{
			width: 15%;
			margin-left:42%;
		}
		
		#tabela{
			width: 35%;
			margin-left:32.5%;
		}
		
		
	</style>
</head>
<body>
	<p align='center' id='title'>Lista de Associações</p>
	<br>
	<div id='tabela' class="table-responsive">
		<table class="table table-striped table-bordered">
		<thead>
			<tr>
				<th>Matricula</th>
				<th>Nome</th>	
			</tr>
		</thead>
			
			<%
				List<String> lista = (List<String>) request.getAttribute("lista");
				String[] splitted;
	
				int matricula;
				String nome;
				
				for (int i = 0; i < lista.size(); i++) {
					
					splitted = lista.get(i).split(" ");
					matricula = Integer.parseInt(splitted[0]);
					nome = splitted[1];
					
					out.println("<tr><td>" +matricula+ "</td><td>" +nome+ "</td></tr>");
				}
			%>
			
		</table>
	</div>
</body>
</html>










    
    

