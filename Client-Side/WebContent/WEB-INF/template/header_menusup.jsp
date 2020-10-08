<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@page import="Controladores.Fabrica" %>
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
      		<input class="form-control mr-sm-2" type="search" placeholder="Nickname, Espectáculo..." aria-label="Search">
      		<button class="rounded-circle btn btn-outline-success my-2 mr-sm-2" type="submit"><i class="fas fa-search"></i></button>
    	</form>
    </li>
    <li class="nav-item dropdown">
    		<%
       			if (request.getSession().getAttribute("usuario_logueado")==null){
       		%>
       		
       		Error
       		<%
       			}
       			else{
       				DtUsuario usuario = Login.getUsuarioLogueado(request);
       		%>
       <a class="nav-link" style="border-radius:0.25em;" href="#" id="UsernavbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
       		<img alt="" src="<%= usuario.getImagen() %>" width=32em class="rounded-circle img-responsive img-fluid">
       		<%= usuario.getNickname() %>
       		<i class="fas fa-sort-down"></i>
       		<%
       			}
       		%>
    	</a>
    	<div class="dropdown-menu dropdown-menu-right" aria-labelledby="UsernavbarDropdown">
          <a class="dropdown-item" href="PerfilUsuario.html">Mi Perfil</a>
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