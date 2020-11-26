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

import webservices.PublicadorService;
import webservices.Publicador;

/**
 * Servlet implementation class Home
 */
public class Perfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Perfil() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	/**
	 * Devuelve el estado de la sesión
	 * @param request
	 */
	private void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 	webservices.PublicadorService service = new webservices.PublicadorService();
	    	webservices.Publicador port = service.getPublicadorPort();
		String nickname = (String) request.getParameter("id");
		if(nickname==null) {
			if(request.getSession().getAttribute("estado_sesion")==webservices.EstadoSesion.LOGIN_CORRECTO) {
				nickname = (String) request.getSession().getAttribute("usuario_logueado");
			}
			else {
				//LLEVAR A ERROR
			}
		}
		if(port.existeNickname(nickname)) {
			if(port.esArtista(nickname)) {
				request.setAttribute("tipo_usuario", "Artista");
				request.setAttribute("usuario_perfil",port.perfilArtista(nickname));
			}
			else {
				request.setAttribute("tipo_usuario", "Espectador");
				request.setAttribute("usuario_perfil",port.perfilEspectador(nickname));
			}
			request.getRequestDispatcher("/WEB-INF/perfil.jsp").forward(request, response);
		}
		else {
			//LLEVAR A ERROR
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ENTRO AL SERVLET EL POST");
		Login.ActualizarUltimoIngreso(request);
		webservices.PublicadorService service = new webservices.PublicadorService();
    	webservices.Publicador port = service.getPublicadorPort();
		
		String usuarioLogueado = request.getParameter("userlogged");
		String usuarioPerfil = request.getParameter("userprofile");
		String tipo = request.getParameter("tipo");
		
		System.out.println("Seguidor: " + usuarioLogueado.toString() + ", Seguido: " + usuarioPerfil.toString() + ", Tipo: " + tipo.toString());
		if(tipo!=null && usuarioLogueado!=null && usuarioPerfil!=null) {
			System.out.println("Seguidor: " + usuarioLogueado + ", Seguido: " + usuarioPerfil + ", Tipo: " + tipo);
			if(tipo.equals("follow")) {
				//System.out.println("Va a seguir");
				try{
					port.seguirUsuario(usuarioLogueado, usuarioPerfil);
					response.getWriter().write("SUCCESS");
				}
				catch(Exception e) {
					response.getWriter().write("ERROR " + e.getMessage());
				}
				//System.out.println("SEGUIDO: "+usuarioLogueado+" "+usuarioPerfil+" "+tipo);
			}
			else if(tipo.equals("unfollow")) {
				try {
					System.out.println("ENTRA A UNFOLLOW");
					port.dejarSeguirUsuario(usuarioLogueado, usuarioPerfil);
					response.getWriter().write("SUCCESS");
				}
				catch(Exception e){
					response.getWriter().write("ERROR " + e.getMessage());
				}
						
			}
		}
	}

}