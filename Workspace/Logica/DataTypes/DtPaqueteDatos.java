package DataTypes;

import java.util.Date;
import java.util.HashSet;

public class DtPaqueteDatos {
	
public DtPaqueteDatos(String nombre, String descripcion, Date inicio, Date fin, Double descuento,
			HashSet<DtEspectaculo> espectaculos) {
		super();
		Nombre = nombre;
		Descripcion = descripcion;
		Inicio = inicio;
		Fin = fin;
		Descuento = descuento;
		Espectaculos = espectaculos;
	}
private
String Nombre;
private
String Descripcion;
private
Date Inicio;

public DtPaqueteDatos() {
	super();
}
private
Date Fin;
private
Double Descuento;
private
HashSet<DtEspectaculo> Espectaculos;

public String getNombre() {
	return Nombre;
}
public String getDescripcion() {
	return Descripcion;
}
public Date getInicio() {
	return Inicio;
}
public Date getFin() {
	return Fin;
}
public Double getDescuento() {
	return Descuento;
}
public HashSet<DtEspectaculo> getEspectaculos() {
	return Espectaculos;
}

}
