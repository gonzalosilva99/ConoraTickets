package manejadores;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;


import Persistencia.ArtistaPersistencia;
import Persistencia.EspectaculoPersistencia;
import Persistencia.EspectadorPersistencia;
import Persistencia.FuncionPersistencia;
import Persistencia.RegistroPersistencia;

import javax.persistence.Persistence;
import javax.persistence.Query;

import clases.Espectaculo;
import clases.Espectador;
import clases.Funcion;
import clases.Plataforma;
import controladores.Fabrica;
import datatypes.DtCategoria;
import datatypes.DtEspectaculo;
import datatypes.DtEspectaculoDatos;
import datatypes.DtFuncion;
import datatypes.DtFuncionDatos;
import datatypes.DtPlataforma;
import datatypes.EstadoEspectaculo;
import excepciones.Identidad;
import interfaces.IUsuario;
import relaciones.RegistroFuncion;
public class ManejadorPlataforma {
	private 
		static ManejadorPlataforma instancia;
		Map<String, Plataforma> plataformas;
	public 
		static ManejadorPlataforma getInstancia() {
			if (instancia==null)
				instancia=new ManejadorPlataforma();
			return instancia;
				
		}
	
		private ManejadorPlataforma() {
			plataformas = new HashMap<String, Plataforma>();
		}

		ManejadorPlataforma(Map<String, Plataforma> Plats){
			super();
			plataformas = Plats;
		}

		Map<String, Plataforma> getPlataformas() {
			return plataformas;
		}

		void setPlataformas(Map<String, Plataforma> plataformas) {
			this.plataformas = plataformas;
		}
		
		public void altaPlataforma(String nombre, String Descripcion, String Url) throws Identidad{
			if (!existePlataforma(nombre)) {
				Plataforma plat = new Plataforma(nombre, Descripcion, Url);
				plataformas.put(nombre, plat);
			}
			else
				throw new Identidad("Ya existe una plataforma con ese Nombre");
		}
		
		public Boolean existePlataforma(String nombre){
			for (Map.Entry<String, Plataforma> entry : plataformas.entrySet()) {
	            if (entry.getValue().getNombre().equalsIgnoreCase(nombre)) {
	            	return true;
	            }           
			}
			return false;
		}
		Set<DtEspectaculo>  listarEspectaculosDePlataforma(String Nombre){
			Plataforma plat = plataformas.get(Nombre);
			return plat.listarEspectaculosDePlataforma();
		}
		
		public Set<DtEspectaculo>  listarEspectaculosAceptadosDePlataforma(String Nombre){
			Plataforma plat = plataformas.get(Nombre);
			return plat.listarEspectaculosAceptadosDePlataforma();
		}
		
		public Set<DtCategoria> listarCategoriasDeEspectaculo(String Plataforma, String Espectaculo) {
			Plataforma plat = plataformas.get(Plataforma);
			return plat.listarCategoriasDeEspectaculo(Espectaculo);
		}
		
		public Set<DtFuncion> listarFuncionesDeEspectaculo(String NombrePlat, String NombreEsp){
			Plataforma plat = plataformas.get(NombrePlat);
			return plat.listarFuncionesDeEspectaculo(NombreEsp);
		}
		
		public Set<DtEspectaculoDatos> filtrarEspectaculos(String search){
			HashSet<DtEspectaculoDatos> ret = new HashSet<DtEspectaculoDatos>();
			for (Map.Entry<String, Plataforma> entry : plataformas.entrySet()) {
	            entry.getValue().filtrarEspectaculos(ret, search);         
			}
			return ret;
		}
		
		public DtFuncionDatos mostrarFuncion(String NombrePlat, String NombreEsp, String NombreFun) {
			Plataforma plat = plataformas.get(NombrePlat);
			return plat.mostrarFuncion(NombreEsp, NombreFun);
		}
				
