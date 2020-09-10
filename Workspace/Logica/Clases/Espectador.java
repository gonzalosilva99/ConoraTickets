package Clases;

import java.util.Date;

import DataTypes.DtEspectaculo;
import DataTypes.DtEspectador;
import DataTypes.DtEspectadorConsulta;
import DataTypes.DtUsuario;
import DataTypes.DtFuncion;
import java.util.HashSet;
import java.util.Iterator;

import javax.swing.JOptionPane;


public class Espectador extends Usuario{
	
	public Espectador(String nickname, String nombre, String apellido, String email, Date nacimiento) {
		super(nickname,nombre, apellido, email,nacimiento);
		Funciones = new HashSet<Funcion>();
	}
	private HashSet<Funcion> Funciones;
	public DtUsuario getDtUsuario() {
		DtUsuario ret = new DtUsuario(this.getNickname(),this.getNombre(),this.getApellido());
		return ret;
	}
	
	public DtEspectador getDtEspectador() {
		DtEspectador ret = new DtEspectador(this.getNickname(),this.getNombre(),this.getApellido(),this.getEmail(),this.getNacimiento());
		return ret;
	}
	
	public HashSet<Funcion> getFunciones() {
		return Funciones;
	}

	public void setFunciones(HashSet<Funcion> funciones) {
		Funciones = funciones;
	}

	public DtEspectadorConsulta getDtEspectadorConsulta() {
		HashSet<DtFuncion> esp = new HashSet<DtFuncion>();
		Iterator<Funcion> itr = Funciones.iterator();	
		while(itr.hasNext()) {
			DtFuncion nuevo = itr.next().getDtFuncion();
			esp.add(nuevo);
		}
		DtEspectadorConsulta ret = new DtEspectadorConsulta(this.getNickname(),this.getNombre(),this.getApellido(),this.getEmail(),this.getNacimiento(),esp);
		return ret;
	}
}


