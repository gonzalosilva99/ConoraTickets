package Manejadores;
import Clases.Plataforma;
import Controladores.Fabrica;
import Clases.Artista;
import Clases.Categoria;
import Clases.Espectaculo;
import Clases.Espectador;
import Clases.Funcion;
import Clases.Paquete;

import java.util.*;
import Excepciones.Identidad;
import Interfaces.IUsuario;

import javax.swing.JOptionPane;

import DataTypes.*;
public class ManejadorPlataforma {
	private 
		static ManejadorPlataforma instancia;
		HashMap<String,Plataforma> Plataformas;
	public 
		static ManejadorPlataforma getInstancia() {
			if(instancia==null)
				instancia=new ManejadorPlataforma();
			return instancia;
				
		}
	
		private ManejadorPlataforma() {
			Plataformas = new HashMap<String,Plataforma>();
		}

		ManejadorPlataforma(HashMap<String,Plataforma> Plats){
			super();
			Plataformas = Plats;
		}

		Map<String, Plataforma> getPlataformas() {
			return Plataformas;
		}

		void setPlataformas(HashMap<String, Plataforma> plataformas) {
			Plataformas = plataformas;
		}
		
		public void AltaPlataforma(String nombre, String Descripcion,String Url) throws Identidad{
			if(!ExistePlataforma(nombre)) {
				Plataforma plat = new Plataforma(nombre,Descripcion,Url);
				Plataformas.put(nombre, plat);
			}
			else
				throw new Identidad("Ya existe una plataforma con ese Nombre");
		}
		
		public Boolean ExistePlataforma(String nombre){
			for (Map.Entry<String,Plataforma> entry : Plataformas.entrySet()) {
	            if(entry.getValue().getNombre().equalsIgnoreCase(nombre)) {
	            	return true;
	            }           
			}
			return false;
		}
		Set<DtEspectaculo>  listarEspectaculosDePlataforma(String Nombre){
			Plataforma plat = Plataformas.get(Nombre);
			return plat.listarEspectaculosDePlataforma();
		}
		
		public Set<DtEspectaculo>  listarEspectaculosAceptadosDePlataforma(String Nombre){
			Plataforma plat = Plataformas.get(Nombre);
			return plat.listarEspectaculosAceptadosDePlataforma();
		}
		
		public HashSet<DtCategoria> ListarCategoriasDeEspectaculo(String Plataforma, String Espectaculo) {
			Plataforma plat = Plataformas.get(Plataforma);
			return plat.ListarCategoriasDeEspectaculo(Espectaculo);
		}
		
		public Set<DtFuncion> listarFuncionesDeEspectaculo(String NombrePlat, String NombreEsp){
			Plataforma plat = Plataformas.get(NombrePlat);
			return plat.listarFuncionesDeEspectaculo(NombreEsp);
		}
		
		public Set<DtEspectaculoDatos> filtrarEspectaculos(String search){
			HashSet<DtEspectaculoDatos> ret = new HashSet<DtEspectaculoDatos>();
			for (Map.Entry<String, Plataforma> entry : Plataformas.entrySet()) {
	            entry.getValue().filtrarEspectaculos(ret, search);         
			}
			return ret;
		}
		
		public DtFuncionDatos MostrarFuncion(String NombrePlat, String NombreEsp, String NombreFun) {
			Plataforma plat = Plataformas.get(NombrePlat);
			return plat.mostrarFuncion(NombreEsp, NombreFun);
		}
				
		public Set<DtFuncion> listarFuncionesVigentesEspectaculo(String nombreEsp, String nombrePlat) {
			Plataforma plat = Plataformas.get(nombrePlat);
			return plat.listarFuncionesVigentesEspectaculo(nombreEsp);
		}
		
		public Plataforma getPlataforma(String nomPlataforma) {
			return Plataformas.get(nomPlataforma);
			
		}
		
		public Funcion getFuncion(String nombrePlataforma, String nombreEspectaculo, String nomFuncion) {
			Plataforma plat = Plataformas.get(nombrePlataforma);
			return plat.getFuncion(nombreEspectaculo, nomFuncion);
		}
		public Set<DtPlataforma> listarPlataformas() {
			Set<DtPlataforma> ret = new HashSet<DtPlataforma>();		
			for (Map.Entry<String, Plataforma> entry : Plataformas.entrySet()) {
	            DtPlataforma nueva = entry.getValue().getDtPlataforma();
	            ret.add(nueva);            
			}
			return ret;
		}
		public Set<DtEspectaculo> listarEspectaculos(String nombrePlataforma){
			Plataforma plat = Plataformas.get(nombrePlataforma);
			return plat.listarEspectaculos();
		}
		
