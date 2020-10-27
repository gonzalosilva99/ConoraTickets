package DataTypes;

import java.util.Date;
import java.util.HashSet;

public class DtEspectadorPerfil extends DtEspectadorConsulta{
	private
	HashSet<DtPaquete> PaquetesComprados;
	Date UltimoIngreso;

	public DtEspectadorPerfil(String nickname, String nombre, String apellido, String email, Date nacimiento, String imagen, String contrasena,
			HashSet<DtFuncion> funciones, HashSet<DtUsuario> seguidores, HashSet<DtUsuario> siguiendo, HashSet<DtPaquete> paquetesComprados, Date UltimoIngreso) {
		super(nickname, nombre, apellido, email, nacimiento,imagen,contrasena, funciones,seguidores,siguiendo);
		PaquetesComprados = paquetesComprados;
		this.UltimoIngreso=UltimoIngreso;
	}

	public Date getUltimoIngreso() {
		return UltimoIngreso;
	}
	
	public HashSet<DtPaquete> getPaquetesComprados() {
		return PaquetesComprados;
	}

}
