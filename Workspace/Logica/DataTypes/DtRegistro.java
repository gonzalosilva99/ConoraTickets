package DataTypes;

import java.util.Date;

public class DtRegistro {
	
	private
	Date fecha;
	private
	Double costo;
	private
	String NombreFuncion;
	private String NicknameEspectador;
	public DtRegistro(Date fecha, Double costo, String nombreFuncion, String nickname) {
			super();
			this.fecha = fecha;
			this.costo = costo;
			NombreFuncion = nombreFuncion;
			NicknameEspectador = nickname;
	}

	public String getNicknameEspectador() {
		return NicknameEspectador;
	}

	public Date getFecha() {
		return fecha;
	}
	public Double getCosto() {
		return costo;
	}
	public String getNombreFuncion() {
		return NombreFuncion;
	}

}
