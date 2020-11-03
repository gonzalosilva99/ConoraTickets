package DataTypes;
import java.util.Date;
import java.util.Set;
import java.util.Iterator;

public class DtArtista {
	public DtArtista(String nickname, String nombre, String apellido, String email, Date nacimiento, String descgeneral,
			String biografia, String link, Set<DtEspectaculo> espectaculos) {
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
	Set<DtEspectaculo> espectaculos;
	private
	String link;
	
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
	public Set<DtEspectaculo> getEspectaculosArtista(){
		return espectaculos;
	}
	
		

}
