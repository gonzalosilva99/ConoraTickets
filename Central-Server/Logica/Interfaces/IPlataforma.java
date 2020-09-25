package Interfaces;

import java.util.Date;
import java.util.Set;
import java.util.Map;

import Clases.Funcion;
import DataTypes.DtEspectaculo;
import DataTypes.DtEspectaculoDatos;
import DataTypes.DtFuncion;
import DataTypes.DtFuncionDatos;
import DataTypes.DtPlataforma;
import Excepciones.Identidad;

public interface IPlataforma {
	public 
		Set<DtEspectaculo> listarEspectaculosDePlataforma(String Nombre);
		Set<DtFuncion> listarFuncionesDeEspectaculo(String NombrePlat, String NombreEsp);
		DtFuncionDatos MostrarFuncion(String NombrePlat, String NombreEsp, String NombreFun);
		DtEspectaculoDatos listarDtEspectaculoDatos(String nomPlat, String NombreEspectaculo);
		void AltaPlataforma(String nombre, String Descripcion,String Url) throws Identidad;
		Set<DtFuncion> listarFuncionesVigentesEspectaculo(String nombreEsp,String nombrePlat);
		public void altaEspectaculo(String nomPlat, String nickArtista, String nomEspectaculo, String descripcion, Integer minEsp, Integer maxEsp, String url, Integer costo, Date fecha, Integer duracion, String imagen) throws Identidad;
		Funcion getFuncion(String nombreEspectaculo, String NomFuncion, String imagen);
		Set<DtPlataforma> listarPlataformas();
		public Set<DtEspectaculo> listarEspectaculos(String nombrePlataforma);
		void ConfirmarAltaFuncionEspectaculo(String nombrePlataforma, String nombreEspectaculo, String nombre, Date inicio,Set<String> artistas, Date alta, String imagen);		
		public Set<DtEspectaculo> listarEspectaculosEnPlataformaNoPaquete(String NombrePaquete, String NombrePlataforma);
		Set<DtEspectaculoDatos> listarEspectaculoDatosDePlataforma(String Nombre);
		public boolean existeFuncion(String nombreFuncion);
		public DtEspectaculoDatos getDatosEspectaculo(String nombrePlataforma, String nombreEspectaculo);
		public DtEspectaculoDatos findDatosEspectaculo(String nombreEspectaculo);
		public String getPlataformaDeEspectaculo(String esp);
		public DtFuncionDatos getFuncionDatos(String nombrePlat, String nombreEspectaculo, String nombreFuncion);
		public DtFuncionDatos findDatosFuncion(String nombre);
		public Boolean PuedeAgregarEspectadores(String nombrePlataforma, String nombreEspectaculo, String nombreFuncion);
}