		public Boolean ExisteEspectaculo(String nomEspectaculo) {
			Boolean ret = false;
			for (Map.Entry<String, Plataforma> entry : Plataformas.entrySet()) {
	            ret = entry.getValue().ExisteEspectaculo(nomEspectaculo);
	            if(ret) return true;           
			}
			return false;
		}
		public void altaEspectaculo(String nomPlat, String nickArtista, String nomEspectaculo, String descripcion, Integer minEsp, Integer maxEsp, String url, Integer costo, Date fecha, Integer duracion, String imagen, Set<String> categorias) throws Identidad {
			Plataforma plat = Plataformas.get(nomPlat);
			if(!ExisteEspectaculo(nomEspectaculo)) {
				plat.altaEspectaculo(nickArtista, nomEspectaculo, descripcion, minEsp, maxEsp, url, costo, fecha, duracion, imagen, categorias);
			}
			else{
				throw new Identidad("Ya Existe un Espectaculo con este Nombre");
			}
		}  
		public DtEspectaculoDatos listarDtEspectaculoDatos(String nomPlat, String NombreEspectaculo) {
			Plataforma plat = Plataformas.get(nomPlat);
			return plat.getDtEspectaculoDatos(NombreEspectaculo);
		}
		
		public DtFuncionDatos listarDtFuncionDatos(String nomPlat, String NombreEspectaculo, String nombreFuncion) {
			Plataforma plat = Plataformas.get(nomPlat);
			Espectaculo esp = plat.getEspectaculo(NombreEspectaculo);
			Funcion fun = esp.getFuncion(nombreFuncion);
			return fun.getDtFuncionDatos(esp.getDatosEspectaculo());
		}
		
		public Set<DtEspectaculo> listarEspectaculosEnPlataformaNoPaquete(String NombrePaquete, String NombrePlataforma) {
			Plataforma pla = this.getPlataforma(NombrePlataforma);
			return pla.listarEspectaculosEnPlataformaNoPaquete(NombrePaquete);
		}

		public void ConfirmarAltaFuncionEspectaculo(String nombrePlataforma, String nombreEspectaculo, String nombre, Date inicio, Set<String> artistas, Date alta, String imagen) {
			Plataforma Plat = Plataformas.get(nombrePlataforma);
			Espectaculo Espec = Plat.getEspectaculo(nombreEspectaculo);
			Espec.AnadirFuncion(nombre, inicio, alta, imagen);
			Fabrica fab = Controladores.Fabrica.getInstancia();
			IUsuario iusuario = fab.getIUsuario();
			Iterator<String> iterArtistas = artistas.iterator();
			while(iterArtistas.hasNext()) {
				iusuario.RelacionarArtistaFuncion(iterArtistas.next(), Espec.ObtenerFuncion(nombre));
			}
		}

		public Set<DtEspectaculoDatos> listarEspectaculoDatosDePlataforma(String Nombre){
			Plataforma pla = this.getPlataforma(Nombre);
			return pla.listarEspectaculoDatos();
		}
		
		public boolean existeFuncion(String nombreFuncion) {
			boolean ret = false;
			for(Map.Entry<String, Plataforma> entry : Plataformas.entrySet()) {
				ret = entry.getValue().existeFuncion(nombreFuncion);
				if(ret){
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
			for(Map.Entry<String, Plataforma> entry : Plataformas.entrySet()) {
				if(entry.getValue().ExisteEspectaculo(nombreEspectaculo)) {
					ret = entry.getValue().getDtEspectaculoDatos(nombreEspectaculo);
					break;
				}
			}
			return ret;
		}
		
		public HashSet<DtEspectaculo> ListarEspectaculosIngresados(){
			HashSet<DtEspectaculo> ret = new HashSet<DtEspectaculo>();
			for(Map.Entry<String, Plataforma> entry : Plataformas.entrySet()) {
				Set<DtEspectaculo> aux = entry.getValue().listarEspectaculosIngresadosDePlataforma();
				Iterator<DtEspectaculo> it = aux.iterator();
				while(it.hasNext()) {
					ret.add(it.next());
				}
			}
			return ret;
		}
		
		public String getPlataformaDeEspectaculo(String esp) {
			String ret = "";
			for(Map.Entry<String, Plataforma> entry : Plataformas.entrySet()) {
				if(entry.getValue().ExisteEspectaculo(esp)) {
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
			
			for(Map.Entry<String, Plataforma> entry : Plataformas.entrySet()) {
				String esp = entry.getValue().ExisteEspectaculoDeFuncion(nombreFuncion);
				if(!esp.equals("")) {
					ret = entry.getValue().getFuncionDatos(esp,nombreFuncion);
					break;
				}
			}
			return ret;
		}
		
		public Boolean PuedeAgregarEspectadores(String nombrePlataforma,String nombreEspectaculo,String nombreFuncion){
			Plataforma plat = Plataformas.get(nombrePlataforma);
			return plat.PuedeAgregarEspectadores(nombreEspectaculo,nombreFuncion);
		}
		
		public void AceptarEspectaculo(String nomEspectaculo) {
			for(Map.Entry<String, Plataforma> entry : Plataformas.entrySet()) {
				if(entry.getValue().ExisteEspectaculo(nomEspectaculo)) {
					entry.getValue().getEspectaculo(nomEspectaculo).setEstado(EstadoEspectaculo.Aceptado);
					break;
				}
			}
		}
		
		public void RechazarEspectaculo(String nomEspectaculo) {
			for(Map.Entry<String, Plataforma> entry : Plataformas.entrySet()) {
				if(entry.getValue().ExisteEspectaculo(nomEspectaculo)) {
					entry.getValue().getEspectaculo(nomEspectaculo).setEstado(EstadoEspectaculo.Rechazado);
					break;
				}
			}
		}

}

		

		

		
		
		



