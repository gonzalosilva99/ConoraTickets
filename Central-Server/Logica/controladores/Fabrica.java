package controladores;
import controladores.ControladorCategoria;
import controladores.ControladorPaquete;
import controladores.ControladorPlataforma;
import controladores.ControladorUsuario;
import controladores.Fabrica;
import interfaces.ICategoria;
import interfaces.IPaquete;
import interfaces.IPlataforma;
import interfaces.IUsuario;
import controladores.ControladorCategoria;
import controladores.ControladorPaquete;
import controladores.ControladorPlataforma;
import controladores.ControladorUsuario;

public class Fabrica {
	
	private static Fabrica instancia;
	private IUsuario interfazUsuario;
	private IPaquete interfazPaquete;
	private IPlataforma interfazPlataforma;
	private ICategoria interfazCategoria;
	private Fabrica() {
	}
	public static Fabrica getInstancia() {
		if (instancia==null) {
			instancia = new Fabrica();
		}
		return instancia;
	}
	public IUsuario getIUsuario() {
		if (interfazUsuario==null){
			interfazUsuario = new ControladorUsuario();
		}
		return interfazUsuario;
	};
	public IPaquete getIPaquete() {
		if (interfazPaquete==null) {
			interfazPaquete = new ControladorPaquete();
		}
		return interfazPaquete;
	};
	public IPlataforma getIPlataforma() {
		if (interfazPlataforma==null) {
			interfazPlataforma = new ControladorPlataforma();
		}
		return interfazPlataforma;
	};
	public ICategoria getICategoria() {
		if (interfazCategoria==null) {
			interfazCategoria = new ControladorCategoria();
		}
		return interfazCategoria;
	};
}
