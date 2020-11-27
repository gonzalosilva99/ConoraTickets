<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@page import="com.coronatickets.controllers.Login" %>
	<%@page import="java.util.Iterator" %>
	<%@page import="java.util.Set"%>
	<%@page import="java.util.HashSet"%>
	<jsp:include page="/WEB-INF/template/head.jsp"/>
<title>CoronaTickets UY - Registrarse</title>
</head>
<body>

<% if((String) request.getAttribute("aceptado")!=null && ((String) request.getAttribute("aceptado")).equals("true")){ %> 
<script type="text/javascript"> alert("Paquete creado con exito"); </script>
<% } %>

<% if((String) request.getAttribute("si")!=null && ((String) request.getAttribute("si")).equals("true")){ %> 
<script type="text/javascript"> alert("Ya existe paquete con ese nombre"); </script>
<% } %>
<% if((String) request.getAttribute("fechainvalida")!=null && ((String) request.getAttribute("fechainvalida")).equals("true")){ %> 
<script type="text/javascript"> alert("La fecha introducida no es válida"); </script>
<% } %>

<div class="wrapper">
	<jsp:include page="/WEB-INF/template/header_menulateral.jsp"/>
        <!-- Page Content  -->
        <div id="content">
			<jsp:include page="/WEB-INF/template/header_menusup.jsp"/>
	
	<h1 class="text-center">Crea un Paquete de Espectáculos</h1>
            
   	<form class="needs-validation mt-5 " novalidate action="altapaquete" method="POST">
   	
   	
    <div class="form-row col-md-5 row-md-4 mb-4 mx-auto">
      <input type="text" name="nombrepaquete" class="form-control" id="validationNombre" placeholder="Nombre del Paquete" required>
      <div class="valid-feedback">
        Bien!
      </div>
    </div>

    <div class="form-row col-md-5  mb-4 mx-auto">
      <textarea class="form-control row-md-3" rows=5 name="descripcion" id="Descripcion" placeholder="Descripción"></textarea>
    </div>
    
    <div class="form-row col-md-5 mx-auto">
    	<div class="form-group col-md-8">
    		<label for="inputFechaInicio">Fecha Inicio:</label>
    		<input type="date" name="dateFechaInicio" placeholder="FechaInicio" class="form-control" id="validationFechaInicio" placeholder="FechaInicio" required>
    	</div>
    </div>
    <div class="form-row col-md-5 mb-4 mx-auto">
    	<div class="form-group col-md-8">
    		<label for="inputFechaInicio">Fecha Fin:</label>
    		<input type="date" name="dateFechaFin" placeholder="FechaFin" class="form-control" id="validationFechaFin" placeholder="FechaFin" required>
    	</div>
    </div>
    
    <div class="form-row col-md-5 mb-4 mx-auto">
    	<div class="input-group col-md-8">
    		<div class="input-group-prepend">
    			<span class="input-group-text">%</span>
    		</div>
    		<input type="number" name = "porcentaje" class="form-control" id="inputPorcentajeDescuento" placeholder="25.55" required>
    	</div>
    </div>
          <div class="form-row col-md-5 mb-4 mx-auto">
  		<input type="url" class="form-control" id="imagen" name="imagen" style="width: 100%;" placeholder="Imagen de la funcion">
	</div>
	
	
	<div class="form-row col-md-5 mb-4 mx-auto">
  		<button class="btn btn-primary" style="width: 100%;" type="submit" onclick="submit()">Crear Paquete!</button>
   </div>
</form>



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


       </div>
</div>



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
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script>
$(document).ready(function () {

});
</script>
</body>
</html>