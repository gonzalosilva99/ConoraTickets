package Relaciones;

import java.util.Date;

import DataTypes.TipoRegistro;

public class RegistroFuncion {
	private Date Fecha;
	private Double Costo;
	private TipoRegistro Registro;
	private Boolean Canjeable;
	public RegistroFuncion(Date fecha, Double costo, TipoRegistro registro, Boolean canjeable) {
		super();
		Fecha = fecha;
		Costo = costo;
		Registro = registro;
		Canjeable = canjeable;
	}
	public Date getFecha() {
		return Fecha;
	}
	public void setFecha(Date fecha) {
		Fecha = fecha;
	}
	public Double getCosto() {
		return Costo;
	}
	public void setCosto(Double costo) {
		Costo = costo;
	}
	public TipoRegistro getRegistro() {
		return Registro;
	}
	public void setRegistro(TipoRegistro registro) {
		Registro = registro;
	}
	public Boolean getCanjeable() {
		return Canjeable;
	}
	public void setCanjeable(Boolean canjeable) {
		Canjeable = canjeable;
	}
	
}
