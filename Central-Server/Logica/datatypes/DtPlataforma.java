package datatypes;

public class DtPlataforma {
	
public DtPlataforma(String nombre, String descripcion, String url) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.url = url;
	}

public DtPlataforma() {};

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
public String getUrl() {
	return url;
}
public void setUrl(String url) {
	this.url = url;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}


}
