<!DOCTYPE html>
<html>
<head>
	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="webservices.*"%>
	<%@page import="java.util.Set" %>
	<%@page import="java.util.Iterator" %>
	<%@page import="com.coronatickets.controllers.Login" %>
	<%@page import="com.coronatickets.controllers.AltaFuncion" %>
	<%@page import="java.time.Month"%>
	<%@page import="java.time.LocalDate"%>
	<%@page import="java.util.Date"%>
	<%@page import="java.util.ArrayList"%>
	<jsp:include page="/WEB-INF/template/head.jsp"/>
	<title>CoronaTickets UY - Alta de funcion</title>
</head>
<body>
<div class="wrapper">
		<jsp:include page="/WEB-INF/template/header_menulateral.jsp"/>
        <!-- Page Content  -->
        <div id="content">
			<jsp:include page="/WEB-INF/template/header_menusup.jsp"/>
	
	<h1 class="text-center">Ingresar nueva funcion</h1>
      
   	<form class="needs-validation mt-5 " id="myForm" novalidate>
   	
    <div class="form-row col-md-5 row-md-4 mb-4 mx-auto"> 	
    <%  String plataformaSeleccionada = (String) request.getSession().getAttribute("plataforma") ; 
    	Boolean platSel = false;%>
      <select class="custom-select" id="selectPlataformas" onChange="obtenerEspectaculos()"   >    
      <option value="" selected><% if (plataformaSeleccionada == null){%> Elija la plataforma <%}else{platSel = true;%> <%=plataformaSeleccionada%> <%} %></option>
      	<%
      			DtUsuario usuario = Login.getUsuarioLogueado(request);
		      	webservices.PublicadorService service = new webservices.PublicadorService();                    
		    	webservices.Publicador port = service.getPublicadorPort();
      			if(port.esArtista(usuario.getNickname())){
      				webservices.ArrayPlataformas plataformas = port.listarPlataformas();
      				Iterator<webservices.DtPlataforma> itrp = plataformas.getPlats().iterator();
      				while(itrp.hasNext()){
      					webservices.DtPlataforma auxp = itrp.next();
      					if (platSel && !auxp.getNombre().equals(plataformaSeleccionada) || !platSel){
      	%>			
      	<option value="<%=auxp.getNombre()%>"><%=auxp.getNombre()%></option>
		             	
        <%}
		             	        	}
		             	        %>
        <%
        	}
        %>
      </optgroup>
     
      </select>
     

   </div>
    <%
    	Set<DtEspectaculo> espectaculosActivados = (Set<DtEspectaculo>) request.getSession().getAttribute("espectaculosAceptados");
    %>
    <div class="form-row col-md-5 row-md-4 mb-4 mx-auto"> 	
      <select class="custom-select" id="selectEspectaculos" name="espectaculo" >
      <option value="" selected><%
      	if (espectaculosActivados == null){
      %> No hay espectaculos disponibles en la plataforma <%
      	}else{
      %> Elija el espectaculo <%
      	}
      %></option>
      <%
      	try{
      	      	Iterator<DtEspectaculo> iterEspectaculos= espectaculosActivados.iterator();
      	while(iterEspectaculos.hasNext()){
      		DtEspectaculo dtespec = iterEspectaculos.next();
      %>
      	<option value="<%=dtespec.getNombre()%>"><%=dtespec.getNombre()%></option>
      	<%
      		}
      	%>
      	<%
      		} catch(Exception e){
      	      	      		System.out.println("CATCH DEL LISTAR ESPECTACULOS");
      		}
      	%>
      	

        
      </select>
   </div>
    <div class="form-row col-md-5 row-md-4 mb-4 mx-auto"> 	
    
      <select class="custom-select" id="selectArtistas" name="invitados[]"  multiple>    
      <option value="" disabled>Elija artistas invitados</option>
      	<%
      		if(port.esArtista(usuario.getNickname())){
      				ArrayArtistas artistasInvitados = port.listarArtistas();
      				Iterator<DtArtista> iterArtista = artistasInvitados.getArtistas().iterator();
      				while(iterArtista.hasNext()){
      					DtArtista artista = iterArtista.next();
      	%>			
      	<option value="<%=artista.getNickname() %>"><%=artista.getNombre() %>  <%=artista.getApellido() %></option>
          	
        <%//} %>
        <%} %>
        <%} %>

     
      </select>
     
	<h7><i>Nota: mantener apretada la tecla CTRL para seleccionar varios artistas.</i> </h7>
   </div>

	<div class="form-row col-md-5 row-md-4 mb-4 mx-auto">
      <input type="text" class="form-control" name="funcion" id="nombreFuncion" placeholder="Nombre de la función" required>
    </div>
    
    <div class="form-row col-md-5 mx-auto">
    	<div class="form-group col-md-8">
    		<input class="form-control" type="date" name="fecha" id="fecha" placeholder="yyyy-MM-dd" required>
    	</div>
    </div>
    
    <div class="form-row col-md-5 mx-auto">
    	<div class="form-group col-md-8">
    		<input class="form-control" type="time" name="hora" id="hora" placeholder="hh:mm" required>
    	</div>
    </div>
     
    <div class="form-row col-md-5 mb-4 mx-auto">
  		<input type="url" class="form-control" id="img" name="img" style="width: 100%;" placeholder="Imagen de la funcion">
	</div>
	
	<div class="form-row col-md-5 mb-4 mx-auto">
  		<button class="btn btn-primary" style="width: 100%;" type="submit" id="botonEnviar" onClick="registrarFuncion()" >Agregar Funcion!</button>
   </div>
   <input type="text" name="inputPrueba" value="algunvalor" id="inputPrueba" hidden>
