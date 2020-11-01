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

import Interfaces.IUsuario;
import Controladores.Fabrica;
import DataTypes.EstadoSesion;
import DataTypes.TipoRegistro;
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
		if(request.getSession().getAttribute("estado_sesion")==EstadoSesion.LOGIN_CORRECTO && request.getSession().getAttribute("usuario_logueado")!=null && !Fabrica.getInstancia().getIUsuario().EsArtista((String) request.getSession().getAttribute("usuario_logueado"))
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
		Login.ActualizarUltimoIngreso(request);
		response.setContentType("text/plain"); // Using text/plain for example
		   response.setCharacterEncoding("UTF-8");
		   try {
			   String usuario = (String) request.getSession().getAttribute("usuario_logueado");
			   String paquete = (String) request.getParameter("paquete");
			   Date fecha = new Date();
			   
			   if(paquete != null  && usuario != null) {
				   System.out.print("que carajos pasa");
				   Fabrica.getInstancia().getIUsuario().comprarPaquete(usuario, paquete, fecha);				  
			   }
			   response.getWriter().write("SUCCESS");
		   }
		   catch(Exception e) {
			   response.getWriter().write("FAIL" + e.getMessage());
		   }
	}

}