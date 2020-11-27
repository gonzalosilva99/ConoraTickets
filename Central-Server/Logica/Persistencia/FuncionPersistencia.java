package Persistencia;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;


/**
 * Entity implementation class for Entity: FuncionPersistencia
 *
 */
@Entity

public class FuncionPersistencia implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	@Column(unique=true)
	private String nombre;
	private Date inicio;
	private Date alta;
	@OneToMany(cascade=CascadeType.PERSIST, fetch=FetchType.LAZY)
    private Set<RegistroPersistencia> registros;
	

	public FuncionPersistencia() {
		super();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Date getInicio() {
		return inicio;
	}


	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}


	public Date getAlta() {
		return alta;
	}


	public void setAlta(Date alta) {
		this.alta = alta;
	}


	public Set<RegistroPersistencia> getRegistros() {
		return registros;
	}


	public void setRegistros(Set<RegistroPersistencia> registros) {
		this.registros = registros;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
   
	
}
