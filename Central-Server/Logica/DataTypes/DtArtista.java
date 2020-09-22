package DataTypes;
import java.util.Date;

public class DtArtista {
	public DtArtista(String nickname, String nombre, String apellido, String email, Date nacimiento, String descgeneral,
			String biografia, String link) {
		super();
		Nickname = nickname;
		Nombre = nombre;
		Apellido = apellido;
		Email = email;
		Nacimiento = nacimiento;
		Descgeneral = descgeneral;
		Biografia = biografia;
		this.link = link;
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
	
		

}
