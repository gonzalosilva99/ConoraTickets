package com.coronatickets.controllers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Controladores.Fabrica;
import DataTypes.EstadoSesion;
import Excepciones.Identidad;

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
            HttpServletResponse response) throws ServletException, IOException, Identidad {
		
		
		String nombre = request.getParameter("nombrepaquete");
	    String descripcion = request.getParameter("descripcion");
	    String  fechaini = request.getParameter("dateFechaInicio");
	    String fechafin = request.getParameter("dateFechaFin");
	    String porcentaje = request.getParameter("porcentaje");
	    String imagen = request.getParameter("imagen");
	    SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd"); 
		
	
		try {
			Date fechaf = formato.parse(fechafin);
			Date fechai = formato.parse(fechaini);
			double d = Double.parseDouble(porcentaje);  
		    java.util.Date fechaactual = new Date();
			Fabrica.getInstancia().getIPaquete().ConfirmarAltaPaquete(nombre, descripcion, fechai, fechaf, d, fechaactual, imagen);
			System.out.print("tamo aca");
	    	request.setAttribute("aceptado", "true");
	    	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/altapaquete.jsp");
			dispatcher.forward(request, response);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			request.setAttribute("aceptado", e.getMessage());
	    	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/altapaquete.jsp");
			dispatcher.forward(request, response);
		}

		
		
		
		
		
	}
    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Login.ActualizarUltimoIngreso(request);
		
		if (Fabrica.getInstancia().getIUsuario().existeNickname((String) request.getSession().getAttribute("usuario_logueado")) && Fabrica.getInstancia().getIUsuario().EsArtista((String) request.getSession().getAttribute("usuario_logueado"))) request.getRequestDispatcher("/WEB-INF/altapaquete.jsp").forward(request, response);
		
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
		} catch (Identidad e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

        

}
