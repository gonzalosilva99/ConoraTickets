package Relaciones;
import Clases.Espectador;
import DataTypes.DtRegistro;

import java.util.Date;

import DataTypes.TipoRegistro;
import DataTypes.DtRegistro;
import Clases.Funcion;
public class RegistroFuncion {
	private Date Fecha;
	private Double Costo;
	private TipoRegistro Registro;
	private Boolean Canjeable;
	private Funcion Funcion;
	private Espectador Espectador;
	public RegistroFuncion(Date fecha, Double costo, TipoRegistro registro, Boolean canjeable,Funcion fun,Espectador espec) {
		super();
		Fecha = fecha;
		Costo = costo;
		Registro = registro;
		Canjeable = canjeable;
		Espectador = espec;
		Funcion = fun;
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
	
	public DtRegistro getDtRegistro() {
		DtRegistro dtret = new DtRegistro(Fecha,Costo,Funcion.getNombre(),Espectador.getNickname());
		return dtret;
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
