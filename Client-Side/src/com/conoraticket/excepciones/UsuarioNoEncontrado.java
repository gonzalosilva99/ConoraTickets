package com.conoraticket.excepciones;

public class UsuarioNoEncontrado extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public UsuarioNoEncontrado() {
	}
	

	public UsuarioNoEncontrado(String msg) {
		super(msg);
	}
}