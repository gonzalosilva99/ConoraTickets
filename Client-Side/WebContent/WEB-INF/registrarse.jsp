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
	
	<%
 if((String) request.getAttribute("alta")!=null && ((String) request.getAttribute("alta")).equals("difieren"))
					{%> <script type="text/javascript"> alert("Las contraseñas no coinciden"); </script> <%}
 else if((String) request.getAttribute("alta")!=null && !((String) request.getAttribute("alta")).equals("difieren")){%> 
					<script type="text/javascript"> alert("<%= (String) request.getAttribute("alta") %>"); </script>
					<% } %>
	
            
   	<form class="needs-validation mt-5 " action="signin" method="POST" novalidate>
   				
   	<div class="mx-auto col-md-4 form-row">
   	
    <div class="col-auto mb-4 justify-content-center align-items-center" >
    <h1 class="text-center col-auto mb-4">Regístrate</h1>
<!--       <label for="validationCustom01">Nombre:</label> -->
      <input type="text" class="form-control" name="inputNombre" id="inputNombre" placeholder="Nombre" required>
      <div class="valid-feedback">
        Bien!
      </div>
    </div>
    <div class="col-auto mb-4">
<!--       <label for="validationCustom02">Apellido:</label> -->
      <input type="text" class="form-control" name="inputApellido" id="inputApellido" placeholder="Apellido" required>
      <div class="valid-feedback">
        Bien!
      </div>
    </div>
    <div class="col-auto mb-4">
      <div class="input-group">
        <input type="text" class="form-control" name="inputEmail" id="inputEmail"  placeholder="Email" aria-describedby="inputGroupPrepend" required>
        <div class="invalid-feedback">
          Email inválido.
        </div>
      </div>
  </div>
    <div class="col-auto mb-4">

      <input type="text" class="form-control" id="inputNickname" placeholder="Nickname" name="inputNickname" required>
      <div class="invalid-feedback">
        Nickname inválido.
      </div>
    </div>
    <div class="col-auto mb-4">
      <input type="password" class="form-control" id="inputPassword" name="inputPassword" placeholder="Contraseña" required>
      <div class="invalid-feedback">
        Contraseña inválida.
      </div>
    </div>
    <div class="col-auto mb-4">
      <input type="password" class="form-control" id="inputConfirmarPassword" name="inputConfirmarPassword" placeholder="Confirmar Contraseña" required>
      <div class="invalid-feedback">
        Contraseña inválida.
      </div>
    </div>
    <div class="col-auto mb-4">
      <input type="date" name="trip-start" placeholder="Nacimiento" class="form-control"  id="inputNacimiento" placeholder="Nacimiento" required>
    </div>
    <div class="col-auto mb-4">

      <input type="text" class="form-control" id="inputNickname" placeholder="Link imagen de perfil" name="imagen">

    </div>
    	<div class="form-group col-auto">
    <div class="form-radio ml-4 mb-4">
      <input class="form-check-input" id="inputCheckEspectador" type="radio" name="espectadorArtista"  value="espectador" checked>
      <label class="form-check-label mr-5" for="invalidCheck" id="chartista">
        Espectador
      </label>
      <input class="form-check-input" id="inputCheckArtista" type="radio" name="espectadorArtista"  value="artista"">
      <label class="form-check-label" for="invalidCheck">
        Artista
      </label>
    </div>
    <div id="opcionesArtista" class=" mb-4 mr-3" style="display:none;">
    	<div class=" mb-4 ">
<!--       <label for="validationCustom03">Nickname:</label> -->
      <textarea type="text" class="form-control" id="validationCustom06" name="descgeneral" placeholder="Desc. General"></textarea>
    </div>
    <div class="mb-4 md-4">
      <textarea type="text" class="form-control" id="validationCustom07" name="biografia" placeholder="Biografia"></textarea>
    </div>
    <div class="mb-4 md-1" style="width: 100%;">
								<input type="url" class="form-control" id="validationCustom08"
									name="url" style="width: 100%;" placeholder="Sitio Web">
							</div>
    </div>
    <div class="col mb-4"">
  		<button class="btn btn-primary" style="width: 100%;" type="submit" onclick="if(document.getElementByClassName('was-validated')){submit()}">Registrate</button>
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

	
	<script type="text/javascript">
        $(document).ready(function () {
            $('#sidebarCollapse').on('click', function () {
                $('#sidebar').toggleClass('active');
            });
            $("#inputCheckArtista").on('change', function () {
                $('#opcionesArtista').show();
            });
            
            $('#inputCheckEspectador').on('change', function () {
                $('#opcionesArtista').hide();
            });
        });
    </script>

<script>
$(document).ready(function () {

});
</script>
</body>
</html>