package DataTypes;

import java.util.Date;

public class DtFuncion {

public DtFuncion(String nombre2, Date inicio2, Date alta2, String imagen2) {
	super();
	Nombre = nombre2;
	Inicio = inicio2;
	Alta = alta2;
	Imagen = imagen2;
}
private
String Nombre;
private
Date Inicio;
private
Date Alta;
private
String Imagen;
public String getNombre() {
	return Nombre;
}
public String getImagen() {
	return Imagen;
}
public Date getInicio() {
	return Inicio;
}
public Date getAlta() {
	return Alta;
}

}
