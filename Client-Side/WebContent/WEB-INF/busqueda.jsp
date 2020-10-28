<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.text.*,java.util.*" %>
<!DOCTYPE html>
<html>
<head>

	<%@page import="DataTypes.DtEspectadorPerfil"%>
	<%@page import="DataTypes.DtUsuario"%>
	<%@page import="DataTypes.DtPaqueteDatos" %>
	<%@page import="DataTypes.DtEspectaculoDatos" %>
	<%@page import="com.coronatickets.controllers.Login" %>
	<%@page import="Controladores.Fabrica"%>
	<%@page import="Interfaces.IUsuario"%>
	<jsp:include page="/WEB-INF/template/head.jsp"/>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
</head>
<body>
	<%
		String search = (String) request.getParameter("s");;
		Set<DtUsuario> UsuariosFiltrados = Fabrica.getInstancia().getIUsuario().filtrarUsuarios(search); 
		Set<DtEspectaculoDatos> EspectaculosFiltrados = Fabrica.getInstancia().getIPlataforma().filtrarEspectaculos(search); 
		Set<DtPaqueteDatos> PaquetesFiltrados = Fabrica.getInstancia().getIUsuario().filtrarPaquetes(search); 
	%>
	<div class="wrapper">
		<jsp:include page="/WEB-INF/template/header_menulateral.jsp"/>
        <div id="content">
			<jsp:include page="/WEB-INF/template/header_menusup.jsp"/>
			
            <h1>Resultado de Búsqueda</h1>
            <br>
            <div class="row">
            
            <div class="col-md-4 col-lg-4 col-sm-4">
            	<div class="panel-group container-fluid">
  				<div class="panel panel-default">
  					<div class="panel-heading mb-sm-2">
  						<i class="fas fa-user"></i> <b>Usuarios</b>
  					</div>
    				<div class="panel-body">
    					<a href="ConsultaArtista.html">
    					<div class="media mb-sm-2">
						 	<img src="https://cdn.wegow.com/media/artists/pimpinela/pimpinela-1492560275.89.2560x1440.jpg" id="imgperfilUsuario" class="mr-3 rounded-circle" alt="img-perfil-usuario" width=64em height="64em"> 
						  	<div class="media-body">
						    	<h4 class="mt-0" id="nombreapellidoUsuario">Pimpinela Pimpinela</h4>
						    	lospimpi / lospimpi@gmail.com
						  	</div>
						</div>
						</a>
						<a href="ConsultaUsuario.html">
						<div class="media mb-sm-2">
						 	<img src="https://estaticos.elmundo.es/assets/multimedia/imagenes/2016/11/07/14785256260398.jpg" id="imgperfilUsuario" class="mr-3 rounded-circle" alt="img-perfil-usuario" width=64em height="64em"> 
						  	<div class="media-body">
						    	<h4 class="mt-0" id="nombreapellidoUsuario">Emma Watson</h4>
						    	waston / e.watson@gmail.com
						  	</div>
						</div>
						</a>
    				</div>
  					</div>
				</div>
            	<a id="btnVerMasUsu" style="color:blue;" href="#">Ver más</a>
            </div>
            
            
            <!-- ESPECTACULOS  --> 
            <div class="col-md-4 col-lg-4 col-sm-4">
            	<div class="panel-group container-fluid">
  				<div class="panel panel-default">
  					<div class="panel-heading mb-sm-2">
  						<i class="fas fa-user"></i> <b>Espectaculos</b>
  					</div>
    				<div class="panel-body">
    					<a href="ConsultaArtista.html">
    					<div class="media mb-sm-2">
						 	<img src="https://cdn.wegow.com/media/artists/pimpinela/pimpinela-1492560275.89.2560x1440.jpg" id="imgperfilUsuario" class="mr-3 rounded-circle" alt="img-perfil-usuario" width=64em height="64em"> 
						  	<div class="media-body">
						    	<h4 class="mt-0" id="nombreapellidoUsuario">Pimpinela Pimpinela</h4>
						    	lospimpi / lospimpi@gmail.com
						  	</div>
						</div>
						</a>
						<a href="ConsultaUsuario.html">
						<div class="media mb-sm-2">
						 	<img src="https://estaticos.elmundo.es/assets/multimedia/imagenes/2016/11/07/14785256260398.jpg" id="imgperfilUsuario" class="mr-3 rounded-circle" alt="img-perfil-usuario" width=64em height="64em"> 
						  	<div class="media-body">
						    	<h4 class="mt-0" id="nombreapellidoUsuario">Emma Watson</h4>
						    	waston / e.watson@gmail.com
						  	</div>
						</div>
						</a>
    				</div>
  					</div>
				</div>
            	<a style="color:blue;" href="#">Ver más</a>
            </div>
            
            
            
            <!-- Paquetes  --> 
            <div class="col-md-4 col-lg-4 col-sm-4">
            	<div class="panel-group container-fluid">
  				<div class="panel panel-default">
  					<div class="panel-heading mb-sm-2">
  						<i class="fas fa-user"></i> <b>Paquetes</b>
  					</div>
    				<div class="panel-body">
    					<a href="ConsultaArtista.html">
    					<div class="media mb-sm-2">
						 	<img src="https://cdn.wegow.com/media/artists/pimpinela/pimpinela-1492560275.89.2560x1440.jpg" id="imgperfilUsuario" class="mr-3 rounded-circle" alt="img-perfil-usuario" width=64em height="64em"> 
						  	<div class="media-body">
						    	<h4 class="mt-0" id="nombreapellidoUsuario">Pimpinela Pimpinela</h4>
						    	lospimpi / lospimpi@gmail.com
						  	</div>
						</div>
						</a>
						<a href="ConsultaUsuario.html">
						<div class="media mb-sm-2">
						 	<img src="https://estaticos.elmundo.es/assets/multimedia/imagenes/2016/11/07/14785256260398.jpg" id="imgperfilUsuario" class="mr-3 rounded-circle" alt="img-perfil-usuario" width=64em height="64em"> 
						  	<div class="media-body">
						    	<h4 class="mt-0" id="nombreapellidoUsuario">Emma Watson</h4>
						    	waston / e.watson@gmail.com
						  	</div>
						</div>
						</a>
    				</div>
  					</div>
				</div>
            	<a style="color:blue;" href="#">Ver más</a>
            </div>
            </div>
             <!-- PANEL GROUP -->
       </div> <!-- CONTENT -->
	</div> <!-- WRAPPER -->

</body>
</html>