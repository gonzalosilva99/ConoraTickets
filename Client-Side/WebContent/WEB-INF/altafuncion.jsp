<!DOCTYPE html>
<html>
<head>
	  <%@page import="java.util.Set" %>
	  <%@page import="java.util.Iterator" %>
    <%@page import="DataTypes.DtPlataforma" %>
	<%@page import="DataTypes.EstadoSesion" %>
	<%@page import="DataTypes.DtPaqueteDatos" %>
	<%@page import="DataTypes.DtEspectaculo" %>
	<%@page import="DataTypes.DtFuncion" %>	
	<%@page import="DataTypes.DtUsuario" %>	
	<%@page import="DataTypes.EstadoEspectaculo" %>	
	<%@page import="com.coronatickets.controllers.Login" %>
	<%@page import="Controladores.Fabrica"%>
	<%@page import="Interfaces.IUsuario"%>
	<%@page import="java.time.Month"%>
	<%@page import="java.time.LocalDate"%>
	<%@page import="java.util.Date"%>
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
            
   	<form class="needs-validation mt-5 " novalidate>
   	
    <div class="form-row col-md-5 row-md-4 mb-4 mx-auto"> 	
      <select class="custom-select" id="inlineFormCustomSelect" >
      <option value="" selected>Elija la plataforma</option>
      	<%
				DtUsuario usuario = Login.getUsuarioLogueado(request);
				if(Fabrica.getInstancia().getIUsuario().EsArtista(usuario.getNickname())){
					Set<DtPlataforma> plataformas = Fabrica.getInstancia().getIPlataforma().listarPlataformas();
					Iterator<DtPlataforma> itrp = plataformas.iterator();
					while(itrp.hasNext()){
						DtPlataforma auxp = itrp.next();
						System.out.println(auxp.getNombre());
		%>			
      	<option value="<%=auxp.getNombre()%>"> <%=auxp.getNombre()%> </option>
      </optgroup>
        <%} %>
        <%} %>
      </select>
   </div>
    <div class="form-row col-md-5 row-md-4 mb-4 mx-auto"> 	
      <select class="custom-select" id="inlineFormCustomSelect" >
      <option value="" selected>Elija el Espectaculo</option>
      <optgroup label="Espectaculos disponibles:">
      	<option value="1">Opcion1</option>
      </optgroup>
        
      </select>
   </div>

	<div class="form-row col-md-5 row-md-4 mb-4 mx-auto">
      <input type="text" class="form-control" id="validationNombre" placeholder="Nombre de la funci�n" required>
      <div class="valid-feedback">
        Bien!
      </div>
    </div>
    
    <div class="form-row col-md-5 mx-auto">
    	<div class="form-group col-md-8">
    		<input class="form-control" type="date" name="dateFechaInicio" placeholder="FechaInicio" required>
    	</div>
    </div>
    
    <div class="form-row col-md-5 mx-auto">
    	<div class="form-group col-md-8">
    		<input type="time" name="timeFechaInicio" placeholder="HoraInicio" class="form-control" required>
    	</div>
    </div>
    
    <div class="form-row col-md-5 mb-4 mx-auto">
  		<input type="file" class="custom-file-input" id="customFileLang" lang="es">
  		<label class="custom-file-label" for="customFileLang">Seleccionar Archivo</label>
	</div>
	
	<div class="form-row col-md-5 mb-4 mx-auto">
  		<button class="btn btn-primary" style="width: 100%;" type="submit">Agregar Funcion!</button>
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