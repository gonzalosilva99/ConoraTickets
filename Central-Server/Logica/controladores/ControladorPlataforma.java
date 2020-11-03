package controladores;

import java.util.Map;
import java.util.HashMap;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import clases.Categoria;
import clases.Espectaculo;
import clases.Funcion;
import clases.Paquete;
import clases.Plataforma;
import datatypes.DtCategoria;
import datatypes.DtEspectaculo;
import datatypes.DtEspectaculoDatos;
import datatypes.DtFuncion;
import datatypes.DtFuncionDatos;
import datatypes.DtPlataforma;
import excepciones.Identidad;
import interfaces.IPlataforma;
import manejadores.ManejadorPaquetes;
import manejadores.ManejadorPlataforma;
import manejadores.ManejadorUsuario;




public class ControladorPlataforma implements IPlataforma{

	public Set<DtEspectaculo> listarEspectaculosDePlataforma(String Nombre) {
		ManejadorPlataforma manplat = manejadores.ManejadorPlataforma.getInstancia();
		return manplat.listarEspectaculos(Nombre);
	};
	
	public Set<DtEspectaculo> listarEspectaculosAceptadosDePlataforma(String Nombre) {
		ManejadorPlataforma manplat = manejadores.ManejadorPlataforma.getInstancia();
		return manplat.listarEspectaculosAceptadosDePlataforma(Nombre);
	};
						 
	public Set<DtFuncion> listarFuncionesDeEspectaculo(String NombrePlat, String NombreEsp) { 
		ManejadorPlataforma manplat = manejadores.ManejadorPlataforma.getInstancia();
		return manplat.listarFuncionesDeEspectaculo(NombrePlat , NombreEsp) ;
	};
	public DtFuncionDatos mostrarFuncion(String NombrePlat, String NombreEsp, String NombreFun) {
		ManejadorPlataforma manplat = manejadores.ManejadorPlataforma.getInstancia();
		return manplat.listarDtFuncionDatos(NombrePlat, NombreEsp, NombreFun);
	};
	public DtEspectaculoDatos listarDtEspectaculoDatos(String nomPlat, String NombreEspectaculo) {
		ManejadorPlataforma manplat = manejadores.ManejadorPlataforma.getInstancia();
		return manplat.listarDtEspectaculoDatos(nomPlat, NombreEspectaculo);
	};
	public void altaPlataforma(String nombre, String Descripcion, String Url) throws Identidad{
		ManejadorPlataforma manplat = manejadores.ManejadorPlataforma.getInstancia();
		manplat.altaPlataforma(nombre, Descripcion, Url);
	};
	
	
	public Set<DtEspectaculoDatos> filtrarEspectaculos(String search){
		ManejadorPlataforma manplat = manejadores.ManejadorPlataforma.getInstancia();
		return manplat.filtrarEspectaculos(search);
	}
	public Set<DtFuncion> listarFuncionesVigentesEspectaculo(String nombreEsp, String nombrePlat){
		ManejadorPlataforma manplat = manejadores.ManejadorPlataforma.getInstancia();
		return manplat.listarFuncionesVigentesEspectaculo(nombreEsp, nombrePlat);
	};
	
	
	public void altaEspectaculo(String nomPlat, String nickArtista, String nomEspectaculo, String descripcion, Integer minEsp, Integer maxEsp, String url, Integer costo, Date fecha, Integer duracion, String imagen, Set<String> categorias) throws Identidad{	 
			ManejadorPlataforma manplat = manejadores.ManejadorPlataforma.getInstancia();
			manplat.altaEspectaculo(nomPlat, nickArtista, nomEspectaculo, descripcion, minEsp, maxEsp, url, costo, fecha, duracion, imagen, categorias);
	};
	
	
	public Funcion getFuncion(String nombreEspectaculo, String NomFuncion, String imagen) {
		Funcion ret = new Funcion(NomFuncion, null, null, imagen);
		return ret;
	};
	public Set<DtPlataforma> listarPlataformas(){
		ManejadorPlataforma manplat = manejadores.ManejadorPlataforma.getInstancia();	
		return manplat.listarPlataformas();
	}
	public Set<DtEspectaculo> listarEspectaculos(String nombrePlataforma){
		ManejadorPlataforma manplat = manejadores.ManejadorPlataforma.getInstancia();
		return manplat.listarEspectaculos(nombrePlataforma);
	}
	
