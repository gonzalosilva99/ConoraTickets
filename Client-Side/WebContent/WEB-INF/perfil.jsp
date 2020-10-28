<%@ page language="java" contentType="text/html"%>
<%@ page import="java.text.*,java.util.*" %>
<!DOCTYPE html>
<html>
<head>
	<%@page import="DataTypes.DtEspectadorPerfil"%>
	<%@page import="DataTypes.DtArtistaPerfil"%>
	<%@page import="DataTypes.EstadoSesion" %>
	<%@page import="DataTypes.DtPaquete" %>
	<%@page import="com.coronatickets.controllers.Login" %>
	<%@page import="Controladores.Fabrica"%>
	<%@page import="Interfaces.IUsuario"%>
	<%@page import="java.time.Month"%>
	<%@page import="java.time.LocalDate"%>
	<%@page import="java.util.Date"%>
	<jsp:include page="/WEB-INF/template/head.jsp"/>
	<title>CoronaTickets UY - Perfil</title>
</head>
<body>
	
	<%
	SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	boolean PerfilPropio = false;
	DtArtistaPerfil dtart=null;
	DtEspectadorPerfil dtesp=null;
	boolean EsArtista =((String) request.getAttribute("tipo_usuario"))=="Artista";
	if(EsArtista){
		dtart = (DtArtistaPerfil) request.getAttribute("usuario_perfil");
		PerfilPropio = dtart.getNickname().equals((String) request.getSession().getAttribute("usuario_logueado"));
	}
	else{
		dtesp = (DtEspectadorPerfil) request.getAttribute("usuario_perfil");
		PerfilPropio = dtesp.getNickname().equals((String) request.getSession().getAttribute("usuario_logueado"));
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
		            <img src="<% if(EsArtista){if(dtart.getImagen()!=null){%><%= dtart.getImagen() %> <%}else{%><%= "https://woises.net/public/img/defaultpic.jpg" %><%}}else{ if(dtesp.getImagen()!=null){%><%= dtesp.getImagen() %><%}else{%><%= "https://woises.net/public/img/defaultpic.jpg" %><% }} %>" class="shadow mx-auto rounded-circle" width=150em height=150em>
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
		 	      		<%= dtesp.getNickname() + " / " + dtesp.getEmail() %>
		 	      			<%}%></p>
	 	   		</div>
		 	    <div class="row">
		 	    	<p class="mx-auto"><b>Último Ingreso: </b><% if(EsArtista){if(dtart.getUltimoIngreso()!=null){%>
						<%= dtart.getUltimoIngreso().getDate() + "/" + dtart.getUltimoIngreso().getMonth() + "/" + (dtart.getUltimoIngreso().getYear()+1900) + " " + dtart.getUltimoIngreso().getHours() + ":" + dtart.getUltimoIngreso().getMinutes()  %>
		 	      		<%}else{%>
		 	      			<%= "Nunca" %>
		 	      		<% }}else{if(dtesp.getUltimoIngreso()!=null){ %>
		 	      		<%= dtesp.getUltimoIngreso().getDate() + "/" + dtesp.getUltimoIngreso().getMonth() + "/" + (dtesp.getUltimoIngreso().getYear()+1900) + " " + dtesp.getUltimoIngreso().getHours() + ":" + dtesp.getUltimoIngreso().getMinutes() %>
		 	      		<%}else{ %>
		 	      			<%= "Nunca" %>
		 	      			<%}}%></p>
		 	    </div>
		 	    <div class="row">
	 	      		<p class="mx-auto" id="seguidores"> <% if(EsArtista){%>
						<%= dtart.getSeguidores().size() %>
		 	      		<%}else{%>
		 	      		<%= dtesp.getSeguidores().size() %>
		 	      			<%}%> seguidores - <% if(EsArtista){%>
						<%= dtart.getSiguiendo().size() %>
		 	      		<%}else{%>
		 	      		<%= dtesp.getSiguiendo().size() %>
		 	      			<%}%> seguidos</p>
	 	   		</div>
            </div>
           	<div class="container mx-auto">
	           	<ul class="nav nav-tabs" id="myTab" role="tablist">
			  		<li class="nav-item">
			  			<a class="nav-link active" id="general-tab" data-toggle="tab" href="#general" role="tab" aria-controls="general" aria-selected="true">GENERAL</a>
			  		</li>
					<% if(PerfilPropio){ %>
					<%if(!EsArtista){ %>
					<li class="nav-item">
						<a class="nav-link" id="registros-tab" data-toggle="tab" href="#registros" role="tab" aria-controls="registros" aria-selected="false">REGISTROS</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" id="paquetes-tab" data-toggle="tab" href="#paquetes" role="tab" aria-controls="paquetes" aria-selected="false">PAQUETES</a>
					</li>
					<%} %>
					<% if(EsArtista){ %>
					<li class="nav-item">
						<a class="nav-link" id="espectaculos-tab" data-toggle="tab" href="#espectaculos" role="tab" aria-controls="espectaculos" aria-selected="false">ESPECTACULOS</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" id="funciones-tab" data-toggle="tab" href="#funciones" role="tab" aria-controls="funciones" aria-selected="false">FUNCIONES INVITADO</a>
					</li>
					<% } %>
					<%} %>
				</ul>
				<div class="tab-content" id="myTabContent">
			  		<div class="tab-pane fade show active ml-sm-5 mt-sm-5" id="general" role="tabpanel" aria-labelledby="general-tab">
						<p class="disabled"><b>Nickname:</b> <span id="nicknameUsuario"><% if(EsArtista){%>	<%= dtart.getNickname() %><%}else{%><%= dtesp.getNickname() %><%}%></span></p>
						<p class="text-dark"><b>Nombre:</b> <span id="nombreUsuario"><% if(EsArtista){%>	<%= dtart.getNombre() %><%}else{%><%= dtesp.getNombre() %><%}%></span></p>
						<p class="text-dark"><b>Apellido:</b> <span id="apellidoUsuario"><% if(EsArtista){%>	<%= dtart.getApellido() %><%}else{%><%= dtesp.getApellido() %><%}%></span></p>
						<p class="disabled"><b>Correo Electrónico:</b> <span id="correoUsuario"><% if(EsArtista){%>	<%= dtart.getEmail() %><%}else{%><%= dtesp.getEmail() %><%}%></span></p>
						<p class="text-dark"><b>Fecha de Nacimiento:</b> <span id="nacimientoUsuario"><% if(EsArtista){%> <%= dtart.getNacimiento().getDate() + "/" + dtart.getNacimiento().getMonth() + "/" + (dtart.getNacimiento().getYear()+1900) %> <%}else{ %> <%= dtesp.getNacimiento().getDate() + "/" + dtesp.getNacimiento().getMonth() + "/" + (dtesp.getNacimiento().getYear()+1900)  %> <%}%></span></p>
						<% if(EsArtista){ %>
						<p class="text-dark"><b>Desc. General:</b> <span id="descGeneralUsuario"><%= dtart.getDescgeneral() %></span></p>
						<p class="text-dark"><b>Biografía:</b> <span id="biografiaUsuario"><%= dtart.getBiografia() %></span></p>
						<p class="text-dark"><b>URL:</b> <span id="urlUsuario"><a href="<%= dtart.getLink() %>"><%= dtart.getLink() %></a></span></p>
						<%} %>
					</div>
					<% if(PerfilPropio){ %>
			  		<% if(!EsArtista){ %>
			  		<div class="tab-pane fade" id="registros" role="tabpanel" aria-labelledby="registros-tab">
			  		...
			  		</div>
			  		<div class="tab-pane fade" id="paquetes" role="tabpanel" aria-labelledby="paquetes-tab">
			  		<ul>
			  		<% Iterator<DtPaquete> itresp = dtesp.getPaquetesComprados().iterator();
					while(itresp.hasNext()) {
						DtPaquete nuevo = itresp.next();
					%>
						<li>
							<%= nuevo.getNombre() %>
						</li>
					<% } %>
					</ul>
			  		</div>
			  		<% }%>			  		
					<% if(EsArtista){ %>
					<div class="tab-pane fade" id="registros" role="tabpanel" aria-labelledby="registros-tab">
					...
					</div>
					<div class="tab-pane fade" id="funciones" role="tabpanel" aria-labelledby="funciones-tab">
					...
					</div>
					<%}}%>
				</div>
			</div>
       </div>
	</div>
</body>
</html>