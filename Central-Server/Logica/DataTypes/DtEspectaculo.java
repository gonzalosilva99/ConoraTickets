package DataTypes;

public class DtEspectaculo {
	
public DtEspectaculo(String nombre, String descripcion, String imagen, EstadoEspectaculo estado, Integer costo) {
		super();
		Nombre = nombre;
		Descripcion = descripcion;
		Imagen = imagen;
		Costo= costo;
		Estado = estado;
	}
private EstadoEspectaculo Estado;
private Integer Costo;
private
String Nombre;
private
String Descripcion;
private
String Imagen;

public EstadoEspectaculo getEstado() {
	return Estado;
}
public Integer getCosto() {
	return Costo;
}
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
