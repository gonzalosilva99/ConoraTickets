<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.text.*,java.util.*" %>
<%@page import="DataTypes.DtEspectaculoDatos"%>
	<%@page import="DataTypes.EstadoSesion" %>
	<%@page import="DataTypes.DtCategoria" %>
	<%@page import="DataTypes.DtPaquete" %>
	<%@page import="DataTypes.DtArtista" %>
	<%@page import="DataTypes.DtFuncionDatos" %>
	<%@page import="com.coronatickets.controllers.Login" %>
	<%@page import="Controladores.Fabrica"%>
	<%@page import="Interfaces.IUsuario"%>
	
<!DOCTYPE html>
<html>
<head>	
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
		String usuario = (String) request.getSession().getAttribute("usuario_logueado");
		DtEspectaculoDatos dtesp=null;
		dtesp = (DtEspectaculoDatos) request.getAttribute("espectaculo");
		Set<DtPaquete> dtpaqesp = dtesp.getPaquetes();
		Set<DtPaquete> dtpaq = Fabrica.getInstancia().getIPaquete().ListarPaquetes();
		DateFormat fechaIncompleta = new SimpleDateFormat("dd/MM/yyyy");
		if(dtesp!=null){%>
	<div class="mb-sm-4 container-fluid"></div>
            <div class="container-fluid media mb-sm-5">
	            <img src="<% if(dtesp.getImagen()!=""){%><%= dtesp.getImagen()%><%}else{%><%="/img/img-loading-fail.png"%><%}%>" id="imgEspectaculo" class="rounded float-left media-object" alt="img-perfil-usuario" width=150em> 
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
						<p class="text-dark"><b>Nombre del espectaculo:</b> <span id="nombreEspectaculo"><%= dtesp.getNombre() %>	</span></p>
						<% Integer tamc = dtesp.getCategorias().size();
				    		if(tamc>0){
				    		tamc=0;%>
						<p class="text-dark"><b>Categorias:</b> <span id="categoriasEspectaculo">
						<% 
					      Iterator<DtCategoria> itr = dtesp.getCategorias().iterator();
							while(itr.hasNext())
								{tamc++;%>
								<%= itr.next().getNomCategoria() %>
								<% if(tamc<dtesp.getCategorias().size()) {%>,<%} %>
								<% } %></span></p>	<% } %>				
						<p class="text-dark"><b>Descripcion:</b> <span id="descripcionEspectaculo"><%= dtesp.getDescripcion() %> </span></p>
						<a href="/perfil?id=<%= dtesp.getOrganizador().getNickname() %>"><p class="text-dark"><b>Organizador:</b> <span id="descripcionEspectaculo"><%= dtesp.getOrganizador().getNombre() %> <%= dtesp.getOrganizador().getApellido() %></span></p></a>
						<p class="text-dark"><b>Duracion:</b> <span id="duracionEspectaculo"><%= dtesp.getDuracion() %> minutos</span></p>
						<a href="<%= dtesp.getURL() %>"><p class="text-dark"><b>Url:</b> <span id="urlEspectaculo"><%= dtesp.getURL() %></span></p></a>
						<p class="text-dark"><b>Cantidad minima de Espectadores:</b> <span id="cantMinEspectadores"><%= dtesp.getCantMin() %></span></p>
					    <p class="text-dark"><b>Cantidad maxima de Espectadores:</b> <span id="cantMaxEspectadores"><%= dtesp.getCantMax() %></span></p>
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
					      Iterator<DtFuncionDatos> itrf = dtesp.getFunciones().iterator();
							while(itrf.hasNext())
								{
								DtFuncionDatos auxf = itrf.next();%>
								<div class="container-fluid media mb-sm-5">
								
								<img src="<% if(auxf.getImagen()!=""){%><%= auxf.getImagen()%><%}else{%><%="/img/img-loading-fail.png"%><%}%>" id="imgPaquete" class="rounded float-left media-object" alt="img-funcion" width=150em> 	
				    				<div class="panel-body">
				    							    							  				
								  			 <p class="text-dark"><b>Nombre:</b> <span id="nombreFuncion"><%= auxf.getNombre() %> </span></p>
								  			 <p class="text-dark"><b>Fecha:</b> <span id="fechaFuncion"><%= fechaIncompleta.format(auxf.getInicio()) %></span></p>
								  			 <p class="text-dark"><b>Hora:</b> <span id="horaFuncion"><%= auxf.getInicio().getHours() + ":" + (auxf.getInicio().getMinutes()/10)+(auxf.getInicio().getMinutes()%10)%> </span></p>					
				    						 <% Integer tama = auxf.getArtistas().size();
				    						 	if(tama>0){tama=0;%>
				    						 <p class="text-dark"><b>Artistas Invitados:</b> <span id="artistasinvitados">
											<%
											
					      					Iterator<DtArtista> itra = auxf.getArtistas().iterator();
											while(itra.hasNext())
											{DtArtista auxa = itra.next();tama++;%>
											<a href="/perfil?id=<%= auxa.getNickname() %>"> <%= auxa.getNombre() + auxa.getApellido() %></a>
											<% if(auxf.getArtistas().size()<tama) {%>,<%}%>
											<% } %></span></p>
											<% } %>
											<p class="text-dark"><b>Espectadores hasta el momento:</b> <span id="fechaFuncion"><%= auxf.getEspectadores() %></span></p>
				    						<% if(request.getSession().getAttribute("estado_sesion")==EstadoSesion.LOGIN_CORRECTO && request.getSession().getAttribute("usuario_logueado")!=null && !Fabrica.getInstancia().getIUsuario().EsArtista((String)request.getSession().getAttribute("usuario_logueado"))){ %>
				    							<button type="submit" class="btn btn-primary" onclick="ComprarFuncion('<%=auxf.getNombre()%>');"><i class="fas fa-shopping-cart"></i> Comprar</button>
				    						<%} %>
				    					</div>
				    				</div>
				    				<hr> 
				    				<% ;}} %>
				    							    				
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
				  					<%
					      Iterator<DtPaquete> itrp = dtesp.getPaquetes().iterator();
							while(itrp.hasNext())
								{
								DtPaquete auxp = itrp.next();%>
				    				<div class="container-fluid media mb-sm-5">
				    				<a href="/consultapaquete?nompaquete=<%=auxp.getNombre()%>">
				    				<div class="container-fluid media mb-sm-5">
				    					 <img src="<% if(auxp.getImagen()!=""){%><%= auxp.getImagen()%><%}else{%><%="/img/img-loading-fail.png"%><%}%>" id="imgPaquete" class="rounded float-left media-object" alt="img-paquete" width=150em> 
										 <% Date todayDate = new Date(); %>
										 <div class="media-body ml-sm-4">		
								             <p class="text-dark"><b>Nombre del paquete:</b> <span id="nombrePaquete"><%= auxp.getNombre() %></span></p>
								             <p class="text-dark"><b>Descripcion:</b> <span id="descuentoPaquete"><%= auxp.getDescripcion() %></span></p>
								  			 <p class="text-dark"><b>Descuento:</b> <span id="descuentoPaquete"><%= auxp.getDescuento() %>%</span></p>							            
								  			 <p class="text-dark red"><b <% if(!todayDate.after(auxp.getInicio()) || !todayDate.before(auxp.getFin())) {%>style="color:red;"<% } %>>Validez: </b> <span id="validezPaquete" <% if(!todayDate.after(auxp.getInicio()) || !todayDate.before(auxp.getFin())) {%>style="color:red;"<% } %>><%=  fechaIncompleta.format(auxp.getInicio()) + " - " + fechaIncompleta.format(auxp.getFin()) %></span></p>
								  			 <% 
								  			 
								  			 if(request.getSession().getAttribute("estado_sesion")==EstadoSesion.LOGIN_CORRECTO && request.getSession().getAttribute("usuario_logueado")!=null && !Fabrica.getInstancia().getIUsuario().EsArtista((String)request.getSession().getAttribute("usuario_logueado")) && todayDate.after(auxp.getInicio()) && todayDate.before(auxp.getFin()) ){ %>
				    							<button type="submit" class="btn btn-primary" onclick="ComprarPaquete('<%=auxp.getNombre()%>');"><i class="fas fa-shopping-cart"></i> Comprar</button>
				    						<%} %>
								  		</div>
								  		</div>
								  		</a>
            						</div>
				    				<hr>
				    				<% }} %>
				    				<% if(Fabrica.getInstancia().getIUsuario().EsArtista(usuario)){ %>
				    				<div class="container-fluid">
				    					<p class="mx-auto" id="anadirpaquetes"><button class="btn btn-primary" data-toggle="modal" data-target="#ModalAnadirPaquete"><i class="far fa-folder-plus"></i> Añadir Paquete</button></p>
				    				</div>	
				    				<!-- MODAL ANADIR PAQUETES -->
				    				<div class="modal fade" id="ModalAnadirPaquete" tabindex="-1" role="dialog" aria-labelledby="ModalAnadirPaquete" aria-hidden="true">
										<div class="modal-dialog modal-dialog-centered" role="document">
											<div class="modal-content">
												<div class="modal-header">
													<h5 class="modal-title" id="exampleModalLongTitle">Seguidores</h5>
													<button type="button" class="close" data-dismiss="modal" aria-label="Close">
														<span aria-hidden="true">&times;</span>
													</button>
									      		</div>
												<div class="modal-body" >
												<form action="consultaespectaculo" method="POST" class="form" id="formAnadirPaquetes">
													<%
													Iterator<DtPaquete> itrdtpaq = dtpaq.iterator();
													while(itrdtpaq.hasNext()){
														DtPaquete nuevo = itrdtpaq.next();
														boolean anadir = true;
														Iterator<DtPaquete> itrdtpaqesp = dtpaqesp.iterator();
														while(itrdtpaqesp.hasNext()){
															DtPaquete auxnuevo = itrdtpaqesp.next();
															if(nuevo.getNombre().equals(auxnuevo.getNombre())){
																anadir=false;
															}
														}
														if(anadir){
															
														
											      	%>
														<div class="form-check">
															<label class="form-check-label">
																<input type="checkbox" name="checkbox" class="form-check-input" value="<%=nuevo.getNombre()%>"><%= nuevo.getNombre() %>
															</label>
														</div>
													<%} else{%>
														<span class="form-check text-info"><i class="fas fa-check form-check-input"></i> <%= nuevo.getNombre() %></span>
												<% 
												}}
												%>											
									      <div class="modal-footer">
									        <button type="submit" class="btn btn-secondary" id="botonModalPaquete">Confirmar</button>
									      </div>
									      <div id="MensajePaquetesAnadidos">
									      </div>
									      </form>
									      </div>
									    </div>
									  </div>
									</div>
				    				<%} %>		    				
				  				</div>
							 </div>				
			  		</div>
				</div>
			</div>
       </div>
