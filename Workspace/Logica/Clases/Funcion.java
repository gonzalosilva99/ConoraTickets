package Clases;

import java.util.Date;
import java.util.Map;
import java.util.HashMap;

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
		public Date getAlta() {
			return Alta;
		}
		public void setAlta(Date alta) {
			Alta = alta;
		}
		public Map<String, Artista> getArtistasInvitado(){
			return ArtistasInvitados;
		}

		
}
