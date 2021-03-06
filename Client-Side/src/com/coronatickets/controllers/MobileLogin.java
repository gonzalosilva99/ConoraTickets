package com.coronatickets.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import webservices.*;





public class MobileLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MobileLogin() {
        super();
        // TODO Auto-generated constructor stub
    }
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
    	webservices.PublicadorService service = new webservices.PublicadorService();                    
    	webservices.Publicador port = service.getPublicadorPort();
        HttpSession objSesion = request.getSession();
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String remember = request.getParameter("checkrememb");
        EstadoSesion nuevoEstado=null;
        try {
        	if(port.logueoCorrecto(login, password)) {
        		Boolean esartista = true;
        		if(login.contains("@")) {
        			DtUsuario usu = port.getUsuarioEmail(login);
        			esartista = port.esArtista(usu.getNickname());
        		}
        		else
        			esartista = port.esArtista(login);
        		
        		if(!esartista) {
            		if(login.contains("@")) {
            			request.getSession().setAttribute("usuario_logueado", port.getUsuarioEmail(login).getNickname());
            			ActualizarUltimoIngreso(request);
            		}
            		else {
            			request.getSession().setAttribute("usuario_logueado", login);
            			ActualizarUltimoIngreso(request);
            		}
            		nuevoEstado = EstadoSesion.LOGIN_CORRECTO;
            		if(remember != null) {
            			Cookie nomusu = new Cookie("nick", login);
            			Cookie passwusu = new Cookie("pswd", password);
            			nomusu.setMaxAge(60*60*24*365);
            			passwusu.setMaxAge(60*60*24*365);
            			response.addCookie(nomusu);
            			response.addCookie(passwusu);
            		}
            		else {
            			Cookie nomusu = new Cookie("nick", null);
            			Cookie passwusu = new Cookie("pswd", null);
            			nomusu.setMaxAge(60*60*24*365);
            			passwusu.setMaxAge(60*60*24*365);
            			response.addCookie(nomusu);
            			response.addCookie(passwusu);
            		}
        		}
        		else 
        			nuevoEstado = EstadoSesion.LOGIN_INCORRECTO;
        	}
        	else {
        		nuevoEstado = EstadoSesion.LOGIN_INCORRECTO;
        	}
        }
        catch(Exception e) {
        	nuevoEstado = EstadoSesion.LOGIN_INCORRECTO;
        }
        objSesion.setAttribute("estado_sesion", nuevoEstado);
        if(nuevoEstado==EstadoSesion.LOGIN_CORRECTO) {
        	response.sendRedirect("/mobilehome");
        }
        else {
        	response.sendRedirect("/mobilelogin");;
        }
    } 
	
	/**
	 * Devuelve el usuario logueado
	 * @param request
	 * @return
	 */
	
    static public DtUsuario getUsuarioLogueado(HttpServletRequest request) {
    	webservices.PublicadorService service = new webservices.PublicadorService();                    
    	webservices.Publicador port = service.getPublicadorPort();
		return port.getUsuarioNickname((String) request.getSession().getAttribute("usuario_logueado"));
	}
    
    /**
	 * Devuelve el usuario logueado
	 * @param request
	 * @return
	 */
	
    static public void Logout(HttpServletRequest request) {
		request.getSession().setAttribute("estado_sesion", null);
		request.getSession().setAttribute("usuario_logueado", null);
	}
    
    static public void ActualizarUltimoIngreso(HttpServletRequest request) {
    	webservices.PublicadorService service = new webservices.PublicadorService();                    
    	webservices.Publicador port = service.getPublicadorPort();
    	if(request.getSession().getAttribute("estado_sesion")==EstadoSesion.LOGIN_CORRECTO && request.getSession().getAttribute("usuario_logueado")!=null) {
    		port.actualizarUltimoIngreso((String) request.getSession().getAttribute("usuario_logueado"));
    	}
    }

     /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
    	Login.ActualizarUltimoIngreso(request);
    	processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
    	Login.ActualizarUltimoIngreso(request);
    	processRequest(request, response);
    }
}