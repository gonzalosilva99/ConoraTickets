<%@page import="webservices.ArrayEspectaculos"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="webservices.DtEspectaculo"%>
    <%@page import="java.util.List"%>
    <%@page import="java.util.Iterator"%>

<!DOCTYPE html>
<html>
<head>
	<jsp:include page="/WEB-INF/template/head.jsp"/>
<title>CoronaTickets UY - Inicio</title>
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
			String nomPlataforma = (String) request.getParameter("plataforma");
			String nomCategoria = (String) request.getParameter("categoria");
			if(nomPlataforma!=null){
				webservices.ArrayEspectaculos arrespectaculos = port.listarEspectaculosAceptadosDePlataforma(nomPlataforma);
				List<webservices.DtEspectaculo> espectaculos = arrespectaculos.getEspectaculos();
				%>
            <h2>Espectáculos disponibles en <%= nomPlataforma %></h2><br>
            <%
            Iterator<DtEspectaculo> itre = espectaculos.iterator();
			while(itre.hasNext()){
				DtEspectaculo auxe = itre.next();
			
            %>
            <div class="mb-sm-4 container-fluid"></div>
            <div class="container-fluid media mb-sm-5">
            <a href="/consultaespectaculo?nomespectaculo=<%= auxe.getNombre() %>">           
            	<img src="/imagenes?id=<%= auxe.getImagen() %>"  class="rounded float-left media-object" alt="<%= auxe.getNombre() %>" width=150em>
             <div class="media-body ml-sm-4">
            <h4><%= auxe.getNombre() %></h4>
            <p><%= auxe.getDescripcion() %> <u>Leer más</u></p>
            </a>
            </div>
            </div>
            <%} %>
   
            <% }else if(nomCategoria!=null){ 
            webservices.ArrayEspectaculos arrespectaculosporc = port.listarEspectaculosAceptadosDeCategoria(nomCategoria);
            List<webservices.DtEspectaculo> espectaculosporc = arrespectaculosporc.getEspectaculos();%>
            <h2>Espectáculos disponibles de <%= nomCategoria %></h2><br>   
            <%
            Iterator<DtEspectaculo> itrc = espectaculosporc.iterator();
			while(itrc.hasNext()){
				DtEspectaculo auxc = itrc.next();
			
            %> 
             
            <div class="container-fluid media mb-sm-5">
            <a href="/consultaespectaculo?nomespectaculo=<%= auxc.getNombre() %>">
            	<img src="/imagenes?id=<%= auxc.getImagen() %>"  class="rounded float-left media-object" alt="<%= auxc.getNombre() %>" width=150em>
             <div class="media-body ml-sm-4">
            <h4><%= auxc.getNombre() %></h4>
            <p> <%= auxc.getDescripcion() %> <u>Leer más</u></p>
            </div>
            </a>
            </div>

<% }} else { %> 
	<h2>Espectáculos destacados</h2><br>
            <div class="mb-sm-4 container-fluid"></div>
            <a href="/consultaespectaculo?nomespectaculo=Global Spirit" class="media-heading">
            <div class="container-fluid media mb-sm-5">
            <img src="/imagenes?id=EspectaculoGlobal Spirit.jpg"  class="rounded float-left media-object" alt="Global Spirit" width=150em>
            <div class="media-body ml-sm-4">
            <h4>Global Spirit</h4>
            <p>Espectáculo donde se presenta el álbum Spirit. <u>Leer más</u></p>
            </div>
            </div>
            </a>
            
            <a href="/consultaespectaculo?nomespectaculo=Bien de Familia" class="pull-left">
            <div class="container-fluid media mb-sm-5">           
            	<img src="/imagenes?id=EspectaculoBien%20de%20Familia.jpg"  class="rounded float-left media-object" alt="BIEN DE FAMILIA" width=150em>
            <div class="media-body ml-sm-4">
           <h4>Bien de Familia</h4>
            <p> El dúo estará presentando sus más sonados éxitos y también nuevas canciones. <u>Leer más</u></p>
            </div>
            </div>
            </a>
            
            <a href="/consultaespectaculo?nomespectaculo=Los Village Volvieron" class="pull-left">
            <div class="container-fluid media mb-sm-5">
            	<img src="/imagenes?id=EspectaculoLos Village Volvieron.jpg"  class="rounded float-left media-object" alt="MEMPHIS BLUES WORLD" width=150em>
             <div class="media-body ml-sm-4">
            <h4>Los Village Volvieron</h4>
            <p> Espectáculo de retorno de los Village People. <u>Leer más</u></p> 
            </div>
            </div>
            </a>
            
	<% } %>  
        </div>


	
</body>
</html>