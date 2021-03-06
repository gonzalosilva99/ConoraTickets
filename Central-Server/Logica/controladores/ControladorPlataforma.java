package controladores;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import clases.Funcion;
import datatypes.DtCategoria;
import datatypes.DtEspectaculo;
import datatypes.DtEspectaculoDatos;
import datatypes.DtEspectador;
import datatypes.DtFuncion;
import datatypes.DtFuncionDatos;
import datatypes.DtPlataforma;
import excepciones.Identidad;
import Persistencia.ArtistaPersistencia;
import Persistencia.EspectaculoPersistencia;
import Persistencia.FuncionPersistencia;
import Persistencia.RegistroPersistencia;
import Persistencia.SetEspectaculoPersistencia;
import interfaces.IPlataforma;
import manejadores.ManejadorPlataforma;
import relaciones.RegistroFuncion;




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
	
	
	public void altaEspectaculo(String nomPlat, String nickArtista, String nomEspectaculo, String descripcion, Integer minEsp, Integer maxEsp, String url, Integer costo, Date fecha, Integer duracion, String imagen, Set<String> categorias,  String urlVideo, String premio, int cantPremios) throws Identidad{	 
			ManejadorPlataforma manplat = manejadores.ManejadorPlataforma.getInstancia();
			manplat.altaEspectaculo(nomPlat, nickArtista, nomEspectaculo, descripcion, minEsp, maxEsp, 
					url, costo, fecha, duracion, imagen, categorias,  urlVideo, premio, cantPremios);
	};
	
	
	public Funcion getFuncion(String nombreEspectaculo, String NomFuncion, String imagen) {
		Funcion ret = new Funcion(NomFuncion, null, null, imagen, null);
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
	
	public Set<DtEspectaculo> listarEspectaculosIngresados(){
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
	
	public Set<DtCategoria> listarCategoriasDeEspectaculo(String Plataforma, String Espectaculo) {
		ManejadorPlataforma manplat = manejadores.ManejadorPlataforma.getInstancia();
		return manplat.listarCategoriasDeEspectaculo(Plataforma, Espectaculo);
	}
	public void aceptarEspectaculo(String nomEspectaculo) {
		ManejadorPlataforma manplat = manejadores.ManejadorPlataforma.getInstancia();
		manplat.aceptarEspectaculo(nomEspectaculo);
	}
	public int obtenerCantVotos(int cantEstrellas, String nomEspectaculo) {
		return manejadores.ManejadorPlataforma.getInstancia().obtenerCantVotos(cantEstrellas, nomEspectaculo);
	}
	public void finzalizarEspectaculo(String nomEspectaculo, Date fechafin) {
		ManejadorPlataforma manplat = manejadores.ManejadorPlataforma.getInstancia();
		manplat.finalizarEspectaculo(nomEspectaculo, fechafin);
	}
	
	public void rechazarEspectaculo(String nomEspectaculo) {
		ManejadorPlataforma manplat = manejadores.ManejadorPlataforma.getInstancia();
		manplat.rechazarEspectaculo(nomEspectaculo);
	}

	public Boolean espectaculoinPlataforma(String nombrePlataforma, String nombreEspectaculo) {
		ManejadorPlataforma manplat = manejadores.ManejadorPlataforma.getInstancia();
		return manplat.espectaculoinPlataforma(nombrePlataforma, nombreEspectaculo);
	}
	

	public DtFuncion getDtFuncion(String nombreFuncion) {
		return ManejadorPlataforma.getInstancia().getDtFuncion(nombreFuncion);
	}
	public Set<DtEspectador> sortearPremios(String nombrePlataforma, String nombreEspectaculo, String nombreFuncion){
		Set<DtEspectador> ganadores = new HashSet<>();
		ManejadorPlataforma manplat = manejadores.ManejadorPlataforma.getInstancia();
		DtEspectaculoDatos espectaculo = manplat.getDatosEspectaculo(nombrePlataforma, nombreEspectaculo);
		int cantidadDeSorteos = espectaculo.getCantPremios();
		Set<RegistroFuncion> registros = manplat.getFuncion(nombrePlataforma, nombreEspectaculo, nombreFuncion).getRegistros();
		int cantidadEspectadores = registros.size();
		RegistroFuncion registrosArray[] = new RegistroFuncion[cantidadEspectadores];
		registros.toArray(registrosArray);
		Set<Integer> numerosGanadores = new HashSet<>();
		for (int i=0; i< cantidadDeSorteos; i++) {
			int random = (int)(Math.random()*cantidadEspectadores);
			while (numerosGanadores.contains(random)) {
				random = (int)(Math.random()*cantidadEspectadores);
			}
			numerosGanadores.add(random);
			registrosArray[random].setGanoPremio(true);
			ganadores.add(registrosArray[random].getEspectador().getDtEspectador());
		}
		Date hoy = new Date();
		manplat.getFuncion(nombrePlataforma, nombreEspectaculo, nombreFuncion).setFechaSorteo(hoy);	
		return ganadores;
	}
	
	public EspectaculoPersistencia getEspectculoPersistencia(String nombreesp) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("EspectaculosFinalizados");
		EntityManager em = emf.createEntityManager();
		EspectaculoPersistencia ret = null;
		TypedQuery<EspectaculoPersistencia> selecta =
				  em.createQuery("SELECT a FROM EspectaculoPersistencia a WHERE a.nombre = :nom",
						  EspectaculoPersistencia.class);
				  selecta.setParameter("nom", nombreesp);
				  ret = (EspectaculoPersistencia) selecta.getSingleResult();
		return ret;
	}
	
	public void setearPremios(String plat, String esp, String fun, String nick, Date fecha) {
		ManejadorPlataforma manplat = manejadores.ManejadorPlataforma.getInstancia();
		manplat.setearPremios(plat, esp, fun, nick, fecha);
	}



}


