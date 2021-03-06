package com.coronatickets.controllers;
import java.util.LinkedHashMap;
import java.util.Map; 
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;
import java.util.Set;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import webservices.*;
/**
 * Servlet implementation class Home
 */




public class Busqueda extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Busqueda() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	/**
	 * Devuelve el estado de la sesión
	 * @param request
	 */
	private void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		webservices.PublicadorService service = new webservices.PublicadorService();
    	webservices.Publicador port = service.getPublicadorPort();
		
		String search;
		List<DtUsuario> usufilt;
		List<DtEspectaculoDatos> especfilt;
		List<DtPaqueteDatos> paqfilt;
		
		if(request.getParameter("s") == null) {
			if(request.getParameter("search") != null) {
				search = request.getParameter("search");
				usufilt = port.filtrarUsuarios(search).getUsuarios();
				especfilt = port.filtrarEspectaculos(search).getEspecs();
				paqfilt = port.filtrarPaquetes(search).getPaqs();	
				}
			else {
				usufilt = port.filtrarUsuarios("").getUsuarios();
				especfilt = port.filtrarEspectaculos("").getEspecs();
				paqfilt = port.filtrarPaquetes("").getPaqs();
			}
		}
		else {
			search = (String) request.getParameter("s");
			usufilt = port.filtrarUsuarios(search).getUsuarios();
			especfilt = port.filtrarEspectaculos(search).getEspecs();
			paqfilt = port.filtrarPaquetes(search).getPaqs();
		}
		System.out.print("el largo de los paqs es " + paqfilt.size() );

		//Filtros
		Boolean FiltroCategorias = request.getParameterValues("checked") != null;
		Boolean FiltroPlataforma = request.getParameter("plat") != null && request.getParameter("plat") != "";
		if(FiltroPlataforma) {
			String Plat = (String) request.getParameter("plat");
			List<DtEspectaculoDatos> copiaespecs = new LinkedList<DtEspectaculoDatos>(especfilt);
			for(DtEspectaculoDatos dtespecd : copiaespecs) {
				if(!port.getPlataformaDeEspectaculo(dtespecd.getNombre()).equalsIgnoreCase(Plat))
					especfilt.remove(dtespecd);
			}
		}
		
		if(FiltroCategorias) {
			Set<String> cats = new HashSet<String>();
		    String[] values = request.getParameterValues("checked");
		    for (int i = 0; i < values.length; i++) {
		    	  cats.add(values[i]);
		    }
		    List<DtEspectaculoDatos> copiaespecs = new LinkedList<DtEspectaculoDatos>(especfilt);
		    for(DtEspectaculoDatos dtespec : copiaespecs) {
				String nombreplat = port.getPlataformaDeEspectaculo(dtespec.getNombre());
				List<DtCategoria> listauxcat = port.listarCategoriasDeEspectaculo(nombreplat, dtespec.getNombre()).getCategorias(); 
				Set<DtCategoria> categoriasespec =  new HashSet<DtCategoria>(listauxcat);
				for(String cat : cats) {
					DtCategoria dtcat = port.getDtCategoria(cat);
					Boolean tiene = false;
					for(DtCategoria aux : categoriasespec) {
						if(aux.getNomCategoria().equalsIgnoreCase(dtcat.getNomCategoria())) {
							tiene=true;
							break;	
						}
					}
					if(!tiene)
						especfilt.remove(dtespec);
				}
			}
		}
		
		
		//Si pidieron orden
		if(request.getParameter("orden") != null) {
			String orden = (String) request.getParameter("orden");
			if(orden.equalsIgnoreCase("alf")) {
				especfilt.sort((x, y) -> x.getNombre().compareToIgnoreCase(y.getNombre()));
				paqfilt.sort((x, y) -> x.getNombre().compareToIgnoreCase(y.getNombre()));
				usufilt.sort((x, y) -> x.getNombre().compareToIgnoreCase(y.getNombre()));
			}
			else if(orden.equalsIgnoreCase("date")) {
				especfilt.sort((x,y) -> y.getRegistro().compare(x.getRegistro()));
				paqfilt.sort((x,y) -> y.getInicio().compare(x.getInicio()));
				usufilt.sort((x,y) -> y.getNacimiento().compare(x.getNacimiento()));
			}
		}
		
		request.setAttribute("UsuariosFiltrados", usufilt);
		request.setAttribute("EspectaculosFiltrados", especfilt);
		request.setAttribute("PaquetesFiltrados", paqfilt);
		request.getRequestDispatcher("/WEB-INF/busqueda.jsp").forward(request, response);
	}
	

	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Login.ActualizarUltimoIngreso(request);
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Login.ActualizarUltimoIngreso(request);
		processRequest(request, response);
		/*System.out.print("LLego al servlet");
		response.setContentType( "text/html; charset=iso-8859-1" );
		PrintWriter out = response.getWriter();
		String search = request.getParameter("Search");
		System.out.print("search: " + search);
		Set<DtUsuario> UsuariosFiltrados = Fabrica.getInstancia().getIUsuario().filtrarUsuarios(search); 
		System.out.print("tamanio: " + UsuariosFiltrados.size());
		for(DtUsuario dtusu : UsuariosFiltrados) {
			System.out.print("llego al for");
			out.println("<h1>Nombre: " + dtusu.getNickname() + "</h1>");
		}
		*/
	}

}