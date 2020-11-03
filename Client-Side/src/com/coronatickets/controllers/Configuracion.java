package com.coronatickets.controllers;
import java.util.LinkedHashMap; 
import datatypes.DtUsuario;
import java.util.Map; 
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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


import datatypes.DtUsuario;
import datatypes.DtCategoria;
import datatypes.DtEspectaculoDatos;
import datatypes.DtPaqueteDatos;
import controladores.Fabrica;
import datatypes.EstadoSesion;

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
		if(Login.getUsuarioLogueado(request) != null)
			request.getRequestDispatcher("/WEB-INF/configuracion.jsp").forward(request, response);
		else 
			response.sendRedirect("/home");
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
		try {
			DtUsuario usuario = Login.getUsuarioLogueado(request);
			Boolean esartista = false; 
			if(Fabrica.getInstancia().getIUsuario().esArtista(usuario.getNickname()))
				esartista=true;
			
				String nombre = request.getParameter("inputNombre");
				String apellido = request.getParameter("inputApellido");
				String nickname = request.getParameter("inputNickname");
				String Email = request.getParameter("inputEmail");  
		        String nacimientoString= request.getParameter("inputNacimiento");       
		        String Imagen = request.getParameter("imagen");
		        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd"); 
				Date fechaNac = null ;
				try {
					fechaNac = formato.parse(nacimientoString);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.print("Nombre: " + nombre + " Apellido: " + apellido + " Nick: " + nickname + " Email: " + Email);
				if(esartista) {
					String Descripcion = request.getParameter("descgeneral");
					String Biografia = request.getParameter("biografia");
					String Url = request.getParameter("url");
					Fabrica.getInstancia().getIUsuario().modificarArtistaCompleto(nickname, nombre, apellido, fechaNac, Descripcion, Biografia, Url,Imagen);
					System.out.print("entro al artista");
				}
				else {
					Fabrica.getInstancia().getIUsuario().modificarEspectadorCompleto(nickname, nombre, apellido, fechaNac,Imagen);
					System.out.print("entro al espectador");
				}
				DtUsuario nuevousuario = Fabrica.getInstancia().getIUsuario().getUsuarioNickname(nickname);
				request.setAttribute("usuario_logueado", nuevousuario);
				response.sendRedirect("/home");
		}catch(Exception e ) {
			response.sendRedirect("/configuracion?t=e");
		}
			
		
	}
}
