package com.coronatickets.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
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
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import java.util.Arrays;
import java.util.ArrayList;
import webservices.Identidad;
import webservices.*;

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
	private Boolean espectaculoEsDelArtista(String nickname, webservices.DtEspectaculo espectaculo) {
		webservices.PublicadorService service = new webservices.PublicadorService();                    
    	webservices.Publicador port = service.getPublicadorPort();
		ArrayList<webservices.DtEspectaculo> espectaculosArtista = (ArrayList) port.getDtArtistaNickname(nickname).getEspectaculos();
		if (espectaculosArtista.contains(espectaculo)) {
			return true;
		}
		return false;
	}

	private void actualizarEspectaculos(HttpServletRequest request, HttpServletResponse resp, String plataforma,
			String nickname) throws ServletException, IOException {
		webservices.PublicadorService service = new webservices.PublicadorService();                    
    	webservices.Publicador port = service.getPublicadorPort();
		request.getSession().setAttribute("exito", null);
		ArrayList<DtEspectaculo> espectaculosAceptados = (ArrayList)port.listarEspectaculosAceptadosDePlataforma(plataforma).getEspectaculos();  
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
		webservices.PublicadorService service = new webservices.PublicadorService();                    
    	webservices.Publicador port = service.getPublicadorPort();
		System.out.println("ENTRO CON:" + request.getParameter("funcion"));
		try {
			if (port.existeFuncion(request.getParameter("funcion"))) {
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
				webservices.ArrayArtistas arrayInvitados = new ArrayArtistas();
				for (String invitado: invitadosSet) {
					DtArtista artista = new DtArtista();
					artista.setNickname(invitado);
					arrayInvitados.getArtistas().add(artista);
				}
				GregorianCalendar c = new GregorianCalendar();
				c.setTime(fechaFuncion);
				XMLGregorianCalendar fechaFuncionGregorian = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
				c.setTime(fechaAlta);
				XMLGregorianCalendar fechaAltaGregorian = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
				String imagen = (String)request.getParameter("imagen");
				port.confirmarAltaFuncionEspectaculo(plataforma, espectaculo, funcion, fechaFuncionGregorian, arrayInvitados, fechaAltaGregorian, imagen);
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
