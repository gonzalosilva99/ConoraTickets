package Clases;

import java.util.Date;
import DataTypes.DtUsuario;
import DataTypes.DtArtista;
import DataTypes.DtEspectaculo;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JOptionPane;

import DataTypes.DtArtistaConsulta;


public class Artista extends Usuario{
	private
		String DescripcionGeneral;
		String Biografia;
		String URL;
		HashSet<Espectaculo> Espectaculos;
		HashSet<Funcion> FuncionesInvitado;
		
		public Artista(String nickname, String nombre, String apellido, String email, Date nacimiento, String imagen, String contrasena, String descripcionGeneral, String biografia, String uRL) {
			super(nickname,nombre, apellido, email,nacimiento,imagen,contrasena);
			DescripcionGeneral = descripcionGeneral;
			Biografia = biografia;
			URL = uRL;
			Espectaculos = new HashSet<Espectaculo>();
			FuncionesInvitado = new HashSet<Funcion>();
		}
		public String getDescripcionGeneral() {
			return DescripcionGeneral;
		}
		public void setDescripcionGeneral(String descripcionGeneral) {
			DescripcionGeneral = descripcionGeneral;
		}
		public String getBiografia() {
			return Biografia;
		}
		public void setBiografia(String biografia) {
			Biografia = biografia;
		}
		public String getURL() {
			return URL;
		}
		public void setURL(String uRL) {
			URL = uRL;
		}
		
		public HashSet<Espectaculo> getEspectaculos() {
			return Espectaculos;
		}
		public void setEspectaculos(HashSet<Espectaculo> espectaculos) {
			Espectaculos = espectaculos;
		}
		public DtUsuario getDtUsuario() {
			DtUsuario ret = new DtUsuario(this.getNickname(),this.getNombre(),this.getApellido());
			return ret;
		}
		public DtArtista getDtArtista() {
			DtArtista ret = new DtArtista(this.getNickname(),this.getNombre(),this.getApellido(),this.getEmail(),this.getNacimiento(),this.getDescripcionGeneral(),this.getBiografia(),this.getURL());
			return ret;
		}
		
		public DtArtistaConsulta getDtArtistaConsulta() {
			HashSet<DtEspectaculo> esp = new HashSet<DtEspectaculo>();
			Iterator<Espectaculo> itr = Espectaculos.iterator();
			while(itr.hasNext()) {
				DtEspectaculo nuevo = itr.next().getDatosEspectaculo();
				esp.add(nuevo);
			}
			DtArtistaConsulta ret = new DtArtistaConsulta(this.getNickname(),this.getNombre(),this.getApellido(),this.getEmail(),this.getNacimiento(),this.getDescripcionGeneral(),this.getBiografia(),this.getURL(),esp);
			return ret;
		}
		
		public void AnadirEspectaculo(Espectaculo e) {
			Espectaculos.add(e);
		}
		public void anadirFuncion(Funcion funcion) {
			funcion.anadirArtista(this,this.getNickname());
			FuncionesInvitado.add(funcion);
		}
		public boolean participaEspectaculo(String nombreEspectaculo) {
			Iterator<Espectaculo> itr = Espectaculos.iterator();
			while(itr.hasNext()) {
				if (itr.next().getNombre() == nombreEspectaculo)
					return true;	
				}
			return false;
		}
	
}