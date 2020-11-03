
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  	<%@page import="datatypes.DtPlataforma"%>
	<%@page import="datatypes.DtCategoria"%>
	<%@page import="datatypes.EstadoSesion" %>
	<%@page import="datatypes.DtUsuario" %>
	<%@page import="com.coronatickets.controllers.Login" %>
	<%@page import="controladores.Fabrica"%>
	<%@page import="interfaces.IPlataforma"%>
	<%@page import="interfaces.ICategoria"%>
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
  		<input type="file" class="custom-file-input" name= "imagen" id="customFileLang" lang="es">
  		<label class="custom-file-label" for="customFileLang">Seleccionar Archivo</label>
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


	<!-- jQuery CDN - Slim version (=without AJAX) -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <!-- Popper.JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
    <!-- Bootstrap JS -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
	
	<script type="text/javascript">
        $(document).ready(function () {
            $('#sidebarCollapse').on('click', function () {
                $('#sidebar').toggleClass('active');
            });
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