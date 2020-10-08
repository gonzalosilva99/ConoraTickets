<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head >
	<meta charset="utf-8">
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" type="text/css" id="bootstrap-css">
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<link href="media/styles/login.css" type="text/css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="media/styles/font-awesome/css/all.css">
</head>
<body style="background-color:#f0f2f5;">
<div class="container wrapper "  >
	<div class="row fadeInDown" >
		<div class="col-md-6 col-xs-12 col-sm-12">
			<div class="fadeIn second" ><img src="images/favicon/favicon.png" style="margin-left:6em;" width=200em> </div>
			<h1 class="fadeIn first" style="margin:auto;">CORONATICKETS.UY</h1>
		</div>
		<div class="col-md-6 col-xs-12 col-sm-12">
			<div  style="margin-left:7em;"id="formContent">
	    		<form action="iniciar-sesion" method="POST">
	      			<input type="text" id="login" class="fadeIn second mt-sm-3" name="login" placeholder="Usuario">
	      			<input type="password" id="password" class="fadeIn third" name="password" placeholder="Contraseña">
	      			<input type="submit" class="fadeIn fourth" value="Acceder" onclick="submit()">
	      			<a href="Registrarse.html"> ¿No tienes cuenta? Regístrate</a>
				</form>
			</div>
		</div>
	</div>
</div>
</body>
</html>