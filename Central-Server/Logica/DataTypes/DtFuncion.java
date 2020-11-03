package DataTypes;

import java.util.Date;

public class DtFuncion {

public DtFuncion(String nombre2, Date inicio2, Date alta2, String imagen2) {
	super();
	nombre = nombre2;
	inicio = inicio2;
	alta = alta2;
	imagen = imagen2;
}
private
String nombre;
private
Date inicio;
private
Date alta;
private
String imagen;
public String getNombre() {
	return nombre;
}
public String getImagen() {
	return imagen;
}
public Date getInicio() {
	return inicio;
}
public Date getAlta() {
	return alta;
}

}
