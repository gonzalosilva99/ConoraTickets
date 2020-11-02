<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.text.*,java.util.*" %>
<%@page import="com.coronatickets.controllers.Login" %>
  <%@page import="Controladores.Fabrica" %>

<%@page import="DataTypes.DtUsuario"%>
<%@page import="DataTypes.DtEspectadorPerfil"%>
<%@page import="DataTypes.DtArtistaPerfil"%>
<%@page import="DataTypes.EstadoSesion" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Configuracion</title>
	<jsp:include page="/WEB-INF/template/head.jsp"/>
</head>
<body>
	<%
	DtUsuario usuario = Login.getUsuarioLogueado(request);

	
	DtArtistaPerfil dtart = null;
	DtEspectadorPerfil dtesp=null;
	if(Fabrica.getInstancia().getIUsuario().EsArtista(usuario.getNickname())) {
		dtart = Fabrica.getInstancia().getIUsuario().PerfilArtista(usuario.getNickname());
	}
	else{
		dtesp = Fabrica.getInstancia().getIUsuario().PerfilEspectador(usuario.getNickname());
	}
	%>
	<div class="wrapper">
	
	<jsp:include page="/WEB-INF/template/header_menulateral.jsp"/>
        <div id="content">
			<jsp:include page="/WEB-INF/template/header_menusup.jsp"/>
            <form class="needs-validation mt-5 " action="signin" method="POST" novalidate>
			   	<div class="mx-auto col-md-6">
			   	<div class="row">
			   		<h1 class="text-center col-auto mb-4">Editar perfil</h1><br>
			    </div>
			   	<div class="row">
			    	<div class="col-md-3">
					<label for="validationCustom01">Nombre:</label>
			    	</div>
			    	<div class="col-md-9">
			    		<input type="text" style="margin-left:5%;display:inline;width:60%;"  class="form-control" name="inputNombre" id="inputNombre" value="<%=usuario.getNombre()%>" placeholder="<%=usuario.getNombre()%>DtUsuario">
				      <div class="valid-feedback">
				        Bien!
				      </div>
			    	</div>
			    </div>
			    <br>
			    <div class="row">
			    	<div class="col-md-3">
			    		<label for="validationCustom02">Apellido:</label>
			    	</div>
			    	<div class="col-md-9">
				      <input type="text" style="margin-left:5%;display:inline;width:60%;"  class="form-control" value="<%=usuario.getApellido()%>" name="inputApellido" id="inputApellido" placeholder="Apellido" required>
				      <div class="valid-feedback">
				        Bien!
				      </div>
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
			    		<label for="validationCustom02">Fecha nacimiento :</label>
			    	</div>
			    	<div class="col-md-9">
			    		<input type="date" name="trip-start"  style="margin-left:5%;display:inline;width:60%;" placeholder="Nacimiento" class="form-control"  id="inputNacimiento" placeholder="Nacimiento" required>
			    	 </div>
			    </div>
			    <br>
			    <div class="row">
			    	<div class="col-md-3"> 
			    		<label for="validationCustom02">Link imagen de perfil:</label>
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

</body>
</html>