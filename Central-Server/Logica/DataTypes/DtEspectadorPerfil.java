package DataTypes;

import java.util.Date;
import java.util.HashSet;

public class DtEspectadorPerfil extends DtEspectadorConsulta{
	private
	HashSet<DtPaquete> PaquetesComprados;

	public DtEspectadorPerfil(String nickname, String nombre, String apellido, String email, Date nacimiento,
			HashSet<DtFuncion> funciones, HashSet<DtPaquete> paquetesComprados) {
		super(nickname, nombre, apellido, email, nacimiento, funciones);
		PaquetesComprados = paquetesComprados;
	}

	public HashSet<DtPaquete> getPaquetesComprados() {
		return PaquetesComprados;
	}

}
