package com.coronatickets.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import webservices.ArrayEspectadores;
import webservices.DtEspectador;
import webservices.EstadoSesion;
import java.util.List;
import java.util.LinkedList;
import java.util.LinkedHashMap;

/**
 * Servlet implementation class Home
 */
public class MobileConsultaEspectaculo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MobileConsultaEspectaculo() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	/**
	 * Devuelve el estado de la sesión
	 * @param request
	 */
	private void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nombreEspectaculo = (String) request.getParameter("nomespectaculo");
		if(nombreEspectaculo!=null) {
			webservices.PublicadorService service = new webservices.PublicadorService();
	    	webservices.Publicador port = service.getPublicadorPort();
			request.setAttribute("espectaculo",port.findDatosEspectaculo(nombreEspectaculo));	
			request.getRequestDispatcher("/WEB-INF/mobileconsultaespectaculo.jsp").forward(request, response);
		}
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
		//processRequest(request, response);
		try {
			webservices.PublicadorService service = new webservices.PublicadorService();
	    	webservices.Publicador port = service.getPublicadorPort();
			String tipoPost = (String) request.getParameter("tipoPost");
			String usuario =  (String) request.getSession().getAttribute("usuario_logueado");
			if(tipoPost.equals("anadirPaquetes")) {
				String paquete = (String) request.getParameter("paquete");
				String espectaculo = (String) request.getParameter("espectaculo");
				String plataforma = port.getPlataformaDeEspectaculo(espectaculo);
				//System.out.println(usuario + " " + paquete + " " + espectaculo + " " + plataforma);
				if((EstadoSesion) request.getSession().getAttribute("estado_sesion")==EstadoSesion.LOGIN_CORRECTO && usuario!=null && paquete != null && espectaculo!=null) {
					port.confirmarAgregarEspectaculoPaquete(paquete, plataforma, espectaculo);
					response.getWriter().write("SUCCESS");
				}
				else {
					response.getWriter().write("Fail, verificar que su sesión esta iniciada, y el espectáculo o el paquete aún existen");
				}
			}
			else if (tipoPost.equals("sortearPremios")) {
				String plataforma = (String) request.getParameter("plataforma");
				String espectaculo = (String) request.getParameter("espectaculo");
				String funcion = (String) request.getParameter("funcion");
				if(funcion != null && espectaculo != null && plataforma != null) {
					System.out.println(plataforma + " " + espectaculo + " " + funcion);
					ArrayEspectadores ganadoresPremio = port.sortearPremios(plataforma, espectaculo, funcion);
					String ganadores = "";
					Iterator<DtEspectador> itrespectadores = ganadoresPremio.getEspectaculos().iterator();
					while (itrespectadores.hasNext()) {
						DtEspectador nuevo = itrespectadores.next();
						ganadores = ganadores + "\t" + nuevo.getNickname() + "\t" + nuevo.getNombre() + " " + nuevo.getApellido() + "\n";
					}
					response.getWriter().write("Ganadores: \n"+ganadores);
				}
			}
			
		}
		catch(Exception e) {
			response.getWriter().write("ERROR. "+e.getMessage());
		}
	}
	
	private void anadirPaquetes() {
		
	}

}