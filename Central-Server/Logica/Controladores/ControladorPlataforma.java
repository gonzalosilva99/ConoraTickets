package Controladores;

import Interfaces.IPlataforma;
import java.util.Map;
import java.util.HashMap;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import Clases.Funcion;
import Clases.Paquete;
import DataTypes.DtEspectaculoDatos;
import DataTypes.DtFuncion;
import DataTypes.DtEspectaculo;
import DataTypes.DtFuncionDatos;
import DataTypes.DtPlataforma;
import Excepciones.Identidad;
import Manejadores.ManejadorPaquetes;
import Manejadores.ManejadorPlataforma;
import Manejadores.ManejadorUsuario;
import Clases.Espectaculo;
import Clases.Plataforma;



public class ControladorPlataforma implements IPlataforma{

	public Set<DtEspectaculo> listarEspectaculosDePlataforma(String Nombre) {
		ManejadorPlataforma manplat = Manejadores.ManejadorPlataforma.getInstancia();
		return manplat.listarEspectaculos(Nombre);
	};
						 
	public Set<DtFuncion> listarFuncionesDeEspectaculo(String NombrePlat, String NombreEsp) { 
		ManejadorPlataforma manplat = Manejadores.ManejadorPlataforma.getInstancia();
		return manplat.listarFuncionesDeEspectaculo(NombrePlat ,NombreEsp) ;
	};
	public DtFuncionDatos MostrarFuncion(String NombrePlat, String NombreEsp, String NombreFun) {
		ManejadorPlataforma manplat = Manejadores.ManejadorPlataforma.getInstancia();
		return manplat.listarDtFuncionDatos(NombrePlat, NombreEsp, NombreFun);
	};
	public DtEspectaculoDatos listarDtEspectaculoDatos(String nomPlat, String NombreEspectaculo) {
		ManejadorPlataforma manplat = Manejadores.ManejadorPlataforma.getInstancia();
		return manplat.listarDtEspectaculoDatos(nomPlat, NombreEspectaculo);
	};
	public void AltaPlataforma(String nombre, String Descripcion,String Url) throws Identidad{
		ManejadorPlataforma manplat = Manejadores.ManejadorPlataforma.getInstancia();
		manplat.AltaPlataforma(nombre, Descripcion, Url);
	};
	
	public Set<DtFuncion> listarFuncionesVigentesEspectaculo(String nombreEsp,String nombrePlat){
		ManejadorPlataforma manplat = Manejadores.ManejadorPlataforma.getInstancia();
		return manplat.listarFuncionesVigentesEspectaculo(nombreEsp, nombrePlat);
	};
	
	
	public void altaEspectaculo(String nomPlat, String nickArtista, String nomEspectaculo, String descripcion, Integer minEsp, Integer maxEsp, String url, Integer costo, Date fecha, Integer duracion, String imagen) throws Identidad{	 
			ManejadorPlataforma manplat = Manejadores.ManejadorPlataforma.getInstancia();
			manplat.altaEspectaculo(nomPlat, nickArtista, nomEspectaculo, descripcion, minEsp, maxEsp, url, costo, fecha, duracion, imagen);
	};
	
	
	public Funcion getFuncion(String nombreEspectaculo, String NomFuncion, String imagen) {
		Funcion ret = new Funcion(NomFuncion, null, null, imagen);
		return ret;
	};
	public Set<DtPlataforma> listarPlataformas(){
		ManejadorPlataforma manplat = Manejadores.ManejadorPlataforma.getInstancia();	
		return manplat.listarPlataformas();
	}
	public Set<DtEspectaculo> listarEspectaculos(String nombrePlataforma){
		ManejadorPlataforma manplat = Manejadores.ManejadorPlataforma.getInstancia();
		return manplat.listarEspectaculos(nombrePlataforma);
	}
	public void ConfirmarAltaFuncionEspectaculo(String nombrePlataforma, String nombreEspectaculo, String nombre, Date inicio,Set<String> artistas, Date alta, String imagen) {
		ManejadorPlataforma manplat = Manejadores.ManejadorPlataforma.getInstancia();
		manplat.ConfirmarAltaFuncionEspectaculo(nombrePlataforma, nombreEspectaculo, nombre, inicio, artistas, alta, imagen);
	}
	public Set<DtEspectaculo> listarEspectaculosEnPlataformaNoPaquete(String NombrePaquete, String NombrePlataforma) {
		ManejadorPlataforma manplat = Manejadores.ManejadorPlataforma.getInstancia();	
		return manplat.listarEspectaculosEnPlataformaNoPaquete(NombrePaquete, NombrePlataforma);
		
	}

	public Set<DtEspectaculoDatos> listarEspectaculoDatosDePlataforma(String Nombre){
		ManejadorPlataforma manplat = Manejadores.ManejadorPlataforma.getInstancia();
		return manplat.listarEspectaculoDatosDePlataforma(Nombre);
	}
	
	public boolean existeFuncion(String nombreFuncion) {
		ManejadorPlataforma manplat = Manejadores.ManejadorPlataforma.getInstancia();
		return manplat.existeFuncion(nombreFuncion);
	}
	public DtEspectaculoDatos getDatosEspectaculo(String nombrePlataforma, String nombreEspectaculo) {
		ManejadorPlataforma manplat = Manejadores.ManejadorPlataforma.getInstancia();
		return manplat.getDatosEspectaculo(nombrePlataforma, nombreEspectaculo);
	}
	
	public DtEspectaculoDatos findDatosEspectaculo(String nombreEspectaculo) {
		ManejadorPlataforma manplat = Manejadores.ManejadorPlataforma.getInstancia();
		return manplat.findDatosEspectaculo(nombreEspectaculo);
	}
	
	public String getPlataformaDeEspectaculo(String esp) {
		ManejadorPlataforma manplat = Manejadores.ManejadorPlataforma.getInstancia();
		return manplat.getPlataformaDeEspectaculo(esp);
	}
	public DtFuncionDatos getFuncionDatos(String nombrePlat, String nombreEspectaculo, String nombreFuncion) {
		ManejadorPlataforma manplat = Manejadores.ManejadorPlataforma.getInstancia();
		return manplat.getFuncionDatos(nombrePlat, nombreEspectaculo, nombreFuncion) ;
	}
	
	public DtFuncionDatos findDatosFuncion(String nombre) {
		ManejadorPlataforma manplat = Manejadores.ManejadorPlataforma.getInstancia();
		return manplat.findFuncionDatos(nombre) ;
	}
	
	public Boolean PuedeAgregarEspectadores(String nombrePlataforma, String nombreEspectaculo, String nombreFuncion) {
		ManejadorPlataforma manplat = Manejadores.ManejadorPlataforma.getInstancia();
		return manplat.PuedeAgregarEspectadores(nombrePlataforma,nombreEspectaculo,nombreFuncion);
	}

}


