<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.text.*,java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@page import="webservices.DtEspectaculoDatos"%>
	<%@page import="webservices.EstadoSesion" %>
	<%@page import="webservices.DtCategoria" %>
	<%@page import="webservices.DtPaquete" %>
	<%@page import="webservices.DtArtista" %>
	<%@page import="webservices.DtEspectador" %>
	<%@page import="webservices.DtFuncionDatos" %>
	<%@page import="com.coronatickets.controllers.Login" %>
	<%@page import="webservices.DtRegistroFuncion"%>
	<%@page import="webservices.ArrayPaquetes"%>	
	<%@page import="webservices.FuncionPersistencia"%>
	<%@page import="webservices.EspectaculoPersistencia"%>
	<%@page import="webservices.RegistroPersistencia"%>
	<%@page import="webservices.EspectadorPersistencia"%>		
	<jsp:include page="/WEB-INF/template/head.jsp"/>
<title>CoronaTickets UY - Consulta Espectaculo Finalizado</title>
</head>
<body>
<div class="wrapper">
	<jsp:include page="/WEB-INF/template/header_menulateral.jsp"/> 

        <!-- Page Content  -->
        <div id="content">
        	
			<jsp:include page="/WEB-INF/template/header_menusup.jsp"/>
		<%
		webservices.PublicadorService service = new webservices.PublicadorService();
    	webservices.Publicador port = service.getPublicadorPort();
		String usuario = (String) request.getSession().getAttribute("usuario_logueado");
		webservices.EspectaculoPersistencia dtesp=null;
		dtesp = (webservices.EspectaculoPersistencia) request.getAttribute("espectaculofin");
		String plataformaesp = port.getPlataformaDeEspectaculo(dtesp.getNombre());
		List<webservices.FuncionPersistencia> dtpaqesp = dtesp.getFunciones();
		DateFormat fechaIncompleta = new SimpleDateFormat("dd/MM/yyyy");
		if(dtesp!=null){
		%>
	<div class="mb-sm-4 container-fluid"></div>
            <div class="container-fluid media mb-sm-5">
	            <img src="<% if(true){%>""<%}else{%><%="/img/img-loading-fail.png"%><%}%>" id="imgEspectaculo" class="rounded float-left media-object" alt="img-perfil-usuario" width=150em> 
	            <div class="media-body ml-sm-4">
		            <p class="media-heading"><h4 id="tituloEspectaculo"><%= dtesp.getNombre() %></h4></p>
		            <p> <span id="descripcionEspectaculo"><%= dtesp.getDescripcion() %> </span></p>        
	            </div>
            </div>
            
           	<div class="container-fluid">
	           	<ul class="nav nav-tabs" id="myTab" role="tablist">
			  		<li class="nav-item">
			  			<a class="nav-link active" id="espectaculo-tab" data-toggle="tab" href="#espectaculo" role="tab" aria-controls="espectaculo" aria-selected="true">INFORMACION</a>
			  		</li>
					<li class="nav-item">
						<a class="nav-link" id="funciones-tab" data-toggle="tab" href="#funciones" role="tab" aria-controls="funciones" aria-selected="false">FUNCIONES</a>
					</li>
				</ul>
				<div class="tab-content" id="myTabContent">
			  		<div class="tab-pane fade show active ml-sm-5 mt-sm-5" id="espectaculo" role="tabpanel" aria-labelledby="espectaculo-tab">
			  			<p class="media-heading"><h4 id="tituloEspectaculo">Informacion sobre el espectaculo:</h4></p>
			  			<hr>
						<p class="text-dark"><b>Nombre del espectaculo:</b> <span id="nombreEspectaculo"><%= dtesp.getNombre() %>	</span></p>			
						<p class="text-dark"><b>Descripcion:</b> <span id="descripcionEspectaculo"><%= dtesp.getDescripcion() %> </span></p>
						<p class="text-dark"><b>Plataforma:</b> <span id="nombreEspectaculo"><%= dtesp.getPlataforma() %>	</span></p>			
						<a href="/perfil?id=<%= dtesp.getOrganizador().getNickname() %>"><p class="text-dark"><b>Organizador:</b> <span id="descripcionEspectaculo"><%= dtesp.getOrganizador().getNombre() %> <%= dtesp.getOrganizador().getApellido() %></span></p></a>
						<p class="text-dark"><b>Duracion:</b> <span id="duracionEspectaculo"><%= dtesp.getDuracion() %> minutos</span></p>
						<a href="<%= dtesp.getUrl() %>"><p class="text-dark"><b>Url:</b> <span id="urlEspectaculo"><%= dtesp.getUrl() %></span></p></a>
						<p class="text-dark"><b>Alta: </b> <span id="finEspectaculo"><%= fechaIncompleta.format(dtesp.getRegistro().toGregorianCalendar().getTime()) %></span></p>
						<p class="text-dark"><b>Finalización: </b> <span id="finEspectaculo"><%= fechaIncompleta.format(dtesp.getFechaFinalizacion().toGregorianCalendar().getTime()) %></span></p>
						<p class="text-dark"><b>Costo:</b> <span id="costoEspectaculo"><%= dtesp.getCosto() %></span></p>					    
					</div>
			  		<div class="tab-pane fade ml-sm-5 mt-sm-5" id="funciones" role="tabpanel" aria-labelledby="funciones-tab">	 
				  			 <div class="panel-group container-fluid">
				  				<div class="panel panel-default">
				  					<div class="panel-heading mb-sm-2">
				  						 <p class="media-heading"><h4 id="tituloFunciones">Funciones:</h4></p>
				  					</div>
				  					<% Integer tamf = dtesp.getFunciones().size();
				    		if(tamf>0){%>
				  					<hr>
				  					<%
					      Iterator<FuncionPersistencia> itrf = dtesp.getFunciones().iterator();
							while(itrf.hasNext())
								{
								FuncionPersistencia auxf = itrf.next();%>
								<div class="container-fluid media mb-sm-5">
								
								<img src="<% if(true){%>""<%}else{%><%="/img/img-loading-fail.png"%><%}%>" id="imgPaquete" class="rounded float-left media-object" alt="img-funcion" width=150em> 	
				    				<div class="panel-body">
				    							    							  				
								  			 <p class="text-dark"><b>Nombre:</b> <span id="nombreFuncion"><%= auxf.getNombre() %> </span></p>
								  			 <p class="text-dark"><b>Fecha:</b> <span id="fechaFuncion"><%= fechaIncompleta.format(auxf.getInicio().toGregorianCalendar().getTime()) %></span></p>
								  			 <p class="text-dark"><b>Hora:</b> <span id="horaFuncion"><%= auxf.getInicio().toGregorianCalendar().getTime().getHours() + ":" + (auxf.getInicio().toGregorianCalendar().getTime().getMinutes()/10)+(auxf.getInicio().toGregorianCalendar().getTime().getMinutes()%10)%> </span></p>					
											<%
				    							if (dtesp.getOrganizador().getNickname().equals(usuario) && request.getSession().getAttribute("estado_sesion")==EstadoSesion.LOGIN_CORRECTO && usuario!=null && port.esArtista(usuario)){
				    								
				    						%>
				    							<button type="submit" class="btn btn-info" data-toggle="modal" data-target="#espectadores<%= auxf.getNombre().replace(" ", "") %>" onclick=""><i class="fas fa-users"></i>Espectadores</button>
				    							<!-- MODAL SORTEAR -->
												<div class="modal fade" id="espectadores<%= auxf.getNombre().replace(" ", "") %>" tabindex="-1" role="dialog" aria-labelledby="espectadores" aria-hidden="true">
												  <div class="modal-dialog modal-dialog-centered" role="document">
												    <div class="modal-content">
												      <div class="modal-header">
												        <h5 class="modal-title" id="exampleModalLongTitle">Espectadores: </h5>
												        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
												          <span aria-hidden="true">&times;</span>
												        </button>
												      </div>
												      <div class="modal-body" >
												      	<%
												      	List<RegistroPersistencia> registros = auxf.getRegistros();
												      	Iterator<RegistroPersistencia> participantes= registros.iterator();								      	
														while(participantes.hasNext()){
															EspectadorPersistencia nuevo = participantes.next().getEspectador();
												      	%>
												      	<a href="/perfil?id=<%= nuevo.getNickname() %>" target="_blank">
												         <div class="row ml-sm-2" > 
												         	<div style="padding-left:0px;" class="col-md-10"><label class="float-left"><%= nuevo.getNombre() + " " + nuevo.getApellido()%> -</label> <label style="color:grey;" >@<%= nuevo.getNickname() %></label></div><br>
												         </div>
												         </a>
												        <%}%>
												      <div class="modal-footer">
												      	<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
												      </div>
												    </div>
												  </div>
												</div>
												</div>
												<!-- FIN MODAL -->
				    			
				    						<% 
				    								
				    							}//FIN IF ESTA LOGUEADO EL DUEÑO DEL ESPECTACULO
				    						%>
				    					</div>
				    				</div>
				    				<hr> 
				    				<%
 				    					;}}}
 				    				%>
				    							    				
				  				</div>
							 </div>		  		
			  		</div>
				</div>
			</div>
       </div>
</div>


 
</body>
</html>