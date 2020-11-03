package com.coronatickets.controllers;
import java.util.LinkedHashMap; 
import datatypes.DtUsuario;
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

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

import datatypes.DtUsuario;import datatypes.DtCategoria;
import datatypes.DtEspectaculoDatos;
import datatypes.DtPaqueteDatos;
import controladores.Fabrica;
import datatypes.EstadoSesion;

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
		String search;
		LinkedList<DtUsuario> usufilt;
		LinkedList<DtEspectaculoDatos> especfilt;
		LinkedList<DtPaqueteDatos> paqfilt;
		
		if(request.getParameter("s") == null) {
			if(request.getParameter("search") != null) {
				search = (String) request.getParameter("search");
				usufilt = new LinkedList<DtUsuario>(Fabrica.getInstancia().getIUsuario().filtrarUsuarios(search));
				especfilt = new LinkedList<DtEspectaculoDatos>(Fabrica.getInstancia().getIPlataforma().filtrarEspectaculos(search));
				paqfilt = new LinkedList<DtPaqueteDatos>(Fabrica.getInstancia().getIPaquete().filtrarPaquetes(search));
				Boolean FiltroCategorias = request.getParameterValues("checked") != null;
				Boolean FiltroPlataforma = request.getParameter("plat") != null && request.getParameter("plat") != "";
				if(FiltroPlataforma) {
					String Plat = (String) request.getParameter("plat");
					List<DtEspectaculoDatos> copiaespecs = new LinkedList<DtEspectaculoDatos>(especfilt);
					for(DtEspectaculoDatos dtespecd : copiaespecs) {
						if(!Fabrica.getInstancia().getIPlataforma().getPlataformaDeEspectaculo(dtespecd.getNombre()).equalsIgnoreCase(Plat))
							especfilt.remove(dtespecd);
					}
				}
				if(FiltroCategorias) {
					System.out.print("Filtro categorias");
					Set<String> cats = new HashSet<String>();
				    String[] values = request.getParameterValues("checked");
				    for (int i = 0; i < values.length; i++) {
				    	  cats.add(values[i]);
				    }
				    List<DtEspectaculoDatos> copiaespecs = new LinkedList<DtEspectaculoDatos>(especfilt);
				    for(DtEspectaculoDatos dtespec : copiaespecs) {
						String nombreplat = Fabrica.getInstancia().getIPlataforma().getPlataformaDeEspectaculo(dtespec.getNombre());
						HashSet<DtCategoria> categoriasespec =  Fabrica.getInstancia().getIPlataforma().listarCategoriasDeEspectaculo(nombreplat,dtespec.getNombre());
						for(DtCategoria cat : categoriasespec) {
							if(!cats.contains(cat.getNomCategoria())) {
								especfilt.remove(dtespec);
								break;
							}
						}
					}
				}
			}
			else {
				usufilt = new LinkedList<DtUsuario>(Fabrica.getInstancia().getIUsuario().filtrarUsuarios(""));
				especfilt = new LinkedList<DtEspectaculoDatos>(Fabrica.getInstancia().getIPlataforma().filtrarEspectaculos(""));
				paqfilt = new LinkedList<DtPaqueteDatos>(Fabrica.getInstancia().getIPaquete().filtrarPaquetes(""));
			}
		}
		else {
			search = (String) request.getParameter("s");
			usufilt = new LinkedList<DtUsuario>(Fabrica.getInstancia().getIUsuario().filtrarUsuarios(search));
			especfilt = new LinkedList<DtEspectaculoDatos>(Fabrica.getInstancia().getIPlataforma().filtrarEspectaculos(search));
			paqfilt = new LinkedList<DtPaqueteDatos>(Fabrica.getInstancia().getIPaquete().filtrarPaquetes(search));
		}

		//Si pidieron orden
		if(request.getParameter("orden") != null) {
			String orden = (String) request.getParameter("orden");
			if(orden.equalsIgnoreCase("alf")) {

				System.out.println("Vino a ordenar");
				especfilt.sort((x, y) -> x.getNombre().compareToIgnoreCase(y.getNombre()));
				paqfilt.sort((x, y) -> x.getNombre().compareToIgnoreCase(y.getNombre()));
				usufilt.sort((x, y) -> x.getNombre().compareToIgnoreCase(y.getNombre()));
			}
			else if(orden.equalsIgnoreCase("date")) {
			}
		}
		System.out.print("El largo de los paquetes es: " + paqfilt.size());
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