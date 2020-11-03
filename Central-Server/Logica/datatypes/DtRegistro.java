package datatypes;

import java.util.Date;

public class DtRegistro {
	private Integer codigo;
	private
	Date fecha;
	private
	Double costo;
	private
	String nombrefuncion;
	private String nicknameespectador;
	public DtRegistro(Integer codigo, Date fecha, Double costo, String nombreFuncion, String nickname) {
			super();
			this.codigo = codigo;
			this.fecha = fecha;
			this.costo = costo;
			this.nombrefuncion = nombreFuncion;
			this.nicknameespectador = nickname;
	}

	public String getNicknameEspectador() {
		return nicknameespectador;
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
		return nombrefuncion;
	}

}
