<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.text.*,java.util.*" %>
	<%@page import="datatypes.DtPaqueteDatos"%>
	<%@page import="webservices.EstadoSesion" %>
	<%@page import="datatypes.DtCategoria" %>
	<%@page import="datatypes.DtEspectaculo" %>
	<%@page import="datatypes.DtEspectaculoDatos"%>
	<%@page import="datatypes.DtPaquete" %>
	<%@page import="datatypes.DtArtista" %>
	<%@page import="datatypes.DtFuncionDatos" %>
	<%@page import="com.coronatickets.controllers.Login" %>
	<%@page import="controladores.Fabrica"%>
	<%@page import="interfaces.IUsuario"%>
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
		String usuario=(String) request.getSession().getAttribute("usuario_logueado");
		DtPaqueteDatos dtpaq=null;
		dtpaq = (DtPaqueteDatos) request.getAttribute("paquete");
		Set<DtEspectaculoDatos> dtesp = Fabrica.getInstancia().getIPlataforma().filtrarEspectaculos("");
		DateFormat fechaIncompleta = new SimpleDateFormat("dd/MM/yyyy");
		if(dtpaq!=null){%>
	<div class="mb-sm-4 container-fluid"></div>
            <div class="container-fluid media mb-sm-5">
	            <img src="<% if(dtpaq.getImagen()!=""){%><%= dtpaq.getImagen()%><%}else{%><%="/img/img-loading-fail.png"%><%}%>" id="imgEspectaculo" class="rounded float-left media-object" alt="img-perfil-usuario" width=150em> 
	            <div class="media-body ml-sm-4">
		            <p class="media-heading"><h4 id="tituloEspectaculo"><%= dtpaq.getNombre() %></h4></p>
		            <p> <span id="descripcionEspectaculo"><%= dtpaq.getDescripcion() %> </span></p>        
		            <%
        		            	Date hoy = new Date();	 
        		            						  			 if(request.getSession().getAttribute("estado_sesion")==EstadoSesion.LOGIN_CORRECTO && request.getSession().getAttribute("usuario_logueado")!=null && !Fabrica.getInstancia().getIUsuario().esArtista((String)request.getSession().getAttribute("usuario_logueado")) && hoy.after(dtpaq.getInicio()) && hoy.before(dtpaq.getFin()) ){
        		            %>
				    							<button type="submit" class="btn btn-primary" onclick="ComprarPaquete('<%=dtpaq.getNombre()%>');"><i class="fas fa-shopping-cart"></i> Comprar</button>
				    						<%
				    							}
				    						%>
	            </div>
            </div>
           	<div class="container-fluid">
	           	<ul class="nav nav-tabs" id="myTab" role="tablist">
			  		<li class="nav-item">
			  			<a class="nav-link active" id="espectaculo-tab" data-toggle="tab" href="#paquete" role="tab" aria-controls="espectaculo" aria-selected="true">INFORMACION</a>
			  		</li>
					<li class="nav-item">
						<a class="nav-link" id="funciones-tab" data-toggle="tab" href="#espectaculos" role="tab" aria-controls="funciones" aria-selected="false">ESPECTACULOS</a>
					</li>
				</ul>
				<div class="tab-content" id="myTabContent">
			  		<div class="tab-pane fade show active ml-sm-5 mt-sm-5" id="paquete" role="tabpanel" aria-labelledby="espectaculo-tab">
			  			<p class="media-heading"><h4 id="tituloEspectaculo">Informacion sobre el paquete:</h4></p>
			  			<hr>
						<p class="text-dark"><b>Nombre del paquete:</b> <span id="nombreEspectaculo"><%=dtpaq.getNombre()%>	</span></p>
						<%
							Integer tamc = dtpaq.getCategorias().size();
								    		if(tamc>0){
								    		tamc=0;
						%>
						<p class="text-dark"><b>Categorias:</b> <span id="categoriasEspectaculo">
						<%
							Iterator<DtCategoria> itr = dtpaq.getCategorias().iterator();
											while(itr.hasNext())
												{tamc++;
						%>
								<%=itr.next().getNomCategoria()%>
								<%
									if(tamc<dtpaq.getCategorias().size()) {
								%>,<%
									}
								%>
								<%
									}
								%></span></p>	<%
		}
	%>				
						<p class="text-dark"><b>Descripcion:</b> <span id="descripcionEspectaculo"><%=dtpaq.getDescripcion()%> </span></p>
						<p class="text-dark"><b>Descuento:</b> <span id="descuentoPaquete"><%=dtpaq.getDescuento()%>%</span></p>							            
						<p class="text-dark red"><b <%Date todayDate = new Date(); if(!todayDate.after(dtpaq.getInicio()) || !todayDate.before(dtpaq.getFin())) {%>style="color:red;"<%}%>>Validez: </b> <span id="validezPaquete" <%if(!todayDate.after(dtpaq.getInicio()) || !todayDate.before(dtpaq.getFin())) {%>style="color:red;"<%}%>><%=fechaIncompleta.format(dtpaq.getInicio()) + " - " + fechaIncompleta.format(dtpaq.getFin())%></span></p>					    
					</div>
			  		<div class="tab-pane fade ml-sm-5 mt-sm-5" id="espectaculos" role="tabpanel" aria-labelledby="funciones-tab">	 
				  			 <div class="panel-group container-fluid">
				  				<div class="panel panel-default">
				  					<div class="panel-heading mb-sm-2">
				  						 <p class="media-heading"><h4 id="tituloFunciones">Espectaculos:</h4></p>
				  					</div>
				  					<%
				  						Integer tame = dtpaq.getEspectaculos().size();
				  							    		if(tame>0){
				  					%>
				  					<hr>
				  					<%
				  						Iterator<DtEspectaculo> itre = dtpaq.getEspectaculos().iterator();
				  										while(itre.hasNext())
				  											{
				  											DtEspectaculo auxe = itre.next();
				  					%>
								<a href="/consultaespectaculo?nomespectaculo=<%=auxe.getNombre()%>">
								<div class="container-fluid media mb-sm-5">
								<img src="<%if(auxe.getImagen()!=""){%><%=auxe.getImagen()%><%}else{%><%="/img/img-loading-fail.png"%><%}%>" id="imgEspectaculo" class="rounded float-left media-object" alt="img-funcion" width=150em> 	
				    				<div class="panel-body">
				    							    							  				
								  			 <p class="text-dark"><b>Nombre:</b> <span id="nombreFuncion"><%=auxe.getNombre()%> </span></p>
								  			 <p class="text-dark"><b>Descripcion:</b> <span id="fechaFuncion"><%=auxe.getDescripcion()%></span></p>
								  			 <p class="text-dark"><b>Costo:</b> <span id="fechaFuncion"><%=auxe.getCosto()%></span></p>					
				    				</div>
				    			</div>
				    			</a>
				    				<hr> 
				    				<%
 				    					;}}}
 				    				%>
				    					
				    				<%
				    									    					if(usuario != null && Fabrica.getInstancia().getIUsuario().esArtista(usuario)){
				    									    				%>
				    				<div class="container-fluid">
				    					<p class="mx-auto" id="anadirespectaculo"><button class="btn btn-primary" data-toggle="modal" data-target="#ModalAnadirEspectaculo"><i class="far fa-folder-plus"></i> Añadir Espectaculo</button></p>
				    				</div>	
				    				<!-- MODAL ANADIR ESPECTACULOS -->
				    				<div class="modal fade" id="ModalAnadirEspectaculo" tabindex="-1" role="dialog" aria-labelledby="ModalAnadirEspectaculo" aria-hidden="true">
										<div class="modal-dialog modal-dialog-centered" role="document">
											<div class="modal-content">
												<div class="modal-header">
													<h5 class="modal-title" id="exampleModalLongTitle">Añadir Espectaculos a <%= dtpaq.getNombre() %></h5>
													<button type="button" class="close" data-dismiss="modal" aria-label="Close">
														<span aria-hidden="true">&times;</span>
													</button>
									      		</div>
												<div class="modal-body" >
												<form action="consultaespectaculo" method="POST" class="form" id="formAnadirEspectaculos">
													<%
													Set<DtEspectaculoDatos> dtespultimos = new HashSet<DtEspectaculoDatos>(); 
													Iterator<DtEspectaculoDatos> itrdtesp = dtesp.iterator();
													while(itrdtesp.hasNext()){
														DtEspectaculoDatos nuevo = itrdtesp.next();
														boolean anadir = true;
														Iterator<DtEspectaculo> itrdtesppaq = dtpaq.getEspectaculos().iterator();
														while(itrdtesppaq.hasNext()){
															DtEspectaculo auxnuevo = itrdtesppaq.next();
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
													<%} else{ 
														dtespultimos.add(nuevo);
														}}
													Iterator<DtEspectaculoDatos> itrdtespultimos = dtespultimos.iterator();
													while(itrdtespultimos.hasNext()){
														DtEspectaculoDatos nuevo=itrdtespultimos.next();
													%>								
														<span class="form-check text-info"><i class="fas fa-check form-check-input"></i> <%= nuevo.getNombre() %></span>
													<%} %>	
									      <div class="modal-footer">
									        <button type="submit" class="btn btn-secondary" id="botonModalEspectaculo">Confirmar</button>
									      </div>
									      <div id="MensajeEspectaculosAnadidos">
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
		function ComprarPaquete(paquete){
			window.location.replace("/comprarpaquete?nompaquete="+paquete);
		}
	</script>
    
    <script>
    $("#formAnadirEspectaculos").submit(function( event ) {
    	event.preventDefault();
    	var rbs = document.getElementsByName("checkbox");
    	var $form = $( this );
    	var valorBoton = document.getElementById("botonModalEspectaculo").innerHTML;
    	if(valorBoton === "Confirmar"){
    		var valoresIngresados = new Array();
    		var indicesIngresados = new Array();
			for (var i=0;i<rbs.length;i++){
				if(rbs[i].checked){
					var result;
					indicesIngresados.push(i);
					valoresIngresados.push(rbs[i].value);
					//console.log(rbs[i].value);
					var data = {
				    		paquete:'<%= dtpaq.getNombre()%>',
				    		espectaculo:rbs[i].value};
				    //console.log(data);
				    //console.log(i);
				    //console.log(rbs[i].value);
				    $.ajax({
				        type: $form.attr('method'),
				        url:  $form.attr('action'),
				        data: data,
				        async: false,
				        success: function (data) {
				            console.log(data);
							var paquete_fin = document.getElementById("MensajeEspectaculosAnadidos")
				            if(data === "SUCCESS") {
				            	paquete_fin.insertAdjacentHTML('afterbegin','<div class="alert alert-success"><a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a><strong>Hecho!</strong>    Se ha añadido el espectaculo: ' + rbs[i].value + ' con éxito al paquete <%= dtpaq.getNombre() %></div>');
				            	//console.log("Espectaculo: " + i + " " + rbs[i].value);
				            	//document.getElementsByClassName("form-check-label")[i].innerHTML='<span class="text-info"><i class="fas fa-check form-check-input"></i>'+rbs[i].value+'</span>';
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
			for(i=0; i<indicesIngresados.length;i++){
				document.getElementsByClassName("form-check-label")[indicesIngresados[i]].innerHTML='<span class="text-info"><i class="fas fa-check form-check-input"></i>'+valoresIngresados[i]+'</span>';
			}
			document.getElementById("botonModalEspectaculo").innerHTML="Recargar";
		}
		else if(valorBoton == "Recargar"){
			$("#ModalAnadirPaquete").modal("hide");
			window.location.reload();
		}
    });
    </script>
</body>
</html>