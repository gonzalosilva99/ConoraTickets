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

import interfaces.IUsuario;
import controladores.Fabrica;
import datatypes.EstadoSesion;
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
		String nickname = (String) request.getParameter("id");
		if(nickname==null) {
			if(request.getSession().getAttribute("estado_sesion")==EstadoSesion.LOGIN_CORRECTO) {
				nickname = (String) request.getSession().getAttribute("usuario_logueado");
			}
			else {
				//LLEVAR A ERROR
			}
		}
		if(Fabrica.getInstancia().getIUsuario().existeNickname(nickname)) {
			if(Fabrica.getInstancia().getIUsuario().esArtista(nickname)) {
				request.setAttribute("tipo_usuario", "Artista");
				request.setAttribute("usuario_perfil",Fabrica.getInstancia().getIUsuario().perfilArtista(nickname));
			}
			else {
				request.setAttribute("tipo_usuario", "Espectador");
				request.setAttribute("usuario_perfil",Fabrica.getInstancia().getIUsuario().perfilEspectador(nickname));
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
		Login.ActualizarUltimoIngreso(request);
		//System.out.println("ENTRO AL SERVLET EL POST");
		String usuarioLogueado = request.getParameter("userlogged");
		String usuarioPerfil = request.getParameter("userprofile");
		String tipo = request.getParameter("tipo");
		
		if(tipo!=null && usuarioLogueado!=null && usuarioPerfil!=null) {
			if(tipo.equals("follow")) {
				//System.out.println("Va a seguir");
				try{
					Fabrica.getInstancia().getIUsuario().seguirUsuario(usuarioLogueado, usuarioPerfil);
					response.getWriter().write("SUCCESS");
				}
				catch(Exception e) {
					response.getWriter().write("ERROR " + e.getMessage());
				}
				//System.out.println("SEGUIDO: "+usuarioLogueado+" "+usuarioPerfil+" "+tipo);
			}
			else if(tipo.equals("unfollow")) {
				try {
					Fabrica.getInstancia().getIUsuario().dejarSeguirUsuario(usuarioLogueado, usuarioPerfil);
					response.getWriter().write("SUCCESS");
				}
				catch(Exception e){
					response.getWriter().write("ERROR " + e.getMessage());
				}
						
			}
		}
	}

}