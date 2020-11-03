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

import controladores.Fabrica;
import datatypes.EstadoSesion;
import datatypes.TipoRegistro;
import excepciones.Identidad;
import interfaces.ICategoria;
import interfaces.IPaquete;
import interfaces.IPlataforma;
import interfaces.IUsuario;



public class Registrarse extends HttpServlet {
	   

	private void processRequest(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		HttpSession objSesion = req.getSession();
		String nombre = req.getParameter("inputNombre");
        String apellido = req.getParameter("inputApellido");
        String email = req.getParameter("inputEmail");
        String nickname = req.getParameter("inputNickname");
        req.setAttribute("nickname", nickname);
        String password = req.getParameter("inputPassword");        
        String confirmarPassword = req.getParameter("inputConfirmarPassword");        
        String nacimientoString= req.getParameter("trip-start");        
        String checkbox = req.getParameter("espectadorArtista");
        String descgeneral = req.getParameter("descgeneral");
        String biografia = req.getParameter("biografia");
        String link = req.getParameter("url");
        String imagen = req.getParameter("imgaen");
        
        
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd"); 
		Date fechaNac;
		try {
			fechaNac = formato.parse(nacimientoString);
			if (password.equals(confirmarPassword) ) {
				if (checkbox.equals("espectador")) {
					System.out.println("nuevo Espectador");
					Fabrica.getInstancia().getIUsuario().confirmarAltaEspectador(nickname, nombre, apellido, email, fechaNac, imagen, password);
				}else if (checkbox.equals("artista")) {
					System.out.println("nuevo Artista");
					Fabrica.getInstancia().getIUsuario().confirmarAltaArtista(nickname, nombre, apellido, email, fechaNac, imagen, password, descgeneral,biografia, link);
				}
					req.setAttribute("alta", "true");
					req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
			}else { 
					req.setAttribute("alta", "difieren");
					req.getRequestDispatcher("/WEB-INF/registrarse.jsp").forward(req, resp);
				}
			
		}catch(Exception e) {
			req.setAttribute("alta", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/registrarse.jsp").forward(req, resp);
		}
              
	}
	

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
    	Login.ActualizarUltimoIngreso(request);
    	request.getRequestDispatcher("/WEB-INF/registrarse.jsp").forward(request, response);
    } 


    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
    	Login.ActualizarUltimoIngreso(request);
    	processRequest(request, response);
    }
}