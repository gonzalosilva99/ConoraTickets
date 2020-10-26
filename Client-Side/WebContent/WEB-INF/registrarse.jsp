<!DOCTYPE html>
<html>
<head>
    <jsp:include page="/WEB-INF/template/head.jsp"/>
<title>CoronaTickets UY - Registrarse</title>
</head>
<body>
<div class="wrapper">
		
		<jsp:include page="/WEB-INF/template/header_menulateral.jsp"/>
        <!-- Page Content  -->
        <div id="content">
		<jsp:include page="/WEB-INF/template/header_menusup.jsp"/>
	
	
            
   	<form class="needs-validation mt-5 " action="signin" method="POST" novalidate>
   				
   	<div class="mx-auto col-md-4 form-row">
   	
    <div class="col-auto mb-4 justify-content-center align-items-center" >
    <h1 class="text-center col-auto mb-4">Regístrate</h1>
<!--       <label for="validationCustom01">Nombre:</label> -->
      <input type="text" class="form-control" id="inputNombre" placeholder="Nombre" required>
      <div class="valid-feedback">
        Bien!
      </div>
    </div>
    <div class="col-auto mb-4">
<!--       <label for="validationCustom02">Apellido:</label> -->
      <input type="text" class="form-control" id="inputApellido" placeholder="Apellido" required>
      <div class="valid-feedback">
        Bien!
      </div>
    </div>
    <div class="col-auto mb-4">
      <div class="input-group">
        <input type="text" class="form-control" id="validationCustomUsername" placeholder="Email" aria-describedby="inputGroupPrepend" required>
        <div class="invalid-feedback">
          Email inválido.
        </div>
      </div>
  </div>
    <div class="col-auto mb-4">

      <input type="text" class="form-control" id="nickname" placeholder="Nickname" name="nickname" required>
      <div class="invalid-feedback">
        Nickname inválido.
      </div>
    </div>
    <div class="col-auto mb-4">
      <input type="password" class="form-control" id="inputPassword" placeholder="Contraseña" required>
      <div class="invalid-feedback">
        Contraseña inválida.
      </div>
    </div>
    <div class="col-auto mb-4">
      <input type="password" class="form-control" id="inputConfirmarPassword" placeholder="Confirmar Contraseña" required>
      <div class="invalid-feedback">
        Contraseña inválida.
      </div>
    </div>
    <div class="col-auto mb-4">
      <input type="date" name="trip-start" placeholder="Nacimiento" class="form-control" id="validationCustom05" placeholder="Nacimiento" required>
    </div>
    <div class="col-auto mb-4">
    <input type="file" >
	</div>
    	<div class="form-group col-auto">
    <div class="form-radio ml-4 mb-4">
      <input class="form-check-input" type="radio" name="tipo" id="gridRadios1" value="espectador" checked>
      <label class="form-check-label mr-5" for="invalidCheck" id="chartista">
        Espectador
      </label>
      <input class="form-check-input" type="radio" name="tipo" id="gridRadios2" value="artista"">
      <label class="form-check-label" for="invalidCheck">
        Artista
      </label>
    </div>
    <div id="opcionesArtista" class=" mb-4 mr-3" style="display:none;">
    	<div class=" mb-4 ">
<!--       <label for="validationCustom03">Nickname:</label> -->
      <textarea type="text" class="form-control" id="validationCustom06" placeholder="Desc. General"></textarea>
    </div>
    <div class="mb-4 md-4">
      <textarea type="text" class="form-control" id="validationCustom07" placeholder="Biografia"></textarea>
    </div>
    <div class="mb-4 md-1" style="width: 100%;">
      <input type="url" class="form-control" id="validationCustom08" style="width: 100%;" placeholder="Sitio Web">
    </div>
    </div>
    <div class="col mb-4"">
  		<button class="btn btn-primary" style="width: 100%;" type="submit" onclick="submit()">Registrate</button>
   </div>
  	</div>
  	
  	
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