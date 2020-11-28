package datatypes;

import java.util.Date;

public class DtPremio implements Comparable{
	private Date fechaSorteo;
	private String nombreFuncion;
	private String nombreEspectaculo;
	private String descripcion;


public Date getFechaSorteo() {
		return fechaSorteo;
	}
	public void setFechaSorteo(Date fechaSorteo) {
		this.fechaSorteo = fechaSorteo;
	}
	public String getNombreFuncion() {
		return nombreFuncion;
	}
	public void setNombreFuncion(String nombreFuncion) {
		this.nombreFuncion = nombreFuncion;
	}
	public String getNombreEspectaculo() {
		return nombreEspectaculo;
	}
	public void setNombreEspectaculo(String nombreEspectaculo) {
		this.nombreEspectaculo = nombreEspectaculo;
	}

public DtPremio(Date fechaSorteo, String nombreFuncion, String nombreEspectaculo, String descripcion) {
		super();
		this.fechaSorteo = fechaSorteo;
		this.nombreFuncion = nombreFuncion;
		this.nombreEspectaculo = nombreEspectaculo;
		this.descripcion = descripcion;
	}


public String getDescripcion() {
	return descripcion;
}
public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}
@Override
public int compareTo(Object o) {
	// TODO Auto-generated method stub
	DtPremio comparable = (DtPremio)o;
	return comparable.getFechaSorteo().compareTo(this.fechaSorteo);
}




}
