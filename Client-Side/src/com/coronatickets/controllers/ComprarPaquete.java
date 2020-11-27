package com.coronatickets.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import webservices.EstadoSesion;
import webservices.TipoRegistro;
/**
 * Servlet implementation class Home
 */
public class ComprarPaquete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComprarPaquete() {
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
		if(request.getSession().getAttribute("estado_sesion")==EstadoSesion.LOGIN_CORRECTO && request.getSession().getAttribute("usuario_logueado")!=null && !port.esArtista((String) request.getSession().getAttribute("usuario_logueado"))
				/*&& request.getAttribute("nomespectaculo")!=null && request.getAttribute("funcion")!=null*/) {
			request.getRequestDispatcher("/WEB-INF/comprarpaquete.jsp").forward(request, response);
		}
		else {
			response.sendRedirect("/home");
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
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		webservices.PublicadorService service = new webservices.PublicadorService();
    	webservices.Publicador port = service.getPublicadorPort();
		Login.ActualizarUltimoIngreso(request);
		response.setContentType("text/plain"); // Using text/plain for example
		   response.setCharacterEncoding("UTF-8");
		   try {
			   String usuario = (String) request.getSession().getAttribute("usuario_logueado");
			   String paquete = (String) request.getParameter("paquete");
			   GregorianCalendar aux = new GregorianCalendar();
			   Date fecha = new Date();
				aux.setTime(fecha);
				XMLGregorianCalendar fef = DatatypeFactory.newInstance().newXMLGregorianCalendar(aux);	   
			   if(paquete != null  && usuario != null) {
				   System.out.print("que carajos pasa");
				   port.comprarPaquete(usuario, paquete, fef);				  
			   }
			   response.getWriter().write("SUCCESS");
		   }
		   catch(Exception e) {
			   response.getWriter().write("FAIL" + e.getMessage());
		   }
	}

}