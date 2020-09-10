package DataTypes;

import java.util.Date;
import java.util.HashSet;

public class DtArtistaConsulta {
	public DtArtistaConsulta(String nickname, String nombre, String apellido, String email, Date nacimiento,
			String descgeneral, String biografia, String link, HashSet<DtEspectaculo> espectaculos) {
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
	HashSet<DtEspectaculo> Espectaculos;
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
	

}
