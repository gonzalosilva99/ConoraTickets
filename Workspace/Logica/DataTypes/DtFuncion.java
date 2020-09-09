package DataTypes;

import java.util.Date;

public class DtFuncion {

public DtFuncion(String nombre, Date inicio, Date alta) {
		super();
		Nombre = nombre;
		Inicio = inicio;
		Alta = alta;
	}
private
String Nombre;
private
Date Inicio;
private
Date Alta;
public String getNombre() {
	return Nombre;
}
public Date getInicio() {
	return Inicio;
}
public Date getAlta() {
	return Alta;
}

}
