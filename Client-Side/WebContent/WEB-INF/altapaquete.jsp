<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  	<%@page import="DataTypes.DtPlataforma"%>
	<%@page import="DataTypes.DtCategoria"%>
	<%@page import="DataTypes.EstadoSesion" %>
	<%@page import="DataTypes.DtUsuario" %>
	<%@page import="com.coronatickets.controllers.Login" %>
	<%@page import="Controladores.Fabrica"%>
	<%@page import="Interfaces.IPlataforma"%>
	<%@page import="Interfaces.ICategoria"%>
	<%@page import="java.util.Iterator" %>
	<%@page import="java.util.Set"%>
	<%@page import="java.util.HashSet"%>
	<jsp:include page="/WEB-INF/template/head.jsp"/>
<title>CoronaTickets UY - Registrarse</title>
</head>
<body>
<div class="wrapper">
		<!-- INICIO MENU LATERAL -->
        <!-- Sidebar  -->
        <nav id="sidebar" class="toggled active">
            <div class="sidebar-header">
                <h4>CORONATICKETS</h4>
            </div>

            <ul class="list-unstyled components">
            	<li>
            	<a href="#accionesSubmenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">ACCIONES</a>
                    <ul class="collapse list-unstyled" id="accionesSubmenu">
                        <li>
                            <a href="#">Registro a Función</a>
                        </li>
                    </ul>
            	</li>
                <li>
                    <a href="#plataformasSubmenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">PLATAFORMAS</a>
                    <ul class="collapse list-unstyled" id="plataformasSubmenu">
                        <li>
                            <a href="#">Instagram Live</a>
                        </li>
                        <li>
                            <a href="#">Facebook Watch</a>
                        </li>
                        <li>
                            <a href="#">Twitter Live</a>
                        </li>
                        <li>
                            <a href="#">Youtube</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#categoriasSubmenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">CATEGORIAS</a>
                    <ul class="collapse list-unstyled" id="categoriasSubmenu">
                        <li>
                            <a href="#">Música</a>
                        </li>
                        <li>
                            <a href="#">Teatro</a>
                        </li>
                        <li>
                            <a href="#">Literatura</a>
                        </li>
                        <li>
                            <a href="#">Danza</a>
                        </li>
                        <li>
                            <a href="#">Carnaval</a>
                        </li>
                    </ul>
                </li>
            </ul>

           <!--
           NO LO BORRO POR LAS DUDAS, MAYBE LUEGO NOS SIRVE
             <ul class="list-unstyled CTAs">
                <li>
                    <a href="https://bootstrapious.com/tutorial/files/sidebar.zip" class="download">Download source</a>
                </li>
                <li>
                    <a href="https://bootstrapious.com/p/bootstrap-sidebar" class="article">Back to article</a>
                </li>
            </ul>  -->
        </nav>
		<!-- FIN MENU LATERAL -->
        <!-- Page Content  -->
        <div id="content">
		<!-- INICIO MENU ARRIBA -->
            <nav class="navbar navbar-expand-lg navbar-light bg-light" id="menuSuperior">
                <div class="container-fluid">
                    <button type="button" id="sidebarCollapse" class="btn btn-info sidebar-collapsed">
                        <i class="fas fa-align-left"></i>
                    </button>
                    <button class="btn btn-dark d-inline-block d-lg-none ml-auto" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <i class="fas fa-align-justify"></i>
                    </button>

                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <div class="navbar-header mx-auto ml-sm-5"><a href="index.html">CORONATICKETS.UY</a></div>
    <ul class="navbar-nav ml-auto container-fluid">
    <li class="nav-item mx-auto">
    	<form class="form-inline my-2 my-lg-0 mx-auto">
      		<input class="form-control mr-sm-2" type="search" placeholder="Nickname, Espectáculo..." aria-label="Search">
      		<button class="rounded-circle btn btn-outline-success my-2 mr-sm-2" type="submit"><i class="fas fa-search"></i></button>
    	</form>
    </li>
    <li class="nav-item dropdown">
       	<a class="nav-link" style="border-radius:0.25em;" href="#" id="UsernavbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
       		<img src="https://us.123rf.com/450wm/amitspro/amitspro1706/amitspro170600016/80099376-mandala-de-flor-abstracta-patr%C3%B3n-decorativo-fondo-azul-imagen-cuadrada-imagen-de-ilusi%C3%B3n-patr%C3%B3n-fondo-photo.jpg?ver=6" width=32em class="rounded-circle img-responsive img-fluid"> 
    		NombreUsuario
    		<i class="fas fa-sort-down"></i>
    	</a>
    	<div class="dropdown-menu dropdown-menu-right" aria-labelledby="UsernavbarDropdown">
          <a class="dropdown-item" href="#">Mi Perfil</a>
          <a class="dropdown-item" href="#">Configuración</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="#">Cerrar Sesión</a>
        </div>
    </li>
	</ul>
                    </div>
                </div>
            </nav>
	<!-- FIN MENU ARRIBA -->
	
	<h1 class="text-center">Crea un Paquete de Espectáculos</h1>
            
   	<form class="needs-validation mt-5 " novalidate action="altapaquete?id=<%= (String) request.getParameter("id") %>" method="POST">
   	
   	
    <div class="form-row col-md-5 row-md-4 mb-4 mx-auto">
      <input type="text" name="nombrepaquete" class="form-control" id="validationNombre" placeholder="Nombre del Paquete" required>
      <div class="valid-feedback">
        Bien!
      </div>
    </div>

    <div class="form-row col-md-5  mb-4 mx-auto">
      <textarea class="form-control row-md-3" rows=5 name="descripcion" id="Descripcion" placeholder="Descripción"></textarea>
    </div>
    
    <div class="form-row col-md-5 mx-auto">
    	<div class="form-group col-md-8">
    		<label for="inputFechaInicio">Fecha Inicio:</label>
    		<input type="date" name="dateFechaInicio" placeholder="FechaInicio" class="form-control" id="validationFechaInicio" placeholder="FechaInicio" required>
    	</div>
    </div>
    <div class="form-row col-md-5 mb-4 mx-auto">
    	<div class="form-group col-md-8">
    		<label for="inputFechaInicio">Fecha Fin:</label>
    		<input type="date" name="dateFechaFin" placeholder="FechaFin" class="form-control" id="validationFechaFin" placeholder="FechaFin" required>
    	</div>
    </div>
    
    <div class="form-row col-md-5 mb-4 mx-auto">
    	<div class="input-group col-md-8">
    		<div class="input-group-prepend">
    			<span class="input-group-text">%</span>
    		</div>
    		<input type="number" name = "porcentaje" class="form-control" id="inputPorcentajeDescuento" placeholder="25.55" required>
    	</div>
    </div>
    <div class="form-row col-md-5 mb-4 mx-auto">
  		<input type="file" class="custom-file-input" name= "imagen" id="customFileLang" lang="es">
  		<label class="custom-file-label" for="customFileLang">Seleccionar Archivo</label>
	</div>
	
	<div class="form-row col-md-5 mb-4 mx-auto">
  		<button class="btn btn-primary" style="width: 100%;" type="submit" onclick="submit()">Crear Paquete!</button>
   </div>
</form>



<script>
// Example starter JavaScript for disabling form submissions if there are invalid fields
(function() {
  'use strict';
  window.addEventListener('load', function() {
    // Fetch all the forms we want to apply custom Bootstrap validation styles to
    var forms = document.getElementsByClassName('needs-validation');
    // Loop over them and prevent submission
    var validation = Array.prototype.filter.call(forms, function(form) {
      form.addEventListener('submit', function(event) {
        if (form.checkValidity() === false) {
          event.preventDefault();
          event.stopPropagation();
        }
        form.classList.add('was-validated');
      }, false);
    });
  }, false);
})();
</script>


       </div>
</div>


	<!-- jQuery CDN - Slim version (=without AJAX) -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <!-- Popper.JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
    <!-- Bootstrap JS -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
	
	<script type="text/javascript">
        $(document).ready(function () {
            $('#sidebarCollapse').on('click', function () {
                $('#sidebar').toggleClass('active');
            });
            $('#gridRadios2').on('change', function () {
                $('#opcionesArtista').show();
            });
            
            $('#gridRadios1').on('change', function () {
                $('#opcionesArtista').hide();
            });
        });
    </script>
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script>
$(document).ready(function () {

});
</script>
</body>
</html>