</div>


	<script type="text/javascript">
		function ComprarFuncion(funcion){
			var espectaculo = "<%=dtesp.getNombre()%>";
			window.location.replace("/registrofuncion?nomespectaculo="+espectaculo+"&funcion="+funcion);
		}
	</script>
	
	<script type="text/javascript">
		function ComprarPaquete(paquete){
			window.location.replace("/comprarpaquete?nompaquete="+paquete);
		}
	</script>

	<script type="text/javascript">
        $(document).ready(function () {
            $('#sidebarCollapse').on('click', function () {
                $('#sidebar').toggleClass('active');
            });
        });
    </script>
    
    <script type="text/javascript">
    $("#formAnadirPaquetes").submit(function( event ) {
    	event.preventDefault();
    	var rbs = document.getElementsByName("checkbox");
    	var $form = $( this );
    	var valorBoton = document.getElementById("botonModalPaquete").innerHTML;
    	if(valorBoton === "Confirmar"){
		for (var i=0;i<rbs.length;i++){
			if(rbs[i].checked){
				var result;
				console.log(rbs[i].value);
				var data = {
			    		espectaculo:'<%= dtesp.getNombre()%>',
			    		paquete:rbs[i].value};
			    console.log(data);
			    console.log(i);
			    console.log(rbs[i].value);
			    $.ajax({
			        type: $form.attr('method'),
			        url:  $form.attr('action'),
			        data: data,
			        async: false,
			        success: function (data) {
			            console.log(data);
						var paquete_fin = document.getElementById("MensajePaquetesAnadidos")
			            if(data === "SUCCESS") {
			            	paquete_fin.insertAdjacentHTML('afterbegin','<div class="alert alert-success"><a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a><strong>Hecho!</strong>    Se ha añadido el paquete: ' + rbs[i].value + 'con éxito al espectáculo <%= dtesp.getNombre() %></div>');
			            	document.getElementsByClassName("form-check-label")[i].innerHTML='<span class="text-info"><i class="fas fa-check form-check-input"></i>'+rbs[i].value+'</span>';
			            	//document.getElementById('metododecompra').setAttribute('style',"pointer-events:none;");
			            	//$('#funcionyacomprada').show();
			            }
			            else{
			            	paquete_fin.insertAdjacentHTML('afterbegin','<div class="alert alert-danger"><a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a><strong>Error!</strong>    Algo ha fallado, por favor intentalo más tarde.'+data+'</div>')
			            }
			        }
			    });
			}
		}
		document.getElementById("botonModalPaquete").innerHTML="Recargar";
		}
		else if(valorBoton == "Recargar"){
			$("#ModalAnadirPaquete").modal("hide");
			window.location.reload();
		}
    });
    </script>
</body>
</html>