	public HashSet<DtEspectaculo> listarEspectaculosIngresados(){
		ManejadorPlataforma manplat = manejadores.ManejadorPlataforma.getInstancia();
		return manplat.listarEspectaculosIngresados();
	}
	
	public void confirmarAltaFuncionEspectaculo(String nombrePlataforma, String nombreEspectaculo, String nombre, Date inicio, Set<String> artistas, Date alta, String imagen) {
		ManejadorPlataforma manplat = manejadores.ManejadorPlataforma.getInstancia();
		manplat.confirmarAltaFuncionEspectaculo(nombrePlataforma, nombreEspectaculo, nombre, inicio, artistas, alta, imagen);
	}
	public Set<DtEspectaculo> listarEspectaculosEnPlataformaNoPaquete(String NombrePaquete, String NombrePlataforma) {
		ManejadorPlataforma manplat = manejadores.ManejadorPlataforma.getInstancia();	
		return manplat.listarEspectaculosEnPlataformaNoPaquete(NombrePaquete, NombrePlataforma);
		
	}

	public Set<DtEspectaculoDatos> listarEspectaculoDatosDePlataforma(String Nombre){
		ManejadorPlataforma manplat = manejadores.ManejadorPlataforma.getInstancia();
		return manplat.listarEspectaculoDatosDePlataforma(Nombre);
	}
	
	public boolean existeFuncion(String nombreFuncion) {
		ManejadorPlataforma manplat = manejadores.ManejadorPlataforma.getInstancia();
		return manplat.existeFuncion(nombreFuncion);
	}
	public DtEspectaculoDatos getDatosEspectaculo(String nombrePlataforma, String nombreEspectaculo) {
		ManejadorPlataforma manplat = manejadores.ManejadorPlataforma.getInstancia();
		return manplat.getDatosEspectaculo(nombrePlataforma, nombreEspectaculo);
	}
	
	public DtEspectaculoDatos findDatosEspectaculo(String nombreEspectaculo) {
		ManejadorPlataforma manplat = manejadores.ManejadorPlataforma.getInstancia();
		return manplat.findDatosEspectaculo(nombreEspectaculo);
	}
	
	public String getPlataformaDeEspectaculo(String esp) {
		ManejadorPlataforma manplat = manejadores.ManejadorPlataforma.getInstancia();
		return manplat.getPlataformaDeEspectaculo(esp);
	}
	public DtFuncionDatos getFuncionDatos(String nombrePlat, String nombreEspectaculo, String nombreFuncion) {
		ManejadorPlataforma manplat = manejadores.ManejadorPlataforma.getInstancia();
		return manplat.getFuncionDatos(nombrePlat, nombreEspectaculo, nombreFuncion) ;
	}
	
	public DtFuncionDatos findDatosFuncion(String nombre) {
		ManejadorPlataforma manplat = manejadores.ManejadorPlataforma.getInstancia();
		return manplat.findFuncionDatos(nombre) ;
	}
	
	public Boolean puedeAgregarEspectadores(String nombrePlataforma, String nombreEspectaculo, String nombreFuncion) {
		ManejadorPlataforma manplat = manejadores.ManejadorPlataforma.getInstancia();
		return manplat.puedeAgregarEspectadores(nombrePlataforma, nombreEspectaculo, nombreFuncion);
	}
	
	public HashSet<DtCategoria> listarCategoriasDeEspectaculo(String Plataforma, String Espectaculo) {
		ManejadorPlataforma manplat = manejadores.ManejadorPlataforma.getInstancia();
		return manplat.listarCategoriasDeEspectaculo(Plataforma, Espectaculo);
	}
	
	public void aceptarEspectaculo(String nomEspectaculo) {
		ManejadorPlataforma manplat = manejadores.ManejadorPlataforma.getInstancia();
		manplat.aceptarEspectaculo(nomEspectaculo);
	}
	
	public void rechazarEspectaculo(String nomEspectaculo) {
		ManejadorPlataforma manplat = manejadores.ManejadorPlataforma.getInstancia();
		manplat.rechazarEspectaculo(nomEspectaculo);
	}

	public Boolean espectaculoinPlataforma(String nombrePlataforma, String nombreEspectaculo) {
		ManejadorPlataforma manplat = manejadores.ManejadorPlataforma.getInstancia();
		return manplat.espectaculoinPlataforma(nombrePlataforma, nombreEspectaculo);
	}

}


