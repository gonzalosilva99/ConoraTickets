package DataTypes;

import java.util.Date;
import java.util.Set;

public class DtPaqueteDatos {
	
public DtPaqueteDatos(String nombre, String descripcion, Date inicio, Date fin, Float descuento,
			Set<DtEspectaculo> espectaculos) {
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
Float Descuento;
private
Set<DtEspectaculo> Espectaculos;

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
public Float getDescuento() {
	return Descuento;
}
public Set<DtEspectaculo> getEspectaculos() {
	return Espectaculos;
}

}
