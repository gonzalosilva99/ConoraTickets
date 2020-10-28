package DataTypes;

public class DtEspectaculo {
	
public DtEspectaculo(String nombre, String descripcion, String imagen) {
		super();
		Nombre = nombre;
		Descripcion = descripcion;
		Imagen = imagen;
	}
private
String Nombre;
private
String Descripcion;
private
String Imagen;

public String getNombre() {
	return Nombre;
}
public String getDescripcion() {
	return Descripcion;
}
public String getImagen() {
	return Imagen;
}

}
