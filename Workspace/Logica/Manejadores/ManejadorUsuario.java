package Manejadores;
import java.util.*;
import Clases.Espectador;
import Clases.Artista;
import DataTypes.DtPaquete;
import DataTypes.DtArtisa;
import DataTypes.DtRegistro;

public class ManejadorUsuario {
	private 
		Map<String,Artista> Artistas;
		Map<String,Espectador> Espectadores;
		
	public 
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
		
		Set<DtArtista> listarArtistas(){
			return new HashSet<DtUsuario>();
		}
		
		Espectador getEspectador(String nickname) {
			return new Espectador();
		}
}
