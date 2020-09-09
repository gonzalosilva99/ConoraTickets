package Manejadores;
import java.util.*;
import Clases.Espectador;
import Clases.Artista;
import DataTypes.DtPaquete;
import DataTypes.DtArtista;
import DataTypes.DtRegistro;
import java.util.Date;
public class ManejadorUsuario {
	private 
		static ManejadorUsuario instancia;
		Map<String,Artista> Artistas;
		Map<String,Espectador> Espectadores;
		
	public 
		static ManejadorUsuario getInstancia() {
			if(instancia==null)
				instancia=new ManejadorUsuario();
			return instancia;
		}
		Map<String, Artista> getArtistas() {
			return Artistas;
		}
		void setArtistas(Map<String, Artista> artistas) {
			Artistas = artistas;
		}
		Map<String, Espectador> getEspectadores() {
			return Espectadores;
		}
		void setEspectadores(Map<String, Espectador> espectadores) {
			Espectadores = espectadores;
		}
		
		Set<DtArtista> listarArtistas(){
			return new HashSet<DtUsuario>();
		}
		
		Set<DtEspectador> listarEspectadores() {
			return new HashSet<DtEspectador>();
		}
		
		Set<DtPaquete> listarPaquetesCanjeables(String nickname, String espectaculo) {
			return new HashSet<DtPaquete>();
		}
		
		Set<DtRegistro> listarResgistrosSinCanjear(String nickname) {
			return HashSet<DtRegistro>();
		}
		
		
		Espectador getEspectador(String nickname) {
			Date fecha = new Date();
			return new Espectador("","","","",fecha);
		}
}
