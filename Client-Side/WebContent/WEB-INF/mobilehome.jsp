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
		 <jsp:include page="/WEB-INF/template/mobile_menulateral.jsp"/> 

        <!-- Page Content  -->
        <div id="content">
        	
			<jsp:include page="/WEB-INF/template/mobile_menusup.jsp"/> 
			<% 
			webservices.PublicadorService service = new webservices.PublicadorService();
	    	webservices.Publicador port = service.getPublicadorPort();
			String nomPlataforma = (String) request.getParameter("plataforma");
			String nomCategoria = (String) request.getParameter("categoria");
			if(nomPlataforma!=null){
				webservices.ArrayEspectaculos arrespectaculos = port.listarEspectaculosAceptadosDePlataforma(nomPlataforma);
				List<webservices.DtEspectaculo> espectaculos = arrespectaculos.getEspectaculos();
				%>
            <h2>Espectáculos en <%= nomPlataforma %></h2><br>
            <div class="container-fluid" style="padding-right:15%;">
            
	            <%
	            Iterator<DtEspectaculo> itre = espectaculos.iterator();
				while(itre.hasNext()){
					DtEspectaculo auxe = itre.next();
				
	            %>
	            <div class="row">
	            	<div class="col-md-2 col-sm-12 col-12 align-items-center justify-content-center" style="text-align:center;">
	            		<a href="/mobileconsultaespectaculo?nomespectaculo=<%=auxe.getNombre() %>"><img class="mr-3" src="<% if(auxe.getImagen()!=null && !auxe.getImagen().equals("")){%>/imagenes?id=<%=auxe.getImagen()%><%}else{%>/img/img-loading-fail.png<%}%>" class="rounded float-left media-object" width="113vw"></a>
			    	</div>
	            	<div class="col-md-10 col-sm-12 col-12">
						<h5 class="mt-0 mb-1"><a href="/mobileconsultaespectaculo?nomespectaculo=<%=auxe.getNombre() %>"><%= auxe.getNombre() %></a></h5>
			      		<p><%= auxe.getDescripcion() %> <a href="/mobileconsultaespectaculo?nomespectaculo=<%=auxe.getNombre() %>">Leer más</a></p>
   	            	</div>
	            </div>
	            <br>
	            <hr>
		       	<%} %>
			</div>
   
            <% }else if(nomCategoria!=null){ 
            	webservices.ArrayEspectaculos arrespectaculosporc = port.listarEspectaculosAceptadosDeCategoria(nomCategoria);
                List<webservices.DtEspectaculo> espectaculosporc = arrespectaculosporc.getEspectaculos();%>
            <h2>Espectáculos disponibles de <%= nomCategoria %></h2><br>   
            <%
            Iterator<DtEspectaculo> itrc = espectaculosporc.iterator();
			while(itrc.hasNext()){
				DtEspectaculo auxc = itrc.next();
			
            %> 
           <div class="row">
	           	<div class="col-md-2 col-sm-12 col-12 align-items-center justify-content-center" style="text-align:center;">
	           		<a href="/mobileconsultaespectaculo?nomespectaculo=<%=auxc.getNombre() %>"><img class="mr-3" src="<% if(auxc.getImagen()!=null && !auxc.getImagen().equals("")){%>/imagenes?id=<%=auxc.getImagen()%><%}else{%>/img/img-loading-fail.png<%}%>" class="rounded float-left media-object" width="113vw"></a>
		    	</div>
	           	<div class="col-md-10 col-sm-12 col-12">
					<h5 class="mt-0 mb-1"><a href="/mobileconsultaespectaculo?nomespectaculo=<%=auxc.getNombre() %>"><%= auxc.getNombre() %></a></h5>
		      		<p><%= auxc.getDescripcion() %> <a href="/consultaespectaculo?nomespectaculo=<%=auxc.getNombre() %>">Leer más</a></p>
	            	</div>
          </div>
           <br>
           <hr>

<% }} else { %> 
	<h2>Espectáculos destacados</h2><br>
    <div class="container-fluid" style="padding-right:15%;">
		 <div class="row">
	           	<div class="col-md-2 col-sm-12 col-12 align-items-center justify-content-center" style="text-align:center;">
	           		<a href="/mobileconsultaespectaculo?nomespectaculo=Global Spirit" class="rounded float-left media-object" width="120em"><img class="mr-3" src="/imagenes?id=EspectaculoGlobal Spirit.jpg" class="rounded float-left media-object" width="113vw"></a>
		    	</div>
	           	<div class="col-md-10 col-sm-12 col-12">
					<h5 class="mt-0 mb-1"><a href="/mobileconsultaespectaculo?nomespectaculo=Global Spirit">Global Spirit</a></h5>
		      		<p>Espectáculo donde se presenta el álbum Spirit.<a href="/mobileconsultaespectaculo?nomespectaculo=Global Spirit"> Leer más</a></p>
	            	</div>
          </div>
          <br>
          <hr>
           <div class="row">
	           	<div class="col-md-2 col-sm-12 col-12 align-items-center justify-content-center" style="text-align:center;">
	           		<a href="/mobileconsultaespectaculo?nomespectaculo=Bien de Familia" class="rounded float-left media-object" width="120em"><img class="mr-3" src="/imagenes?id=EspectaculoBien de Familia.jpg" class="rounded float-left media-object" width="113vw"></a>
		    	</div>
	           	<div class="col-md-10 col-sm-12 col-12">
					<h5 class="mt-0 mb-1"><a href="/mobileconsultaespectaculo?nomespectaculo=Bien de Familia">Bien de familia</a></h5>
		      		<p>El dúo estará presentando sus más sonados éxitos y también nuevas canciones. <a href="/mobileconsultaespectaculo?nomespectaculo=Bien de Familia"> Leer más</a></p>
	            	</div>
          </div>
          <br>
          <hr>
          <div class="row">
	           	<div class="col-md-2 col-sm-12 col-12 align-items-center justify-content-center" style="text-align:center;">
	           		<a href="/mobileconsultaespectaculo?nomespectaculo=Los Village Volvieron" class="rounded float-left media-object" width="120em"><img class="mr-3" src="/imagenes?id=EspectaculoLos Village Volvieron.jpg" class="rounded float-left media-object" width="113vw"></a>
		    	</div>
	           	<div class="col-md-10 col-sm-12 col-12">
					<h5 class="mt-0 mb-1"><a href="/mobileconsultaespectaculo?nomespectaculo=Los Village Volvieron">Los Village Volvieron</a></h5>
		      		<p>Espectáculo de retorno de los Village People.<a href="/mobileconsultaespectaculo?nomespectaculo=Los Village Volvieron"> Leer más</a></p>
	            	</div>
          </div>
          <br>
          <hr>
          
    </div>        
	<% } %>  
        </div>


	
</body>
</html>