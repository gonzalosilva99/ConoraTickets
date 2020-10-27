package Clases;

import java.util.Date;
import DataTypes.DtUsuario;
import DataTypes.EstadoEspectaculo;
import DataTypes.DtArtista;
import DataTypes.DtEspectaculo;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.swing.JOptionPane;

import DataTypes.DtArtistaConsulta;
import DataTypes.DtArtistaPerfil;


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
		
		
		public DtArtista getDtArtista() {
			DtArtista ret = new DtArtista(this.getNickname(),this.getNombre(),this.getApellido(),this.getEmail(),this.getNacimiento(),this.getDescripcionGeneral(),this.getBiografia(),this.getURL());
			return ret;
		}
		
		public DtArtistaPerfil getDtArtistaPerfil() {
			HashSet<DtUsuario> seguidores = new HashSet<DtUsuario>();
			for (Map.Entry<String,Usuario> entry : Seguidores.entrySet()) {
					DtUsuario nuevo = entry.getValue().getDtUsuario();
					seguidores.add(nuevo);
			}
			
			HashSet<DtUsuario> siguiendo = new HashSet<DtUsuario>();
			for (Map.Entry<String,Usuario> entry : Siguiendo.entrySet()) {
					DtUsuario nuevo = entry.getValue().getDtUsuario();
					siguiendo.add(nuevo);
			}
			HashSet<DtEspectaculo> espna = new HashSet<DtEspectaculo>();
			Iterator<Espectaculo> itresp = Espectaculos.iterator();
			while(itresp.hasNext()) {
				Espectaculo nuevo = itresp.next();
				if(nuevo.getEstado()!=EstadoEspectaculo.Aceptado)
					espna.add(nuevo.getDatosEspectaculo());
			}
			
			HashSet<DtEspectaculo> esp = new HashSet<DtEspectaculo>();
			Iterator<Espectaculo> itr = Espectaculos.iterator();
			while(itr.hasNext()) {
				DtEspectaculo nuevo = itr.next().getDatosEspectaculo();
				esp.add(nuevo);
			}
			DtArtistaPerfil ret = new DtArtistaPerfil(this.getNickname(),this.getNombre(),this.getApellido(),this.getEmail(),this.getNacimiento(),this.getImagen(),this.getContrasena(),this.getDescripcionGeneral(),this.getBiografia(),this.getURL(),esp,seguidores,siguiendo,espna);
			return ret;
		}
		
		public DtArtistaConsulta getDtArtistaConsulta() {
			HashSet<DtUsuario> seguidores = new HashSet<DtUsuario>();
			for (Map.Entry<String,Usuario> entry : Seguidores.entrySet()) {
					DtUsuario nuevo = entry.getValue().getDtUsuario();
					seguidores.add(nuevo);
			}
			
			HashSet<DtUsuario> siguiendo = new HashSet<DtUsuario>();
			for (Map.Entry<String,Usuario> entry : Siguiendo.entrySet()) {
					DtUsuario nuevo = entry.getValue().getDtUsuario();
					siguiendo.add(nuevo);
			}
			
			HashSet<DtEspectaculo> esp = new HashSet<DtEspectaculo>();
			Iterator<Espectaculo> itr = Espectaculos.iterator();
			while(itr.hasNext()) {
				DtEspectaculo nuevo = itr.next().getDatosEspectaculo();
				esp.add(nuevo);
			}
			DtArtistaConsulta ret = new DtArtistaConsulta(this.getNickname(),this.getNombre(),this.getApellido(),this.getEmail(),this.getNacimiento(),this.getImagen(),this.getContrasena(),this.getDescripcionGeneral(),this.getBiografia(),this.getURL(),esp,seguidores,siguiendo);
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
