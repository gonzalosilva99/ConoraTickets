package datatypes;

import java.util.Date;

public class DtEspectador {
	public DtEspectador(String nickname, String nombre, String apellido, String email, Date nacimiento) {
		super();
		this.nickname = nickname;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.nacimiento = nacimiento;
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
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
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

}
