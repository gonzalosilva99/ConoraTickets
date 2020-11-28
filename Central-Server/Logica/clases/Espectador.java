package clases;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;

import datatypes.DtEspectaculo;
import datatypes.DtEspectador;
import datatypes.DtEspectadorConsulta;
import datatypes.DtEspectadorPerfil;
import datatypes.DtFuncion;
import datatypes.DtPaquete;
import datatypes.DtPaqueteDatos;
import datatypes.DtPremio;
import datatypes.DtRegistro;
import datatypes.DtUsuario;
import manejadores.ManejadorPlataforma;
import relaciones.CompraPaquete;
import relaciones.PuntajeAsignado;
import relaciones.RegistroFuncion;

public class Espectador extends Usuario{

	private Map<Integer, RegistroFuncion> registroFunciones;
	private Map<Integer, CompraPaquete> compraPaquetes;
	private Map<String, Espectaculo> espectaculosFavoritos;
	private Set<PuntajeAsignado> puntajesAsignados;
	
	public Espectador(String nickname, String nombre, String apellido, String email, 
			Date nacimiento, String imagen, String contrasena) {
		super(nickname, nombre, apellido, email, nacimiento, imagen, contrasena);
		registroFunciones = new HashMap<Integer, RegistroFuncion>();
		compraPaquetes = new HashMap<Integer, CompraPaquete>();
		espectaculosFavoritos = new HashMap<String, Espectaculo>();
		puntajesAsignados = new HashSet<PuntajeAsignado>();
		
	}
	
	public void agregarRegistroFuncion(RegistroFuncion registrofuncion) {
		registroFunciones.put(registroFunciones.size() + 1, registrofuncion);
	}
	
	public void marcarRegistrosUsados(Integer Registro1, Integer Registro2, Integer Registro3) {
		RegistroFuncion reg1 = registroFunciones.get(Registro1);
		RegistroFuncion reg2 = registroFunciones.get(Registro2);
		RegistroFuncion reg3 = registroFunciones.get(Registro3);
		reg1.setCanjeable(false);
		reg2.setCanjeable(false);
		reg3.setCanjeable(false);
	}
	
	public Integer getUltimoCodigo() {
		if (registroFunciones!= null)
			return registroFunciones.size();
		else return 0;
	}

	
	public DtEspectador getDtEspectador() {
		DtEspectador ret = new DtEspectador(this.getNickname(), this.getNombre(), this.getApellido(), this.getEmail(), this.getNacimiento());
		return ret;
	}
	
	public Map<Integer, RegistroFuncion> getRegistroFunciones() {
		return registroFunciones;
	}

	public void setFunciones(Map<Integer, RegistroFuncion> regfunciones) {
		registroFunciones = regfunciones;
	}

	public DtEspectadorConsulta getDtEspectadorConsulta() {
		HashSet<DtUsuario> seguidore = new HashSet<DtUsuario>();
		for (Map.Entry<String, Usuario> entry : seguidores.entrySet()) {
				DtUsuario nuevo = entry.getValue().getDtUsuario();
				seguidore.add(nuevo);
		}
		
		HashSet<DtUsuario> siguiend = new HashSet<DtUsuario>();
		for (Map.Entry<String, Usuario> entry : siguiendo.entrySet()) {
				DtUsuario nuevo = entry.getValue().getDtUsuario();
				siguiend.add(nuevo);
		}
		
		HashSet<DtFuncion> esp = new HashSet<DtFuncion>();
		for (Map.Entry<Integer, RegistroFuncion> entry : registroFunciones.entrySet()) {
			DtFuncion nuevo = entry.getValue().getDtFuncion();
			esp.add(nuevo);
		}
		DtEspectadorConsulta ret = new DtEspectadorConsulta(this.getNickname(), this.getNombre(), this.getApellido(), this.getEmail(), this.getNacimiento(), this.getImagen(), this.getContrasena(), esp, seguidore, siguiend);
		return ret;
	}
	
	public DtEspectadorPerfil getDtEspectadorPerfil() {
		HashSet<DtUsuario> seguidore = new HashSet<DtUsuario>();
		for (Map.Entry<String, Usuario> entry : seguidores.entrySet()) {
				DtUsuario nuevo = entry.getValue().getDtUsuario();
				seguidore.add(nuevo);
		}
		
		HashSet<DtUsuario> siguiend = new HashSet<DtUsuario>();
		for (Map.Entry<String, Usuario> entry : siguiendo.entrySet()) {
				DtUsuario nuevo = entry.getValue().getDtUsuario();
				siguiend.add(nuevo);
		}
		
		HashSet<DtPaqueteDatos> paq = new HashSet<DtPaqueteDatos>();
		for (Map.Entry<Integer, CompraPaquete> entry : compraPaquetes.entrySet()) {
			DtPaqueteDatos nuevo = entry.getValue().getDtPaqueteDatos();
			paq.add(nuevo);
		}
		
		HashSet<DtFuncion> esp = new HashSet<DtFuncion>();
		for (Map.Entry<Integer, RegistroFuncion> entry : registroFunciones.entrySet()) {
			DtFuncion nuevo = entry.getValue().getDtFuncion();
			esp.add(nuevo);
		}
		DtEspectadorPerfil ret = new DtEspectadorPerfil(this.getNickname(), this.getNombre(), this.getApellido(), this.getEmail(), this.getNacimiento(), this.getImagen(), this.getContrasena(), esp, seguidore, siguiend, paq, this.getUltimoIngreso());
		return ret;
	}
	
