package com.coronatickets.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import controladores.Fabrica;
import interfaces.IPlataforma;
import datatypes.DtCategoria;
import datatypes.EstadoSesion;
import excepciones.Identidad;
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
	    	GregorianCalendar aux = new GregorianCalendar();
	    	webservices.PublicadorService service = new webservices.PublicadorService();
	    	webservices.Publicador port = service.getPublicadorPort();
	    	String nombre = requestt.getParameter("Nombre");
			String plat = requestt.getParameter("plat");
		    String descripcion = requestt.getParameter("descripcion");
		    String min = requestt.getParameter("espmin");
		    String max = requestt.getParameter("espmax");
		    String costo = requestt.getParameter("costo");
		    String duracion = requestt.getParameter("duracion");
		    String url = requestt.getParameter("url");
		    String imagen = requestt.getParameter("imagen");
		    List<webservices.DtCategoria> lcat = new ArrayList<webservices.DtCategoria>();
		    String[] values = requestt.getParameterValues("checked");
		    if(values!=null) {
		    for (int i = 0; i < values.length; i++) {
		    	  webservices.DtCategoria auxx = new webservices.DtCategoria();
		    	  auxx.setNomCategoria(values[i]);
		    	  lcat.add(auxx);
		    }
		    }
		   
		    webservices.ArrayCategorias cate = new webservices.ArrayCategorias();
		    java.util.Date fechaactual = new Date();
		    aux.setTime(fechaactual);
			XMLGregorianCalendar fef = DatatypeFactory.newInstance().newXMLGregorianCalendar(aux);
	    	port.altaEspectaculo(plat, (String) requestt.getSession().getAttribute("usuario_logueado"), nombre, descripcion, Integer.parseInt(min), Integer.parseInt(max), url, Integer.parseInt(costo), fef, Integer.parseInt(duracion), imagen, cate, "", "", 0);	    		    	
	    	//requestt.setAttribute("id", (String) requestt.getParameter("id"));
	    	requestt.setAttribute("aceptado", "true");
	    	RequestDispatcher dispatcher = requestt.getRequestDispatcher("/WEB-INF/altaespectaculo.jsp");
			dispatcher.forward(requestt, resp);
	    }
	    catch (Exception e) {
	    	requestt.setAttribute("aceptado", e.getMessage());
	    	RequestDispatcher dispatcher = requestt.getRequestDispatcher("/WEB-INF/altaespectaculo.jsp");
			dispatcher.forward(requestt, resp);
		}
		}
			
	
	
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Login.ActualizarUltimoIngreso(request);
		request.getRequestDispatcher("/WEB-INF/altaespectaculo.jsp").forward(request,response);
		//processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Login.ActualizarUltimoIngreso(request);
		processRequest(request, response);
	}

}