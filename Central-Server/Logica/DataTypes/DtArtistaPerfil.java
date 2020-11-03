package DataTypes;

import java.util.Date;
import java.util.Set;

public class DtArtistaPerfil extends DtArtistaConsulta{
	private
		Set<DtEspectaculo> espectaculosNOaceptados;
		Date ultimoIngreso;
		Set<DtFuncion> funcionesinvitado;
	public DtArtistaPerfil(String nickname, String nombre, String apellido, String email, Date nacimiento, String imagen, String contrasena,
			String descgeneral, String biografia, String link, Set<DtEspectaculo> espectaculos, Set<DtUsuario> seguidores, Set<DtUsuario> siguiendo,
			Set<DtEspectaculo> espectaculosNOaceptados, Date ultimoIngreso, Set<DtFuncion> funcionesinvitado) {
		super(nickname, nombre, apellido, email, nacimiento, imagen, contrasena, descgeneral, biografia, link, espectaculos, seguidores, siguiendo);
		this.espectaculosNOaceptados = espectaculosNOaceptados;
		this.ultimoIngreso=ultimoIngreso;
		this.funcionesinvitado = funcionesinvitado;
	}

	public Date getUltimoIngreso() {
		return ultimoIngreso;
	}
	
	public Set<DtFuncion> getFuncionesInvitado() {
		return funcionesinvitado;
	}

	public Set<DtEspectaculo> getEspectaculosNOaceptados() {
		return espectaculosNOaceptados;
	}
	
	
}
