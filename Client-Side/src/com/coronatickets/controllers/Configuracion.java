package com.coronatickets.controllers;
import java.util.LinkedHashMap; 
import DataTypes.DtUsuario;
import java.util.Map; 
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;
import java.util.Set;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

import DataTypes.DtUsuario;
import DataTypes.DtCategoria;
import DataTypes.DtEspectaculoDatos;
import DataTypes.DtPaqueteDatos;
import Controladores.Fabrica;
import DataTypes.EstadoSesion;

/**
 * Servlet implementation class Home
 */




public class Configuracion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Configuracion() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	/**
	 * Devuelve el estado de la sesión
	 * @param request
	 */
	private void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/configuracion.jsp").forward(request, response);
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
	}
}
