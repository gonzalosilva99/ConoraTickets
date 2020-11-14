package clases;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import datatypes.DtArtista;
import datatypes.DtEspectaculo;
import datatypes.DtEspectador;
import datatypes.DtFuncion;
import datatypes.DtFuncionDatos;
import datatypes.DtRegistroFuncion;
import datatypes.DtUsuario;
import relaciones.RegistroFuncion;

public class Funcion {
	private String nombre;
	private Date inicio;
	private Date alta;
	private String imagen;
	private Set<RegistroFuncion> registros;
	private Map<String, Artista> artistasinvitados;
	private Integer espectadores;
	private Date fechaSorteo;
		public Funcion(String nombre, Date inicio, Date alta, String imagen) {
			super();
			this.nombre = nombre;
			this.inicio = inicio;
			this.alta = alta;
			this.imagen = imagen;
			this.artistasinvitados = new HashMap<String, Artista>();
			this.espectadores = 0;
			this.fechaSorteo = null;
			this.setRegistros(new HashSet<>());
		}
		public Date getFechaSorteo() {
			return fechaSorteo;
		}
		public void setFechaSorteo(Date fechaSorteo) {
			this.fechaSorteo = fechaSorteo;
		}
		public String getNombre() {
			return nombre;
		}
		
		public Integer getEspectadores() {
			return espectadores;
		}
		
		public void incrementarEspectadores() {
			espectadores++;
		}
		public void setEspectadores(Integer espec) {
			espectadores = espec;
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
		public Boolean estaVigente() {
			Date today = Calendar.getInstance().getTime();
			if (today.compareTo(inicio) > 0)
				return false;
			else return true;
		}
		
		public String getImagen() {
			return imagen;
		}
		public void setImagen(String imagen) {
			this.imagen = imagen;
		}
		
		public Date getAlta() {
			return alta;
		}
		public void setAlta(Date alta) {
			this.alta = alta;
		}
		
		public DtFuncion getDtFuncion() {
			DtFuncion dtfun = new DtFuncion(this.nombre, this.inicio, this.alta, this.imagen);
			return dtfun;
		}
		public Map<String, Artista> getArtistasInvitado(){
			return artistasinvitados;
		}
		public void anadirArtista(Artista artista, String nick) {
			artistasinvitados.put(nick, artista);	
		}
		public DtFuncionDatos getDtFuncionDatos(DtEspectaculo Espectaculo) {
			Set<DtArtista> DtArtistaDevolver = new HashSet<DtArtista>();
			for (Map.Entry<String, Artista> entry : artistasinvitados.entrySet()) {
				DtArtistaDevolver.add(entry.getValue().getDtArtista());
			}
			Set<DtRegistroFuncion> datosRegistros = new HashSet<>();
			for(RegistroFuncion registro: this.registros) {
				datosRegistros.add(registro.getDtRegistroFuncion());
			}
			return new DtFuncionDatos(this.nombre, this.inicio, this.alta, DtArtistaDevolver, Espectaculo, imagen, espectadores, datosRegistros, fechaSorteo, obtenerGanadoresSorteo());
		}
		public Set<RegistroFuncion> getRegistros() {
			return registros;
		}
		public void setRegistros(Set<RegistroFuncion> registros) {
			this.registros = registros;
		}
		public void setRegistro(RegistroFuncion registro) {
			this.registros.add(registro);
		}
		public Set<DtEspectador> obtenerGanadoresSorteo(){
			Set<DtEspectador> ret = new HashSet<DtEspectador>();
			if (this.fechaSorteo!=null) {
				for(RegistroFuncion registro: this.registros) {
					if (registro.ganoPremio()) {
						ret.add(registro.getEspectador().getDtEspectador());
					}
				}
			}
			return ret;
		}
		
}
