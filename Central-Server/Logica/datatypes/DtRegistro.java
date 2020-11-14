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
	private Boolean ganoPremio;
	public DtRegistro(Integer codigo, Date fecha, Double costo, String nombreFuncion, String nickname, Boolean ganoPremio) {
			super();
			this.codigo = codigo;
			this.fecha = fecha;
			this.costo = costo;
			this.nombrefuncion = nombreFuncion;
			this.nicknameespectador = nickname;
			this.ganoPremio = ganoPremio;
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

	public Boolean getGanoPremio() {
		return ganoPremio;
	}
	

}
