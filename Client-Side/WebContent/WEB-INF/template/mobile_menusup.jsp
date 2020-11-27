<%@page import="webservices.EstadoSesion"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@page import="com.coronatickets.controllers.Login" %>
  <%@page import="webservices.DtUsuario" %>

  
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
                        <div class="navbar-header d-xs-none d-sm-none mx-auto ml-sm-5"><a href="/mobilehome">CORONATICKETS.UY</a></div>
    <ul class="navbar-nav ml-auto container-fluid">
    <li class="nav-item mx-auto">
    	<form class="form-inline my-2 my-lg-0 mx-auto">
      		<input id="tosearch" class="form-control mr-sm-2" type="search" placeholder="Nickname, Espectáculo..." style="width:14em;" aria-label="Search">
      		<!--<a class="rounded-circle btn btn-outline-success my-2 mr-sm-2" href="../Client-Side/HTMLs/busqueda.html">-->
     		<button class="rounded-circle btn btn-outline-success my-2 mr-sm-2" onclick="InvocarBusqueda()" type="button"> 
      		<i class="fas fa-search"></i>
     		</button> 
      	<!--  	</a> -->
    	</form>
    </li>
   
		<%
			if (request.getSession().getAttribute("usuario_logueado")!=null && request.getSession().getAttribute("estado_sesion")!=null && ((EstadoSesion) request.getSession().getAttribute("estado_sesion")==EstadoSesion.LOGIN_CORRECTO)){
			
				webservices.DtUsuario usuario = Login.getUsuarioLogueado(request);
				%>
		    <li class="nav-item dropdown">
		       	<a class="nav-link" style="border-radius:0.25em;" href="#" id="UsernavbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		       	<div class="d-flex flex-row">
		       	<div style="width:2em;height:2em;" class="mr-2">
		       		<img alt="" src="<% if(usuario.getImagen()!=null && usuario.getImagen()!=""){ %><%= usuario.getImagen() %><%}else{ %><%= "/img/defaultpic.jpg"%><%} %>" class="rounded-circle img-responsive h-100 w-100">
		       	</div>
		       	<%= usuario.getNickname() %>
		       	<i class="fas fa-sort-down"></i>
		       	</div>
		       	</a>
		    	<div class="dropdown-menu dropdown-menu-right" aria-labelledby="UsernavbarDropdown">
		          <a class="dropdown-item" href="/mobilelogout">Cerrar Sesión</a>
		        </div>
		        
		    </li>
		<%
			}
			else{
		
		%>
		<li class="nav-item">
		<a href="/mobilelogin">Iniciar Sesión</a>
		</li>				
       	<%
       		}
       	%>
    	
	</ul>
                    </div>
                </div>
            </nav>
            
            
            
            
            
     <!-- jQuery CDN - Slim version (=without AJAX) -->
     <script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
    <!-- Popper.JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
    <!-- Bootstrap JS -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
	
	<script type="text/javascript">
	
	
		function InvocarBusqueda(){
			var busq = document.getElementById("tosearch").value;
			window.location.href = "/mobilebusqueda?s=" + busq;
			
		}
	
        $(document).ready(function () {
            $('#sidebarCollapse').on('click', function () {
                $('#sidebar').toggleClass('active');
            });
        });
    </script>
	<!-- FIN MENU ARRIBA -->