</form>
       </div>
       <input type="text" name="inputPrueba" value="algunvalor" id="inputPrueba" hidden>
</div>


<script>
// Example starter JavaScript for disabling form submissions if there are invalid fields
(function() {
  'use strict';
  window.addEventListener('load', function() {
    // Fetch all the forms we want to apply custom Bootstrap validation styles to
    var forms = document.getElementsByClassName('needs-validation');
    // Loop over them and prevent submission
    var validation = Array.prototype.filter.call(forms, function(form) {
      form.addEventListener('submit', function(event) {
        if (form.checkValidity() === false) {
          event.preventDefault();
          event.stopPropagation();
        }
        form.classList.add('was-validated');
      }, false);
    });
  }, false);
})();
</script>
	<script type="text/javascript">
        $(document).ready(function () {
            $('#gridRadios2').on('change', function () {
                $('#opcionesArtista').show();
            });
            
            $('#gridRadios1').on('change', function () {
                $('#opcionesArtista').hide();
            });
        });
    </script>


<script >
		function obtenerEspectaculos(){
			event.preventDefault();
			var e = document.getElementById("selectPlataformas");
			var plataforma = e.options[e.selectedIndex].text;
			var data = {
					userlogged:'<%= usuario.getNickname() %>',
					plataforma:plataforma,
		    		actualizar:'true'};
			$.ajax({
		        type: 'POST',
		        url:  'altafuncion',
		        data: data,
		        async: false,
		        success: function (data) {
		            console.log(data);
		            window.location.reload();
		        }
		    });
			return false;
		}
		function registrarFuncion(){
			event.preventDefault();
			var selectPlataformas = document.getElementById("selectPlataformas");
			var plataforma = selectPlataformas.options[selectPlataformas.selectedIndex].text;
			var selectEspectaculos = document.getElementById("selectEspectaculos");
			var espectaculo = selectEspectaculos.options[selectEspectaculos.selectedIndex].text;
			var funcion = document.getElementById("nombreFuncion").value;		
			var artistasInvitados = $('#selectArtistas').val();
			var fecha = document.getElementById("fecha").value;
			var fecha = fecha + " " + document.getElementById("hora").value;
			var imagen = document.getElementById("img").value;
			if(funcion!=""){
			var data = {
					usuario_logueado:'<%= usuario %>',
					plataforma: plataforma,
					espectaculo: espectaculo,
					funcion: funcion,
					invitados: artistasInvitados,
					fecha: fecha,
					imagen: imagen,
		    		actualizar: 'false'};
			$.ajax({
		        type: 'POST',
		        url:  'altafuncion',
		        data: data,
		        async: false,
		        success: function (data) {
		            console.log(data);
		            if(data === "SUCCESS") {
		   				alert("Funcion registrada con exito");
		   				window.location.replace("/altafuncion");
		            }
		            else if (data === "EXISTE_FUNCION"){
		            	alert("Ya existe una funcion con ese nombre!");
		            }else{
		            	alert("ERROR: " + data);
		            }
		        }
		    });
			return false;
		}
			else{
				alert("Por favor complete el campo Nombre Funcion.");
			}
			}
</script>
</body>
</html>
