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
	private String Nombre;
	private Date Inicio;
	private Date Alta;
	private Map<String, Artista> ArtistasInvitados;
		public Funcion(String nombre, Date inicio, Date alta) {
			super();
			Nombre = nombre;
			Inicio = inicio;
			Alta = alta;
			ArtistasInvitados = new HashMap<String, Artista>();
		}
		public String getNombre() {
			return Nombre;
		}
		public void setNombre(String nombre) {
			Nombre = nombre;
		}
		public Date getInicio() {
			return Inicio;
		}
		public void setInicio(Date inicio) {
			Inicio = inicio;
		}
		public Boolean estaVigente() {
			Date today = Calendar.getInstance().getTime();
			if(today.compareTo(Inicio) > 0)
				return false;
			else return true;
		}
		
		public Date getAlta() {
			return Alta;
		}
		public void setAlta(Date alta) {
			Alta = alta;
		}
		
		public DtFuncion getDtFuncion() {
			DtFuncion dtfun = new DtFuncion(this.Nombre,this.Inicio,this.Alta);
			return dtfun;
		}
		public Map<String, Artista> getArtistasInvitado(){
			return ArtistasInvitados;
		}
		public void anadirArtista(Artista artista, String nick) {
			ArtistasInvitados.put(nick, artista);	
		}
		public DtFuncionDatos getDtFuncionDatos(DtEspectaculo Espectaculo) {
			Set<DtArtista> DtArtistaDevolver = new HashSet<DtArtista>();
			for (Map.Entry<String,Artista> entry : ArtistasInvitados.entrySet()) {
				DtArtistaDevolver.add(entry.getValue().getDtArtista());
			}
			return new DtFuncionDatos(this.Nombre, this.Inicio, this.Alta, DtArtistaDevolver, Espectaculo);
		}
		
}
