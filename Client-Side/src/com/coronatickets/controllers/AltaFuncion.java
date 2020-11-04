package com.coronatickets.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import clases.Espectaculo;

import java.util.Arrays;

import controladores.Fabrica;
import interfaces.IPlataforma;
import datatypes.DtEspectaculo;
import datatypes.EstadoSesion;
import datatypes.DtArtista;
import datatypes.DtUsuario;
import excepciones.Identidad;

/**
 * Servlet implementation class Home
 */
public class AltaFuncion extends HttpServlet {

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	/*
	 * public AltaEspectaculo() { super(); // TODO Auto-generated constructor stub }
	 */

	/**
	 * Devuelve el estado de la sesión
	 * 
	 * @param request
	 */
	private Boolean espectaculoEsDelArtista(String nickname, DtEspectaculo espectaculo) {
		Set<DtEspectaculo> espectaculosArtista = Fabrica.getInstancia().getIUsuario().getDtArtistaNickname(nickname)
				.getEspectaculosArtista();
		if (espectaculosArtista.contains(espectaculo)) {
			return true;
		}
		return false;
	}

	private void actualizarEspectaculos(HttpServletRequest request, HttpServletResponse resp, String plataforma,
			String nickname) throws ServletException, IOException {
		request.getSession().setAttribute("exito", null);
		Set<DtEspectaculo> espectaculosAceptados = Fabrica.getInstancia().getIPlataforma()
				.listarEspectaculosAceptadosDePlataforma(plataforma);
		Set<DtEspectaculo> espectaculosAceptadosDelArtista = new HashSet<>();
		Iterator<DtEspectaculo> itr = espectaculosAceptados.iterator();
		while (itr.hasNext()) {
			if (espectaculoEsDelArtista(nickname, itr.next())) {
				espectaculosAceptadosDelArtista.add(itr.next());
			}
		}
		request.getSession().setAttribute("espectaculosAceptados", espectaculosAceptados);
		request.getSession().setAttribute("plataforma", plataforma);
	}

	private void confirmarAltaFuncionEspectaculo(HttpServletRequest request, HttpServletResponse response,
			String plataforma) throws ServletException, IOException {
		System.out.println("ENTRO CON:" + request.getParameter("funcion"));
		try {
			if (Fabrica.getInstancia().getIPlataforma().existeFuncion(request.getParameter("funcion"))) {
				response.getWriter().write("EXISTE_FUNCION");
			}else {
				String funcion = (String)request.getParameter("funcion");
				String espectaculo = (String)request.getParameter("espectaculo");
				SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd hh:mm");
				Date fechaFuncion = formato.parse(request.getParameter("fecha"));
				Date fechaAlta = new Date();
				String[] invitados = request.getParameterValues("invitados[]");	
				Set<String> invitadosSet = null;
				if (invitados != null) {
					invitadosSet = new HashSet<>(Arrays.asList(invitados));
				}
				String imagen = (String)request.getParameter("imagen");
				Fabrica.getInstancia().getIPlataforma().confirmarAltaFuncionEspectaculo(plataforma, espectaculo, 
							funcion, fechaFuncion, invitadosSet, fechaAlta, imagen);
				response.getWriter().write("SUCCESS");
			}				
		}catch(Exception e) {
			System.out.println("excepcioN"+ e.getMessage());
			response.getWriter().write("ERROR " + e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getSession().setAttribute("exito", null);
		Login.ActualizarUltimoIngreso(request);
		if (request.getSession().getAttribute("usuario_logueado") != null
				&& request.getSession().getAttribute("estado_sesion") != null
				&& ((EstadoSesion) request.getSession().getAttribute("estado_sesion") == EstadoSesion.LOGIN_CORRECTO)) {
			request.getRequestDispatcher("/WEB-INF/altafuncion.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
		}
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			Login.ActualizarUltimoIngreso(request);
			String plataforma = request.getParameter("plataforma");
			if (request.getParameter("actualizar") != null && request.getParameter("actualizar").equals("true")) 
			{
				String nickname = (String) request.getSession().getAttribute("usuario_logueado");
				actualizarEspectaculos(request, response, plataforma, nickname);
			}else 
			{
				confirmarAltaFuncionEspectaculo(request, response, plataforma);
			}
	}
	
}
