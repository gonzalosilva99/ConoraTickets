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
	<%@page import="webservices.DtCategoria"%>
	<%@page import="webservices.DtEspectaculoDatos"%>
	<%@page import="webservices.DtPaquete"%>
	<title>CoronaTickets UY - Comprar Paquete</title>
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
				DtPaqueteDatos dtpaq = port.getPaqueteDatos(request.getParameter("nompaquete"));
				String usuario = (String) request.getSession().getAttribute("usuario_logueado");
			%>
			<div class="container-fluid media mb-sm-5">
	            <img src="/imagenes?id=<%= dtpaq.getImagen() %>" id="imgFuncion" class="rounded float-left media-object" alt="img-funcion" width=150em> 
	            <div class="media-body ml-sm-4">
		            <p class="text-dark"><b>Nombre del paquete:</b> <span id="nombreEspectaculo"><%= dtpaq.getNombre() %>	</span></p>
						<% Integer tamc = dtpaq.getCategorias().size();
				    		if(tamc>0){
				    		tamc=0;%>
						<p class="text-dark"><b>Categorias:</b> <span id="categoriasEspectaculo">
						<% 
						
					      Iterator<DtCategoria> itr = dtpaq.getCategorias().iterator();
							while(itr.hasNext())
								{tamc++;%>
								<%= itr.next().getNomCategoria() %>
								<% if(tamc<dtpaq.getCategorias().size()) {%>,<%} %>
								<% } %></span></p>	<% } %>				
						<p class="text-dark"><b>Descripcion:</b> <span id="descripcionEspectaculo"><%= dtpaq.getDescripcion() %> </span></p>
						<p class="text-dark"><b>Descuento:</b> <span id="descuentoPaquete"><%= dtpaq.getDescuento() %>%</span></p>							            
						<p class="text-dark red"><b <%Date todayDate = new Date(); if(!todayDate.after(dtpaq.getInicio().toGregorianCalendar().getTime()) || !todayDate.before(dtpaq.getFin().toGregorianCalendar().getTime())) {%>style="color:red;"<% } %>>Validez: </b> <span id="validezPaquete" <% if(!todayDate.after(dtpaq.getInicio().toGregorianCalendar().getTime()) || !todayDate.before(dtpaq.getFin().toGregorianCalendar().getTime())) {%>style="color:red;"<% } %>><%=  fechaIncompleta.format(dtpaq.getInicio()) + " - " + fechaIncompleta.format(dtpaq.getFin()) %></span></p>	    
	            		 <%
	    	            		 	if(!port.existeCompraPaquete(usuario,dtpaq.getNombre())){
	    	            		 %>
				<div class="container-fluid" id="compraNormal">
					<form action="comprarpaquete" method="POST" class="form" id="formNormal">
						<div class="button">
							<button id="btn-normal" class="btn btn-primary" type="submit">Comprar</button>
						</div>
					</form>
				</div>
				
				
				<!-- CANJEAR POR FUNCIONES -->
				
				<div id="resultado-compra" class="mt-sm-5 ml-sm-5">
				</div>
				</div>
				
				<%}else {%>
				<div class="container-fluid mt-sm-5 ml-sm-5">
					<p class="text-muted"><h1>YA HAS COMPRADO ESTE PAQUETE</h1></p>
				</div>
				<%} %>
	            </div>
            </div>
            <div id="metododecompra">
           
	</div>
	
	<script>
	$("#formNormal").submit(function( event ) {
		event.preventDefault();
	    var $form = $( this );
	    var data = {
	    		paquete:'<%= dtpaq.getNombre() %>'
	    		};
	    console.log(data);
	    $.ajax({
	        type: $form.attr('method'),
	        url:  $form.attr('action'),
	        data: data,
	        success: function (data) {
	            console.log(data);
				var paquete_fin = document.getElementById("resultado-compra")
	            if(data === "SUCCESS") {
	            	paquete_fin.insertAdjacentHTML('afterbegin','<div class="alert alert-success"><a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a><strong>Hecho!</strong>    Has comprado el paquete exitosamente.</div>')
	            	//$('#metododecompra').hide();
	            	document.getElementById('metododecompra').setAttribute('style',"pointer-events:none;");
	            	//$('#funcionyacomprada').show();
	            }
	            else{
	            	paquete_fin.insertAdjacentHTML('afterbegin','<div class="alert alert-danger"><a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a><strong>Error!</strong>    Algo ha fallado, por favor intentalo más tarde.</div>')
	            }
	        }
	    });
	}); 
	
	</script>
	</body>
</html>