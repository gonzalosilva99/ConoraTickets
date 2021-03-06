package com.coronatickets.controllers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import webservices.Identidad;
import webservices.Identidad_Exception;

/**
 * Servlet implementation class AltaPaquete
 */
@WebServlet("/AltaPaquete")
public class AltaPaquete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaPaquete() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void processRequest(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException, Identidad_Exception {
		
		
		String nombre = request.getParameter("nombrepaquete");
	    String descripcion = request.getParameter("descripcion");
	    String  fechaini = request.getParameter("dateFechaInicio");
	    String fechafin = request.getParameter("dateFechaFin");
	    String porcentaje = request.getParameter("porcentaje");
	    String imagen = request.getParameter("imagen");
	    SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd"); 
		
	
		try {
			GregorianCalendar aux = new GregorianCalendar();
			Date fechaf = formato.parse(fechafin);
			aux.setTime(fechaf);
			XMLGregorianCalendar fef = DatatypeFactory.newInstance().newXMLGregorianCalendar(aux);
			Date fechai = formato.parse(fechaini);
			aux.setTime(fechai);
		    XMLGregorianCalendar fei = DatatypeFactory.newInstance().newXMLGregorianCalendar(aux);
			double d = Double.parseDouble(porcentaje);  
		    java.util.Date fechaactual = new Date();
		    aux.setTime(fechaactual);
		    XMLGregorianCalendar fea = DatatypeFactory.newInstance().newXMLGregorianCalendar(aux);
		    webservices.PublicadorService service = new webservices.PublicadorService();
	    	webservices.Publicador port = service.getPublicadorPort();
	    	
			if (fechai.before(fechaf)) {port.confirmarAltaPaquete(nombre, descripcion, fei, fef, d, fea, imagen); 
			request.setAttribute("aceptado", "true");}
			
			else request.setAttribute("fechainvalida", "true");
	    
	    	
	    	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/altapaquete.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			request.setAttribute("si", "true");
	    	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/altapaquete.jsp");
			dispatcher.forward(request, response);
		}

		
		
		
		
		
	}
    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		webservices.PublicadorService service = new webservices.PublicadorService();
    	webservices.Publicador port = service.getPublicadorPort();
		Login.ActualizarUltimoIngreso(request);
		request.setAttribute("aceptado", "false");
		request.setAttribute("si", "false");
		request.setAttribute("fechainvalida", "false");
		if (port.existeNickname((String) request.getSession().getAttribute("usuario_logueado")) && port.esArtista((String) request.getSession().getAttribute("usuario_logueado"))) request.getRequestDispatcher("/WEB-INF/altapaquete.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Login.ActualizarUltimoIngreso(request);
		try {
			processRequest(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (webservices.Identidad_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

        

}
