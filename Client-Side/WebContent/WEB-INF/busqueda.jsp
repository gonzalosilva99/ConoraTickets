<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.text.*,java.util.*" %>
<!DOCTYPE html>
<html>
<head>
	
	<%@page import="webservices.DtPlataforma"%>
	<%@page import="webservices.DtEspectadorPerfil"%>
	<%@page import="webservices.DtUsuario"%>
	<%@page import="webservices.DtPaqueteDatos" %>
	<%@page import="webservices.DtEspectaculoDatos" %>
	<%@page import="webservices.DtCategoria" %>
	<%@page import="webservices.ArrayCategorias" %>
	
	
	<jsp:include page="/WEB-INF/template/head.jsp"/>
	<meta charset="ISO-8859-1">
	<title>Busqueda</title>
</head>
<body onload="Onload()">
	<%
		webservices.PublicadorService service = new webservices.PublicadorService();
		webservices.Publicador port = service.getPublicadorPort();
		String search;
	
		if(request.getParameter("s") != null)
			search = request.getParameter("s");
		else 
			search = "";
		List<DtUsuario> UsuariosFiltrados = (ArrayList<DtUsuario>) request.getAttribute("UsuariosFiltrados");
		System.out.print("Tamanio usu:::" + UsuariosFiltrados.size());
		List<DtEspectaculoDatos> EspectaculosFiltrados = (ArrayList<DtEspectaculoDatos>) request.getAttribute("EspectaculosFiltrados");
		System.out.print("Tamanio esp:::" + EspectaculosFiltrados.size()); 
		List<DtPaqueteDatos> PaquetesFiltrados =(ArrayList<DtPaqueteDatos>) request.getAttribute("PaquetesFiltrados"); 
		System.out.print("Tamanio paq:::" + PaquetesFiltrados.size());
	%>
	
	
	<div class="wrapper">
		<jsp:include page="/WEB-INF/template/header_menulateral.jsp"/>
        <div id="content">
			<jsp:include page="/WEB-INF/template/header_menusup.jsp"/>
			
            <h1>Resultado de Búsqueda</h1>
            
           <div class="panel panel-info">
           		 <div class="panel-heading btn btn-primary" style="background-color:transparent;color:grey;border:none;">
           			<i class="fas fa-filter"></i>
	                <a fas fa-filter data-toggle="collapse" data-target="#filtrosArea" href="javascript:void(0);" aria-expanded="false">
	              	Filtrar contenido</a>
	            </div>
		        <div id="filtrosArea" style="padding-right:20%;padding-left:10%;" class="collapse">
		        	<hr>
		            <div class="panel panel-body">
		            <form>
	            		<div class="row">
	            			<hr>
	            			<div class="col-md-4 col-lg-4">
		            			<div class="form-group">
		            				  <input type="hidden" id="search" name="search" value="<%=search %>" />
			                          <p>Plataforma: </p>
			                           <select  style="width: 70%;" class="custom-select" id="plat" name="plat">
										      <option value="" selected>Elije la plataforma</option>
										      <optgroup label="Plataformas:">
										      <%
										      List<DtPlataforma> ListaPlataformas = port.listarPlataformas().getPlats();
										      Iterator<DtPlataforma> itr = ListaPlataformas.iterator();
												while(itr.hasNext())
													{
													String aux = itr.next().getNombre();
										      %>
										      
										      	<option value="<%=aux%>"><%= aux %></option>
										      	<%}%>
								      </optgroup>
								      </select>
								     <br>
								     <br>
			                        </div> 
	            			</div>
	            			
	            			<div class="col-md-4 col-lg-4">
	            				<div class="form-group">
	            				
		                    	<p>Categoría: </p>
	                        	<ul  name="categorias">
							  	<%
								List<DtCategoria> lstcats = port.listarCategorias().getCategorias();
							    Iterator<DtCategoria> itrc = lstcats.iterator();
									while(itrc.hasNext())
										{ 	
							  		String aux = itrc.next().getNomCategoria();
							  		%>
							  		<li style="display:inline-block;zoom:1; *display:inline;" name="<%= aux %>">
								      <!-- Default checked -->
								      <div class="custom-control custom-checkbox">
								        <input type="checkbox" class="custom-control-input" id="<%= aux %>" name="checked" value="<%= aux %>">
								        <label class="custom-control-label" for="<%= aux %>"><%= aux %></label>
								        
								      </div>
								    </li>
							    <% ;} %>
 								</ul>
 								</div>	
	                
	                			</div>
	                			<div class="col-md-4 col-lg-4">
	            					<div class="form-group">
	            					   <p>Ordenar por: </p>
			                           <select  style="width: 70%;" class="custom-select" id="orden" name="orden">
										      <option value="" selected>Elige el orden</option>
										      <option value="alf">Orden alfabético (asc.)</option>
										      <option value="date">Orden por fecha (desc.)</option>
								      </select>
 									</div>	
	                
	                			</div>
	            			
	            		</div>
	            		<p><b>Nota:</b> Los filtros serán aplicados a los espectáculos</p>
	            		<button class="btn btn-primary" style="width: 15%;background-color:#148ea1;border:none;" type="submit" value="Acceder" onclick="submit()">Filtrar</button>
	            		</form>
	            	</div>  
	            	<hr>
		        </div>
    			<br>
           	<div class="container mx-auto">
           		<ul class="nav nav-tabs mx-auto" id="myTab" role="tablist">
	           		<%if(UsuariosFiltrados != null && UsuariosFiltrados.size() != 0){ %>
			  		<li class="nav-item active">
			  			<a class="nav-link " id="usuarios-tab" data-toggle="tab" href="#usuarios" role="tab" aria-controls="general" aria-selected="true">Usuarios</a>
			  		</li><%}%>
			  		<%if(EspectaculosFiltrados != null && EspectaculosFiltrados.size() != 0){ %>
					<li class="nav-item">
						<a class="nav-link" id="espectaculos-tab" data-toggle="tab" href="#espectaculos" role="tab" aria-controls="registros" aria-selected="false">Espectaculos</a>
					</li><%}%>
					<%if(PaquetesFiltrados != null && PaquetesFiltrados.size() != 0){ %>
					<li class="nav-item">
						<a class="nav-link" id="paquetes-tab" data-toggle="tab" href="#paquetes" role="tab" aria-controls="registros" aria-selected="false">Paquetes</a>
					</li><%} %>
				</ul>
				<div class="tab-content" id="myTabContent">
							<%if( !(UsuariosFiltrados != null && UsuariosFiltrados.size() != 0) && !(EspectaculosFiltrados != null && EspectaculosFiltrados.size() != 0) && !(PaquetesFiltrados != null && PaquetesFiltrados.size() != 0)){%> 
							<h3>No hay resultados para tu búsqueda</h3><%}%>
	           		  		<%if(UsuariosFiltrados != null && UsuariosFiltrados.size() != 0){ %>
					  		<div class="tab-pane fade" id="usuarios" role="tabpanel" aria-labelledby="usuarios-tab">
					  			<div class="row">
		    					<%
		    					Integer i=0,p=0;%>
		    					<div class="col-md-6 col-lg-6"><%
		    					if(UsuariosFiltrados != null && UsuariosFiltrados.size() != 0){
			    					for(DtUsuario dtusu : UsuariosFiltrados){if(i==1){%></div><div <%if(p>3){%>style="display:none;"<%}%> id="usu<%=p%>" class="col-md-6 col-lg-6"><%i=0;}%>
			    						<br>
			    						
			    						<div class="media mb-sm-2">
										 	<img src="<% if(dtusu.getImagen()!=null && !dtusu.getImagen().equals("")){%> <%= dtusu.getImagen()%> <%} else{ %><%= "https://bit.ly/3ng8YZE"%><%}%>"  alt="https://image.flaticon.com/icons/png/512/68/68314.png" id="imgperfilUsuario" class="mr-3 rounded-circle" alt="img-perfil-usuario" width=64em height="64em"> 
										  	<div class="media-body">
										    	<h4 class="mt-0" id="nombreapellidoUsuario"><a href="/perfil?id=<%=dtusu.getNickname()%>"><%=dtusu.getNombre()%> <%=dtusu.getApellido()%></a></h4>
										    	<%=dtusu.getNickname()%> / <%= dtusu.getEmail()%>
										  	</div>
										</div>
		    					<%i++;p++;}}%>
		    					<%if(i>0){%></div><%}%>
							</div><br>
							<button class="btn btn-primary btn-sm" style="<%if(p<4){%>display:none;<%}%>width:10%;background-color:#148ea1;border:none;margin-left:40%;" id="btnmostrarusuarios" onclick="AddUsers()">Ver más</button>
					  		</div>
					  		<%}%>
					  	<%if(EspectaculosFiltrados != null && EspectaculosFiltrados.size() != 0){ %>
						<div class="tab-pane fade" id="espectaculos" role="tabpanel" aria-labelledby="espectaculos-tab">
									<div class="row">		    					
									<% 
		    						Integer j=0,r=0;
		    						Iterator<DtEspectaculoDatos> itere = EspectaculosFiltrados.iterator();%>		    							
		    						<div class="col-md-6 col-lg-6"><%
									if(EspectaculosFiltrados != null && EspectaculosFiltrados.size() != 0){
									while(itere.hasNext()){%><%DtEspectaculoDatos dtespec = itere.next();%> <%if(j==1){%><div <%if(r>3){%>style="display:none;"<%}%> id="espec<%=r%>" class="col-md-6 col-lg-6"><%j=0;}%>
			    					<br>
			    						<div class="media">
									 	<img src="/imagenes?id=<%= dtespec.getImagen() %>" id="imgEspec" class="mr-3 rounded-circle" alt="img-perfil-usuario" width=64em height="64em"> 
									  	<div class="media-body">
									    	<h4 class="mt-0" id="nombreespectaculo"><a href="/consultaespectaculo?nomespectaculo=<%=dtespec.getNombre() %>"><%= dtespec.getNombre()%></a></h4>
									    	<%=dtespec.getDescripcion() %>
									    	Espectadores: <%= dtespec.getCantmin() %> / <%= dtespec.getCantmax() %>  
									  	</div>
									</div>
									</div>
		    					<%j++;r++;}}%>
		    					</div><br>
		    					<button class="btn btn-primary btn-sm" style="<%if(r<4){%>display:none;<%}%>width:10%;background-color:#148ea1;border:none;margin-left:40%;" id="btnmostrarespectaculos" onclick="AddEspecs()">Ver más</button>
					  		
						</div>	
						<%}%>
						<%if(PaquetesFiltrados != null && PaquetesFiltrados.size() != 0){ %>
						<div class="tab-pane fade" id="paquetes" role="tabpanel" aria-labelledby="paquetes-tab">
									<div class="row">
									<% 
		    						Integer k=0,q=0;%>
		    						<div class="col-md-6 col-lg-6"><%
									if(PaquetesFiltrados != null && PaquetesFiltrados.size() != 0){
									//Iterator<DtPaqueteDatos> iterpaq = PaquetesFiltrados.iterator();
			    					for(DtPaqueteDatos dtpaq : PaquetesFiltrados){if(k==1){%></div><div  <%if(q>3){%>style="display:none;"<%}%> id="paq<%=q%>" class="col-md-6 col-lg-6"><%k=0;}%>
			    					<br>
			    					<div class="media mb-sm-2">
									 	<img src="<% if(dtpaq.getImagen() != null && dtpaq.getImagen()!=""){%> <%= dtpaq.getImagen()%> <%} else{ %><%= "https://bit.ly/3ng8YZE"%><%}%>" id="imgEspec" class="mr-3 rounded-circle" alt="img-perfil-usuario" width=64em height="64em"> 
									  	<div class="media-body">
									    	<h4 class="mt-0" id="nombreespectaculo"><a href="/paquete?nompaquete=<%=dtpaq.getNombre() %>"><%= dtpaq.getNombre() %></a></h4>
									    	<%= dtpaq.getDescripcion() %>
									    	Fechas: <%=dtpaq.getInicio() %> / <%=dtpaq.getFin() %>
									  	</div>
									</div>
		    					<%k++;q++;}}%>
		    					<%if(k>0){%></div><%}%>
		    					</div><br>
		    					<button class="btn btn-primary btn-sm" style="<%if(q<4){%>display:none;<%}%>width:10%;background-color:#148ea1;border:none;margin-left:40%;" id="btnmostrarpaquetes" onclick="AddPaqs()">Ver más</button>
				   		</div>
				   		<%} %>
				</div>
				
			</div>
	 	    
			
       </div> <!-- CONTENT -->
	</div> <!-- WRAPPER -->
	</div>
	<script type="text/javascript">
		
		function AddUsers(){
			var i=4;
			var cont=0;
			var usu = document.getElementById("usu" + i);
			while(usu != null && cont<4){
				if(usu.style.display == 'none'){
					usu.style.display='block';
					cont++;
				}
				i++;
				usu = document.getElementById("usu" + i);
			}
			if(usu == null)
				document.getElementById("btnmostrarusuarios").style.display = 'none';
		}
		

		function AddPaqs(){
			var i=4;
			var cont=0;
			var paq = document.getElementById("paq" + i);
			while(paq != null && cont<4){
				if(paq.style.display == 'none'){
					paq.style.display='block';
					cont++;
				}
				i++;
				paq = document.getElementById("paq" + i);
			}
			if(paq == null)
				document.getElementById("btnmostrarpaquetes").style.display = 'none';
		}

		function AddEspecs(){
			var i=4;
			var cont=0;
			var espec = document.getElementById("espec" + i);
			while(espec != null && cont<4){
				if(espec.style.display == 'none'){
					espec.style.display='block';
					cont++;
				}
				i++;
				espec = document.getElementById("espec" + i);
			}
			if(espec == null)
				document.getElementById("btnmostrarespectaculos").style.display = 'none';
		}
		function Onload(){
			var usuarios = document.getElementById("usuarios-tab");
			if(usuarios != null)
				usuarios.click();
			else if(document.getElementById("espectaculos-tab"))
				document.getElementById("espectaculos-tab").click();
			else if(document.getElementById("paquetes-tab"))
				document.getElementById("paquetes-tab").click();
		}
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