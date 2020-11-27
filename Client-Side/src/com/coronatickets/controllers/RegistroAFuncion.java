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

import webservices.EstadoSesion;
import webservices.TipoRegistro;
/**
 * Servlet implementation class Home
 */
public class RegistroAFuncion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistroAFuncion() {
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
			request.getRequestDispatcher("/WEB-INF/registroafuncion.jsp").forward(request, response);
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
		Login.ActualizarUltimoIngreso(request);
		webservices.PublicadorService service = new webservices.PublicadorService();
    	webservices.Publicador port = service.getPublicadorPort();
		response.setContentType("text/plain"); // Using text/plain for example
		   response.setCharacterEncoding("UTF-8");
		   try {
			   String usuario = (String) request.getSession().getAttribute("usuario_logueado");
			   String plataforma = (String) request.getParameter("plataforma");
			   String espectaculo = (String) request.getParameter("espectaculo");
			   Date fecha = new Date();
			   String funcion = (String) request.getParameter("funcion");
			   int tiporegistro = Integer.parseInt((String) request.getParameter("tiporegistro"));
			   System.out.println("Usuario: " + usuario + " TipoRegistro: " + tiporegistro);
			   System.out.println("Plataforma: " + plataforma + " Espectaculo: "+ espectaculo + " Funcion: "+funcion+ " Fecha: "+fecha.toString());
			   Double costo = port.getDatosEspectaculo(plataforma, espectaculo).getCosto().doubleValue();
			   if(plataforma != null && espectaculo != null && funcion != null && usuario != null) {
				   System.out.println("Entra al primer if");
				   if(tiporegistro==1) {
					   GregorianCalendar auxgc = new GregorianCalendar();
					   auxgc.setTime(fecha);
					   port.confirmarRegistroFuncionEspectaculo(plataforma, espectaculo, usuario, funcion, DatatypeFactory.newInstance().newXMLGregorianCalendar(auxgc), TipoRegistro.TIPO_1, 0, 0, 0, "", costo);
					   System.out.println("REGISTRO 1 REALIZADO");
				   }
				   else if(tiporegistro==2) {
					   int valor1 = Integer.parseInt((String) request.getParameter("valor1"));
					   int valor2 = Integer.parseInt((String) request.getParameter("valor2"));
					   int valor3 = Integer.parseInt((String) request.getParameter("valor3"));
					   System.out.println("Valores de Registros: " + valor1 + " "+ valor2 + " " + valor3);
					   GregorianCalendar auxgc = new GregorianCalendar();
					   auxgc.setTime(fecha);
					   port.confirmarRegistroFuncionEspectaculo(plataforma, espectaculo, usuario, funcion, DatatypeFactory.newInstance().newXMLGregorianCalendar(auxgc), TipoRegistro.TIPO_2, valor1, valor2, valor3, "", costo);
					   System.out.println("REGISTRO 2 REALIZADO");
				   }
				   else if(tiporegistro==3) {
					   String paquete = request.getParameter("paquete");
					   System.out.println("Paquete: "+ paquete + " TipoRegistro: "+request.getParameter("tiporegistro"));
					   GregorianCalendar auxgc = new GregorianCalendar();
					   auxgc.setTime(fecha);
					   port.confirmarRegistroFuncionEspectaculo(plataforma, espectaculo, usuario, funcion, DatatypeFactory.newInstance().newXMLGregorianCalendar(auxgc), TipoRegistro.TIPO_3, 0, 0, 0, paquete, costo);
				   }
			   }
			   response.getWriter().write("SUCCESS");
		   }
		   catch(Exception e) {
			   response.getWriter().write("FAIL" + e.getMessage());
		   }
	}

}