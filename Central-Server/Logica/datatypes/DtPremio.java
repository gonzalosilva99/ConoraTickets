package datatypes;

import java.util.Date;

public class DtPremio implements Comparable{


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
public DtPremio(Date fechaSorteo, String nombreFuncion, String nombreEspectaculo) {
		super();
		this.fechaSorteo = fechaSorteo;
		this.nombreFuncion = nombreFuncion;
		this.nombreEspectaculo = nombreEspectaculo;
	}
private Date fechaSorteo;
private String nombreFuncion;
private String nombreEspectaculo;
@Override
public int compareTo(Object o) {
	// TODO Auto-generated method stub
	DtPremio comparable = (DtPremio)o;
	return comparable.getFechaSorteo().compareTo(this.fechaSorteo);
}




}
