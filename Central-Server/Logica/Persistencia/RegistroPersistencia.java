package Persistencia;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: RegistroPersistencia
 *
 */
@Entity

public class RegistroPersistencia implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	@OneToOne(cascade=CascadeType.PERSIST)
	private EspectadorPersistencia espectador;
	private Date fecha;
	private Integer costo;

	public RegistroPersistencia() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public EspectadorPersistencia getEspectador() {
		return espectador;
	}

	public void setEspectador(EspectadorPersistencia espectador) {
		this.espectador = espectador;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Integer getCosto() {
		return costo;
	}

	public void setCosto(Integer costo) {
		this.costo = costo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
   
}
