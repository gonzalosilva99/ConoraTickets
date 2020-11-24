package datatypes;

import java.util.Date;
import java.util.Set;

import datatypes.DtEspectadorConsulta;
import datatypes.DtUsuario;

public class DtEspectadorPerfil extends DtEspectadorConsulta{
	private
	Set<DtPaqueteDatos> paquetesComprados;
	Date ultimoIngreso;

	public DtEspectadorPerfil(String nickname, String nombre, String apellido, String email, Date nacimiento, String imagen, String contrasena,
			Set<DtFuncion> funciones, Set<DtUsuario> seguidores, Set<DtUsuario> siguiendo, Set<DtPaqueteDatos> paquetesComprados, Date ultimoIngreso) {
		super(nickname, nombre, apellido, email, nacimiento, imagen, contrasena, funciones, seguidores, siguiendo);
		this.paquetesComprados = paquetesComprados;
		this.ultimoIngreso=ultimoIngreso;
	}

	public Date getUltimoIngreso() {
		return ultimoIngreso;
	}
	
	public Set<DtPaqueteDatos> getPaquetesComprados() {
		return paquetesComprados;
	}
	public void setPaquetesComprados(Set<DtPaqueteDatos> paquetesComprados) {
		this.paquetesComprados = paquetesComprados;
	}

	public void setUltimoIngreso(Date ultimoIngreso) {
		this.ultimoIngreso = ultimoIngreso;
	}

}
