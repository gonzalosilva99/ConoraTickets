package Clases;

import java.util.Date;

import DataTypes.DtEspectaculo;
import DataTypes.DtEspectador;
import DataTypes.DtEspectadorConsulta;
import DataTypes.DtUsuario;
import DataTypes.DtFuncion;
import DataTypes.DtRegistro;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import Relaciones.RegistroFuncion;
import javax.swing.JOptionPane;


public class Espectador extends Usuario{

	private HashMap<Integer,RegistroFuncion> RegistroFunciones;
	
	public Espectador(String nickname, String nombre, String apellido, String email, Date nacimiento) {
		super(nickname,nombre, apellido, email,nacimiento);
		RegistroFunciones = new HashMap<Integer,RegistroFuncion>();
	}
	public DtUsuario getDtUsuario() {
		DtUsuario ret = new DtUsuario(this.getNickname(),this.getNombre(),this.getApellido());
		return ret;
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
		//HashMap<Integer,RegistroFuncion> esp = new HashSet<DtFuncion>();
		//Iterator<Funcion> itr = Funciones.iterator();	
		//while(itr.hasNext()) {
			//DtFuncion nuevo = itr.next().getDtFuncion();
			//esp.add(nuevo);
		//}
		//DtEspectadorConsulta ret = new DtEspectadorConsulta(this.getNickname(),this.getNombre(),this.getApellido(),this.getEmail(),this.getNacimiento(),esp);
		Date coso = new Date();
		HashSet<DtFuncion> popo = new HashSet<DtFuncion>();
		DtEspectadorConsulta ret = new DtEspectadorConsulta("","","","",coso,popo);
		return ret;
	}
	
	public Set<DtRegistro> listarRegistrosSinCanjeaer(){
		HashSet<DtRegistro> ret = new HashSet<DtRegistro>();
		for(Map.Entry<Integer, RegistroFuncion> entry : RegistroFunciones.entrySet()) {
			if(entry.getValue().getCanjeable()) {
				DtRegistro nuevo = entry.getValue().getDtRegistro();
				ret.add(nuevo);
			}
		}
		return ret;
	}
}


