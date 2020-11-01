<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.text.*,java.util.*" %>
	<%@page import="DataTypes.DtPaqueteDatos"%>
	<%@page import="DataTypes.EstadoSesion" %>
	<%@page import="DataTypes.DtCategoria" %>
	<%@page import="DataTypes.DtEspectaculo" %>
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
		DtPaqueteDatos dtpaq=null;
		dtpaq = (DtPaqueteDatos) request.getAttribute("paquete");
		DateFormat fechaIncompleta = new SimpleDateFormat("dd/MM/yyyy");
		if(dtpaq!=null){%>
	<div class="mb-sm-4 container-fluid"></div>
            <div class="container-fluid media mb-sm-5">
	            <img src="<% if(dtpaq.getImagen()!=""){%><%= dtpaq.getImagen()%><%}else{%><%="/img/img-loading-fail.png"%><%}%>" id="imgEspectaculo" class="rounded float-left media-object" alt="img-perfil-usuario" width=150em> 
	            <div class="media-body ml-sm-4">
		            <p class="media-heading"><h4 id="tituloEspectaculo"><%= dtpaq.getNombre() %></h4></p>
		            <p> <span id="descripcionEspectaculo"><%= dtpaq.getDescripcion() %> </span></p>        
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
						<p class="text-dark"><b>Validez: </b> <span id="validezPaquete"><%=  fechaIncompleta.format(dtpaq.getInicio()) + " - " + fechaIncompleta.format(dtpaq.getFin()) %></span></p>					    
					</div>
			  		<div class="tab-pane fade ml-sm-5 mt-sm-5" id="espectaculos" role="tabpanel" aria-labelledby="funciones-tab">	 
				  			 <div class="panel-group container-fluid">
				  				<div class="panel panel-default">
				  					<div class="panel-heading mb-sm-2">
				  						 <p class="media-heading"><h4 id="tituloFunciones">Espectaculos:</h4></p>
				  					</div>
				  					<% Integer tame = dtpaq.getEspectaculos().size();
				    		if(tame>0){%>
				  					<hr>
				  					<%
					      Iterator<DtEspectaculo> itre = dtpaq.getEspectaculos().iterator();
							while(itre.hasNext())
								{
								DtEspectaculo auxe = itre.next();%>
								<a href="/consultaespectaculo?nomespectaculo=<%= auxe.getNombre() %>">
								<div class="container-fluid media mb-sm-5">
								<img src="<% if(auxe.getImagen()!=""){%><%= auxe.getImagen()%><%}else{%><%="/img/img-loading-fail.png"%><%}%>" id="imgEspectaculo" class="rounded float-left media-object" alt="img-funcion" width=150em> 	
				    				<div class="panel-body">
				    							    							  				
								  			 <p class="text-dark"><b>Nombre:</b> <span id="nombreFuncion"><%= auxe.getNombre() %> </span></p>
								  			 <p class="text-dark"><b>Descripcion:</b> <span id="fechaFuncion"><%= auxe.getDescripcion() %></span></p>
								  			 <p class="text-dark"><b>Costo:</b> <span id="fechaFuncion"><%= auxe.getCosto() %></span></p>					
				    				</div>
				    			</div>
				    			</a>
				    				<hr> 
				    				<% ;}}} %>
				    							    				
				  				</div>
							 </div>		  		
			  		</div>
				</div>
			</div>
       </div>
</div>
	
	<script type="text/javascript">
        $(document).ready(function () {
            $('#sidebarCollapse').on('click', function () {
                $('#sidebar').toggleClass('active');
            });
        });
    </script>
</body>
</html>