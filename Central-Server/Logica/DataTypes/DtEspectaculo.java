package DataTypes;

public class DtEspectaculo {
	
public DtEspectaculo(String nombre, String descripcion, String imagen, EstadoEspectaculo estado, Integer costo) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.imagen = imagen;
		this.costo= costo;
		estado = estado;
	}
private EstadoEspectaculo estado;
private Integer costo;
private
String nombre;
private
String descripcion;
private
String imagen;

public EstadoEspectaculo getEstado() {
	return estado;
}
public Integer getCosto() {
	return costo;
}
public String getNombre() {
	return nombre;
}
public String getDescripcion() {
	return descripcion;
}
public String getImagen() {
	return imagen;
}

}
