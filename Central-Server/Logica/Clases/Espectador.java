package Clases;

import java.util.Calendar;
import java.util.Date;

import DataTypes.DtEspectaculo;
import DataTypes.DtEspectador;
import DataTypes.DtEspectadorConsulta;
import DataTypes.DtUsuario;
import DataTypes.DtFuncion;
import DataTypes.DtPaquete;
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

	private HashMap<Integer,RegistroFuncion> RegistroFunciones;
	private HashMap<Integer,CompraPaquete> CompraPaquetes;
	
	public Espectador(String nickname, String nombre, String apellido, String email, Date nacimiento, String imagen, String contrasena) {
		super(nickname,nombre, apellido, email,nacimiento,imagen,contrasena);
		RegistroFunciones = new HashMap<Integer,RegistroFuncion>();
		CompraPaquetes = new HashMap<Integer,CompraPaquete>();
	}
	
	public void agregarRegistroFuncion(RegistroFuncion registrofuncion) {
		RegistroFunciones.put(RegistroFunciones.size() + 1, registrofuncion);
	}
	
	public void MarcarRegistrosUsados(Integer Registro1,Integer Registro2,Integer Registro3 ) {
		RegistroFuncion reg1 = RegistroFunciones.get(Registro1);
		RegistroFuncion reg2 = RegistroFunciones.get(Registro2);
		RegistroFuncion reg3 = RegistroFunciones.get(Registro3);
		reg1.setCanjeable(false);
		reg2.setCanjeable(false);
		reg3.setCanjeable(false);
	}
	
	public Integer getUltimoCodigo() {
		if(RegistroFunciones!= null)
			return RegistroFunciones.size();
		else return 0;
	}

	
	public DtEspectador getDtEspectador() {
		DtEspectador ret = new DtEspectador(this.getNickname(),this.getNombre(),this.getApellido(),this.getEmail(),this.getNacimiento());
		return ret;
	}
	
	public HashMap<Integer,RegistroFuncion> getRegistroFunciones() {
		return RegistroFunciones;
	}

	public void setFunciones(HashMap<Integer,RegistroFuncion> regfunciones) {
		RegistroFunciones = regfunciones;
	}

	public DtEspectadorConsulta getDtEspectadorConsulta() {
		HashSet<DtUsuario> seguidores = new HashSet<DtUsuario>();
		for (Map.Entry<String,Usuario> entry : Seguidores.entrySet()) {
				DtUsuario nuevo = entry.getValue().getDtUsuario();
				seguidores.add(nuevo);
		}
		
		HashSet<DtUsuario> siguiendo = new HashSet<DtUsuario>();
		for (Map.Entry<String,Usuario> entry : Siguiendo.entrySet()) {
				DtUsuario nuevo = entry.getValue().getDtUsuario();
				siguiendo.add(nuevo);
		}
		
		HashSet<DtFuncion> esp = new HashSet<DtFuncion>();
		for(Map.Entry<Integer, RegistroFuncion> entry : RegistroFunciones.entrySet()) {
			DtFuncion nuevo = entry.getValue().getDtFuncion();
			esp.add(nuevo);
		}
		DtEspectadorConsulta ret = new DtEspectadorConsulta(this.getNickname(),this.getNombre(),this.getApellido(),this.getEmail(),this.getNacimiento(),this.getImagen(),this.getContrasena(),esp,seguidores,siguiendo);
		return ret;
	}
	
	public Set<DtRegistro> listarRegistrosSinCanjeaer(){
		Set<DtRegistro> ret = new HashSet<DtRegistro>();
		for(Map.Entry<Integer, RegistroFuncion> entry : RegistroFunciones.entrySet()) {
			if(entry.getValue().getCanjeable()) {
				DtRegistro nuevo = entry.getValue().getDtRegistro();
				ret.add(nuevo);
			}
		}
		return ret;
	}
	
	public Set<DtPaquete> listarPaquetesCanjeables(String nombreEspectaculo){
		HashSet<DtPaquete> ret = new HashSet<DtPaquete>();
		for(Map.Entry<Integer, CompraPaquete> entry : CompraPaquetes.entrySet()) {
			if(entry.getValue().TieneEspectaculo(nombreEspectaculo)) {
				DtPaquete dtpaq = entry.getValue().getDtPaquete();
				ret.add(dtpaq);
				
			}
		}
		return ret;
	}
	
	public Boolean ExisteRegistroaFuncion(String nombreFuncion) {
		for(Map.Entry<Integer, RegistroFuncion> entry: RegistroFunciones.entrySet() ) {
			if(entry.getValue().getDtFuncion().getNombre().equals(nombreFuncion))
				return true;
		}
		return false;
	}
	
	public void anadirPaquete(Paquete paquete, Date fecha) {
		CompraPaquete compraPaquete = new CompraPaquete(fecha, this, paquete);
		CompraPaquetes.put(CompraPaquetes.size()+1, compraPaquete);
		
	}
	
}


