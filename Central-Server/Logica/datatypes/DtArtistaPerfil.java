package datatypes;

import java.util.Date;
import java.util.Set;

import datatypes.DtArtistaConsulta;
import datatypes.DtUsuario;

public class DtArtistaPerfil extends DtArtistaConsulta{
	private
		Set<DtEspectaculo> espectaculosNOaceptados;
		public Set<DtFuncion> getFuncionesinvitado() {
		return funcionesinvitado;
	}

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

	public void setFuncionesinvitado(Set<DtFuncion> funcionesinvitado) {
		this.funcionesinvitado = funcionesinvitado;
	}

	public void setEspectaculosNOaceptados(Set<DtEspectaculo> espectaculosNOaceptados) {
		this.espectaculosNOaceptados = espectaculosNOaceptados;
	}

	public void setUltimoIngreso(Date ultimoIngreso) {
		this.ultimoIngreso = ultimoIngreso;
	}

	
}
