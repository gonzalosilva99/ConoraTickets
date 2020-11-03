package DataTypes;

import java.util.Date;
import java.util.Set;

public class DtArtistaConsulta {
	public DtArtistaConsulta(String nickname, String nombre, String apellido, String email, Date nacimiento, String imagen, String contrasena,
			String descgeneral, String biografia, String link, Set<DtEspectaculo> espectaculos, Set<DtUsuario> seguidores, Set<DtUsuario> siguiendo) {
		super();
		this.nickname = nickname;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.nacimiento = nacimiento;
		this.descgeneral = descgeneral;
		this.biografia = biografia;
		this.link = link;
		this.espectaculos = espectaculos;
		this.siguiendo = siguiendo;
		this.seguidores = seguidores;
		this.imagen = imagen;
		this.contrasena = contrasena;
	}
	private
	String nickname;
	private
	String nombre;
	private
	String apellido;
	private
	String email;
	private
	Date nacimiento;
	private
	String descgeneral;
	private
	String biografia;
	private
	String link;
	private
	String imagen;
	private
	String contrasena;
	private
	Set<DtEspectaculo> espectaculos;
	private
	Set<DtUsuario> seguidores;
	private
	Set<DtUsuario> siguiendo;
	public String getNickname() {
		return nickname;
	}
	public String getNombre() {
		return nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public String getEmail() {
		return email;
	}
	public Date getNacimiento() {
		return nacimiento;
	}
	public String getDescgeneral() {
		return descgeneral;
	}
	public String getBiografia() {
		return biografia;
	}
	public String getLink() {
		return link;
	}
	public Set<DtEspectaculo> getEspectaculos() {
		return espectaculos;
	}
	public Set<DtUsuario> getSeguidores() {
		return seguidores;
	}
	public Set<DtUsuario> getSiguiendo() {
		return siguiendo;
	}
	public String getImagen() {
		return imagen;
	}
	public String getContrasena() {
		return contrasena;
	}
	

}
