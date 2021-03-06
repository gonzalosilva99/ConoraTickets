package datatypes;

import java.util.Date;
import java.util.Set;

import datatypes.DtUsuario;

public class DtEspectadorConsulta {
	public DtEspectadorConsulta(String nickname, String nombre, String apellido, String email, Date nacimiento, String imagen, String contrasena, Set<DtFuncion> funciones, Set<DtUsuario> seguidores, Set<DtUsuario> siguiendo) {
		super();
		this.nickname = nickname;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.nacimiento = nacimiento;
		this.funciones = funciones;
		this.siguiendo= siguiendo;
		this.seguidores = seguidores;
		this.imagen = imagen;
		this.contrasena = contrasena;
	}
	private
	String imagen;
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
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
	public void setFunciones(Set<DtFuncion> funciones) {
		this.funciones = funciones;
	}
	public void setSeguidores(Set<DtUsuario> seguidores) {
		this.seguidores = seguidores;
	}
	public void setSiguiendo(Set<DtUsuario> siguiendo) {
		this.siguiendo = siguiendo;
	}
	private
	String contrasena;
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
	Set<DtFuncion> funciones;
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
	public Set<DtFuncion> getFunciones() {
		return funciones;
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
