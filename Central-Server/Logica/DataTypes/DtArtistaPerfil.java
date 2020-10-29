package DataTypes;

import java.util.Date;
import java.util.HashSet;

public class DtArtistaPerfil extends DtArtistaConsulta{
	private
		HashSet<DtEspectaculo> EspectaculosNOaceptados;
		Date UltimoIngreso;
		HashSet<DtFuncion> FuncionesInvitado;
	public DtArtistaPerfil(String nickname, String nombre, String apellido, String email, Date nacimiento, String imagen, String contrasena,
			String descgeneral, String biografia, String link, HashSet<DtEspectaculo> espectaculos, HashSet<DtUsuario> seguidores, HashSet<DtUsuario> siguiendo,
			HashSet<DtEspectaculo> espectaculosNOaceptados, Date UltimoIngreso, HashSet<DtFuncion> funcionesinvitado) {
		super(nickname, nombre, apellido, email, nacimiento,imagen,contrasena, descgeneral, biografia, link, espectaculos,seguidores,siguiendo);
		EspectaculosNOaceptados = espectaculosNOaceptados;
		this.UltimoIngreso=UltimoIngreso;
		this.FuncionesInvitado = funcionesinvitado;
	}

	public Date getUltimoIngreso() {
		return UltimoIngreso;
	}
	
	public HashSet<DtFuncion> getFuncionesInvitado() {
		return FuncionesInvitado;
	}

	public HashSet<DtEspectaculo> getEspectaculosNOaceptados() {
		return EspectaculosNOaceptados;
	}
	
	
}
