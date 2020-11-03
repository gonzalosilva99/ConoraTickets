package DataTypes;

public class DtPlataforma {
	
public DtPlataforma(String nombre, String descripcion, String url) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.url = url;
	}
private
String nombre;
private
String descripcion;
private
String url;
public String getNombre() {
	return nombre;
}
public String getDescripcion() {
	return descripcion;
}
public String getURL() {
	return url;
}

}
