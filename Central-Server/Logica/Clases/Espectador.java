package Clases;

import java.util.Calendar;
import java.util.Date;

import DataTypes.DtEspectaculo;
import DataTypes.DtEspectador;
import DataTypes.DtEspectadorConsulta;
import DataTypes.DtEspectadorPerfil;
import DataTypes.DtUsuario;
import DataTypes.DtFuncion;
import DataTypes.DtPaquete;
import DataTypes.DtPaqueteDatos;
import DataTypes.DtRegistro;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import Relaciones.RegistroFuncion;
import javax.swing.JOptionPane;
import Relaciones.CompraPaquete;

public class Espectador extends Usuario{

	private Map<Integer, RegistroFuncion> registroFunciones;
	private Map<Integer, CompraPaquete> compraPaquetes;
	
	public Espectador(String nickname, String nombre, String apellido, String email, Date nacimiento, String imagen, String contrasena) {
		super(nickname, nombre, apellido, email, nacimiento, imagen, contrasena);
		registroFunciones = new HashMap<Integer, RegistroFuncion>();
		compraPaquetes = new HashMap<Integer, CompraPaquete>();
	}
	
	public void agregarRegistroFuncion(RegistroFuncion registrofuncion) {
		registroFunciones.put(registroFunciones.size() + 1, registrofuncion);
	}
	
	public void MarcarRegistrosUsados(Integer Registro1, Integer Registro2, Integer Registro3 ) {
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
		DtEspectadorConsulta ret = new DtEspectadorConsulta(this.getNickname(), this.getNombre(), this.getApellido(), this.getEmail(), this.getNacimiento(), this.getImagen(), this.getContrasena(), esp, seguidores, siguiendo);
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
		DtEspectadorPerfil ret = new DtEspectadorPerfil(this.getNickname(), this.getNombre(), this.getApellido(), this.getEmail(), this.getNacimiento(), this.getImagen(), this.getContrasena(), esp, seguidores, siguiendo, paq, this.getUltimoIngreso());
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
			if (entry.getValue().TieneEspectaculo(nombreEspectaculo)) {
				DtPaquete dtpaq = entry.getValue().getDtPaquete();
				ret.add(dtpaq);
				
			}
		}
		return ret;
	}
	
	public Boolean ExisteRegistroaFuncion(String nombreFuncion) {
		for (Map.Entry<Integer, RegistroFuncion> entry: registroFunciones.entrySet() ) {
			if (entry.getValue().getDtFuncion().getNombre().equals(nombreFuncion))
				return true;
		}
		return false;
	}
	
	public void anadirPaquete(Paquete paquete, Date fecha) {
		CompraPaquete compraPaquete = new CompraPaquete(fecha, this, paquete);
		compraPaquetes.put(compraPaquetes.size()+1, compraPaquete);
		
	}
	
	public Boolean ExisteCompraPaquete(String nombrePaquete) {
		for (Map.Entry<Integer, CompraPaquete> entry: compraPaquetes.entrySet() ) {
			if (entry.getValue().getDtPaquete().getNombre().equals(nombrePaquete))
				return true;
		}
		return false;
	}
	
}


