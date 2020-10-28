package DataTypes;

import java.util.Date;

public class DtFuncion {

public DtFuncion(String nombre, Date inicio, Date alta, String imagen) {
		super();
		Nombre = nombre;
		Inicio = inicio;
		Alta = alta;
		Imagen = imagen;
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
