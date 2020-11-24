package com.coronatickets.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controladores.Fabrica;
import interfaces.IPlataforma;
import webservices.EstadoSesion;
/**
 * Servlet implementation class Home
 */
public class ConsultaPaquete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultaPaquete() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	/**
	 * Devuelve el estado de la sesión
	 * @param request
	 */
	private void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nombrePaquete = (String) request.getParameter("nompaquete");
		request.setAttribute("paquete",Fabrica.getInstancia().getIPaquete().getPaqueteDatos(nombrePaquete));	
		request.getRequestDispatcher("/WEB-INF/consultapaquete.jsp").forward(request, response);
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
		try {
			String usuario =  (String) request.getSession().getAttribute("usuario_logueado");
			String paquete = (String) request.getParameter("paquete");
			String espectaculo = (String) request.getParameter("espectaculo");
			String plataforma = Fabrica.getInstancia().getIPlataforma().getPlataformaDeEspectaculo(espectaculo);
			//System.out.println(usuario + " " + paquete + " " + espectaculo + " " + plataforma);
			if((EstadoSesion) request.getSession().getAttribute("estado_sesion")==EstadoSesion.LOGIN_CORRECTO && usuario!=null && paquete != null && espectaculo!=null) {
				Fabrica.getInstancia().getIPaquete().confirmarAgregarEspectaculoPaquete(paquete, plataforma, espectaculo);
				response.getWriter().write("SUCCESS");
			}
			else {
				response.getWriter().write("Fail, verificar que su sesión esta iniciada, y el espectáculo o el paquete aún existen");
			}
		}
		catch(Exception e) {
			response.getWriter().write("ERROR. "+e.getMessage());
		}
	}

}