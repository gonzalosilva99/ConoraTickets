package manejadores;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import clases.Espectaculo;
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
		public void altaEspectaculo(String nomPlat, String nickArtista, String nomEspectaculo, String descripcion, Integer minEsp, Integer maxEsp, String url, Integer costo, Date fecha, Integer duracion, String imagen, Set<String> categorias) throws Identidad {
			Plataforma plat = plataformas.get(nomPlat);
			if (!existeEspectaculo(nomEspectaculo)) {
				plat.altaEspectaculo(nickArtista, nomEspectaculo, descripcion, minEsp, maxEsp, url, costo, fecha, duracion, imagen, categorias);
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
				String esp = entry.getValue().existeEspectaculoDeFuncion(nombreFuncion);
				if (!esp.equals("")) {
					ret = entry.getValue().getFuncionDatos(esp, nombreFuncion);
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
		
		public void rechazarEspectaculo(String nomEspectaculo) {
			for (Map.Entry<String, Plataforma> entry : plataformas.entrySet()) {
				if (entry.getValue().existeEspectaculo(nomEspectaculo)) {
					entry.getValue().getEspectaculo(nomEspectaculo).setEstado(EstadoEspectaculo.Rechazado);
					break;
				}
			}
		}

}

		

		

		
		
		



