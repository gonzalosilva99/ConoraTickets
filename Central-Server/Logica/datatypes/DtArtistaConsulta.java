package datatypes;

import java.util.Date;
import java.util.Set;

import datatypes.DtUsuario;

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
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	private
	String nombre;
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setNacimiento(Date nacimiento) {
		this.nacimiento = nacimiento;
	}
	public void setDescgeneral(String descgeneral) {
		this.descgeneral = descgeneral;
	}
	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public void setEspectaculos(Set<DtEspectaculo> espectaculos) {
		this.espectaculos = espectaculos;
	}
	public void setSeguidores(Set<DtUsuario> seguidores) {
		this.seguidores = seguidores;
	}
	public void setSiguiendo(Set<DtUsuario> siguiendo) {
		this.siguiendo = siguiendo;
	}

}
