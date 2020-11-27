package Persistencia;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;





/**
 * Entity implementation class for Entity: EspectaculoPersistencia
 *
 */
@Entity

public class EspectaculoPersistencia implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	@Column(unique=true)
	private String nombre;
	private String descripcion;
	private Integer duracion;
	private Date registro;
	private Integer costo;
	private String url;
	private Date fechaFinalizacion;
	private String plataforma;
	@OneToOne(cascade=CascadeType.PERSIST)
	private ArtistaPersistencia organizador;
	@OneToMany(cascade=CascadeType.PERSIST, fetch=FetchType.LAZY)
	private Set<FuncionPersistencia> funciones;
	
	
	
	

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




	public Date getRegistro() {
		return registro;
	}




	public void setRegistro(Date registro) {
		this.registro = registro;
	}




	public Integer getCosto() {
		return costo;
	}




	public void setCosto(Integer costo) {
		this.costo = costo;
	}




	public String getUrl() {
		return url;
	}




	public void setUrl(String url) {
		this.url = url;
	}




	public EspectaculoPersistencia() {
		super();
	}




	public String getDescripcion() {
		return descripcion;
	}




	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}




	public Integer getDuracion() {
		return duracion;
	}




	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}




	public Date getFechaFinalizacion() {
		return fechaFinalizacion;
	}




	public void setFechaFinalizacion(Date fechaFinalizacion) {
		this.fechaFinalizacion = fechaFinalizacion;
	}




	public String getPlataforma() {
		return plataforma;
	}




	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}




	public ArtistaPersistencia getOrganizador() {
		return organizador;
	}




	public void setOrganizador(ArtistaPersistencia organizador) {
		this.organizador = organizador;
	}




	public Set<FuncionPersistencia> getFunciones() {
		return funciones;
	}




	public void setFunciones(Set<FuncionPersistencia> funciones) {
		this.funciones = funciones;
	}
   
}
