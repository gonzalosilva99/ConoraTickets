package DataTypes;

import java.util.Date;
import java.util.HashSet;

public class DtArtistaPerfil extends DtArtistaConsulta{
	private
		HashSet<DtEspectaculo> EspectaculosNOaceptados;

	public DtArtistaPerfil(String nickname, String nombre, String apellido, String email, Date nacimiento, String imagen, String contrasena,
			String descgeneral, String biografia, String link, HashSet<DtEspectaculo> espectaculos, HashSet<DtUsuario> seguidores, HashSet<DtUsuario> siguiendo,
			HashSet<DtEspectaculo> espectaculosNOaceptados) {
		super(nickname, nombre, apellido, email, nacimiento,imagen,contrasena, descgeneral, biografia, link, espectaculos,seguidores,siguiendo);
		EspectaculosNOaceptados = espectaculosNOaceptados;
	}

	public HashSet<DtEspectaculo> getEspectaculosNOaceptados() {
		return EspectaculosNOaceptados;
	}
	
	
}
