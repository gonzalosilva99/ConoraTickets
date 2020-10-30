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
				Set<DtEspectaculo> espectaculos = Fabrica.getInstancia().getIPlataforma().listarEspectaculosAceptadosDePlataforma(nomPlataforma);
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
            	<img src="<% if(auxe.getImagen()!=""){%><%= auxe.getImagen()%><%}else{%><%="/img/img-loading-fail.png"%><%}%>" class="rounded float-left media-object" alt="SPRINGSTEEN BROADWAY" width=150em>
            <div class="media-body ml-sm-4">
            <h4><%= auxe.getNombre() %></h4>
            <p><%= auxe.getDescripcion() %> <u>Leer más</u></p>
            </a>
            </div>
            </div>
            <%} %>
   
            <% }else if(nomCategoria!=null){ 
            Set<DtEspectaculo> espectaculosporc = Fabrica.getInstancia().getICategoria().listarEspectaculosAceptadosDeCategoria(nomCategoria); %>
            <h2>Espectáculos disponibles de <%= nomCategoria %></h2><br>   
            <%
            Iterator<DtEspectaculo> itrc = espectaculosporc.iterator();
			while(itrc.hasNext()){
				DtEspectaculo auxc = itrc.next();
			
            %> 
             
            <div class="container-fluid media mb-sm-5">
            <a href="/consultaespectaculo?nomespectaculo=<%= auxc.getNombre() %>">
            	<img src="<% if(auxc.getImagen()!=""){%><%= auxc.getImagen()%><%}else{%><%="/img/img-loading-fail.png"%><%}%>" class="rounded float-left media-object" alt="BIEN DE FAMILIA" width=150em>
            <div class="media-body ml-sm-4">
            <h4><%= auxc.getNombre() %></h4>
            <p> <%= auxc.getDescripcion() %> <u>Leer más</u></p>
            </div>
            </a>
            </div>

<% }} else { %> 
	<h2>Espectáculos destacados</h2><br>
            <div class="mb-sm-4 container-fluid"></div>
            <div class="container-fluid media mb-sm-5">
            <a href="#" class="pull-left">
            	<img src="https://www.revistamoi.com/wp-content/uploads/2016/08/cuando-cumples-30-an%CC%83os.jpg" class="rounded float-left media-object" alt="SPRINGSTEEN BROADWAY" width=150em>
            </a>
            <div class="media-body ml-sm-4">
            <a href="#" class="media-heading"><h4>30 años</h4></a>
            <p>Espectáculo conmemorando los 30 años de Violeta. <u><a href="#">Leer más</a></u></p>
            </div>
            </div>
            
            <div class="container-fluid media mb-sm-5">
            <a href="#" class="pull-left">
            	<img src="https://bit.ly/2FWyB0B" class="rounded float-left media-object" alt="BIEN DE FAMILIA" width=150em>
            </a>
            <div class="media-body ml-sm-4">
            <a href="#" class="media-heading"><h4>Bien de Familia</h4></a>
            <p> El dúo estará presentando sus más sonados éxitos y también nuevas canciones. <u><a href="#">Leer más</a></u></p>
            </div>
            </div>
            
            <div class="container-fluid media mb-sm-5">
            <a href="#" class="pull-left">
            	<img src="https://www.memphisbluesbbq.com/wp-content/uploads/2019/05/Colour.png" class="rounded float-left media-object" alt="GLOBAL SPIRIT" width=150em>
            </a>
            <div class="media-body ml-sm-4">
            <a href="#" class="media-heading"><h4>Memphis Blues World</h4></a>
            <p> Espectáculo promoviendo álbum Memphis Blues. <u><a href="#">Leer más</a></u></p> 
            </div>
            </div>
	<% } %>  
        </div>
    </div>


	
</body>
</html>