package DataTypes;

import java.util.Date;
import java.util.HashSet;

public class DtArtistaPerfil extends DtArtistaConsulta{
	private
		HashSet<DtEspectaculo> EspectaculosNOaceptados;

	public DtArtistaPerfil(String nickname, String nombre, String apellido, String email, Date nacimiento,
			String descgeneral, String biografia, String link, HashSet<DtEspectaculo> espectaculos,
			HashSet<DtEspectaculo> espectaculosNOaceptados) {
		super(nickname, nombre, apellido, email, nacimiento, descgeneral, biografia, link, espectaculos);
		EspectaculosNOaceptados = espectaculosNOaceptados;
	}

	public HashSet<DtEspectaculo> getEspectaculosNOaceptados() {
		return EspectaculosNOaceptados;
	}
	
	
}