		public Set<DtFuncion> listarFuncionesVigentesEspectaculo(String nombreEsp, String nombrePlat) {
			Plataforma plat = plataformas.get(nombrePlat);
			return plat.listarFuncionesVigentesEspectaculo(nombreEsp);
		}
		
		public Plataforma getPlataforma(String nomPlataforma) {
			return plataformas.get(nomPlataforma);
			
		}
		
		public Funcion getFuncion(String nombrePlataforma, String nombreEspectaculo, String nomFuncion) {
			Plataforma plat = plataformas.get(nombrePlataforma);
			return plat.getFuncion(nombreEspectaculo, nomFuncion);
		}
		public Set<DtPlataforma> listarPlataformas() {
			Set<DtPlataforma> ret = new HashSet<DtPlataforma>();		
			for (Map.Entry<String, Plataforma> entry : plataformas.entrySet()) {
	            DtPlataforma nueva = entry.getValue().getDtPlataforma();
	            ret.add(nueva);            
			}
			return ret;
		}
		
		public Boolean espectaculoinPlataforma(String nombrePlataforma, String nombreEspectaculo) {
			Plataforma Plat = plataformas.get(nombrePlataforma);
			return Plat.espectaculoinPlataforma(nombreEspectaculo);
		}
		
		public Set<DtEspectaculo> listarEspectaculos(String nombrePlataforma){
			Plataforma plat = plataformas.get(nombrePlataforma);
			return plat.listarEspectaculos();
		}
		
		public Boolean existeEspectaculo(String nomEspectaculo) {
			Boolean ret = false;
			for (Map.Entry<String, Plataforma> entry : plataformas.entrySet()) {
	            ret = entry.getValue().existeEspectaculo(nomEspectaculo);
	            if (ret) return true;           
			}
			return false;
		}
		public void altaEspectaculo(String nomPlat, String nickArtista, String nomEspectaculo, String descripcion, Integer minEsp, Integer maxEsp, String url,
				Integer costo, Date fecha, Integer duracion, String imagen, Set<String> categorias,  String urlVideo, String premio, int cantPremios) throws Identidad {
			Plataforma plat = plataformas.get(nomPlat);
			if (!existeEspectaculo(nomEspectaculo)) {
				plat.altaEspectaculo(nickArtista, nomEspectaculo, descripcion, minEsp, maxEsp, url, 
						costo, fecha, duracion, imagen, categorias, urlVideo, premio, cantPremios);
			}
			else {
				throw new Identidad("Ya Existe un Espectaculo con este Nombre");
			}
		}  
		public DtEspectaculoDatos listarDtEspectaculoDatos(String nomPlat, String NombreEspectaculo) {
			Plataforma plat = plataformas.get(nomPlat);
			return plat.getDtEspectaculoDatos(NombreEspectaculo);
		}
		
		public DtFuncionDatos listarDtFuncionDatos(String nomPlat, String NombreEspectaculo, String nombreFuncion) {
			Plataforma plat = plataformas.get(nomPlat);
			Espectaculo esp = plat.getEspectaculo(NombreEspectaculo);
			Funcion fun = esp.getFuncion(nombreFuncion);
			return fun.getDtFuncionDatos(esp.getDatosEspectaculo());
		}
		
		public int obtenerCantVotos(int cantEstrellas, String nomEspectaculo) {
			Espectaculo esp = plataformas.get(this.getPlataformaDeEspectaculo(nomEspectaculo)).getEspectaculo(nomEspectaculo);
			return esp.cantVotosEstrella(cantEstrellas);
		}
		
		public Set<DtEspectaculo> listarEspectaculosEnPlataformaNoPaquete(String NombrePaquete, String NombrePlataforma) {
			Plataforma pla = this.getPlataforma(NombrePlataforma);
			return pla.listarEspectaculosEnPlataformaNoPaquete(NombrePaquete);
		}

