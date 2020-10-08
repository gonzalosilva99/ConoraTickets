package com.coronatickets.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Controladores.Fabrica;
import DataTypes.DtUsuario;
import DataTypes.EstadoSesion;
import Manejadores.ManejadorUsuario;



public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
        HttpSession objSesion = request.getSession();
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        EstadoSesion nuevoEstado=null;
        try {
        	if(Fabrica.getInstancia().getIUsuario().LogueoCorrecto(login, password)) {
        		nuevoEstado = EstadoSesion.LOGIN_CORRECTO;
        		if(login.contains("@")) {
        			request.getSession().setAttribute("usuario_logueado", Fabrica.getInstancia().getIUsuario().getUsuarioEmail(login).getNickname());
        		}
        		else {
        			request.getSession().setAttribute("usuario_logueado", login);
        		}
        	}
        	else {
        		nuevoEstado = EstadoSesion.LOGIN_INCORRECTO;
        	}
        }
        catch(Exception e) {
        	nuevoEstado = EstadoSesion.LOGIN_INCORRECTO;
        }
        objSesion.setAttribute("estado_sesion", nuevoEstado);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/index.jsp");
        dispatcher.forward(request, response);
    } 
	
	/**
	 * Devuelve el usuario logueado
	 * @param request
	 * @return
	 */
	
    static public DtUsuario getUsuarioLogueado(HttpServletRequest request) {
		return Fabrica.getInstancia().getIUsuario().getUsuarioNickname((String) request.getSession().getAttribute("usuario_logueado"));
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
        processRequest(request, response);
    }
}