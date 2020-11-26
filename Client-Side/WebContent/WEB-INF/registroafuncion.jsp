<%@page import="webservices.ArrayDtRegistros"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.text.*,java.util.*" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<jsp:include page="/WEB-INF/template/head.jsp"/>
	<%@page import="webservices.DtFuncionDatos"%>
	<%@page import="webservices.DtPaqueteDatos"%>
	<%@page import="webservices.DtArtista"%>
	<%@page import="webservices.DtRegistro"%>
	<%@page import="webservices.DtEspectaculoDatos"%>
	<%@page import="webservices.DtPaquete"%>
	<title>CoronaTickets UY - Registro a Funcion</title>
</head>
<body>
	<div class="wrapper">
        <jsp:include page="/WEB-INF/template/header_menulateral.jsp"/>
        <!-- Page Content  -->
        <div id="content">
			<jsp:include page="/WEB-INF/template/header_menusup.jsp"/>
			<!-- COMIENZO CODIGO -->
			<%
			webservices.PublicadorService service = new webservices.PublicadorService();
			webservices.Publicador port = service.getPublicadorPort();
				DateFormat fechaIncompleta = new SimpleDateFormat("dd/MM/yyyy");
					DateFormat horaFecha = new SimpleDateFormat("hh:mm");
					String usuario = (String) request.getSession().getAttribute("usuario_logueado");
					DtEspectaculoDatos dtesp = port.findDatosEspectaculo(request.getParameter("nomespectaculo"));
					List<DtPaqueteDatos> dtpaquetesdisponibles = port.perfilEspectador(usuario).getPaquetesComprados();
					DtFuncionDatos dtfuncdatos = port.findDatosFuncion(request.getParameter("funcion"));
					webservices.ArrayDtRegistros arrregistroscanjeables = port.listarRegistrosSinCanjeaer(usuario);
					List<webservices.DtRegistro> registroscanjeables = arrregistroscanjeables.getRegistros();
			%>
			<div class="container-fluid media mb-sm-5">
	            <img src="<%if(dtfuncdatos.getImagen()!=null && dtfuncdatos.getImagen()!=""){%><%= dtfuncdatos.getImagen()%><%}else{%><%="img/img-loading-fail.png"%><%}%>" id="imgFuncion" class="rounded float-left media-object" alt="img-funcion" width=150em> 
	            <div class="media-body ml-sm-4">
		            <p class="media-heading"><h4 id="tituloEspectaculo"><%= dtfuncdatos.getNombre() %></h4></p>
		            <p> <span id="fechaFuncion"><span class="text-dark">Fecha:</span> <%= fechaIncompleta.format(dtfuncdatos.getInicio().toGregorianCalendar().getTime()) %></span></p>
		            <p> <span id="horaFuncion"><span class="text-dark">Hora:</span> <%= horaFecha.format(dtfuncdatos.getInicio().toGregorianCalendar().getTime()) %></span></p>
		            <p> <span id="artistasFuncion"><span class="text-dark">Artistas:</span> <%
		            	Iterator<DtArtista> itrart = dtfuncdatos.getArtistas().iterator();
		            	while(itrart.hasNext()){
		            		DtArtista nuevo = itrart.next();
		            	%>
		            	<a href="/perfil?id=<%= nuevo.getNickname()%>" target="_blank">@<%=nuevo.getNickname()%></a>
		            	<%}%></span></p> 
		            <p>	<span id="costoFuncion"><span class="text-dark">Costo: </span><%= dtesp.getCosto() %></span></p>     
	            </div>
            </div>
            <%
            	if(!port.existeRegistroaFuncion(usuario, dtfuncdatos.getNombre())){
            %>
            <div id="metododecompra">
            <div class="container-fluid">
            	<h3>Método de Compra:</h3>
				<div class="form-group col-md-5 d-flex">
					<select class="form-control" id="sel1">
						<option>Normal</option>
						<option>Usar Paquete de Espectáculos</option>
						<option>Usar Tres Registros</option>
					</select>
					<a class="ml-sm-3 text-warning" style="font-size: 1.5em" data-toggle="tooltip" title="Normal: Abonarás el valor total de la función.
Usar Paquetes de Espectaculos: Utilizarás el paquete para adquirir la función, al precio se le descontará el porcentaje de .
Usar Tres Registros: Cambiarás Tres Registros previamente realizados por una función gratis (recuerda que no podrás utilizar más de una vez un registro para esto)."><i class="fas fa-info-circle"></i></a>
				</div> 
			</div>
				<div class="container-fluid mt-sm-5 ml-sm-3">
				<!-- COMPRA NORMAL -->
				<div class="container-fluid" id="compraNormal">
					<form action="registrofuncion" method="POST" class="form" id="formNormal">
						<div class="button">
							<button id="btn-normal" class="btn btn-primary" type="submit">Comprar</button>
						</div>
					</form>
				</div>
				
				<!-- CANJEAR POR PAQUETE -->
				<div class="container" id="canjearPaquete" style="display:none;">
					<form action="registrofuncion" method="POST" class="form" id="formPaquete">
						<%
						Iterator<DtPaqueteDatos> itrdtp = dtpaquetesdisponibles.iterator();
						while(itrdtp.hasNext()){
							DtPaqueteDatos nuevo = itrdtp.next();
							boolean agregar = false;
							Iterator<DtPaquete> itrdtesp = dtesp.getPaquetes().iterator();
							while(itrdtesp.hasNext()){
								DtPaquete nuevo2 = itrdtesp.next();
								if(nuevo2.getNombre().equals(nuevo.getNombre())){
									agregar=true;
									break;
								}
							}
							if(agregar){
						%>
							<div class="radio mb-sm-1">
								<label><input type="radio" name="radiopaquete" value="<%=nuevo.getNombre()%>"> <%=nuevo.getNombre()%> - <%= nuevo.getDescuento().toString() %>% Descuendo</label>
							</div>							
							<%}}%>
						<div class="button mt-sm-5">
							<button id="btn-paquete" class="btn btn-primary" type="submit">Canjear</button>
						</div>
					</form>
				</div>
				
				<!-- CANJEAR POR FUNCIONES -->
				<div class="container" id="canjearFunciones" style="display:none;">
					<form action="registrofuncion" method="POST" class="form" id="formFunciones">
					<%
					Iterator<DtRegistro> itrreg = registroscanjeables.iterator();
					while(itrreg.hasNext()){
						DtRegistro nuevo = itrreg.next();
					%>
						<div class="form-check mt-sm-2">
							<label class="form-check-label">
								<input type="checkbox" name="checkbox" class="form-check-input" value="<%= nuevo.getCodigo() %>"><%= nuevo.getNombrefuncion() %>
							</label>
						</div>
						
					<% 
					}
					%>
					<div class="button mt-sm-5">
						<button id="btn-paquete" class="btn btn-primary" type="submit">Canjear</button>
					</div>
					</form>
				</div>
				</div>
				</div>
				<div id="resultado-compra" class="mt-sm-5 ml-sm-5">
				</div>
				<%
					}else if(port.puedeAgregarEspectadores(port.getPlataformaDeEspectaculo(dtesp.getNombre()), dtesp.getNombre(), dtfuncdatos.getNombre())){
				%>
				<div class="container-fluid mt-sm-5 ml-sm-5">
					<p class="text-muted"><h1>YA HAS COMPRADO ESTA FUNCION</h1></p>
				</div>
				<%}else{%>
					<div class="container-fluid mt-sm-5 ml-sm-5">
					<p class="text-muted"><h1>SOLD OUT!</h1> Lo sentimos</p>
				</div>	
				<%} %>
				<div id="funcionyacomprada" class="container-fluid mt-sm-5 ml-sm-5" style="display:none;">
					<p class="text-muted"><h1>YA HAS COMPRADO ESTA FUNCION</h1></p>
				</div>
	</div>
	<script>
	$("#formPaquete").submit(function( event ) {
		event.preventDefault();
		var rbs = document.getElementsByName("radiopaquete");
		var selectedValue;
		for (i=0;i<rbs.length;i++){
			if(rbs[i].checked){
				selectedValue = rbs[i].value;
				break;
			}
		}
		if (selectedValue!=null){
	    var $form = $( this );
	    var data = {
	    		plataforma:'<%=port.getPlataformaDeEspectaculo(dtesp.getNombre())%>',
	    		espectaculo:'<%=dtesp.getNombre()%>',
	    		funcion:'<%=dtfuncdatos.getNombre()%>',
	    		paquete:selectedValue,
	    		tiporegistro:'3'};
	    console.log(data);
	    $.ajax({
	        type: $form.attr('method'),
	        url:  $form.attr('action'),
	        data: data,
	        success: function (data) {
	            console.log(data);
				var paquete_fin = document.getElementById("resultado-compra")
	            if(data === "SUCCESS") {
	            	paquete_fin.insertAdjacentHTML('afterbegin','<div class="alert alert-success"><a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a><strong>Hecho!</strong>    Te has registrado a la función exitosamente, se te ha aplicado el descuento a la función comprada.</div>')
	            	//$('#metododecompra').hide();
	            	document.getElementById('metododecompra').setAttribute('style',"pointer-events:none;");
	            	//$('#funcionyacomprada').show();
	            }
	            else{
	            	paquete_fin.insertAdjacentHTML('afterbegin','<div class="alert alert-danger"><a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a><strong>Error!</strong>    Algo ha fallado, por favor intentalo más tarde.</div>')
	            }
	        }
	    });
	    }
		else{
			if(rbs.length==0){
				alert("No tienes paquetes que incluyan un espectáculo de esta función. Por favor adquiere uno antes de realizar esta función");
			}
			else{
				alert("Por favor selecciona un paquete.");
			}
		}
	}); 
	$("#formNormal").submit(function( event ) {
		event.preventDefault();
	    var $form = $( this );
	    var data = {
	    		plataforma:'<%=port.getPlataformaDeEspectaculo(dtesp.getNombre())%>',
	    		espectaculo:'<%=dtesp.getNombre()%>',
	    		funcion:'<%=dtfuncdatos.getNombre()%>',
	    		tiporegistro:'1'};
	    console.log(data);
	    $.ajax({
	        type: $form.attr('method'),
	        url:  $form.attr('action'),
	        data: data,
	        success: function (data) {
	            console.log(data);
				var paquete_fin = document.getElementById("resultado-compra")
	            if(data === "SUCCESS") {
	            	paquete_fin.insertAdjacentHTML('afterbegin','<div class="alert alert-success"><a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a><strong>Hecho!</strong>    Te has registrado a la función exitosamente, se te ha cobrado el valor $<%= dtesp.getCosto() %> por realizar esta operación.</div>')
	            	document.getElementById('metododecompra').setAttribute('style',"pointer-events:none;");
	            	//$('#funcionyacomprada').show();
	            }
	            else{
	            	paquete_fin.insertAdjacentHTML('afterbegin','<div class="alert alert-danger"><a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a><strong>Error!</strong>    Algo ha fallado, por favor intentalo más tarde.'+data+'</div>')
	            }
	        }
	    });
	});
	/*
	
	*/
	</script>
	<script>
	$("#formFunciones").submit(function( event ) {
		event.preventDefault();
		var rbs = document.getElementsByName("checkbox");
		var selectedValue = new Array();
		var cont=0;
		for (i=0;i<rbs.length;i++){
			if(rbs[i].checked){
				selectedValue.push(rbs[i].value);
				cont++;
			}
		}
		if(cont==3){
	    var $form = $( this );
	    var data = {
	    		plataforma:'<%=port.getPlataformaDeEspectaculo(dtesp.getNombre())%>',
	    		espectaculo:'<%=dtesp.getNombre()%>',
	    		funcion:'<%=dtfuncdatos.getNombre()%>',
	    		valor1:selectedValue[0],
	    		valor2:selectedValue[1],
	    		valor3:selectedValue[2],
	    		tiporegistro:'2'};
	    console.log(data);
	    $.ajax({
	        type: $form.attr('method'),
	        url:  $form.attr('action'),
	        data: data,
	        success: function (data) {
	            console.log(data);
				var paquete_fin = document.getElementById("resultado-compra")
	            if(data === "SUCCESS") {
	            	paquete_fin.insertAdjacentHTML('afterbegin','<div class="alert alert-success"><a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a><strong>Hecho!</strong>    Te has registrado a la función exitosamente, no se te ha cobrado nada por realizar esta operación.</div>')
	            	document.getElementById('metododecompra').setAttribute('style',"pointer-events:none;");
	            	//$('#funcionyacomprada').show();
	            }
	            else{
	            	paquete_fin.insertAdjacentHTML('afterbegin','<div class="alert alert-danger"><a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a><strong>Error!</strong>    Algo ha fallado, por favor intentalo más tarde.'+data+'</div>')
	            }
	        }
	    });
	    }
		else{
			if(rbs.length<3){
				alert('No tienes funciones suficientes para canjear');
			}
			else{
				alert('Por favor selecciona exactamente TRES registros a funciones.');	
			}
			
		}
	});
	</script>
	<script>
	$(document).ready(function () {
		$('#sel1').on('click', function(){
			if(document.getElementById('sel1').value==="Normal"){
				$('#canjearPaquete').hide();
				$('#compraNormal').show();
				$('#canjearFunciones').hide();
			}
			else if(document.getElementById('sel1').value==="Usar Paquete de Espectáculos"){
				$('#canjearPaquete').show();
				$('#compraNormal').hide();
				$('#canjearFunciones').hide();
			}
			else if(document.getElementById('sel1').value==="Usar Tres Registros"){
				$('#canjearPaquete').hide();
				$('#compraNormal').hide();
				$('#canjearFunciones').show();
			}
		});	
	});
	</script>
</body>
</html>