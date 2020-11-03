package clases;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.swing.JOptionPane;

import clases.Espectaculo;
import clases.Funcion;
import clases.Usuario;
import datatypes.DtArtista;
import datatypes.DtArtistaConsulta;
import datatypes.DtArtistaPerfil;
import datatypes.DtEspectaculo;
import datatypes.DtFuncion;
import datatypes.DtUsuario;
import datatypes.EstadoEspectaculo;


public class Artista extends Usuario{
	private
		String descripcionGeneral;
		String biografia;
		String url;
		Set<Espectaculo> espectaculos;
		Set<Funcion> funcionesinvitado;
		
		public Artista(String nickname, String nombre, String apellido, String email, Date nacimiento, String imagen, String contrasena, String descripcionGeneral, String biografia, String url) {
			super(nickname, nombre, apellido, email, nacimiento, imagen, contrasena);
			this.descripcionGeneral = descripcionGeneral;
			this.biografia = biografia;
			this.url = url;
			this.espectaculos = new HashSet<Espectaculo>();
			this.funcionesinvitado = new HashSet<Funcion>();
		}
		public String getDescripcionGeneral() {
			return descripcionGeneral;
		}
		public void setDescripcionGeneral(String descripcionGeneral) {
			this.descripcionGeneral = descripcionGeneral;
		}
		public String getBiografia() {
			return biografia;
		}
		public void setBiografia(String biografia) {
			this.biografia = biografia;
		}
		public String getURL() {
			return url;
		}
		public void setURL(String url) {
			this.url = url;
		}
		public Set<Funcion> getFuncionesInvitado() {
			return funcionesinvitado;
		}
		public void setFuncionesInvitado(HashSet<Funcion> funcionesinvitado) {
			this.funcionesinvitado = funcionesinvitado;
		}
		public Set<Espectaculo> getEspectaculos() {
			return espectaculos;
		}
		public void setEspectaculos(HashSet<Espectaculo> espectaculos) {
			this.espectaculos = espectaculos;
		}
		
		
		public DtArtista getDtArtista() {
			HashSet<DtEspectaculo> datosEspectaculos = new HashSet<DtEspectaculo>();
			Iterator<Espectaculo> itresp = espectaculos.iterator();
			while (itresp.hasNext()) {
				Espectaculo nuevo = itresp.next();
				if (nuevo.getEstado()!=EstadoEspectaculo.Aceptado)
					datosEspectaculos.add(nuevo.getDatosEspectaculo());
			}
			DtArtista ret = new DtArtista(this.getNickname(), this.getNombre(), this.getApellido(), this.getEmail(), this.getNacimiento(), this.getDescripcionGeneral(), this.getBiografia(), this.getURL(), datosEspectaculos);
			return ret;
		}
		
		public DtArtistaPerfil getDtArtistaPerfil() {
			Set<DtUsuario> seguidore = new HashSet<DtUsuario>();
			for (Map.Entry<String, Usuario> entry : seguidores.entrySet()) {
					DtUsuario nuevo = entry.getValue().getDtUsuario();
					seguidore.add(nuevo);
			}
			
			Set<DtUsuario> siguiend = new HashSet<DtUsuario>();
			for (Map.Entry<String, Usuario> entry : siguiendo.entrySet()) {
					DtUsuario nuevo = entry.getValue().getDtUsuario();
					siguiend.add(nuevo);
			}
			Set<DtEspectaculo> espna = new HashSet<DtEspectaculo>();
			Iterator<Espectaculo> itresp = espectaculos.iterator();
			while (itresp.hasNext()) {
				Espectaculo nuevo = itresp.next();
				if (nuevo.getEstado()!=EstadoEspectaculo.Aceptado)
					espna.add(nuevo.getDatosEspectaculo());
			}
			
			Set<DtEspectaculo> esp = new HashSet<DtEspectaculo>();
			Iterator<Espectaculo> itr = espectaculos.iterator();
			while (itr.hasNext()) {
				DtEspectaculo nuevo = itr.next().getDatosEspectaculo();
				esp.add(nuevo);
			}
			
			Set<DtFuncion> fun = new HashSet<DtFuncion>();
			Iterator<Funcion> itrf = this.funcionesinvitado.iterator();
			while (itrf.hasNext()) {
				DtFuncion nuevo = itrf.next().getDtFuncion();
				fun.add(nuevo);
			}
			DtArtistaPerfil ret = new DtArtistaPerfil(this.getNickname(), this.getNombre(), this.getApellido(), this.getEmail(), this.getNacimiento(), this.getImagen(), this.getContrasena(), this.getDescripcionGeneral(), this.getBiografia(), this.getURL(), esp, seguidore, siguiend, espna, this.getUltimoIngreso(), fun);
			return ret;
		}
		
		public DtArtistaConsulta getDtArtistaConsulta() {
			HashSet<DtUsuario> seguidore = new HashSet<DtUsuario>();
			for (Map.Entry<String, Usuario> entry : seguidores.entrySet()) {
					DtUsuario nuevo = entry.getValue().getDtUsuario();
					seguidore.add(nuevo);
			}
			
			HashSet<DtUsuario> siguiend = new HashSet<DtUsuario>();
			for (Map.Entry<String, Usuario> entry : siguiendo.entrySet()) {
					DtUsuario nuevo = entry.getValue().getDtUsuario();
					siguiend.add(nuevo);
			}
			
			HashSet<DtEspectaculo> esp = new HashSet<DtEspectaculo>();
			Iterator<Espectaculo> itr = espectaculos.iterator();
			while (itr.hasNext()) {
				DtEspectaculo nuevo = itr.next().getDatosEspectaculo();
				esp.add(nuevo);
			}
			DtArtistaConsulta ret = new DtArtistaConsulta(this.getNickname(), this.getNombre(), this.getApellido(), this.getEmail(), this.getNacimiento(), this.getImagen(), this.getContrasena(), this.getDescripcionGeneral(), this.getBiografia(), this.getURL(), esp, seguidore, siguiend);
			return ret;
		}
		
		public void AnadirEspectaculo(Espectaculo e) {
			espectaculos.add(e);
		}
		public void anadirFuncion(Funcion funcion) {
			funcion.anadirArtista(this, this.getNickname());
			funcionesinvitado.add(funcion);
		}
		public boolean participaEspectaculo(String nombreEspectaculo) {
			Iterator<Espectaculo> itr = espectaculos.iterator();
			while (itr.hasNext()) {
				if (itr.next().getNombre() == nombreEspectaculo)
					return true;	
				}
			return false;
		}
	
}
