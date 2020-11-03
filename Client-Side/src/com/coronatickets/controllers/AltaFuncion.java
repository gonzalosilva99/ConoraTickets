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
		Iterator<DtEspectaculo> itr = espectaculosArtista.iterator();
		while (itr.hasNext()) {
			if (itr.next().getNombre().equals(espectaculo.getNombre())) {
				return true;
			}
		}
		return false;
	}

	private void actualizarEspectaculos(HttpServletRequest request, HttpServletResponse resp, String plataforma,
			String nickname) throws ServletException, IOException {
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
		try {
			SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
			Date fechaFuncion = formato.parse(request.getParameter("fecha"));
			Date fechaAlta = new Date();
			System.out.println("Plataforma: " + request.getParameter("inputPrueba"));
			System.out.println("Espectaculo: " + request.getParameter("espectaculo"));
			System.out.println("Funcion: " + request.getParameter("funcion"));
			System.out.println("Fecha: " + request.getParameter("fecha"));
			String[] invitados = request.getParameterValues("invitados[]");
			Set<String> invitadosSet = new HashSet<>(Arrays.asList(invitados));
			Iterator<String> iter = invitadosSet.iterator();
			while (iter.hasNext()) {
				System.out.println("invitados: " + iter.next());
			}
			Fabrica.getInstancia().getIPlataforma().confirmarAltaFuncionEspectaculo(request.getParameter("inputPrueba"),
					request.getParameter("espectaculo"), request.getParameter("funcion"), fechaFuncion, invitadosSet,
					fechaAlta, request.getParameter("img"));
			request.getSession().setAttribute("exito", new Integer(0)); // exito
		} catch (Exception e) {
			request.getSession().setAttribute("exito", new Integer(1)); // error
			System.out.println("EXCEPCION confirmarAltaFuncionEspectaculo " + e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
		if (request.getParameter("actualizar") != null && request.getParameter("actualizar").equals("true")) {
			String nickname = (String) request.getSession().getAttribute("usuario_logueado");
			actualizarEspectaculos(request, response, plataforma, nickname);
		} else if (request.getParameter("actualizar") == null) {
			if (!Fabrica.getInstancia().getIPlataforma().existeFuncion(request.getParameter("funcion"))) {
				confirmarAltaFuncionEspectaculo(request, response, plataforma);
			} else {

				request.getSession().setAttribute("exito", new Integer(2)); // existe funcion con ese nombre
			}
			request.getRequestDispatcher("/WEB-INF/altafuncion.jsp").forward(request, response);
		}
	}

}
