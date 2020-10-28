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
	    	String nombre = requestt.getParameter("Nombre");
			String plat = requestt.getParameter("plat");
		    String descripcion = requestt.getParameter("descripcion");
		    String min = requestt.getParameter("espmin");
		    String max = requestt.getParameter("espmax");
		    String costo = requestt.getParameter("costo");
		    String duracion = requestt.getParameter("duracion");
		    String url = requestt.getParameter("url");
		    String imagen = requestt.getParameter("imagen");
		    Set<String> cats = new HashSet<String>();
		    String[] values = requestt.getParameterValues("checked");
		    for (int i = 0; i < values.length; i++) {
		    	  cats.add(values[i]);
		    	}
		    java.util.Date fechaactual = new Date();
	    	Fabrica.getInstancia().getIPlataforma().altaEspectaculo(plat, "alcides", nombre, descripcion, Integer.parseInt(min), Integer.parseInt(max), url, Integer.parseInt(costo), fechaactual, Integer.parseInt(duracion), imagen, cats);	    	
	    	RequestDispatcher dispatcher = requestt.getRequestDispatcher("home");
			dispatcher.forward(requestt, resp);
	    }
	    catch (Exception e) {
			requestt.getRequestDispatcher("/WEB-INF/altaespectaculo.jsp").forward(requestt,resp);
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