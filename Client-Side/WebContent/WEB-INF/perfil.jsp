<!DOCTYPE html>
<html>
<head>
	<%@page import="DataTypes.DtEspectadorPerfil"%>
	<%@page import="DataTypes.DtArtistaPerfil"%>
	<%@page import="DataTypes.EstadoSesion" %>
	<%@page import="com.coronatickets.controllers.Login" %>
	<%@page import="Controladores.Fabrica"%>
	<%@page import="Interfaces.IUsuario"%>
	<jsp:include page="/WEB-INF/template/head.jsp"/>
	<title>CoronaTickets UY - Perfil</title>
</head>
<body>
	
	<%
	boolean PerfilPropio = false;
	DtArtistaPerfil dtart=null;
	DtEspectadorPerfil dtesp=null;
	boolean EsArtista = false;
	if((String) request.getParameter("id")==null){
		PerfilPropio = (EstadoSesion) request.getAttribute("estado_sesion") == EstadoSesion.LOGIN_CORRECTO;}
		//ELSE REDIRECT A ERROR PAGE
	if (Fabrica.getInstancia().getIUsuario().EsArtista((String) request.getParameter("id"))){
		EsArtista = true;
		if(!PerfilPropio)
			dtart = Fabrica.getInstancia().getIUsuario().PerfilArtista((String) request.getParameter("id"));
		else
			dtart = Fabrica.getInstancia().getIUsuario().PerfilArtista((String) request.getAttribute("usuario_logueado"));
		}
	else{
		if(!PerfilPropio)
			dtesp = Fabrica.getInstancia().getIUsuario().PerfilEspectador((String) request.getParameter("id"));
		else
			dtesp = Fabrica.getInstancia().getIUsuario().PerfilEspectador((String) request.getParameter("usuario_logueado"));
		}
	%>
	<div class="wrapper">
        <jsp:include page="/WEB-INF/template/header_menulateral.jsp"/>
        <!-- Page Content  -->
        <div id="content">
		<jsp:include page="/WEB-INF/template/header_menusup.jsp"/>
            <h1>Perfil</h1>
            <div class="container-fluid">
            	<div class="mb-sm-4 container-fluid"></div>
	            <div class="row">
		            <img src="<% if(EsArtista){%>
						<%= dtart.getImagen() %> 
		 	      		<%}else{%>
		 	      		<%= dtesp.getImagen() %>
		 	      			<%}%>" class="shadow mx-auto rounded-circle" width=150em>
		        </div >
		        <div class="row">
		 	      	<h1 class="mx-auto" style="margin-top:0.5em"> <% if(EsArtista){%>
						<%= dtart.getNombre() + " " + dtart.getApellido() %> 
		 	      		<%}else{%>
		 	      		<%= dtesp.getNombre() + " " + dtesp.getApellido() %>
		 	      			<%}%>
		 	      			</h1><br>
		 	    </div>
		 	    <div class="row">
	 	      		<p class="mx-auto"> <% if(EsArtista){%>
						<%= dtart.getNickname() + " / " + dtart.getEmail() %>
		 	      		<%}else{%>
		 	      		<%= dtesp.getNombre() + " / " + dtesp.getApellido() %>
		 	      			<%}%> </p>
	 	   		</div>
		 	    <div class="row">
		 	    	<p class="mx-auto"><b>Último Ingreso: </b>25/09/2020</p>
		 	    </div>
		 	    <div class="row">
	 	      		<p class="mx-auto" id="seguidores"> 5000 seguidores - 120 seguidos</p>
	 	   		</div>
            </div>
           	<div class="container mx-auto">
	           	<ul class="nav nav-tabs" id="myTab" role="tablist">
			  		<li class="nav-item">
			  			<a class="nav-link active" id="general-tab" data-toggle="tab" href="#general" role="tab" aria-controls="general" aria-selected="true">GENERAL</a>
			  		</li>
					<li class="nav-item">
						<a class="nav-link" id="registros-tab" data-toggle="tab" href="#registros" role="tab" aria-controls="registros" aria-selected="false">REGISTROS</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" id="paquetes-tab" data-toggle="tab" href="#paquetes" role="tab" aria-controls="paquetes" aria-selected="false">PAQUETES</a>
					</li>
				</ul>
				<div class="tab-content" id="myTabContent">
			  		<div class="tab-pane fade show active ml-sm-5 mt-sm-5" id="general" role="tabpanel" aria-labelledby="general-tab">
						<p class="disabled"><b>Nickname:</b> <span id="nicknameUsuario">NombreUsuario</span></p>
						<p class="text-dark"><b>Nombre:</b> <span id="nombreUsuario">Nombre</span></p>
						<p class="text-dark"><b>Apellido:</b> <span id="apellidoUsuario">Apellido</span></p>
						<p class="disabled"><b>Correo Electrónico:</b> <span id="correoUsuario">nombreusuario@correo.com</span></p>
						<p class="text-dark"><b>Fecha de Nacimiento:</b> <span id="nacimientoUsuario">15/05/1999</span></p>
					</div>
			  		<div class="tab-pane fade" id="registros" role="tabpanel" aria-labelledby="registros-tab">...</div>
			  		<div class="tab-pane fade" id="paquetes" role="tabpanel" aria-labelledby="paquetes-tab">...</div>
				</div>
			</div>
       </div>
	</div>
</body>
</html>