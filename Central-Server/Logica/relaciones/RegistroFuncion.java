package relaciones;
import java.util.Date;

import clases.Espectador;
import clases.Funcion;
import clases.Paquete;
import datatypes.DtFuncion;
import datatypes.DtRegistro;
import datatypes.TipoRegistro;
public class RegistroFuncion {
	private Integer codigo;
	private Date fecha;
	private Double costo;
	private TipoRegistro registro;
	private Boolean canjeable;
	private Funcion funcion;
	private Espectador espectador;
	private Paquete paquete;
	public RegistroFuncion(Integer codigo, Date fecha, Double costo, TipoRegistro registro, Boolean canjeable, Funcion fun, Espectador espec) {
		super();
		this.codigo = codigo;
		this.fecha = fecha;
		this.costo = costo;
		this.registro= registro;
		this.canjeable = canjeable;
		this.espectador = espec;
		this.funcion = fun;
		fun.incrementarEspectadores();
		this.paquete = null;
	}
	
	public RegistroFuncion(Integer codigo, Date fecha, TipoRegistro registro, Funcion fun, Espectador espec) {
		super();
		this.codigo = codigo;
		this.fecha = fecha;
		this.registro = registro;
		this.espectador = espec;
		this.funcion = fun;
		fun.incrementarEspectadores();
	}
	
	public void setPaquete(Paquete paq) {
		this.paquete = paq;
	}
	
	
	public Date getFecha() {
		return this.fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Double getCosto() {
		return this.costo;
	}
	
	public DtRegistro getDtRegistro() {
		DtRegistro dtret = new DtRegistro(this.codigo, this.fecha, this.costo, this.funcion.getNombre(), this.espectador.getNickname());
		return dtret;
	}
	public void setCosto(Double costo) {
		this.costo = costo;
	}
	public TipoRegistro getRegistro() {
		return this.registro;
	}
	public void setRegistro(TipoRegistro registro) {
		this.registro = registro;
	}
	public Boolean getCanjeable() {
		return this.canjeable;
	}
	public void setCanjeable(Boolean canjeable) {
		this.canjeable = canjeable;
	}
	public DtFuncion getDtFuncion() {
		return this.funcion.getDtFuncion();
	}
	public void canjearPaquete(Paquete pa) {
		setPaquete(pa);
	}
	
}
