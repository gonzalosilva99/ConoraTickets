package Clases;

import java.util.Date;

import DataTypes.DtEspectador;
import DataTypes.DtUsuario;


public class Espectador extends Usuario{
	public Espectador(String nickname, String nombre, String apellido, String email, Date nacimiento) {
		super(nickname,nombre, apellido, email,nacimiento);
	}
	
	public DtUsuario getDtUsuario() {
		DtUsuario ret = new DtUsuario(this.getNickname(),this.getNombre(),this.getApellido());
		return ret;
	}
	
	public DtEspectador getDtEspectador() {
		DtEspectador ret = new DtEspectador(this.getNickname(),this.getNombre(),this.getApellido(),this.getEmail(),this.getNacimiento());
		return ret;
	}
}


