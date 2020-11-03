<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@page import="controladores.Fabrica" %>
  <%@page import="com.coronatickets.controllers.Login" %>
  <%@page import="datatypes.DtUsuario" %>
  <%@page import="datatypes.DtPlataforma" %>
  <%@page import="datatypes.DtCategoria" %>
  <%@page import="controladores.Fabrica" %>
  <%@page import="java.util.Set" %>
  <%@page import="java.util.Iterator" %>
  <%@page import="datatypes.EstadoSesion" %>
  <%@page import="com.coronatickets.controllers.Login" %>
<!-- INICIO MENU LATERAL -->
        <!-- Sidebar  -->
        <nav id="sidebar">
            <div class="sidebar-header">
                <h4><a href="/home">CORONATICKETS</a></h4>
            </div>

            <ul class="list-unstyled components">
            <%
            	if (request.getSession().getAttribute("usuario_logueado")!=null && request.getSession().getAttribute("estado_sesion")!=null && ((EstadoSesion) request.getSession().getAttribute("estado_sesion")==EstadoSesion.LOGIN_CORRECTO)){
            		
            		DtUsuario usuario = Login.getUsuarioLogueado(request);
            		if(Fabrica.getInstancia().getIUsuario().esArtista(usuario.getNickname())){
            %>
            	<li>
            	<a href="#accionesSubmenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">ACCIONES</a>
                    <ul class="collapse list-unstyled" id="accionesSubmenu">
                        <li>
                            <a href="/altapaquete">Alta Paquete</a>
                            <a href="/altaespectaculo">Alta Espectaculo</a>
                            <a href="/altafuncion" ">Alta Funcion</a>
                            <a href="#">Agregar Espectaculo a Paquete</a>
                        </li>
                    </ul>
            	</li>
            	<% }} %>
                <li>
                    <a href="#plataformasSubmenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">PLATAFORMAS</a>
                    <ul class="collapse list-unstyled" id="plataformasSubmenu">
                    <% Set<DtPlataforma> plataformas = Fabrica.getInstancia().getIPlataforma().listarPlataformas();
                    Iterator<DtPlataforma> itrp = plataformas.iterator();
							while(itrp.hasNext())
								{DtPlataforma auxp = itrp.next();%>
                        <li>
                            <a href="/home?plataforma=<%= auxp.getNombre() %>"><%= auxp.getNombre() %></a>
                        </li>
                        <% } %>
                    </ul>
                </li>
                <li>
                    <a href="#categoriasSubmenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">CATEGORIAS</a>
                    <ul class="collapse list-unstyled" id="categoriasSubmenu">
                        <% Set<DtCategoria> categorias = Fabrica.getInstancia().getICategoria().listarCategorias();
                    Iterator<DtCategoria> itrc = categorias.iterator();
							while(itrc.hasNext())
								{DtCategoria auxc = itrc.next();%>
                        <li>
                            <a href="/home?categoria=<%= auxc.getNomCategoria() %>"><%= auxc.getNomCategoria() %></a>
                        </li>
                        <% } %>
                        
                    </ul>
                </li>
            </ul>

           <!--
           NO LO BORRO POR LAS DUDAS, MAYBE LUEGO NOS SIRVE
             <ul class="list-unstyled CTAs">
                <li>
                    <a href="https://bootstrapious.com/tutorial/files/sidebar.zip" class="download">Download source</a>
                </li>
                <li>
                    <a href="https://bootstrapious.com/p/bootstrap-sidebar" class="article">Back to article</a>
                </li>
            </ul>  -->
        </nav>
		<!-- FIN MENU LATERAL -->

		