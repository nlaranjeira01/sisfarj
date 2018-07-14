<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
  
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>MENU</title>
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
			margin-left:44.5%;
			
		}
		
		img{
   			width: 15%;
    		height: auto;
		}
		
		.footer {
		    position: relative;
		    left: -5px;
		    bottom: 5px;
		    width: 100%;
		    text-align: center;
		}
		
		.btn{
			padding: 15px 15px;
			height: 80px;
   			width: 300px;
   			font-size: 24px;
			margin:4px;
		}
		
	</style>

</head>
<body>
 	<h4 id='title' align='center'>Casos de Uso</h4>
 	<br><br>
	<div id='menu' align='center' class="row">
		<div class='form'>
			<form method='post' action="IdentificarUsuario.jsp">
				<div class="form-group">
					<input type="hidden" name="opcao" value='ECU1' />
				</div>
				<div align='center'>
					<button type="submit" class="btn btn-primary btn-lg">Filiar
						Associação</button>
				</div>
			</form>
		</div>

		<div class='form'>
			<form method='post' action="IdentificarUsuario.jsp">
				<div class="form-group">
					<input type="hidden" name="opcao" value='ECU2' />
				</div>
				<div align='center'>
					<button type="submit" class="btn btn-primary btn-lg">Alterar
						Associação</button>
				</div>
			</form>
		</div>

		<div class='form'>
			<form method='post' action="IdentificarUsuario.jsp">
				<div class="form-group">
					<input type="hidden" name="opcao" value='ECU3' />
				</div>
				<div align='center'>
					<button type="submit" class="btn btn-primary btn-lg">Listar
						Associação</button>
				</div>
			</form>
		</div>
		<div class='form'>
			<form method='post' action="IdentificarUsuario.jsp">
				<div class="form-group">
					<input type="hidden" name="opcao" value='ECU4' />
				</div>
				<div align='center'>
					<button type="submit" class="btn btn-primary btn-lg">Criar
						atleta</button>
				</div>
			</form>
		</div>

		<div class='form'>
			<form method='post' action="IdentificarUsuario.jsp">
				<div class="form-group">
					<input type="hidden" name="opcao" value='ECU5' />
				</div>
				<div align='center'>
					<button type="submit" class="btn btn-primary btn-lg">Alterar
						cadastro do atleta</button>
				</div>
			</form>
		</div>
	</div>
	
	<div class="footer">
		<div align="right">
			<img src="img/ufrrj_logo.png"></img>
		</div>
	</div>

</body>
</html>