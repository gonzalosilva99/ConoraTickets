package DataTypes;

import java.util.Date;

public class DtRegistro {
	private Integer codigo;
	private
	Date fecha;
	private
	Double costo;
	private
	String NombreFuncion;
	private String NicknameEspectador;
	public DtRegistro(Integer codigo, Date fecha, Double costo, String nombreFuncion, String nickname) {
			super();
			this.codigo = codigo;
			this.fecha = fecha;
			this.costo = costo;
			NombreFuncion = nombreFuncion;
			NicknameEspectador = nickname;
	}

	public String getNicknameEspectador() {
		return NicknameEspectador;
	}
	
	public Integer getCodigo() {
		return codigo;
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
