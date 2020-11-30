package com.coronatickets.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import webservices.EstadoSesion;
/**
 * Servlet implementation class Home
 */
public class MobileHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MobileHome() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	/**
	 * Devuelve el estado de la sesión
	 * @param request
	 */
	private void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//String nombrePlataforma = (String) request.getParameter("plataforma");
		//request.setAttribute("plat",Fabrica.getInstancia().getIPlataforma().findDatosEspectaculo(nombreEspectaculo));	
		webservices.PublicadorService service = new webservices.PublicadorService();
    	webservices.Publicador port = service.getPublicadorPort();
		if (request.getSession().getAttribute("usuario_logueado")!=null && request.getSession().getAttribute("estado_sesion")!=null && ((EstadoSesion) request.getSession().getAttribute("estado_sesion")==EstadoSesion.LOGIN_CORRECTO)) {
			webservices.DtUsuario usuario = Login.getUsuarioLogueado(request);
    		if(!port.esArtista(usuario.getNickname()))
				request.getRequestDispatcher("/WEB-INF/mobilehome.jsp").forward(request, response);
			else
				response.sendRedirect("/mobilelogin");
    			
		}else
			response.sendRedirect("/mobilelogin");
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
	}

}