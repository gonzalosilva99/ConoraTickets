package datatypes;

import java.util.Date;
import java.util.Set;

public class DtPaqueteDatos {
	
public DtPaqueteDatos(String nombre, String descripcion, Date inicio, Date fin, Double descuento,
			Set<DtEspectaculo> espectaculos, Set<DtCategoria> categorias, String imagen) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.inicio = inicio;
		this.fin = fin;
		this.descuento = descuento;
		this.espectaculos = espectaculos;
		this.categorias = categorias;
		this.imagen = imagen;
	}
private
String nombre;
private
String descripcion;
private
Date inicio;

public DtPaqueteDatos() {
	super();
}
private
Date fin;
private
Double descuento;
private
Set<DtEspectaculo> espectaculos;
private
Set<DtCategoria> categorias;

private String imagen;


public String getNombre() {
	return nombre;
}
public String getDescripcion() {
	return descripcion;
}
public Date getInicio() {
	return inicio;
}
public Date getFin() {
	return fin;
}

public String getImagen(){
	return imagen;
	
}

public Double getDescuento() {
	return descuento;
}
public Set<DtEspectaculo> getEspectaculos() {
	return espectaculos;
}
public Set<DtCategoria> getCategorias() {
	return categorias;
}

}
