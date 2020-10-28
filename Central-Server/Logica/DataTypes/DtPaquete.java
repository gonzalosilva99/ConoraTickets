package DataTypes;

public class DtPaquete {


private
String Nombre;
private
String Descripcion;
private
String Imagen;
private
Double Descuento;
public DtPaquete(String nombre, String descripcion, String imagen, Double descuento) {
	Nombre = nombre;
	Descripcion = descripcion;
	Descuento = descuento;
	Imagen = imagen;
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
public Double getDescuento() {
	return Descuento;
}

}
