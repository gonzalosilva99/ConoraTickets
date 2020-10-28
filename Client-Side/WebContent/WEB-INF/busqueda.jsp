<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.text.*,java.util.*" %>
<!DOCTYPE html>
<html>
<head>

	<%@page import="DataTypes.DtEspectadorPerfil"%>
	<%@page import="DataTypes.DtUsuario"%>
	<%@page import="DataTypes.DtPaqueteDatos" %>
	<%@page import="DataTypes.DtEspectaculoDatos" %>
	<%@page import="com.coronatickets.controllers.Login" %>
	<%@page import="Controladores.Fabrica"%>
	<%@page import="Interfaces.IUsuario"%>
	<jsp:include page="/WEB-INF/template/head.jsp"/>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
</head>
<body>
	<%
		String search = (String) request.getParameter("s");
		Set<DtUsuario> UsuariosFiltrados = Fabrica.getInstancia().getIUsuario().filtrarUsuarios(search); 
		Set<DtEspectaculoDatos> EspectaculosFiltrados = Fabrica.getInstancia().getIPlataforma().filtrarEspectaculos(search); 
		Set<DtPaqueteDatos> PaquetesFiltrados = Fabrica.getInstancia().getIPaquete().filtrarPaquetes(search); 
	%>
	
	
	<div class="wrapper">
		<input type="hidden" id="searchhidden" name="searchhidden" value="<%=search %>" />
		<jsp:include page="/WEB-INF/template/header_menulateral.jsp"/>
        <div id="content">
			<jsp:include page="/WEB-INF/template/header_menusup.jsp"/>
			
            <h1>Resultado de Búsqueda</h1>
            
            <br>	
           	<div class="container mx-auto">
	           	<ul class="nav nav-tabs mx-auto" id="myTab" role="tablist">
			  		<li class="nav-item">
			  			<a class="nav-link active" id="usuarios-tab" data-toggle="tab" href="#usuarios" role="tab" aria-controls="general" aria-selected="true">Usuarios</a>
			  		</li>
					<li class="nav-item">
						<a class="nav-link" id="espectaculos-tab" data-toggle="tab" href="#espectaculos" role="tab" aria-controls="registros" aria-selected="false">Espectaculos</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" id="paquetes-tab" data-toggle="tab" href="#paquetes" role="tab" aria-controls="registros" aria-selected="false">Paquetes</a>
					</li>
				</ul>
				<div class="tab-content" id="myTabContent">
					  		<div class="tab-pane fade" id="usuarios" role="tabpanel" aria-labelledby="usuarios-tab">
		    					<%
		    					Set<DtUsuario> temp = new HashSet<DtUsuario>();
		    					Integer i=0;
		    					for(DtUsuario dtusu : UsuariosFiltrados){ %>
		    					<%if(i<4){temp.add(dtusu);%>
		    						<br>
		    						<a href="/perfil?id=<%=dtusu.getNickname()%>">
		    						<div class="media mb-sm-2">
								 	<img src="<% if(dtusu.getImagen()!=null && !dtusu.getImagen().equals("")){%> <%= dtusu.getImagen()%> <%} else{ %><%= "https://bit.ly/3ng8YZE"%><%}%>"  alt="https://image.flaticon.com/icons/png/512/68/68314.png" id="imgperfilUsuario" class="mr-3 rounded-circle" alt="img-perfil-usuario" width=64em height="64em"> 
								  	<div class="media-body">
								    	<h4 class="mt-0" id="nombreapellidoUsuario"><%=dtusu.getNombre()%> <%=dtusu.getApellido()%></h4>
								    	<%=dtusu.getNickname()%> / <%= dtusu.getEmail()%>
								  	</div>
								</div>
								</a>
								<%i++;%>
		    					<%}else break;}i=0;%>
		    					<%for(DtUsuario rem : temp){UsuariosFiltrados.remove(rem);}%>
		    					<form id="formus">
		    						<input type="button" id="submitusu" value="Cargar Más" /> 
		    					</form>	
							</div>
					  		
						<div class="tab-pane fade" id="espectaculos" role="tabpanel" aria-labelledby="espectaculos-tab">
							<%
									Set<DtEspectaculoDatos> tempe = new HashSet<DtEspectaculoDatos>();
	    							Integer e=0;
			    					for(DtEspectaculoDatos dtespec : EspectaculosFiltrados){ %>
			    					<%if(e<4){tempe.add(dtespec);%>
			    					<br>
			    					<a href="/perfil?id=<%=dtespec.getNombre() %>">
			    						<div class="media mb-sm-2">
									 	<img src="<% if(dtespec.getImagen() != null && dtespec.getImagen()!=""){%> <%= dtespec.getImagen()%> <%} else{ %><%= "https://bit.ly/3ng8YZE"%><%}%>" id="imgEspec" class="mr-3 rounded-circle" alt="img-perfil-usuario" width=64em height="64em"> 
									  	<div class="media-body">
									    	<h4 class="mt-0" id="nombreespectaculo"><%= dtespec.getNombre()%></h4>
									    	<%=dtespec.getDescripcion() %>
									    	Espectadores: <%= dtespec.getCantMin() %> / <%= dtespec.getCantMax() %>  
									  	</div>
									</div>
									</a>
								<%e++;%>
		    					<%}else break;}e=0;%>
		    					<%for(DtEspectaculoDatos esprem : tempe){EspectaculosFiltrados.remove(esprem);}%>
		    					<form>
		    						<button class="btn btn-primary" style="width: 100%;" type="submit" onclick="submit()">Ver mas </button>
		    					</form>	
		    					<a style="color:blue;" href="#"> Ver más</a>
						</div>
						
						<div class="tab-pane fade" id="paquetes" role="tabpanel" aria-labelledby="espectaculos-tab">
							<%
									Set<DtPaqueteDatos> tempp = new HashSet<DtPaqueteDatos>();
									Integer p=0;
			    					for(DtPaqueteDatos dtpaq : PaquetesFiltrados){ %>
			    					<%if(p<4){tempp.add(dtpaq);%>
			    					< <br>
			    					<a href="/perfil?id=<%=dtpaq.getNombre() %>">
			    						<div class="media mb-sm-2">
									 	<img src="<% if(dtpaq.getImagen() != null && dtpaq.getImagen()!=""){%> <%= dtpaq.getImagen()%> <%} else{ %><%= "https://bit.ly/3ng8YZE"%><%}%>" id="imgEspec" class="mr-3 rounded-circle" alt="img-perfil-usuario" width=64em height="64em"> 
									  	<div class="media-body">
									    	<h4 class="mt-0" id="nombreespectaculo"><%= dtpaq.getNombre()%></h4>
									    	<%=dtpaq.getDescripcion() %>
									    	Fechas: <%= dtpaq.getInicio() %> / <%= dtpaq.getFin()%>  
									  	</div>
									</div>
									</a>
			    				<%p++;%>
		    					<%}else break;}p=0;%>
		    					<%for(DtPaqueteDatos paqrem : tempp){PaquetesFiltrados.remove(paqrem);}%>	
		    				<a style="color:blue;" href="#"> Ver más</a>
						</div>
				</div>
				
			</div>
	 	    
			
       </div> <!-- CONTENT -->
	</div> <!-- WRAPPER -->

	<script type="text/javascript">
	
		$(document).ready(function() {
			$('#submitusu').click(function(event) {
				var search = document.getElementById("searchhidden").value;
				$.post('busqueda', {
					Search : search
				}, function(responseText) {
					$('#usuarios').html(responseText);
				});
			});
		});
	</script>
</body>
</html>