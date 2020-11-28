package interfaces;

import java.util.Date;
import java.util.Set;

import clases.Funcion;
import datatypes.DtCategoria;
import datatypes.DtEspectaculo;
import datatypes.DtEspectaculoDatos;
import datatypes.DtEspectador;
import datatypes.DtFuncion;
import datatypes.DtFuncionDatos;
import datatypes.DtPlataforma;
import excepciones.Identidad;
import Persistencia.EspectaculoPersistencia;

public interface IPlataforma {
	public 
		Set<DtEspectaculo> listarEspectaculosDePlataforma(String Nombre);
		public Set<DtEspectaculo> listarEspectaculosAceptadosDePlataforma(String Nombre);
		Set<DtFuncion> listarFuncionesDeEspectaculo(String NombrePlat, String NombreEsp);
		DtFuncionDatos mostrarFuncion(String NombrePlat, String NombreEsp, String NombreFun);
		DtEspectaculoDatos listarDtEspectaculoDatos(String nomPlat, String NombreEspectaculo);
		void altaPlataforma(String nombre, String Descripcion, String Url) throws Identidad;
		Set<DtFuncion> listarFuncionesVigentesEspectaculo(String nombreEsp, String nombrePlat);
		public void altaEspectaculo(String nomPlat, String nickArtista, String nomEspectaculo, String descripcion, 
				Integer minEsp, Integer maxEsp, String url, Integer costo, Date fecha, Integer duracion, String imagen, Set<String> categorias,  String urlVideo, String premio, int cantPremios) throws Identidad;
		public Funcion getFuncion(String nombreEspectaculo, String NomFuncion, String imagen);
		Set<DtPlataforma> listarPlataformas();
		public Set<DtEspectaculo> listarEspectaculos(String nombrePlataforma);
		void confirmarAltaFuncionEspectaculo(String nombrePlataforma, String nombreEspectaculo, String nombre, Date inicio, Set<String> artistas, Date alta, String imagen);		
		public Set<DtEspectaculo> listarEspectaculosEnPlataformaNoPaquete(String NombrePaquete, String NombrePlataforma);
		Set<DtEspectaculoDatos> listarEspectaculoDatosDePlataforma(String Nombre);
		public boolean existeFuncion(String nombreFuncion);
		public DtEspectaculoDatos getDatosEspectaculo(String nombrePlataforma, String nombreEspectaculo);
		public DtEspectaculoDatos findDatosEspectaculo(String nombreEspectaculo);
		public String getPlataformaDeEspectaculo(String esp);
		public DtFuncionDatos getFuncionDatos(String nombrePlat, String nombreEspectaculo, String nombreFuncion);
		public DtFuncionDatos findDatosFuncion(String nombre);
		public Boolean puedeAgregarEspectadores(String nombrePlataforma, String nombreEspectaculo, String nombreFuncion);
		public Set<DtCategoria> listarCategoriasDeEspectaculo(String Plataforma, String Espectaculo);
		public Set<DtEspectaculo> listarEspectaculosIngresados();
		public void aceptarEspectaculo(String nomEspectaculo);
		public void rechazarEspectaculo(String nomEspectaculo);
		public void finzalizarEspectaculo(String nomEspectaculo, Date fechafin);
		public Set<DtEspectaculoDatos> filtrarEspectaculos(String search);
		public Boolean espectaculoinPlataforma(String nombrePlataforma, String nombreEspectaculo);
		public DtFuncion getDtFuncion(String nombreFuncion);
		public Set<DtEspectador> sortearPremios(String nombrePlataforma, String nombreEspectaculo, String nombreFuncion);
		public EspectaculoPersistencia getEspectculoPersistencia(String nombreesp);
		public void setearPremios(String plat, String esp, String fun, String nick, Date fecha);
}
