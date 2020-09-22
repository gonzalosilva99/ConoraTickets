package Relaciones;
import Clases.Espectador;
import Clases.Paquete;
import DataTypes.DtRegistro;
import DataTypes.DtFuncion;
import java.util.Date;

import DataTypes.TipoRegistro;
import DataTypes.DtRegistro;
import Clases.Funcion;
public class RegistroFuncion {
	private Integer Codigo;
	private Date Fecha;
	private Double Costo;
	private TipoRegistro Registro;
	private Boolean Canjeable;
	private Funcion Funcion;
	private Espectador Espectador;
	private Paquete Paquete;
	public RegistroFuncion(Integer codigo,Date fecha, Double costo, TipoRegistro registro, Boolean canjeable,Funcion fun,Espectador espec) {
		super();
		Codigo = codigo;
		Fecha = fecha;
		Costo = costo;
		Registro = registro;
		Canjeable = canjeable;
		Espectador = espec;
		Funcion = fun;
		fun.IncrementarEspectadores();
		Paquete = null;
	}
	
	public RegistroFuncion(Integer codigo, Date fecha,TipoRegistro registro,Funcion fun,Espectador espec) {
		super();
		Codigo = codigo;
		Fecha = fecha;
		Registro = registro;
		Espectador = espec;
		Funcion = fun;
		fun.IncrementarEspectadores();
	}
	
	public void setPaquete(Paquete paq) {
		Paquete = paq;
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
		DtRegistro dtret = new DtRegistro(Codigo,Fecha,Costo,Funcion.getNombre(),Espectador.getNickname());
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
	public DtFuncion getDtFuncion() {
		return this.Funcion.getDtFuncion();
	}
	public void canjearPaquete(Paquete pa) {
		setPaquete(pa);
	}
	
}
