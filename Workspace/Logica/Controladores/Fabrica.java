package Controladores;
import Interfaces.*;
import Controladores.*;

public class Fabrica {
	
	private Fabrica Instancia;
	private IUsuario InterfazUsuario;
	private IPaquete InterfazPaquete;
	private IPlataforma InterfazPlataforma;
	private Fabrica() {
	}
	public Fabrica getInstancia() {
		if (Instancia==null) {
			Instancia = new Fabrica();
		}
		return Instancia;
	}
	public IUsuario getIUsuario() {
		if (InterfazUsuario==null){
			InterfazUsuario = new ControladorUsuario();
		}
		return InterfazUsuario;
	};
	public IPaquete getIPaquete() {
		if (InterfazPaquete==null) {
			InterfazPaquete = new ControladorPaquete();
		}
		return InterfazPaquete;
	};
	public IPlataforma getIPlataforma() {
		if (InterfazPlataforma==null) {
			InterfazPlataforma = new ControladorPlataforma();
		}
		return InterfazPlataforma;
	};
}
