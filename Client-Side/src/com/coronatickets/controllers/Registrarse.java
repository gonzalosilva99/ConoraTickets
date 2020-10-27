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
import Excepciones.Identidad;
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
        
        String password = req.getParameter("inputPassword");
        objSesion.setAttribute("password", password);
        
        String confirmarPassword = req.getParameter("inputConfirmarPassword");
        objSesion.setAttribute("confirmarPassword", confirmarPassword);
        
        String nacimientoString= req.getParameter("trip-start");
        
        String checkbox = req.getParameter("espectadorArtista");
        
        System.out.println("nickname:" + nickname);
        System.out.println("nombre:" + nombre);
        System.out.println("apellido:" + apellido);
        System.out.println("email:" + email);
        System.out.println("PASS :" + password);
        System.out.println("confirmar Pass:" + confirmarPassword);
        System.out.println("nacimiento:" + nacimientoString);
        System.out.println("CheckBox:" + checkbox);
        
        
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd"); 
		Date fechaNac;
		Boolean estadoOK = false;
		try {
			fechaNac = formato.parse(nacimientoString);
			if (!Fabrica.getInstancia().getIUsuario().existeNickname(nickname) && password.equals(confirmarPassword) ) {
				estadoOK = true;
				if (checkbox.equals("espectador")) {
					System.out.println("nuevo Espectador");
					Fabrica.getInstancia().getIUsuario().confirmarAltaEspectador(nickname, nombre, apellido, email, fechaNac, "", password);
				}else if (checkbox.equals("artista")) {
					System.out.println("nuevo Artista");
					Fabrica.getInstancia().getIUsuario().confirmarAltaArtista(nickname, nombre, apellido, email, fechaNac, "", password, "","", "");
				}
			}else { 
				if (Fabrica.getInstancia().getIUsuario().existeNickname(nickname)) {
					System.out.println("YA EXISTE NICK");
				}
				if (!password.equals(confirmarPassword)) {
					System.out.println("DIFIEREN LAS PASSWORD");
				}
			}
			
		}catch(Exception e) {
			 System.out.println("Excepcion: " + e.getMessage());
		}
		
		RequestDispatcher dispatcher;
		
		if (estadoOK) {
			dispatcher = req.getRequestDispatcher("/login");
		}else {
			dispatcher = req.getRequestDispatcher("/home");
		}
		
        dispatcher.forward(req, resp);
                
	}
	

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
    	request.getRequestDispatcher("/WEB-INF/registrarse.jsp").forward(request, response);
    } 


    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}