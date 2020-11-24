<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.text.*,java.util.*" %>
<%@page import="com.coronatickets.controllers.Login" %>
  <%@page import="controladores.Fabrica" %>

<%@page import="datatypes.DtUsuario"%>
<%@page import="datatypes.DtEspectadorPerfil"%>
<%@page import="datatypes.DtArtistaPerfil"%>
<%@page import="datatypes.EstadoSesion" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Configuracion</title>
	<jsp:include page="/WEB-INF/template/head.jsp"/>
</head>
<body>
	<%
		try{
			DateFormat fechaIncompleta = new SimpleDateFormat("yyyy-MM-dd");
			webservices.DtUsuario usuario = Login.getUsuarioLogueado(request);

			DtArtistaPerfil dtart = null;
			DtEspectadorPerfil dtesp=null;
			if(Fabrica.getInstancia().getIUsuario().esArtista(usuario.getNickname())) {
		dtart = Fabrica.getInstancia().getIUsuario().perfilArtista(usuario.getNickname());
			}
			else{
		dtesp = Fabrica.getInstancia().getIUsuario().perfilEspectador(usuario.getNickname());
			}
			Date aux = usuario.getNacimiento().toGregorianCalendar().getTime();	
			String fecha_nac = fechaIncompleta.format(usuario.getNacimiento());
	%>
	<div class="wrapper">
	
	<jsp:include page="/WEB-INF/template/header_menulateral.jsp"/>
        <div id="content">
			<jsp:include page="/WEB-INF/template/header_menusup.jsp"/>
            <form class="needs-validation mt-5 " action="configuracion" method="POST" novalidate>
			   	<div class="mx-auto col-md-6">
				   	<div style="display:none;" class="alert alert-warning" role="alert">
						  Ha ocurrido un error con los datos ingresados.
					</div>
				   	<div class="row">
				   		<h1 class="text-center col-auto mb-4">Editar perfil</h1><br>
				    </div>
					<%if(request.getParameter("t")!=null && request.getParameter("t").equals("e")){ %>
						<script type="text/javascript"> $(".alert").show();</script>
					<%}%>
				   	<div class="row">
				    	<div class="col-md-3">
						<label for="validationCustom01">Nombre:</label>
				    	</div>
				    	<div class="col-md-9">
				    		<input type="text" style="margin-left:5%;display:inline;width:60%;"  class="form-control" name="inputNombre" id="inputNombre" value="<%=usuario.getNombre()%>" title="Ingrese solo letras" required pattern="([A-Z]|[a-z])+">
					    </div>
				    </div>
				    <br>
				    <div class="row">
				    	<div class="col-md-3">
				    		<label for="validationCustom02">Apellido:</label>
				    	</div>
				    	<div class="col-md-9">
					      <input type="text" style="margin-left:5%;display:inline;width:60%;"  class="form-control" value="<%=usuario.getApellido()%>" name="inputApellido" id="inputApellido"  title="Ingrese solo letras" placeholder="Apellido" required pattern="([A-Z]|[a-z])+">
					    </div>
				    </div>
				    <br>
				    <div class="row">
				    	<div class="col-md-3"> 
				    		<label for="validationCustom02">Email:</label>
				    	</div>
				    	<div class="col-md-9">
					        <input type="text" readonly style="margin-left:5%;display:inline;width:60%;"  class="form-control" value="<%=usuario.getEmail()%>" name="inputEmail" id="inputEmail"  placeholder="Email" aria-describedby="inputGroupPrepend" required>
					        <div class="invalid-feedback">
					          Email inválido.
					        </div>
					    </div>
				    </div>
				    <br>
				    <div class="row">
				    	<div class="col-md-3"> 
				    		<label for="validationCustom02">Nickname:</label>
				    	</div>
				    	<div class="col-md-9">
						      <input type="text" readonly style="margin-left:5%;display:inline;width:60%;" class="form-control" value="<%=usuario.getNickname()%>" id="inputNickname" placeholder="Nickname" name="inputNickname" required>
						      <div class="invalid-feedback">
						        Nickname inválido.
						      </div>
				   		 </div>
				    </div>
				    <br>
				    <div class="row">
				    	<div class="col-md-3"> 
				    		<label for="validationCustom02">Nacimiento:</label>
				    	</div>
				    	<div class="col-md-9">
				    		<input type="date" name="inputNacimiento"  style="margin-left:5%;display:inline;width:60%;" placeholder="Nacimiento" class="form-control"  value="<%=fecha_nac%>" id="inputNacimiento" placeholder="Nacimiento" required>
				    	 </div>
				    </div>
				    <br>
				    <div class="row">
				    	<div class="col-md-3"> 
				    		<label for="validationCustom02">Imagen:</label>
				    	</div>
				    	<div class="col-md-9">
							 <input type="text"  style="margin-left:5%;display:inline;width:60%;" value="<%=usuario.getImagen()%>" class="form-control" id="inputNickname" placeholder="Link imagen de perfil" name="imagen">
						</div>
				    </div>
				    <br>
				    <%--Mostrar si es artista: --%>
				    <%if(dtart!=null){ %>
				    <div class="row">
				    	<div class="col-md-3"> 
				    		<label for="validationCustom02">Descripcion general:</label>
				    	</div>
				    	<div class="col-md-9">
				      		<textarea type="text"  style="margin-left:5%;display:inline;width:60%;" class="form-control"  id="validationCustom06" name="descgeneral" placeholder="Desc. General"><%=dtart.getDescgeneral() %></textarea>
				    	</div>
				    </div>
				    <br>
				    <div class="row">
				    	<div class="col-md-3"> 
				    		<label for="validationCustom02">Biografia:</label>
				    	</div>
				    	<div class="col-md-9">
				      		<textarea style="margin-left:5%;display:inline;width:60%;"  class="form-control" id="validationCustom07"  name="biografia" placeholder="Biografia"><%=dtart.getBiografia()%></textarea>
				    	</div>
				    </div>
				    <br>
				    <div class="row">
				    	<div class="col-md-3"> 
				    		<label for="validationCustom02">Sitio web:</label>
				    	</div>
				    	<div class="col-md-9">
				      		<input type="url"  style="margin-left:5%;display:inline;width:60%;" class="form-control" id="validationCustom08" name="url" value="<%=dtart.getLink() %>" style="width: 100%;" placeholder="Sitio Web">
				    	</div>
				    </div>
				    <br><%} %>
				   	<div class="row">
				   		<button class="btn btn-primary mx-auto" style="margin-right:30%;width: 30%;background-color:#148ea1" type="submit" onclick="if(document.getElementByClassName('was-validated')){submit()}">Guardar cambios</button>
				   	</div>
			  	</div>
			</form>
        </div>
	</div>
	<%}catch(Exception e){
		response.sendRedirect("/home");
	} %>

</body>
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
</html>