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

	<style>
		h1{
			margin:auto;
			font-size:2em;
		}
		.row {
		    display: flex;
		    align-items: center;
		    justify-content: center;
		}
		.minh-100 {
		  height: 100vh;
		}
	</style>
	<script>
		function onLoad(){
			var match = document.cookie.match(new RegExp('(^| )' + 'nick' + '=([^;]+)'));
			var matchpwd = document.cookie.match(new RegExp('(^| )' + 'pswd' + '=([^;]+)'));
		      if (match) {
		      	document.getElementById("login").setAttribute("value",match[2]);
		      	document.getElementById("password").setAttribute("value",matchpwd[2]);
		      }
		}
	</script>
</head>
<body style="background-color:#f0f2f5;" onLoad="onLoad();">
<% if((String) request.getAttribute("alta")!=null && ((String) request.getAttribute("alta")).equals("true")){ %> 
<script type="text/javascript"> alert("Registrado con exito!"); </script>
<% } %>
	<div class="row minh-100 align-items-center justify-content-center">
		<div class="col-md-6 col-12 col-sm-12 fadeIn second">
			<div class="row fadeInDown">
				<div class="col-md-6 col-12 col-sm-12 fadeIn second">
					<img src="images/favicon/favicon.png" style="margin:auto;display:block;" width=200em> 
				</div>
			</div>
			<div class="row fadeInDown">
				<h1 class="fadeIn first" >CORONATICKETS.UY</h1>
			</div>
		</div>
		
		<div class="col-md-6 col-12 col-sm-12 fadeIn second">
			<div  id="formContent" style="margin-left:auto;margin-right:auto;">
			    		<form action="mobileiniciar-sesion" method="POST">
			      			<input type="text" id="login" class="fadeIn second mt-sm-3" name="login" placeholder="Usuario" >
			      			<input type="password" id="password" class="fadeIn third" name="password" placeholder="Contraseña" >
			      			<input id="check" name="checkrememb" type="checkbox" value="Recuérdame">
			      			<input type="submit" class="fadeIn fourth" value="Acceder" onclick="submit()">
			      			<a href="/signin"> ¿No tienes cuenta? Regístrate</a>
						</form>
			</div>
		</div>
	</div>
</body>
</html>