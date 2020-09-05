package CentralServer;

public class Plataforma {
	private String Nombre;
	private String Descripcion;
		public Plataforma(String nombre, String descripcion) {
			super();
			Nombre = nombre;
			Descripcion = descripcion;
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
		
}
