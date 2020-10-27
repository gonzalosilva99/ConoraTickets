package com.coronatickets.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Controladores.Fabrica;
import DataTypes.EstadoSesion;
import DataTypes.TipoRegistro;
import Interfaces.ICategoria;
import Interfaces.IPaquete;
import Interfaces.IPlataforma;
import Interfaces.IUsuario;



public class Registrarse extends HttpServlet {
	   

	private void processRequest(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		HttpSession objSesion = req.getSession();
		String nombre = req.getParameter("inputNombre");
        objSesion.setAttribute("nombre", nombre);
        
        String apellido = req.getParameter("inputApellido");
        objSesion.setAttribute("apellido", apellido);
        
        String email = req.getParameter("inputEmail");
        objSesion.setAttribute("email", email);
        
        String nickname = req.getParameter("inputNickname");
        objSesion.setAttribute("nickname", nickname);
        Integer nuevoEstado = 0;

    
        req.getRequestDispatcher("/WEB-INF/registrarse.jsp").forward(req, resp);
        
	}
	

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    } 


    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}