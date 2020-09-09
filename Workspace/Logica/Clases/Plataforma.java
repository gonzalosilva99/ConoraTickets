package Clases;
import java.util.HashMap;
import java.util.Map;

public class Plataforma {
	private String Nombre;
	private String Descripcion;
	private String Url;
	private Map<String,Espectaculo> Espectaculos;
		public Plataforma(String nombre, String descripcion, String Url) {
			super();
			Nombre = nombre;
			Descripcion = descripcion;
			Espectaculos = new HashMap<String,Espectaculo>();
		}
		public String getUrl() {
			return Url;
		}
		public void setUrl(String url) {
			Url = url;
		}
		public Map<String, Espectaculo> getEspectaculos() {
			return Espectaculos;
		}
		public void setEspectaculos(Map<String, Espectaculo> espectaculos) {
			Espectaculos = espectaculos;
		}
		public String getNombre() {
			return Nombre;
		}
		public void setNombre(String nombre) {
			Nombre = nombre;
		}
		public String getDescripcion() {
			return Descripcion;
		}
		public void setDescripcion(String descripcion) {
			Descripcion = descripcion;
		}
		public Funcion getFuncion(String nombreEspectaculo, String nomFuncion) {
			Espectaculo esp = Espectaculos.get(nombreEspectaculo);
			return esp.getFuncion(nomFuncion);
		}
}
