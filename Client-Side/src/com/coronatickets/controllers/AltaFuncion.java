package com.coronatickets.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Controladores.Fabrica;
import Interfaces.IPlataforma;
import DataTypes.DtEspectaculo;
import DataTypes.EstadoSesion;
import Excepciones.Identidad;
/**
 * Servlet implementation class Home
 */
public class AltaFuncion extends HttpServlet {
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	/*
	 * public AltaEspectaculo() { super(); // TODO Auto-generated constructor stub }
	 */
	
	/**
	 * Devuelve el estado de la sesión
	 * @param request
	 */
	private void processRequest(HttpServletRequest requestt, HttpServletResponse resp)
			throws ServletException, IOException {
		
	    try {

	    }
	    catch (Exception e) {
	    	System.out.println(e.getMessage());
		}
	}
			
	
	
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Login.ActualizarUltimoIngreso(request);
		if (request.getSession().getAttribute("usuario_logueado")!=null && request.getSession().getAttribute("estado_sesion")!=null && ((EstadoSesion) request.getSession().getAttribute("estado_sesion")==EstadoSesion.LOGIN_CORRECTO)){
			request.getRequestDispatcher("/WEB-INF/altafuncion.jsp").forward(request,response);
		}else {
			request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Login.ActualizarUltimoIngreso(request);
		System.out.println("ENTRO AL SERVLET EL POST");
		String usuarioLogueado = request.getParameter("userlogged");
		String plataforma = request.getParameter("plataforma");
		if(usuarioLogueado!=null && plataforma!=null) {
			  if (request.getParameter("actualizar").equals("true")) 
			  { 
				  Set<DtEspectaculo> espectaculosAceptados = Fabrica.getInstancia().getIPlataforma().
				  listarEspectaculosAceptadosDePlataforma(plataforma);
				  request.getSession().setAttribute("espectaculosAceptados", espectaculosAceptados); 
				  request.getSession().setAttribute("plataforma", plataforma); 
			  }
			  else 
			  {
				  
				  try {
					  SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
					  Date fechaFuncion = formato.parse(request.getParameter("fecha"));
					  Date fechaAlta = new Date();
					  Fabrica.getInstancia().getIPlataforma().ConfirmarAltaFuncionEspectaculo(request.getParameter("plataforma"), 
							  request.getParameter("espectaculo"), request.getParameter("funcion"), fechaFuncion, null , fechaAlta, "imagen");
					  request.getSession().setAttribute("exito", true); 
				  }catch (Exception e) {  
					  request.getSession().setAttribute("exito", false);
					  System.out.println("EXCEPCION ALTAFUNCION.JAVA LINEA 92 " + e.getMessage());
				  }
			}
			 
		}
		
	}

}