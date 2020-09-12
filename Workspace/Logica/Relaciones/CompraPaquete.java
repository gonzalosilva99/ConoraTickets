package Relaciones;

import java.util.Date;
import Clases.Espectador;
import Clases.Paquete;
import DataTypes.DtPaquete;

public class CompraPaquete {
	private Integer Codigo;
	private Date Fecha;
	private Espectador Espectador;
	private Paquete Paquete;

	public Date getFecha() {
		return Fecha;
	}

	public void setFecha(Date fecha) {
		Fecha = fecha;
	}

	public CompraPaquete(Date fecha, Espectador espec, Paquete paq) {
		super();
		Fecha = fecha;
		Espectador = espec;
		Paquete = paq;
	}
	 
	public Boolean TieneEspectaculo(String nombreEspectaculo) {
		return Paquete.tieneEspectaculo(nombreEspectaculo);
	}
	
	public DtPaquete getDtPaquete() {
		return Paquete.getDtPaquete();
	}
}
