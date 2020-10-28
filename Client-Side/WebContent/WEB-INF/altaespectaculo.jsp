<!DOCTYPE html>
<html>
<head>
	<%@page import="DataTypes.DtPlataforma"%>
	<%@page import="DataTypes.DtCategoria"%>
	<%@page import="DataTypes.EstadoSesion" %>
	<%@page import="com.coronatickets.controllers.Login" %>
	<%@page import="Controladores.Fabrica"%>
	<%@page import="Interfaces.IPlataforma"%>
	<%@page import="Interfaces.ICategoria"%>
	<%@page import="java.util.Iterator" %>
	<%@page import="java.util.Set"%>
	<%@page import="java.util.HashSet"%>
	<jsp:include page="/WEB-INF/template/head.jsp"/>
	<title>CoronaTickets UY - Alta Espectaculo</title>
</head>
<body>
	
	<%
	if((String) request.getParameter("id")!=null && Fabrica.getInstancia().getIUsuario().EsArtista((String) request.getParameter("id"))){
		//todo el codigo de abajo
	}
	else{
		//ELSE REDIRECT A ERROR PAGE
	}
	
	%>
	
	
	<div class="wrapper">
        <jsp:include page="/WEB-INF/template/header_menulateral.jsp"/>
        <!-- Page Content  -->
        <div id="content">
		<jsp:include page="/WEB-INF/template/header_menusup.jsp"/>
			<h1 class="text-center">Alta de Espectaculo</h1>
            
   	<form class="needs-validation mt-5 " action="altaespectaculo" method="POST" novalidate>
   	
    
    <div class="form-row col-md-5 row-md-4 mb-4 mx-auto"> 	
<!--       <label class="mr-sm-2" for="inlineFormCustomSelect">Plataforma</label> -->
      <select class="custom-select" id="plat" name="plat">
      <option value="" selected>Elije la plataforma</option>
      <optgroup label="Plataformas:">
      <%
      Set<DtPlataforma> ListaPlataformas = Fabrica.getInstancia().getIPlataforma().listarPlataformas();
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
      <textarea class="form-control row-md-3" rows=5 id="Descripcion" placeholder="Descripción" id="descripcion" name="descripcion"></textarea>
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
  	HashSet<DtCategoria> Categorias = Fabrica.getInstancia().getICategoria().listarCategorias();
    Iterator<DtCategoria> itrc = Categorias.iterator();
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
    <% ;} %>	
  </ul>
   </div> 
    <div class="form-row col-md-5 mb-4 mx-auto">
  		<input type="file" class="custom-file-input" id="customFileLang" lang="es" name="imagen">
  		<label class="custom-file-label" for="customFileLang">Seleccionar Archivo</label>
	</div>
	
	<div class="form-row col-md-5 mb-4 mx-auto">
  		<button class="btn btn-primary" style="width: 100%;" type="submit" value="Acceder" onclick="submit()">Crear Espectaculo!</button>
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
</body>
</html>