package DataTypes;

import java.util.Date;

public class DtRegistro {
	
public DtRegistro(Date fecha, Float costo, String nombreFuncion) {
		super();
		this.fecha = fecha;
		this.costo = costo;
		NombreFuncion = nombreFuncion;
	}
private
Date fecha;
private
Float costo;
private
String NombreFuncion;
public Date getFecha() {
	return fecha;
}
public Float getCosto() {
	return costo;
}
public String getNombreFuncion() {
	return NombreFuncion;
}



}
