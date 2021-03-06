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
import javax.xml.ws.Response;

import webservices.EstadoSesion;
/**
 * Servlet implementation class Home
 */
public class MobileLoginHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MobileLoginHome() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * inicializa la sesión si no estaba creada 
	 * @param request 
	 */
	public static void initSession(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("estado_sesion") == null) {
			session.setAttribute("estado_sesion", EstadoSesion.NO_LOGIN);
		}
	}
	
	/**
	 * Devuelve el estado de la sesión
	 * @param request
	 */
	private void processRequest(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		initSession(req);
		
		switch((EstadoSesion) req.getSession().getAttribute("estado_sesion")){
			case NO_LOGIN:
				// hace que se ejecute el jsp sin cambiar la url
				req.getRequestDispatcher("/WEB-INF/mobilelogin.jsp").
						forward(req, resp);
				break;
			case LOGIN_INCORRECTO:
				// hace que se ejecute el jsp sin cambiar la url
				PrintWriter writer = resp.getWriter();
				writer.println("Mal iniciada la sesion");
				try {
					wait(5000);
				}
				catch(Exception e) {}
				req.getRequestDispatcher("/WEB-INF/mobilelogin.jsp").
				forward(req, resp);
				//		forward(req, resp);
				break;
			case LOGIN_CORRECTO:
				webservices.PublicadorService service = new webservices.PublicadorService();
		    	webservices.Publicador port = service.getPublicadorPort();
		    	webservices.DtUsuario usuario = Login.getUsuarioLogueado(req);
		    	if(!port.esArtista(usuario.getNickname())) {
					// manda una redirección a otra URL (cambia la URL)
					RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/mobilehome.jsp");
			        dispatcher.forward(req, resp);
					break;
		    	}
		    	else {
		    		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/mobilelogin.jsp");
		    		dispatcher.forward(req, resp);
					break;
		    	}
		}
	}
	
	/**
	 * Devuelve el estado de la sesión
	 * @param request
	 * @return 
	 */
	public static EstadoSesion getEstado(HttpServletRequest request)
	{
		return (EstadoSesion) request.getAttribute("estado_sesion");
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