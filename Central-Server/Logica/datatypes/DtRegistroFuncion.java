package datatypes;

import java.util.Date;


public class DtRegistroFuncion {
	private Date fecha;
	private DtFuncion funcion;
	private DtEspectador espectador;
	private Boolean ganoPremio;
	
	public DtRegistroFuncion(Date fecha, DtFuncion funcion, DtEspectador espectador, Boolean ganoPremio){
		this.fecha = fecha;
		this.funcion = funcion;
		this.espectador = espectador;
		this.ganoPremio = ganoPremio;
	}

	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Boolean getGanoPremio() {
		return ganoPremio;
	}
	public void setGanoPremio(Boolean ganoPremio) {
		this.ganoPremio = ganoPremio;
	}
	public DtEspectador getEspectador() {
		return espectador;
	}
	public void setEspectador(DtEspectador espectador) {
		this.espectador = espectador;
	}
	public DtFuncion getFuncion() {
		return funcion;
	}
	public void setFuncion(DtFuncion funcion) {
		this.funcion = funcion;
	}
}
