package Clases;

import java.util.Calendar;
import java.util.Date;

import DataTypes.DtArtista;
import DataTypes.DtEspectaculo;
import DataTypes.DtFuncion;
import DataTypes.DtFuncionDatos;

import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;

public class Funcion {
	private String nombre;
	private Date inicio;
	private Date alta;
	private String imagen;
	private Map<String, Artista> artistasinvitados;
	private Integer espectadores;
		public Funcion(String nombre, Date inicio, Date alta, String imagen) {
			super();
			this.nombre = nombre;
			this.inicio = inicio;
			this.alta = alta;
			this.imagen = imagen;
			this.artistasinvitados = new HashMap<String, Artista>();
			this.espectadores = 0;
		}
		public String getNombre() {
			return nombre;
		}
		
		public Integer getEspectadores() {
			return espectadores;
		}
		
		public void IncrementarEspectadores() {
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
			return new DtFuncionDatos(this.nombre, this.inicio, this.alta, DtArtistaDevolver, Espectaculo, imagen, espectadores);
		}

		
}
