<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@page import="Controladores.Fabrica" %>
  <%@page import="DataTypes.EstadoSesion" %>
  <%@page import="com.coronatickets.controllers.Login" %>
  <%@page import="DataTypes.DtUsuario" %>
  
<!-- INICIO MENU ARRIBA -->
            <nav class="navbar navbar-expand-lg navbar-light bg-light" id="menuSuperior">
                <div class="container-fluid">
                    <button type="button" id="sidebarCollapse" class="btn btn-info">
                        <i class="fas fa-align-left"></i>
                    </button>
                    <button class="btn btn-dark d-inline-block d-lg-none ml-auto" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <i class="fas fa-align-justify"></i>
                    </button>

                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <div class="navbar-header mx-auto ml-sm-5"><a href="#">CORONATICKETS.UY</a></div>
    <ul class="navbar-nav ml-auto container-fluid">
    <li class="nav-item mx-auto">
    	<form class="form-inline my-2 my-lg-0 mx-auto">
      		<input class="form-control mr-sm-2" type="search" placeholder="Nickname, Espect�culo..." aria-label="Search">
      		<!--<a class="rounded-circle btn btn-outline-success my-2 mr-sm-2" href="../Client-Side/HTMLs/busqueda.html">-->
     		<button class="rounded-circle btn btn-outline-success my-2 mr-sm-2" onclick="location.href='HTMLs/busqueda.html'" type="button"> 
      		<i class="fas fa-search"></i>
     		</button> 
      	<!--  	</a> -->
    	</form>
    </li>
   
		<%
			if (request.getSession().getAttribute("usuario_logueado")!=null && request.getSession().getAttribute("estado_sesion")!=null && ((EstadoSesion) request.getSession().getAttribute("estado_sesion")==EstadoSesion.LOGIN_CORRECTO)){
		
				DtUsuario usuario = Login.getUsuarioLogueado(request);
				%>
		    <li class="nav-item dropdown">
		       	<a class="nav-link" style="border-radius:0.25em;" href="#" id="UsernavbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		       	<img alt="" src="<%= usuario.getImagen() %>" width=32em class="rounded-circle img-responsive img-fluid">
		       	<%= usuario.getNickname() %>
		       	<i class="fas fa-sort-down"></i>
		       	</a>
		    	<div class="dropdown-menu dropdown-menu-right" aria-labelledby="UsernavbarDropdown">
		          <a class="dropdown-item" href="PerfilUsuario.html">Mi Perfil</a>
		          <a class="dropdown-item" href="#">Configuraci�n</a>
		          <div class="dropdown-divider"></div>
		          <a class="dropdown-item" href="/logout">Cerrar Sesi�n</a>
		        </div>
		    </li>
		<%
			}
			else{
		
		%>
		<li class="nav-item">
		<a href="/login">Iniciar Sesi�n</a>
		</li>
		<li class="nav-item">/</li>
		<li class="nav-item">
		<a href="/HTMLs/Registrarse.html">Registrarse</a>
		</li>				
       	<%
       		}
       	%>
    	
	</ul>
                    </div>
                </div>
            </nav>
            
            
            
            
            
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
        });
    </script>
	<!-- FIN MENU ARRIBA -->