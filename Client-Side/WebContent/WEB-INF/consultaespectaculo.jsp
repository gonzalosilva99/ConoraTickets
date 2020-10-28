<%@ page language="java" contentType="text/html"%>
<%@ page import="java.text.*,java.util.*" %>
<!DOCTYPE html>
<html>
<head>
	<%@page import="DataTypes.DtEspectaculoDatos"%>
	<%@page import="DataTypes.EstadoSesion" %>
	<%@page import="com.coronatickets.controllers.Login" %>
	<%@page import="Controladores.Fabrica"%>
	<%@page import="Interfaces.IUsuario"%>
	<jsp:include page="/WEB-INF/template/head.jsp"/>
	<title>CoronaTickets UY - Consulta Espectaculo</title>
</head>
<body>
<div class="wrapper">
	<jsp:include page="/WEB-INF/template/header_menulateral.jsp"/>
        <!-- Page Content  -->
    	<div id="content">
		<jsp:include page="/WEB-INF/template/header_menusup.jsp"/>
		<% 
		DtEspectaculoDatos dtesp=null;
		dtesp = (DtEspectaculoDatos) request.getAttribute("espectaculo");
		%>
	<div class="mb-sm-4 container-fluid"></div>
            <div class="container-fluid media mb-sm-5">
	            <img src="dtesp.getImagen()" id="imgEspectaculo" class="rounded float-left media-object" alt="img-perfil-usuario" width=150em> 
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
					<li class="nav-item">
						<a class="nav-link" id="paquetes-tab" data-toggle="tab" href="#paquetes" role="tab" aria-controls="paquetes" aria-selected="false">PAQUETES</a>
					</li>
				</ul>
				<div class="tab-content" id="myTabContent">
			  		<div class="tab-pane fade show active ml-sm-5 mt-sm-5" id="espectaculo" role="tabpanel" aria-labelledby="espectaculo-tab">
			  			<p class="media-heading"><h4 id="tituloEspectaculo">Informacion sobre el espectaculo:</h4></p>
			  			<hr>
						<p class="text-dark"><b>Nombre del espectaculo:</b> <span id="nombreEspectaculo">Bien de Familia	</span></p>
						<p class="text-dark"><b>Categorias:</b> <span id="categoriasEspectaculo">Musica</span></p>
						<p class="text-dark"><b>Descripcion:</b> <span id="descripcionEspectaculo">Springsteen tocando guitarra o piano y relatando anécdotas recogidas en su autobiografía de 2016, Burn to Run. </span></p>
						<p class="text-dark"><b>Duracion:</b> <span id="duracionEspectaculo">150 minutos</span></p>
						<p class="text-dark"><b>Url:</b> <span id="urlEspectaculo">https://twitter.com/PimpinelaNet</span></p>
						<p class="text-dark"><b>Cantidad minima de Espectadores:</b> <span id="cantMinEspectadores">10</span></p>
					    <p class="text-dark"><b>Cantidad maxima de Espectadores:</b> <span id="cantMaxEspectadores">500</span></p>
						<p class="text-dark"><b>Costo:</b> <span id="costoEspectaculo">500</span></p>					    
					</div>
			  		<div class="tab-pane fade ml-sm-5 mt-sm-5" id="funciones" role="tabpanel" aria-labelledby="funciones-tab">	 
				  			 <div class="panel-group container-fluid">
				  				<div class="panel panel-default">
				  					<div class="panel-heading mb-sm-2">
				  						 <p class="media-heading"><h4 id="tituloFunciones">Funciones:</h4></p>
				  					</div>
				  					<hr>
				    				<div class="panel-body">		    							  				
								  			 <p class="text-dark"><b>Nombre:</b> <span id="nombreFuncion">Bien de Familia - A </span></p>
								  			 <p class="text-dark"><b>Fecha:</b> <span id="fechaFuncion">25/09/20</span></p>
								  			 <p class="text-dark"><b>Hora:</b> <span id="horaFuncion">19:00</span></p>
								  			 <p class="text-dark"><b>Artistas invitados:</b> <span id="artistasInvitadosFuncion"> Alcides Violeta</span></p>
								  			 <p class="text-dark"><b>Costo:</b> <span id="costoFuncion">$500</span></p>						
				    				</div>
				    				<hr> 
				    				<div class="panel-body">			    								  				
							  			 <p class="text-dark"><b>Nombre:</b> <span id="nombreFuncion">Bien de Familia - B</span></p>
							  			 <p class="text-dark"><b>Fecha:</b> <span id="fechaFuncion">25/10/20</span></p>
							  			 <p class="text-dark"><b>Hora:</b> <span id="horaFuncion">18:30</span></p>
							  			 <p class="text-dark"><b>Artistas invitados:</b> <span id="artistasInvitadosFuncion"> La Triple Nelson</span></p>
							  			 <p class="text-dark"><b>Costo:</b> <span id="costoFuncion">$500</span></p>						
				    				</div>		
				    				<hr> 
				    				<div class="panel-body">			    								  				
							  			 <p class="text-dark"><b>Nombre:</b> <span id="nombreFuncion">Bien de Familia - C</span></p>
							  			 <p class="text-dark"><b>Fecha:</b> <span id="fechaFuncion">25/11/20</span></p>
							  			 <p class="text-dark"><b>Hora:</b> <span id="horaFuncion">17:45 </span></p>
							  			 <p class="text-dark"><b>Artistas invitados:</b> <span id="artistasInvitadosFuncion"> ...</span></p>
							  			 <p class="text-dark"><b>Costo:</b> <span id="costoFuncion">$500</span></p>						
				    				</div>						    				
				  				</div>
							 </div>		  		
			  		</div>
			  		<div class="tab-pane fade ml-sm-5 mt-sm-5" id="paquetes" role="tabpanel" aria-labelledby="paquetes-tab">		
							<div class="panel-group container-fluid">
				  				<div class="panel panel-default">
				  					<div class="panel-heading mb-sm-2">
				  						 <p class="media-heading"><h4 id="tituloFunciones">Paquetes:</h4></p>
				  					</div>
				  					<hr>
				    				<div class="container-fluid media mb-sm-5">
				    				<a href="ConsultaPaquete.html">
				    					 <img src="https://images-platform.99static.com//nErsv2I3Mbjoc_IsYm4-hefSSHw=/0x0:1200x1200/fit-in/500x500/99designs-contests-attachments/89/89846/attachment_89846410" id="imgPaquete" class="rounded float-left media-object" alt="img-perfil-usuario" width=150em> 
										 
										 <div class="media-body ml-sm-4">		
								             <p class="text-dark"><b>Nombre del paquete:</b> <span id="nombrePaquete">Paquete de Latino.</span></p>
								  			 <p class="text-dark"><b>Descuento:</b> <span id="descuentoPaquete">15%</span></p>							            
								  		</div>
								  		</a>
            						</div>
				    				<hr>				    				
				  				</div>
							 </div>				
			  		</div>
				</div>
			</div>
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
        });
    </script>
</body>
</html>