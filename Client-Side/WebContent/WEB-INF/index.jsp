<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="Controladores.Fabrica"%>
    <%@page import="DataTypes.DtEspectaculo"%>
    <%@page import="java.util.Set"%>
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
			String nomPlataforma = (String) request.getParameter("plataforma");
			String nomCategoria = (String) request.getParameter("categoria");
			if(nomPlataforma!=null){
				Set<DtEspectaculo> espectaculos = Fabrica.getInstancia().getIPlataforma().listarEspectaculosDePlataforma(nomPlataforma);
				%>
            <h2>Espectáculos disponibles en <%= nomPlataforma %></h2>
            <%
            Iterator<DtEspectaculo> itre = espectaculos.iterator();
			while(itre.hasNext()){
				DtEspectaculo auxe = itre.next();
			
            %>
            <div class="mb-sm-4 container-fluid"></div>
            <div class="container-fluid media mb-sm-5">
            <a href="#" class="pull-left">
            	<img src="<%= auxe.getImagen() %>" class="rounded float-left media-object" alt="SPRINGSTEEN BROADWAY" width=150em>
            </a>
            <div class="media-body ml-sm-4">
            <a href="#" class="media-heading"><h4><%= auxe.getNombre() %></h4></a>
            <p><%= auxe.getDescripcion() %> <u><a href="/consultaespectaculo?nomespectaculo=<%= auxe.getNombre() %>">Leer más</a></u></p>
            </div>
            </div>
            <%} %>
   
            <% }else if(nomCategoria!=null){ 
            Set<DtEspectaculo> espectaculosporc = Fabrica.getInstancia().getICategoria().listarEspectaculosAceptadosDeCategoria(nomCategoria); %>
            <h2>Espectáculos disponibles de <%= nomCategoria %></h2>   
            <%
            Iterator<DtEspectaculo> itrc = espectaculosporc.iterator();
			while(itrc.hasNext()){
				DtEspectaculo auxc = itrc.next();
			
            %>  
            <div class="container-fluid media mb-sm-5">
            <a href="#" class="pull-left">
            	<img src="<%= auxc.getImagen() %>" class="rounded float-left media-object" alt="BIEN DE FAMILIA" width=150em>
            </a>
            <div class="media-body ml-sm-4">
            <a href="#" class="media-heading"><h4><%= auxc.getNombre() %></h4></a>
            <p> <%= auxc.getDescripcion() %> <u><a href="/consultaespectaculo?nomespectaculo=<%= auxc.getNombre() %>">Leer más</a></u></p>
            </div>
            </div>
<% }} %>  
        </div>
    </div>


	
</body>
</html>