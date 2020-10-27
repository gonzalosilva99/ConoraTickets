package com.coronatickets.controllers;

import java.io.IOException;
import java.io.PrintWriter;
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
import DataTypes.DtCategoria;
import DataTypes.EstadoSesion;
import Excepciones.Identidad;
/**
 * Servlet implementation class Home
 */
public class AltaEspectaculo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaEspectaculo() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	/**
	 * Devuelve el estado de la sesión
	 * @param request
	 */
	private void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String nombre = request.getParameter("Nombre");
		request.getRequestDispatcher("/WEB-INF/altaespectaculo.jsp").forward(request,response);
		String plat = request.getParameter("plat");
	    String descripcion = request.getParameter("descripcion");
	    String min = request.getParameter("espmin");
	    String max = request.getParameter("espmax");
	    String costo = request.getParameter("costo");
	    String duracion = request.getParameter("duracion");
	    String url = request.getParameter("url");
	    String imagen = request.getParameter("imagen");
	    Set<String> cats = new HashSet<String>();
	    String[] values = request.getParameterValues("checked");
	    for (int i = 0; i < values.length; i++) {
	    	  cats.add(values[i]);
	    	}
	    java.util.Date fechaactual = new Date();
	    try {
	    	Fabrica.getInstancia().getIPlataforma().altaEspectaculo(plat, "sa", nombre, descripcion, Integer.parseInt(min), Integer.parseInt(max), url, Integer.parseInt(costo), fechaactual, Integer.parseInt(duracion), imagen, cats);
	    }
	    catch (Exception e) {
			e.printStackTrace();
		}
		}
			
	
	
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/altaespectaculo.jsp").forward(request,response);
		//processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}