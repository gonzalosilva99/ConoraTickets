<%@ page language="java" contentType="text/html"%>
<%@ page import="java.text.*,java.util.*" %>
<!DOCTYPE html>
<html>
<head>
	<%@page import="DataTypes.DtEspectadorPerfil"%>
	<%@page import="DataTypes.DtArtistaPerfil"%>
	<%@page import="DataTypes.EstadoSesion" %>
	<%@page import="DataTypes.DtPaqueteDatos" %>
	<%@page import="DataTypes.DtEspectaculo" %>
	<%@page import="DataTypes.DtFuncion" %>	
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
	boolean PerfilPropio = false;
	DtArtistaPerfil dtart=null;
	DateFormat fechaCompleta = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
	DateFormat fechaIncompleta = new SimpleDateFormat("dd/MM/yyyy");
	DateFormat horaFecha = new SimpleDateFormat("hh:mm");
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
						<%= fechaCompleta.format(dtart.getUltimoIngreso())%>
		 	      		<%}else{%>
		 	      			<%= "Nunca" %>
		 	      		<% }}else{if(dtesp.getUltimoIngreso()!=null){ %>
		 	      		<%= fechaCompleta.format(dtesp.getUltimoIngreso()) %>
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
			  		<% if(!EsArtista){ %>
			  			<li class="nav-item">
							<a class="nav-link" id="registros-tab" data-toggle="tab" href="#registros" role="tab" aria-controls="registros" aria-selected="false">REGISTROS</a>
						</li>
			  		<% } %>
					<% if(PerfilPropio){ %>
					<%if(!EsArtista){ %>
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
					<% }}%>
				</ul>
				<div class="tab-content" id="myTabContent">
			  		<div class="tab-pane fade show active ml-sm-5 mt-sm-5" id="general" role="tabpanel" aria-labelledby="general-tab">
						<p class="disabled"><b>Nickname:</b> <span id="nicknameUsuario"><% if(EsArtista){%>	<%= dtart.getNickname() %><%}else{%><%= dtesp.getNickname() %><%}%></span></p>
						<p class="text-dark"><b>Nombre:</b> <span id="nombreUsuario"><% if(EsArtista){%>	<%= dtart.getNombre() %><%}else{%><%= dtesp.getNombre() %><%}%></span></p>
						<p class="text-dark"><b>Apellido:</b> <span id="apellidoUsuario"><% if(EsArtista){%>	<%= dtart.getApellido() %><%}else{%><%= dtesp.getApellido() %><%}%></span></p>
						<p class="disabled"><b>Correo Electrónico:</b> <span id="correoUsuario"><% if(EsArtista){%>	<%= dtart.getEmail() %><%}else{%><%= dtesp.getEmail() %><%}%></span></p>
						<p class="text-dark"><b>Fecha de Nacimiento:</b> <span id="nacimientoUsuario"><% if(EsArtista){%> <%= fechaIncompleta.format(dtart.getNacimiento()) %> <%}else{ %> <%= fechaIncompleta.format(dtesp.getNacimiento())  %> <%}%></span></p>
						<% if(EsArtista){ %>
						<p class="text-dark"><b>Desc. General:</b> <span id="descGeneralUsuario"><%= dtart.getDescgeneral() %></span></p>
						<p class="text-dark"><b>Biografía:</b> <span id="biografiaUsuario"><%= dtart.getBiografia() %></span></p>
						<p class="text-dark"><b>URL:</b> <span id="urlUsuario"><a href="<%= dtart.getLink() %>"><%= dtart.getLink() %></a></span></p>
						<%} %>
					</div>
					<% if(!EsArtista){%>
						<div class="tab-pane fade" id="registros" role="tabpanel" aria-labelledby="registros-tab">
			  			<div class="container mt-5">
				  			<% 	Iterator<DtFuncion> itrfunc = dtesp.getFunciones().iterator();
				  				while(itrfunc.hasNext()){
				  					DtFuncion nuevo = itrfunc.next();
				  			%>
					    		<div class="container-fluid media mb-sm-3">
				    			<a href="/consultaespectaculo?nomespectaculo=<%= Fabrica.getInstancia().getIPlataforma().findDatosFuncion(nuevo.getNombre()).getEspectaculo().getNombre() %>">
				    			<div class="container-fluid media">
				    				<img src="<%= nuevo.getImagen() %>" id="imgPaquete" class="rounded float-left media-object" alt="img-funcion" width=150em> 	 
										<div class="media-body ml-sm-4">	
											<p class="text-dark"><b>Nombre:</b> <span id="nombreFuncion"><%= nuevo.getNombre() %> </span></p>
									  		<p class="text-dark"><b>Fecha:</b> <span id="fechaFuncion"><%= fechaIncompleta.format(nuevo.getInicio()) %></span></p>
									  		<p class="text-dark"><b>Hora:</b> <span id="horaFuncion"><%= horaFecha.format(nuevo.getInicio()) %> </span></p>	
								        </div>
								</div>
								</a>
            					</div>
								<hr>
				  			<%		
				  				}
				  			%>
			  			</div>
			  		</div>
					<%}%>
					<% if(EsArtista && !PerfilPropio){
						//MOSTRAR ESPECTACULOS ACEPTADOS
					%>
					
					<% } %>
					<% if(PerfilPropio){ %>
			  		<% if(!EsArtista){ %>
			  		<div class="tab-pane fade" id="paquetes" role="tabpanel" aria-labelledby="paquetes-tab">
				  		<div class="container mt-5">
				  		<% Iterator<DtPaqueteDatos> itrpaq = dtesp.getPaquetesComprados().iterator();
						while(itrpaq.hasNext()) {
							DtPaqueteDatos nuevo = itrpaq.next();
						%>
							<div class="container-fluid media mb-sm-3">
				    			<a href="ConsultaPaquete.html">
				    			<div class="container-fluid media">
				    				<img src="<%= nuevo.getImagen() %>" id="imgPaquete" class="rounded float-left media-object" alt="img-paquete" width=150em> 
										<div class="media-body ml-sm-4">		
								         	<p class="text-dark"><b>Nombre del paquete:</b> <span id="nombrePaquete"><%= nuevo.getNombre() %></span></p>
											<p class="text-dark"><b>Descripcion:</b> <span id="descuentoPaquete"><%= nuevo.getDescripcion() %></span></p>
								  			<p class="text-dark"><b>Descuento:</b> <span id="descuentoPaquete"><%= nuevo.getDescuento() %>%</span></p>	
								  			<p class="text-dark"><b>Validez: </b> <span id="validezPaquete"><%=  fechaIncompleta.format(nuevo.getInicio()) + " - " + fechaIncompleta.format(nuevo.getFin()) %></span></p>							            
								  		</div>
								</div>
								</a>
            					</div>
				    			<hr>
						<% } %>
				  		</div>
			  		</div>
			  		<% }%>			  		
					<% if(EsArtista){ %>
					<div class="tab-pane fade" id="espectaculos" role="tabpanel" aria-labelledby="espectaculos-tab">
						<% Iterator<DtEspectaculo> itresp = dtart.getEspectaculos().iterator();
						while(itresp.hasNext()) {
							DtEspectaculo nuevo = itresp.next(); %>
					</div>
					<div class="tab-pane fade" id="funcionesinvitado" role="tabpanel" aria-labelledby="funcionesinvitado-tab">
					...
					</div>
					<%}}}%>
				</div>
			</div>
       </div>
	</div>
</body>
</html>