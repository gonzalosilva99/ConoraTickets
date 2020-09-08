package GUI;

import java.util.Date;

public class CompraPaquete {
	private Date Fecha;

	public Date getFecha() {
		return Fecha;
	}

	public void setFecha(Date fecha) {
		Fecha = fecha;
	}

	public CompraPaquete(Date fecha) {
		super();
		Fecha = fecha;
	}
	
}