		public void confirmarAltaFuncionEspectaculo(String nombrePlataforma, String nombreEspectaculo, String nombre, Date inicio, 
				Set<String> artistas, Date alta, String imagen) {
			Plataforma Plat = plataformas.get(nombrePlataforma);
			Espectaculo Espec = Plat.getEspectaculo(nombreEspectaculo);
			Espec.anadirFuncion(nombre, inicio, alta, imagen);	
			if (artistas != null) {
				Fabrica fab = controladores.Fabrica.getInstancia();
				IUsuario iusuario = fab.getIUsuario();
				Iterator<String> iterArtistas = artistas.iterator();
				while (iterArtistas.hasNext()) {
					iusuario.relacionarArtistaFuncion(iterArtistas.next(), Espec.obtenerFuncion(nombre));
				}
			}
			
		}

		public Set<DtEspectaculoDatos> listarEspectaculoDatosDePlataforma(String Nombre){
			Plataforma pla = this.getPlataforma(Nombre);
			return pla.listarEspectaculoDatos();
		}
		
		public boolean existeFuncion(String nombreFuncion) {
			boolean ret = false;
			for (Map.Entry<String, Plataforma> entry : plataformas.entrySet()) {
				ret = entry.getValue().existeFuncion(nombreFuncion);
				if (ret){
					return ret;
				}
			}
			return ret;
		}
		public DtEspectaculoDatos getDatosEspectaculo(String nombrePlataforma, String nombreEspectaculo) {
			Plataforma pla = this.getPlataforma(nombrePlataforma);
			return pla.getDtEspectaculoDatos(nombreEspectaculo);
		}
		public DtEspectaculoDatos findDatosEspectaculo(String nombreEspectaculo){
			DtEspectaculoDatos ret = null;
			for (Map.Entry<String, Plataforma> entry : plataformas.entrySet()) {
				if (entry.getValue().existeEspectaculo(nombreEspectaculo)) {
					ret = entry.getValue().getDtEspectaculoDatos(nombreEspectaculo);
					break;
				}
			}
			return ret;
		}
		
		public Espectaculo getEspectaculo(String nombreEspectaculo){
			Espectaculo ret = null;
			for (Map.Entry<String, Plataforma> entry : plataformas.entrySet()) {
				if (entry.getValue().existeEspectaculo(nombreEspectaculo)) {
					ret = entry.getValue().getEspectaculo(nombreEspectaculo);
					break;
				}
			}
			return ret;
		}
		
		public Set<DtEspectaculo> listarEspectaculosIngresados(){
			HashSet<DtEspectaculo> ret = new HashSet<DtEspectaculo>();
			for (Map.Entry<String, Plataforma> entry : plataformas.entrySet()) {
				Set<DtEspectaculo> aux = entry.getValue().listarEspectaculosIngresadosDePlataforma();
				Iterator<DtEspectaculo> ite = aux.iterator();
				while (ite.hasNext()) {
					ret.add(ite.next());
				}
			}
			return ret;
		}
		
		public String getPlataformaDeEspectaculo(String esp) {
			String ret = "";
			for (Map.Entry<String, Plataforma> entry : plataformas.entrySet()) {
				if (entry.getValue().existeEspectaculo(esp)) {
					ret = entry.getValue().getNombre();
					break;
				}
			}
			return ret;
		}
		public DtFuncionDatos getFuncionDatos(String nombrePlat, String nombreEspectaculo, String nombreFuncion) {
			Plataforma pla = this.getPlataforma(nombrePlat);
			return pla.getFuncionDatos(nombreEspectaculo, nombreFuncion);
		}
		
		public DtFuncionDatos findFuncionDatos(String nombreFuncion) {
			DtFuncionDatos ret = null;			
			for (Map.Entry<String, Plataforma> entry : plataformas.entrySet()) {
				DtEspectaculo esp = entry.getValue().existeEspectaculoDeFuncion(nombreFuncion);
				if (esp!=null && !esp.getNombre().equals("")) {
					ret = entry.getValue().getFuncionDatos(esp.getNombre(), nombreFuncion);
					break;
				}
			}
			return ret;
		}
		
