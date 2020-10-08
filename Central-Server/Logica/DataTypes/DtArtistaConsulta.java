package DataTypes;

import java.util.Date;
import java.util.HashSet;

public class DtArtistaConsulta {
	public DtArtistaConsulta(String nickname, String nombre, String apellido, String email, Date nacimiento, String imagen, String contrasena,
			String descgeneral, String biografia, String link, HashSet<DtEspectaculo> espectaculos, HashSet<DtUsuario> seguidores, HashSet<DtUsuario> siguiendo) {
		super();
		Nickname = nickname;
		Nombre = nombre;
		Apellido = apellido;
		Email = email;
		Nacimiento = nacimiento;
		Descgeneral = descgeneral;
		Biografia = biografia;
		this.link = link;
		Espectaculos = espectaculos;
		Siguiendo = siguiendo;
		Seguidores = seguidores;
		Imagen = imagen;
		Contrasena = contrasena;
	}
	private
	String Nickname;
	private
	String Nombre;
	private
	String Apellido;
	private
	String Email;
	private
	Date Nacimiento;
	private
	String Descgeneral;
	private
	String Biografia;
	private
	String link;
	private
	String Imagen;
	private
	String Contrasena;
	private
	HashSet<DtEspectaculo> Espectaculos;
	private
	HashSet<DtUsuario> Seguidores;
	private
	HashSet<DtUsuario> Siguiendo;
	public String getNickname() {
		return Nickname;
	}
	public String getNombre() {
		return Nombre;
	}
	public String getApellido() {
		return Apellido;
	}
	public String getEmail() {
		return Email;
	}
	public Date getNacimiento() {
		return Nacimiento;
	}
	public String getDescgeneral() {
		return Descgeneral;
	}
	public String getBiografia() {
		return Biografia;
	}
	public String getLink() {
		return link;
	}
	public HashSet<DtEspectaculo> getEspectaculos() {
		return Espectaculos;
	}
	public HashSet<DtUsuario> getSeguidores() {
		return Seguidores;
	}
	public HashSet<DtUsuario> getSiguiendo() {
		return Siguiendo;
	}
	public String getImagen() {
		return Imagen;
	}
	public String getContrasena() {
		return Contrasena;
	}
	

}
