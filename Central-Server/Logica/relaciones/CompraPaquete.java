package relaciones;

import java.util.Date;

import clases.Espectador;
import clases.Paquete;
import datatypes.DtPaquete;
import datatypes.DtPaqueteDatos;

public class CompraPaquete {
	public Integer codigo;
	private Date fecha;
	public Espectador espectador;
	private Paquete paquete;

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public CompraPaquete(Date fecha, Espectador espec, Paquete paq) {
		super();
		this.fecha = fecha;
		this.espectador = espec;
		this.paquete = paq;
	}
	 
	public Boolean tieneEspectaculo(String nombreEspectaculo) {
		//return Paquete.tieneEspectaculo(nombreEspectaculo);
		return true;
	}
	
	public DtPaquete getDtPaquete() {
		return this.paquete.getDtPaquete();
	}
	
	public DtPaqueteDatos getDtPaqueteDatos() {
		return this.paquete.getDtPaqueteDatos();
	}
}
