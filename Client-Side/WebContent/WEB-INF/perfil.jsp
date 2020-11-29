<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.text.*,java.util.*" %>
<!DOCTYPE html>
<html>
<head>
	<%@page import="webservices.DtEspectadorPerfil"%>
	<%@page import="webservices.DtArtistaPerfil"%>
	<%@page import="webservices.DtRegistro" %>
	<%@page import="webservices.DtPaqueteDatos" %>
	<%@page import="webservices.DtEspectaculo" %>
	<%@page import="webservices.DtFuncion" %>	
	<%@page import="webservices.DtUsuario" %>
	<%@page import="webservices.DtFuncionDatos" %>	
	<%@page import="webservices.EstadoEspectaculo" %>
	<%@page import="webservices.EstadoSesion" %>
	<%@page import="webservices.EspectaculoPersistencia" %>
	<%@page import="java.time.Month"%>
	<%@page import="java.util.Date"%>
	<jsp:include page="/WEB-INF/template/head.jsp"/>
	<title>CoronaTickets UY - Perfil</title>
</head>
<body>
	
	<%
	webservices.PublicadorService service = new webservices.PublicadorService();
	webservices.Publicador port = service.getPublicadorPort();
	boolean PerfilPropio = false;
	boolean Logueado = ((webservices.EstadoSesion) request.getSession().getAttribute("estado_sesion"))==webservices.EstadoSesion.LOGIN_CORRECTO;
	String idUsuario = (String) request.getSession().getAttribute("usuario_logueado");
	webservices.DtArtistaPerfil dtart=null;
	DateFormat fechaCompleta = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
	DateFormat fechaIncompleta = new SimpleDateFormat("dd/MM/yyyy");
	DateFormat horaFecha = new SimpleDateFormat("hh:mm");
	webservices.DtEspectadorPerfil dtesp=null;
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
		            <img src="<% if(EsArtista){if(dtart.getImagen()!=null && dtart.getImagen()!=""){%><%= dtart.getImagen() %> <%}else{%><%= "img/defaultpic.jpg" %><%}}else{ if(dtesp.getImagen()!=null && dtesp.getImagen()!=""){%><%= dtesp.getImagen() %><%}else{%><%= "img/defaultpic.jpg" %><% }} %>" class="shadow mx-auto rounded-circle" width=150em height=150em>
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
						<%= fechaCompleta.format(dtart.getUltimoIngreso().toGregorianCalendar().getTime())%>
		 	      		<%}else{%>
		 	      			<%= "Nunca" %>
		 	      		<% }}else{if(dtesp.getUltimoIngreso()!=null){ %>
		 	      		<%= fechaCompleta.format(dtesp.getUltimoIngreso().toGregorianCalendar().getTime()) %>
		 	      		<%}else{ %>
		 	      			<%= "Nunca" %>
		 	      			<%}}%></p>
		 	    </div>
		 	    <div class="row">
	 	      		<p class="mx-auto" id="seguidores"><a href="#" data-toggle="modal" data-target="#ModalSeguidores"><% if(EsArtista){%>
						<%= dtart.getSeguidores().size() %>
		 	      		<%}else{%>
		 	      		<%= dtesp.getSeguidores().size() %>
		 	      			<%}%> seguidores</a> - <a href="#" data-toggle="modal" data-target="#ModalSeguidos"><% if(EsArtista){%>
						<%= dtart.getSiguiendo().size() %>
		 	      		<%}else{%>
		 	      		<%= dtesp.getSiguiendo().size() %>
		 	      			<%}%> seguidos</a></p>
	 	   		</div>
	 	   		<!-- MODAL SEGUIDOS -->
				<div class="modal fade" id="ModalSeguidos" tabindex="-1" role="dialog" aria-labelledby="ModalSeguidos" aria-hidden="true">
				  <div class="modal-dialog modal-dialog-centered" role="document">
				    <div class="modal-content">
				      <div class="modal-header">
				        <h5 class="modal-title" id="exampleModalLongTitle">Seguidos</h5>
				        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
				          <span aria-hidden="true">&times;</span>
				        </button>
				      </div>
				      <div class="modal-body" >
				      	<%
				      	Iterator<DtUsuario> Seguidos=null;
				      	if(EsArtista){Seguidos=dtart.getSiguiendo().iterator();}
				      	else{Seguidos=dtesp.getSiguiendo().iterator();}
				      	
						while(Seguidos.hasNext()){
							DtUsuario nuevo = Seguidos.next();
				      	%>
				      	<a href="/perfil?id=<%= nuevo.getNickname() %>">
				         <div class="row" > 
				         	<div class="col-md-2"><img class="float-right rounded-circle img-responsive " src="<%if(nuevo.getImagen()!=null && nuevo.getImagen()!=""){%><%=nuevo.getImagen()%><%}else{%><%= "img/defaultpic.jpg" %><%}%>" height=32em width=32em ></div>
				         	<div style="padding-left:0px;" class="col-md-10"><label class="float-left"><%= nuevo.getNombre() + " " + nuevo.getApellido()%> -</label> <label style="color:grey;" >@<%= nuevo.getNickname() %></label></div><br>
				         </div>
				         </a>
				         <br>
				        <%}%>
				      <div class="modal-footer">
				        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
				      </div>
				    </div>
				  </div>
				</div>
				</div>
				<!-- MODAL SEGUIDORES -->
				<div class="modal fade" id="ModalSeguidores" tabindex="-1" role="dialog" aria-labelledby="ModalSeguidores" aria-hidden="true">
					<div class="modal-dialog modal-dialog-centered" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="exampleModalLongTitle">Seguidores</h5>
								<button type="button" class="close" data-dismiss="modal" aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
				      		</div>
							<div class="modal-body" >
						<%
						Iterator<webservices.DtUsuario> Seguidores=null;
						if(EsArtista){Seguidores=dtart.getSeguidores().iterator();}
						else{Seguidores=dtesp.getSeguidores().iterator();}
						while(Seguidores.hasNext()){
							webservices.DtUsuario nuevo = Seguidores.next();
				      	%>
						<a href="/perfil?id=<%= nuevo.getNickname() %>">
							<div class="row" >
				         	<div class="col-md-2"><img class="float-right rounded-circle img-responsive " src="<%if(nuevo.getImagen()!=null && nuevo.getImagen()!=""){%><%=nuevo.getImagen()%><%}else{%><%= "img/defaultpic.jpg" %><%}%>" height=32em width=32em ></div>
				         	<div style="padding-left:0px;" class="col-md-10"><label class="float-left"><%= nuevo.getNombre() + " " + nuevo.getApellido()%> -</label> <label style="color:grey;" >@<%= nuevo.getNickname() %></label></div><br>
							</div>
						</a>
						<br>
				        <%}%>
				      <div class="modal-footer">
				        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
				      </div>
				      </div>
				    </div>
				  </div>
				</div>
	 	   		<% if(!PerfilPropio){ %>
	 	   			<%
	 	   			boolean Siguiendo = false;
	 	   			List<webservices.DtUsuario> seguidores = new ArrayList<webservices.DtUsuario>();
	 	   			if(Logueado){
	 	   			if(EsArtista){seguidores = dtart.getSeguidores();}
	 	   			else{seguidores = dtesp.getSeguidores();}
	 	   			Iterator<webservices.DtUsuario> itrseguidores = seguidores.iterator();
	 	   			while(itrseguidores.hasNext()){
	 	   			webservices.DtUsuario nuevo = itrseguidores.next();
	 	   				if(nuevo.getNickname().equals(idUsuario)){
	 	   					Siguiendo = true;
	 	   				}
	 	   			}
	 	   			if(!Siguiendo){
	 	   			%>
	 	   			<div class="row">
	 	      			<button id="buttonFollow" type="button" onclick="SeguirUsuario()" name="seguir" value="seguir" class="mx-auto btn btn-success">
                        <i class="fas fa-user-plus"></i> Seguir
                 		</button>
                 	</div>
	 	   			<%}else{ %>  
					<div class="row">
	 	      			<button id="buttonFollow" type="button" onclick="DejarSeguirUsuario()" name="dejar-seguir" value="dejar-seguir" class="mx-auto btn btn-danger">
                        <i class="fas fa-user-minus"></i> Siguiendo
                 		</button>
                 	</div>
                 <%}}} %>
	 	    
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
			  		<% if(EsArtista){ %>
			  			<li class="nav-item">
							<a class="nav-link" id="espectaculos-tab" data-toggle="tab" href="#espectaculos" role="tab" aria-controls="espectaculos" aria-selected="false">ESPECTACULOS</a>
						</li>
			  		<%} %>
					<% if(PerfilPropio){ %>
					<%if(!EsArtista){ %>
					<li class="nav-item">
						<a class="nav-link" id="paquetes-tab" data-toggle="tab" href="#paquetes" role="tab" aria-controls="paquetes" aria-selected="false">PAQUETES</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" id="premios-tab" data-toggle="tab" href="#premios" role="tab" aria-controls="premios" aria-selected="false">PREMIOS</a>
					</li>
					<%} %>
					<% if(EsArtista){ %>
					<li class="nav-item">
						<a class="nav-link" id="funciones-tab" data-toggle="tab" href="#funcionesinvitado" role="tab" aria-controls="funcionesinvitado" aria-selected="false">FUNCIONES INVITADO</a>
					</li>
					<% }%>
					<% if(EsArtista){ %>
			  			<li class="nav-item">
							<a class="nav-link" id="espectaculos-tab" data-toggle="tab" href="#espectaculosfinalizados" role="tab" aria-controls="espectaculos" aria-selected="false">FINALIZADOS</a>
						</li>
			  		<%}} %>
				</ul>
				<div class="tab-content" id="myTabContent">
			  		<div class="tab-pane fade show active ml-sm-5 mt-sm-5" id="general" role="tabpanel" aria-labelledby="general-tab">
						<p class="disabled"><b>Nickname:</b> <span id="nicknameUsuario"><% if(EsArtista){%>	<%= dtart.getNickname() %><%}else{%><%= dtesp.getNickname() %><%}%></span></p>
						<p class="text-dark"><b>Nombre:</b> <span id="nombreUsuario"><% if(EsArtista){%>	<%= dtart.getNombre() %><%}else{%><%= dtesp.getNombre() %><%}%></span></p>
						<p class="text-dark"><b>Apellido:</b> <span id="apellidoUsuario"><% if(EsArtista){%>	<%= dtart.getApellido() %><%}else{%><%= dtesp.getApellido() %><%}%></span></p>
						<p class="disabled"><b>Correo Electrónico:</b> <span id="correoUsuario"><% if(EsArtista){%>	<%= dtart.getEmail() %><%}else{%><%= dtesp.getEmail() %><%}%></span></p>
						<p class="text-dark"><b>Fecha de Nacimiento:</b> <span id="nacimientoUsuario"><% if(EsArtista){%> <%= fechaIncompleta.format(dtart.getNacimiento().toGregorianCalendar().getTime()) %> <%}else{ %> <%= fechaIncompleta.format(dtesp.getNacimiento().toGregorianCalendar().getTime())  %> <%}%></span></p>
						<% if(EsArtista){ %>
						<p class="text-dark"><b>Desc. General:</b> <span id="descGeneralUsuario"><%= dtart.getDescgeneral() %></span></p>
						<p class="text-dark"><b>Biografía:</b> <span id="biografiaUsuario"><%= dtart.getBiografia() %></span></p>
						<p class="text-dark"><b>URL:</b> <span id="urlUsuario"><a href="<%= dtart.getLink() %>"><%= dtart.getLink() %></a></span></p>
						<%} %>
					</div>
					<% if(!EsArtista){%>
					<!-- MOSTRAMOS LOS REGISTROS A FUNCIONES DEL ESPECTADOR -->
						<div class="tab-pane fade" id="registros" role="tabpanel" aria-labelledby="registros-tab">
			  			<div class="container mt-5">
				  			<% 	
				  			
				  				List<webservices.DtRegistro> registros = port.listarRegistros(dtesp.getNickname()).getRegistros();
				  				Iterator<webservices.DtRegistro> itrreg = registros.iterator();
				  				while(itrreg.hasNext()){
				  					webservices.DtRegistro reg = itrreg.next();
				  					webservices.DtFuncion nuevo = port.getDtFuncion(reg.getNombrefuncion());
				  					
				  			%>
					    		<div class="container-fluid media mb-sm-3">
				    			<a href="/consultaespectaculo?nomespectaculo=<%= port.findDatosFuncion(nuevo.getNombre()).getEspectaculo().getNombre() %>">
				    			<div class="container-fluid media">
				    				<img src="/imagenes?id=<%= nuevo.getImagen() %>" id="imgPaquete" class="rounded float-left media-object" alt="img-funcion" width=150em> 	 
										<div class="media-body ml-sm-4">	
											<p class="text-dark"><b>Nombre:</b> <span id="nombreFuncion"><%= nuevo.getNombre() %> </span></p>
									  		<p class="text-dark"><b>Fecha:</b> <span id="fechaFuncion"><%= fechaIncompleta.format(nuevo.getInicio().toGregorianCalendar().getTime()) %></span></p>
									  		<p class="text-dark"><b>Hora:</b> <span id="horaFuncion"><%= horaFecha.format(nuevo.getInicio().toGregorianCalendar().getTime()) %> </span></p>	
									  		<p class="text-dark"><b>Costo:</b> <span id="horaFuncion"><%= reg.getCosto() %> </span></p>
											        
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
			  		<!--  MOSTRAMOS LOS PREMIOS DEL ESPECTADOR -->
			  		<div class="tab-pane fade" id="premios" role="tabpanel" aria-labelledby="premios-tab">
			  			<div class="container mt-5">
							<% 	
				  			
				  				List<webservices.DtPremio> premios = port.listarPremiosEspectador(idUsuario).getPremios();
								
				  				for (webservices.DtPremio premio: premios){
				  					
				  			%>
					    		<div class="container-fluid media mb-sm-3">
				    			<div class="container-fluid media">
										<div class="media-body ml-sm-4">	
											<p class="text-dark"><b>Premio:</b> <span id="nombrePremio"> <%= premio.getDescripcion() %>  </span></p>
									  		<p class="text-dark"><b>Fecha del sorteo:</b> <span id="fechaSorte"> <%= fechaIncompleta.format(premio.getFechaSorteo().toGregorianCalendar().getTime()) %> <%= horaFecha.format(premio.getFechaSorteo().toGregorianCalendar().getTime()) %> </span></p>
									  		<p class="text-dark"><b>Espectaculo:</b> <span id="nombreEspectaculo"> <%= premio.getNombreEspectaculo() %> </span></p>	
									  		<p class="text-dark"><b>Funcion:</b> <span id="nombreFuncion"> <%= premio.getNombreFuncion() %> </span></p>   
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
					<%	if(EsArtista && !PerfilPropio){%>
					<!-- MOSTRAMOS LOS ESPECTACULOS DEL ARTISTA DEL QUE SE CONSULTO EL PERFIL -->
					<div class="tab-pane fade" id="espectaculos" role="tabpanel" aria-labelledby="espectaculos-tab">
						<div class="container mt-5">
					<%	
							Iterator<DtEspectaculo> itresp = dtart.getEspectaculos().iterator();
							while(itresp.hasNext()) {
								DtEspectaculo nuevo = itresp.next();
								if(nuevo.getEstado()==EstadoEspectaculo.ACEPTADO){
					%>
							<div class="container-fluid media mb-sm-3">
				    			<a href="/consultaespectaculo?nomespectaculo=<%=nuevo.getNombre()%>">
					    			<div class="container-fluid media">
					    				<img src="/imagenes?id=<%= nuevo.getImagen() %>" id="imgEspectaculo" class="rounded float-left media-object" alt="<%="Imagen:(" + nuevo.getImagen() + ")" %>" width=150em> 
											<div class="media-body ml-sm-4">		
									         	<p class="text-dark"><b>Nombre del espectaculo:</b> <span id="nombreEspectaculo"><%= nuevo.getNombre() %></span></p>
									         	<p class="text-dark"><b>Precio: $</b> <span id="precioEspectaculo"><%= nuevo.getCosto() %></span></p>
												<p class="text-dark"><b>Descripcion:</b> <span id="descripcionEspectaculo"><% try{ %><%= nuevo.getDescripcion().substring(0, 50) + "..."%><%}catch(Exception e){%><%= nuevo.getDescripcion()%>  <%}%>  </span></p>									  					            
									  		</div>
									</div>
								</a>
            				</div>
				    			<hr>
					
					<%				
								}
					%>
					
					<% } %>
						</div>
					</div>
					<%} %>
					<% if(PerfilPropio){ %>
			  		<% if(!EsArtista){ %>
			  		<!-- CARGAMOS LOS PAQUETES DEL ESPECTADOR -->
			  		<div class="tab-pane fade" id="paquetes" role="tabpanel" aria-labelledby="paquetes-tab">
				  		<div class="container mt-5">
				  		<% Iterator<DtPaqueteDatos> itrpaq = dtesp.getPaquetesComprados().iterator();
						while(itrpaq.hasNext()) {
							DtPaqueteDatos nuevo = itrpaq.next();
						%>
							<div class="container-fluid media mb-sm-3">
				    			<a href="/consultapaquete?nompaquete=<%=nuevo.getNombre()%>">
					    			<div class="container-fluid media">
					    				<img src="<% if(nuevo.getImagen()!=null && nuevo.getImagen()!=""){%><%= nuevo.getImagen()%><%}else{%><%="/img/img-loading-fail.png"%><%}%>" id="imgPaquete" class="rounded float-left media-object" alt="img-paquete" width=150em> 
											<div class="media-body ml-sm-4">		
									         	<p class="text-dark"><b>Nombre del paquete:</b> <span id="nombrePaquete"><%= nuevo.getNombre() %></span></p>
												<p class="text-dark"><b>Descripcion:</b> <span id="descuentoPaquete"><%= nuevo.getDescripcion() %></span></p>
									  			<p class="text-dark"><b>Descuento:</b> <span id="descuentoPaquete"><%= nuevo.getDescuento() %>%</span></p>	
									  			<p class="text-dark"><b>Validez: </b> <span id="validezPaquete"><%=  fechaIncompleta.format(nuevo.getInicio().toGregorianCalendar().getTime()) + " - " + fechaIncompleta.format(nuevo.getFin().toGregorianCalendar().getTime()) %></span></p>							            
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
					<!-- CARGAMOS LOS ESPECTACULOS QUE ORGANIZA EL ARTISTA DUEÑO DE LA CUENTA -->
					<div class="tab-pane fade" id="espectaculos" role="tabpanel" aria-labelledby="espectaculos-tab">
						<div class="container mt-5">
							<% Iterator<DtEspectaculo> itresp = dtart.getEspectaculos().iterator();
							while(itresp.hasNext()) {
								DtEspectaculo nuevo = itresp.next();
								if(nuevo.getEstado()!=EstadoEspectaculo.FINALIZADO){
								%>
							
								<div class="container-fluid media mb-sm-3">
					    			<a href="/consultaespectaculo?nomespectaculo=<%=nuevo.getNombre()%>">
						    			<div class="container-fluid media">
						    				<img src="/imagenes?id=<%= nuevo.getImagen() %>" id="imgEspectaculo" class="rounded float-left media-object" alt="<%="Imagen:(" + nuevo.getImagen() + ")" %>" width=150em> 
												<div class="media-body ml-sm-4">		
										         	<p class="text-dark"><b>Nombre del espectaculo:</b> <span id="nombreEspectaculo"><%= nuevo.getNombre() %></span></p>
										         	<p class="text-dark"><b>Precio: $</b> <span id="precioEspectaculo"><%= nuevo.getCosto() %></span></p>
													<p class="text-dark"><b>Descripcion:</b> <span id="descripcionEspectaculo"><%try{ %><%= nuevo.getDescripcion().substring(0, 50) + "..."%><%}catch(Exception e){%><%= nuevo.getDescripcion()%>  <%}%> </span></p>									  					            
										  			<%
										  			if(nuevo.getEstado()==EstadoEspectaculo.ACEPTADO){%>
										  				<p class="text-success"><b>Aceptado</b></p>
										  				<button id="buttonfin" type="button" onclick="finalizarEspectaculo('<%= nuevo.getNombre() %>')" name="finalizar" value="finalizar" class="mx-auto btn btn-dark">
                        								<i class="btn-dark"></i> Finalizar
                 										</button>
										  			<%}else if(nuevo.getEstado()==EstadoEspectaculo.RECHAZADO){ %>
										  				<p class="text-danger"><b>Rechazado</b></p>
										  			<%}else if(nuevo.getEstado()==EstadoEspectaculo.INGRESADO){ %>
										  				<p class="text-warning"><b>Ingresado</b></p>
										  			<%}else if(nuevo.getEstado()==null){System.out.println("ES NULL LOCO");}%>
											</div>
										</div>
									</a>
	            				</div>
					    		<hr>
							<%}} %>
						</div>
					</div>
					<!-- MOSTRAMOS LAS FUNCIONES A LAS QUE FUE INVITADO -->
					<div class="tab-pane fade" id="funcionesinvitado" role="tabpanel" aria-labelledby="funcionesinvitado-tab">
						<div class="container mt-5">
				  			<% 	Iterator<DtFuncion> itrfunc2 = dtart.getFuncionesinvitado().iterator();
				  				while(itrfunc2.hasNext()){
				  					DtFuncion nuevo = itrfunc2.next();
				  					System.out.println("AAA "+nuevo.getNombre() + " " + nuevo.getAlta() + " " + nuevo.getImagen());
				  			%>
					    		<div class="container-fluid media mb-sm-3">
				    			<a href="/consultaespectaculo?nomespectaculo=<%= port.findDatosFuncion(nuevo.getNombre()).getEspectaculo().getNombre() %>">
					    			<div class="container-fluid media">
					    				<img src="/imagenes?id=<%= nuevo.getImagen() %>" id="imgFuncion" class="rounded float-left media-object" alt="img-funcion" width=150em> 	 
											<div class="media-body ml-sm-4">	
												<p class="text-dark"><b>Nombre:</b> <span id="nombreFuncion"><%= nuevo.getNombre() %> </span></p>
										  		<p class="text-dark"><b>Fecha:</b> <span id="fechaFuncion"><%= fechaIncompleta.format(nuevo.getInicio().toGregorianCalendar().getTime()) %></span></p>
										  		<p class="text-dark"><b>Hora:</b> <span id="horaFuncion"><%= horaFecha.format(nuevo.getInicio().toGregorianCalendar().getTime()) %> </span></p>	
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
					<!-- CARGAMOS LOS ESPECTACULOS FINALIZADOS QUE ORGANIZÓ EL ARTISTA DUEÑO DE LA CUENTA -->
					<div class="tab-pane fade" id="espectaculosfinalizados" role="tabpanel" aria-labelledby="espectaculos-tab">
						<div class="container mt-5">
							<% 
							List<EspectaculoPersistencia> fin = port.listarEspectaculosFinalizados(dtart.getNickname()).getEspectaculos();
							Iterator<EspectaculoPersistencia> itrespper = fin.iterator();
							DateFormat fechaIncompletaFin = new SimpleDateFormat("dd/MM/yyyy");
							while(itrespper.hasNext()) {
								EspectaculoPersistencia nuevo = itrespper.next();
								%>
							
								<div class="container-fluid media mb-sm-3">
					    			<a href="/consultaespectaculofinalizado?nomespectaculofin=<%=nuevo.getNombre()%>">
						    			<div class="container-fluid media">
						    				<img src="/imagenes?id=<%= nuevo.getImagen() %>" id="imgEspectaculo" class="rounded float-left media-object" alt="<%="Imagen:(" + "" + ")" %>" width=150em> 
												<div class="media-body ml-sm-4">		
										         	<p class="text-dark"><b>Nombre del espectaculo:</b> <span id="nombreEspectaculo"><%= nuevo.getNombre() %></span></p>
										         	<p class="text-dark"><b>Precio: $</b> <span id="precioEspectaculo"><%= nuevo.getCosto() %></span></p>
													<p class="text-dark"><b>Descripcion:</b> <span id="descripcionEspectaculo"><%try{ %><%= nuevo.getDescripcion().substring(0, 50) + "..."%><%}catch(Exception e){%><%= nuevo.getDescripcion()%>  <%}%> </span></p>									  					            
										  			<p class="text-dark"><b>Finalización: </b> <span id="finEspectaculo"><%= fechaIncompletaFin.format(nuevo.getFechaFinalizacion().toGregorianCalendar().getTime()) %></span></p>
											</div>
										</div>
									</a>
	            				</div>
					    		<hr>
							<%} %>
						</div>
					</div>
					<%}}%>
				</div>
			</div>
       </div>
	</div>
	<script type="text/javascript">
		var usuarioLogueado = "<%= idUsuario %>";
		var usuarioPerfil = "<%if(EsArtista){%><%=dtart.getNickname()%><%}else{%><%=dtesp.getNickname()%><%}%>"
		function SeguirUsuario(){
			event.preventDefault();
			var data = {
		    		userlogged:'<%= idUsuario %>',
		    		userprofile:'<%if(EsArtista){%><%=dtart.getNickname()%><%}else{%><%=dtesp.getNickname()%><%}%>',
		    		tipo:'follow'};
		    $.ajax({
		        type: 'POST',
		        url:  'perfil',
		        data: data,
		        async: false,
		        success: function (data) {
		            console.log(data);
		            if(data === "SUCCESS") {
		   				window.location.reload();
		            }
		            else{
		            	alert("Error! No puedes seguir a este usuario en este momento " + data);
		            }
		        }
		    });
			return false;
		}	
	</script>
	<script>
	var usuarioLogueado = "<%= idUsuario %>";
	var usuarioPerfil = "<%if(EsArtista){%><%=dtart.getNickname()%><%}else{%><%=dtesp.getNickname()%><%}%>"
	function DejarSeguirUsuario(){
		event.preventDefault();
		var data = {
	    		userlogged:usuarioLogueado,
	    		userprofile:usuarioPerfil,
	    		tipo:'unfollow'};
	    $.ajax({
	        type: 'POST',
	        url:  'perfil',
	        data: data,
	        async: false,
	        success: function (data) {
	            console.log(data);
	            if(data === "SUCCESS") {
	            	//alert("Dejaste de seguir al user");
	   				window.location.reload();
	            }
	            else{
	            	alert("Error! No puedes dejar de seguir a este usuario en este momento " + data);
	            }
	        }
	    });
		return false;
	}
	</script>
	
	<script type="text/javascript">
		var usuarioLogueado = "<%= idUsuario %>";
		var usuarioPerfil = "<%if(EsArtista){%><%=dtart.getNickname()%><%}else{%><%=dtesp.getNickname()%><%}%>"
		function finalizarEspectaculo(esp){
			event.preventDefault();
			var data = {
		    		userlogged:'<%= idUsuario %>',
		    		userprofile:'<%if(EsArtista){%><%=dtart.getNickname()%><%}else{%><%=dtesp.getNickname()%><%}%>',
		    		tipo:'finalizar',
		    		espectaculo:esp};
		    $.ajax({
		        type: 'POST',
		        url:  'perfil',
		        data: data,
		        async: false,
		        success: function (data) {
		            console.log(data);
		            if(data === "SUCCESS") {
		   				window.location.reload();
		            }
		            else{
		            	alert("Error! No se pudo finalizar el espectaculo " + data);
		            }
		        }
		    });
			return false;
		}	
	</script>
</body>
</html>