	public Set<DtRegistro> listarRegistrosSinCanjeaer(){
		Set<DtRegistro> ret = new HashSet<DtRegistro>();
		for (Map.Entry<Integer, RegistroFuncion> entry : registroFunciones.entrySet()) {
			if (entry.getValue().getCanjeable()) {
				DtRegistro nuevo = entry.getValue().getDtRegistro();
				ret.add(nuevo);
			}
		}
		return ret;
	}
	
	public Set<DtPaquete> listarPaquetesCanjeables(String nombreEspectaculo){
		HashSet<DtPaquete> ret = new HashSet<DtPaquete>();
		for (Map.Entry<Integer, CompraPaquete> entry : compraPaquetes.entrySet()) {
			if (entry.getValue().tieneEspectaculo(nombreEspectaculo)) {
				DtPaquete dtpaq = entry.getValue().getDtPaquete();
				ret.add(dtpaq);
				
			}
		}
		return ret;
	}
	
	public Boolean existeRegistroaFuncion(String nombreFuncion) {
		for (Map.Entry<Integer, RegistroFuncion> entry: registroFunciones.entrySet()) {
			if (entry.getValue().getDtFuncion().getNombre().equals(nombreFuncion))
				return true;
		}
		return false;
	}
	
	public void anadirPaquete(Paquete paquete, Date fecha) {
		CompraPaquete compraPaquete = new CompraPaquete(fecha, this, paquete);
		compraPaquetes.put(compraPaquetes.size()+1, compraPaquete);
		
	}
	
	public Boolean existeCompraPaquete(String nombrePaquete) {
		for (Map.Entry<Integer, CompraPaquete> entry: compraPaquetes.entrySet()) {
			if (entry.getValue().getDtPaquete().getNombre().equals(nombrePaquete))
				return true;
		}
		return false;
	}
	

	public Set<DtRegistro> listarRegistros(){
		Set<DtRegistro> setdtreg = new HashSet<DtRegistro>();
		for (Map.Entry<Integer, RegistroFuncion> entry: registroFunciones.entrySet()) {
			setdtreg.add(entry.getValue().getDtRegistro());
		}
		return setdtreg;
	}
	
	protected void abstracta() {}

	public Map<String, Espectaculo> getEspectaculosFavoritos() {
		return espectaculosFavoritos;
	}

	public void setEspectaculosFavoritos(Map<String, Espectaculo> espectaculosFavoritos) {
		this.espectaculosFavoritos = espectaculosFavoritos;
	}

	public Set<PuntajeAsignado> getPuntajesAsignados() {
		return puntajesAsignados;
	}

	public void setPuntajesAsignados(Set<PuntajeAsignado> puntajesAsignados) {
		this.puntajesAsignados = puntajesAsignados;
	};
	
	public void anadirFavorito(Espectaculo esp) {
		espectaculosFavoritos.put(esp.getNombre(), esp);
	}
	
	public void quitarFavorito(Espectaculo esp) {
		espectaculosFavoritos.remove(esp);
	}
	public Set<DtEspectaculo> getEspectaculosParaPuntuar(){
		Set<DtEspectaculo> ret = new HashSet<DtEspectaculo>();
		Map<String, DtEspectaculo> ret2 = new HashMap<String, DtEspectaculo>();
		for (Map.Entry<Integer, RegistroFuncion> entry: registroFunciones.entrySet()) {
			DtFuncion aux = entry.getValue().getDtFuncion();
			Date iniciofun = aux.getInicio();
			DtEspectaculo esp = ManejadorPlataforma.getInstancia().getEspectaculoDeFuncion(aux.getNombre());
			int duracion  = esp.getDuracion();
			Calendar cal = Calendar.getInstance();
			cal.setTime(iniciofun);
			cal.add(cal.MINUTE, duracion);
			Date fechafin = cal.getTime();
			Date hoy = new Date();
			if (!ret2.containsKey(esp.getNombre()) && hoy.after(fechafin))
				ret2.put(esp.getNombre(), esp);
		}
		for (Map.Entry<String, DtEspectaculo> entry: ret2.entrySet()) {
			ret.add(entry.getValue());
		}
		return ret;
	}
	
	public void valorarespectaculo(String nomEsp, int valoracion){
		Espectaculo espectaculo = ManejadorPlataforma.getInstancia().getEspectaculo(nomEsp);
		PuntajeAsignado nuevo = new PuntajeAsignado(this,espectaculo,valoracion);
		this.puntajesAsignados.add(nuevo);
		espectaculo.anadirPuntaje(nuevo);		
	}
	
	public int getPuntajeEspectaculo(String nomEsp) {
		int ret = 0;
		Iterator<PuntajeAsignado> itr = puntajesAsignados.iterator();
		while(itr.hasNext()) {
			PuntajeAsignado pun = itr.next();
			if(pun.getEspectaculo().getNombre().equals(nomEsp)) {
				ret=pun.getPuntaje();
				break;
			}
		}
		return ret;
	}
	public ArrayList<DtPremio> listarPremios(){
		ArrayList<DtPremio> premios = new ArrayList<>();
	    for (Map.Entry<Integer, RegistroFuncion> registro : registroFunciones.entrySet())  {
	    	if (registro.getValue().ganoPremio()) {
	    		DtPremio premio = new DtPremio(registro.getValue().getFuncion().getFechaSorteo(),
	    				registro.getValue().getFuncion().getNombre() , registro.getValue().getFuncion().getEspectaculo().getNombre());
	    		premios.add(premio);
	    	}
	    }
	    Collections.sort(premios);
		return premios;
	}
}


