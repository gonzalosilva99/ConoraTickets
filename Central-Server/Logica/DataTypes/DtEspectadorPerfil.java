package DataTypes;

import java.util.Date;
import java.util.HashSet;

public class DtEspectadorPerfil extends DtEspectadorConsulta{
	private
	HashSet<DtPaquete> PaquetesComprados;

	public DtEspectadorPerfil(String nickname, String nombre, String apellido, String email, Date nacimiento, String imagen, String contrasena,
			HashSet<DtFuncion> funciones, HashSet<DtUsuario> seguidores, HashSet<DtUsuario> siguiendo, HashSet<DtPaquete> paquetesComprados) {
		super(nickname, nombre, apellido, email, nacimiento,imagen,contrasena, funciones,seguidores,siguiendo);
		PaquetesComprados = paquetesComprados;
	}

	public HashSet<DtPaquete> getPaquetesComprados() {
		return PaquetesComprados;
	}

}