		public DtEspectaculo getEspectaculoDeFuncion(String nombreFuncion) {
			DtEspectaculo ret = null;		
			for (Map.Entry<String, Plataforma> entry : plataformas.entrySet()) {
				ret = entry.getValue().existeEspectaculoDeFuncion(nombreFuncion);
				if (ret!=null) {				
					break;
				}
			}
			return ret;
		}
		
		public Boolean puedeAgregarEspectadores(String nombrePlataforma, String nombreEspectaculo, String nombreFuncion){
			Plataforma plat = plataformas.get(nombrePlataforma);
			return plat.puedeAgregarEspectadores(nombreEspectaculo, nombreFuncion);
		}
		
		public void aceptarEspectaculo(String nomEspectaculo) {
			for (Map.Entry<String, Plataforma> entry : plataformas.entrySet()) {
				if (entry.getValue().existeEspectaculo(nomEspectaculo)) {
					entry.getValue().getEspectaculo(nomEspectaculo).setEstado(EstadoEspectaculo.Aceptado);
					
					break;
				}
			}
		}
		
		private void almacenarEspectaculo(String plataforma, Espectaculo esp, Date fechafin) {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("EspectaculosFinalizados");
			EntityManager em = emf.createEntityManager();
			
			//CARGAR DATOS ORGANIZADOR
			ArtistaPersistencia organizador = null;
			Query canta = em.createQuery("SELECT COUNT(DISTINCT a.nickname) FROM ArtistaPersistencia a WHERE a.nickname = :nick");
			canta.setParameter("nick", esp.getOrganizador().getNickname());
			long resa = (long) canta.getSingleResult();
			if(resa==0) {
			organizador = new ArtistaPersistencia();
			organizador.setNickname(esp.getOrganizador().getNickname());
			organizador.setNombre(esp.getOrganizador().getNombre());
			organizador.setApellido(esp.getOrganizador().getApellido());
			organizador.setContrasena(esp.getOrganizador().getContrasena());
			organizador.setEmail(esp.getOrganizador().getEmail());
			organizador.setNacimiento(esp.getOrganizador().getNacimiento());
			organizador.setDescripcion(esp.getOrganizador().getDescripcionGeneral());
			organizador.setBiografia(esp.getOrganizador().getBiografia());
			organizador.setUrl(esp.getOrganizador().getURL());
			em.getTransaction().begin();
			em.persist(organizador);
			em.getTransaction().commit();
			}
			else {
				TypedQuery<ArtistaPersistencia> selecta =
						  em.createQuery("SELECT a FROM ArtistaPersistencia a WHERE a.nickname = :nom",
								  ArtistaPersistencia.class);
						  selecta.setParameter("nom",esp.getOrganizador().getNickname());
						  organizador = (ArtistaPersistencia) selecta.getSingleResult();
			}
			
			//CARGAR DATOS ESPECTACULO
			EspectaculoPersistencia espectaculo = new EspectaculoPersistencia();
			espectaculo.setNombre(esp.getNombre());
			espectaculo.setDescripcion(esp.getDescripcion());
			espectaculo.setDuracion(esp.getDuracion());
			espectaculo.setUrl(esp.getURL());
			espectaculo.setRegistro(esp.getRegistro());
			espectaculo.setCosto(esp.getCosto());
			espectaculo.setFechaFinalizacion(fechafin);
			espectaculo.setPlataforma(plataforma);
			espectaculo.setOrganizador(organizador);
			
			//CARGAR FUNCIONES
			Set<FuncionPersistencia> funciones = new HashSet<FuncionPersistencia>();
			Map<String, Funcion> funaux = esp.getFunciones();
			for (Map.Entry<String, Funcion> entry : funaux.entrySet()) {
				Set<RegistroPersistencia> registros = new HashSet<RegistroPersistencia>();
				Set<RegistroFuncion> regaux = entry.getValue().getRegistros();
				Iterator<RegistroFuncion> itrr = regaux.iterator();
				while(itrr.hasNext()) {
					RegistroFuncion reg=itrr.next();					
					EspectadorPersistencia espagregar = null;
					RegistroPersistencia regagregar = new RegistroPersistencia();
					regagregar.setCosto((int) Math.round(reg.getCosto()));
					regagregar.setFecha(reg.getFecha());
					Espectador espaux = reg.getEspectador();
					
					
					
					Query cant = em.createQuery("SELECT COUNT(DISTINCT a.nickname) FROM EspectadorPersistencia a WHERE a.nickname = :nick");
					cant.setParameter("nick", espaux.getNickname());
					long res = (long) cant.getSingleResult();
					if(res==0) {
					espagregar = new EspectadorPersistencia();				
					espagregar.setNickname(espaux.getNickname());
					espagregar.setNombre(espaux.getNombre());
					espagregar.setApellido(espaux.getApellido());
					espagregar.setEmail(espaux.getEmail());
					espagregar.setContrasena(espaux.getContrasena());
					espagregar.setNacimiento(espaux.getNacimiento());
					espagregar.setImagen(espaux.getImagen());
					em.getTransaction().begin();
					em.persist(espagregar);
					em.getTransaction().commit();				
					}
					else {
						  TypedQuery<EspectadorPersistencia> select3 =
						  em.createQuery("SELECT a FROM EspectadorPersistencia a WHERE a.nickname = :nom",
								  EspectadorPersistencia.class);
						  select3.setParameter("nom",espaux.getNickname());
						  espagregar = (EspectadorPersistencia) select3.getSingleResult();
					}
					regagregar.setEspectador(espagregar);
					registros.add(regagregar);
				}
				FuncionPersistencia funagregar = new FuncionPersistencia();
				funagregar.setNombre(entry.getValue().getNombre());
				funagregar.setInicio(entry.getValue().getInicio());
				funagregar.setAlta(entry.getValue().getAlta());
				funagregar.setRegistros(registros);
				funciones.add(funagregar);
			}
			
			try {				
				  em.getTransaction().begin();				 
				  espectaculo.setFunciones(funciones);		  
				  em.persist(espectaculo);
				  em.getTransaction().commit();
				
			} catch (Exception e) {
				e.printStackTrace();
				em.getTransaction().rollback();
			} finally {
				em.close();
				emf.close();
			}
			
		}
		
		public void finalizarEspectaculo(String nomEspectaculo, Date fechafin) {
			for (Map.Entry<String, Plataforma> entry : plataformas.entrySet()) {
				if (entry.getValue().existeEspectaculo(nomEspectaculo)) {
					entry.getValue().getEspectaculo(nomEspectaculo).setEstado(EstadoEspectaculo.Finalizado);
					almacenarEspectaculo(entry.getValue().getNombre(),entry.getValue().getEspectaculo(nomEspectaculo), fechafin);
					break;
				}
			}
		}
		
		public void rechazarEspectaculo(String nomEspectaculo) {
			for (Map.Entry<String, Plataforma> entry : plataformas.entrySet()) {
				if (entry.getValue().existeEspectaculo(nomEspectaculo)) {
					entry.getValue().getEspectaculo(nomEspectaculo).setEstado(EstadoEspectaculo.Rechazado);
					break;
				}
			}
		}
		

		public DtFuncion getDtFuncion(String nombreFuncion) {
			for (Map.Entry<String, Plataforma> entry : plataformas.entrySet()) {
				if(entry.getValue().getDtFuncion(nombreFuncion) != null)
					return entry.getValue().getDtFuncion(nombreFuncion);
			}
			return null;
		}

}

		

		

		
		
		



