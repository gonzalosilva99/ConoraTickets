<!DOCTYPE html>
<%@page import="webservices.EstadoSesion"%>
<%@page import="webservices.DtPlataforma"%>
<html>
<head>

	<%@page import="webservices.DtCategoria"%>
	<%@page import="com.coronatickets.controllers.Login" %>
	<%@page import="java.util.Iterator" %>
	<%@page import="java.util.Set"%>
	<%@page import="java.util.List"%>
	<%@page import="java.util.HashSet"%>
	<jsp:include page="/WEB-INF/template/head.jsp"/>
	<title>CoronaTickets UY - Alta Espectaculo</title>
</head>
<body>
	
	<%		
			 webservices.PublicadorService service = new webservices.PublicadorService();
	 		 webservices.Publicador port = service.getPublicadorPort();
			if (request.getSession().getAttribute("usuario_logueado")!=null && request.getSession().getAttribute("estado_sesion")!=null && ((EstadoSesion) request.getSession().getAttribute("estado_sesion")==EstadoSesion.LOGIN_CORRECTO)){
				webservices.DtUsuario usuario = Login.getUsuarioLogueado(request);
			if(port.esArtista(usuario.getNickname())){
				System.out.print("jsp2 "+(String) request.getAttribute("aceptado"));
				if((String) request.getAttribute("aceptado")!=null && ((String) request.getAttribute("aceptado")).equals("true")){
		%>	
	 	<script type="text/javascript"> alert("Enviado. Esperando a ser aceptado"); </script>
				<% } else if((String) request.getAttribute("aceptado")!=null && !((String) request.getAttribute("aceptado")).equals("true")){%> <script type="text/javascript"> alert("<%= (String) request.getAttribute("aceptado") %>"); </script> <%}%>
	<div class="wrapper">
        <jsp:include page="/WEB-INF/template/header_menulateral.jsp"/>
        <!-- Page Content  -->
        <div id="content">
		<jsp:include page="/WEB-INF/template/header_menusup.jsp"/>
			<h1 class="text-center">Alta de Espectaculo</h1>
            
   	<form class="needs-validation mt-5 " action="altaespectaculo" method="POST" novalidate>
   	
    
    <div class="form-row col-md-5 row-md-4 mb-4 mx-auto"> 	
<!--       <label class="mr-sm-2" for="inlineFormCustomSelect">Plataforma</label> -->
      <select class="custom-select" id="plat" name="plat" required>
      <option value="" id="elijeplat" selected>Elije la plataforma</option>
      <optgroup label="Plataformas:">
      <%
     
	  webservices.ArrayPlataformas plat = port.listarPlataformas();
      List<DtPlataforma> ListaPlataformas = port.listarPlataformas().getPlats();
      Iterator<DtPlataforma> itr = ListaPlataformas.iterator();
		while(itr.hasNext())
			{
			String aux = itr.next().getNombre();
      %>
      
      	<option value="<%=aux%>"><%= aux %></option>
      	<% ;} %>
      </optgroup>
        
      </select>
   </div>

	<div class="form-row col-md-5 row-md-4 mb-4 mx-auto">
      <input type="text" class="form-control" id="validationNombre" name="Nombre" placeholder="Nombre del Espectaculo" required>
      <div class="valid-feedback">
        Bien!
      </div>
    </div>
    
    <div class="form-row col-md-5  mb-4 mx-auto">
      <textarea class="form-control row-md-3" rows=5 placeholder="Descripción" id="descripcion" name="descripcion"></textarea>
    </div>
    
    <div class="form-row col-md-5 mx-auto">
    	<div class="form-group col-md-8">
<!--     		<label for="espmin">Espectadores minimos:</label> -->
    		<input type="number" name="espmin" placeholder="Espectadores mínimos" class="form-control" id="validationEspMin" name="validationEspMin" required>
    	</div>
    </div>
    <div class="form-row col-md-5 mb-4 mx-auto">
    	<div class="form-group col-md-8">
<!--     		<label for="espmax">Espectadores máximos:</label> -->
    		<input type="number" name="espmax" placeholder="Espectadores máximos" class="form-control" id="validationEspMax" name="validationEspMax" required>
    	</div>
    </div>
    
    <div class="form-row col-md-5 mb-4 mx-auto">
    	<div class="input-group col-md-8">
    		<div class="input-group-prepend">
    			<span class="input-group-text">$</span>
    		</div>
    		<input type="number" class="form-control" id="inputPorcentajeDescuento" placeholder="Costo" name="costo" required>
    	</div>
    </div>
    
    <div class="form-row col-md-5 row-md-4 mb-4 mx-auto">
      <input type="url" class="form-control"  placeholder="URL" name="url" required>
    </div>
    
    <div class="form-row col-md-5 row-md-4 mb-4 mx-auto">
      <input type="number" class="form-control"  placeholder="Duracion(minutos)" name="duracion" required>
    </div>
    
  <div class="form-row col-md-5 row-md-4 mb-4 mx-auto">   
     
  <ul class="list-group list-group-flush" style="" name="categorias">
  <label>Categorías:</label>
  	<%
  	List<DtCategoria> lstcats = port.listarCategorias().getCategorias();
    Iterator<DtCategoria> itrc = lstcats.iterator();
		while(itrc.hasNext())
			{ 	
  		String aux = itrc.next().getNomCategoria();
  		%>
    <li class="list-group-item" name="<%= aux %>">
      <!-- Default checked -->
      <div class="custom-control custom-checkbox">
        <input type="checkbox" class="custom-control-input" id="<%= aux %>" name="checked" value="<%= aux %>">
        <label class="custom-control-label" for="<%= aux %>"><%= aux %></label>
        
      </div>
    </li>
    <% } %>	
  </ul>
   </div> 
    <div class="form-row col-md-5 row-md-4 mb-4 mx-auto">
      <input type="url" class="form-control" id="imagen" placeholder="Link Imagen del Espectaculo" name="imagen">
    </div>
    <div class="form-row col-md-5 row-md-4 mb-4 mx-auto">
      <input type="url" class="form-control" id="video" placeholder="Link del video asociado" name="video">
    </div>
    
    <br>
    <div class="form-row col-md-5 row-md-4 mb-4 mx-auto">
      <input type="number" class="form-control"  placeholder="Cant. Premios" name="cantpremios" required>
    </div>
    <div class="form-row col-md-5  mb-4 mx-auto">
      <textarea class="form-control row-md-3" rows=5 id="descripcionpremios" placeholder="Descripción de premios" name="descripcionpremios"></textarea>
    </div>
	
	<div class="form-row col-md-5 mb-4 mx-auto">
  		<button class="btn btn-primary" style="width: 100%;" type="submit" value="Acceder" onclick="if(document.getElementByClassName('was-validated')){submit()}">Crear Espectaculo!</button>
   </div>
   
</form>

				
<script type="text/javascript">
function ShowSelected()
{

var ret = false;
var combo = document.getElementById("plat");
var selected = combo.options[combo.selectedIndex].text;
if(selected=="Elije la plataforma"){
combo.classList.add('invalid');
alert(selected);
ret=true;
}
return ret;
}
</script>

<script>
(function() {
  'use strict';
  window.addEventListener('load', function() {
    // Fetch all the forms we want to apply custom Bootstrap validation styles to
    var forms = document.getElementsByClassName('needs-validation');
    // Loop over them and prevent submission
    var validation = Array.prototype.filter.call(forms, function(form) {
      form.addEventListener('submit', function(event) {
        if (form.checkValidity() == false || ShowSelected()) {
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
		
	<%
	}}
	else{
		//ELSE REDIRECT A ERROR PAGE
	}
	
	%>
	
	
	
</body>
</html>