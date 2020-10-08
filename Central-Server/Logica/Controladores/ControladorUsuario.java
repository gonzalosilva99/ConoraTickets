package Controladores;

import java.util.Date;
import Clases.Espectador;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import Clases.Paquete;
import Manejadores.ManejadorPaquetes;
import javax.swing.JOptionPane;

import Clases.Espectaculo;
import Clases.Artista;
import Clases.Funcion;
import DataTypes.DtFuncion;
import DataTypes.DtPaquete;
import DataTypes.DtRegistro;
import DataTypes.DtUsuario;
import DataTypes.TipoRegistro;
import DataTypes.DtArtista;
import DataTypes.DtEspectador;
import DataTypes.DtArtistaConsulta;
import DataTypes.DtEspectadorConsulta;
import Interfaces.IUsuario;
import Manejadores.ManejadorPlataforma;
import Manejadores.ManejadorUsuario;
import Excepciones.Identidad;
import Relaciones.RegistroFuncion;

public class ControladorUsuario implements IUsuario{
	
	public void confirmarAltaArtista(String Nickname, String Nombre, String Apellido, String Email, Date Nacimiento, String imagen, String contrasena,  String Descripcion, String Biografia, String Link) throws Identidad {
		ManejadorUsuario manusu = Manejadores.ManejadorUsuario.getInstancia();	
		manusu.confirmarAltaArtista(Nickname,Nombre,Apellido,Email,Nacimiento,imagen,contrasena,Descripcion,Biografia,Link);
	}
		
	public void confirmarAltaEspectador(String Nickname, String Nombre, String Apellido, String Email, Date Nacimiento,  String imagen, String contrasena) throws Identidad{
		ManejadorUsuario manusu = Manejadores.ManejadorUsuario.getInstancia();	
		manusu.confirmarAltaEspectador(Nickname,Nombre,Apellido,Email,Nacimiento,imagen,contrasena);
	}
	

	public Set<DtEspectador> listarEspectadores(){
		ManejadorUsuario manusu = Manejadores.ManejadorUsuario.getInstancia();
		return manusu.listarEspectadores();
	}
	
	public Set<DtRegistro> listarRegistrosSinCanjeaer(String nickname){
		ManejadorUsuario manusu = Manejadores.ManejadorUsuario.getInstancia();
		return manusu.listarRegistrosSinCanjeaer(nickname);
	}
	
	public Set<DtUsuario> listarUsuarios(){
		ManejadorUsuario manusu = Manejadores.ManejadorUsuario.getInstancia();
		Set<DtUsuario> h = manusu.listarUsuarios();
		return h;
	}
	public Set<DtArtista> listarArtistas(){
		ManejadorUsuario manusu = Manejadores.ManejadorUsuario.getInstancia();
		Set<DtArtista> h = manusu.listarArtistas();
		return h;
	}
	
	public Boolean EsArtista(String nickname) {
		ManejadorUsuario manusu = Manejadores.ManejadorUsuario.getInstancia();
		Boolean h = manusu.EsArtista(nickname);
		return h;
	}
	
	public DtArtistaConsulta MostrarArtista(String nickname) {
		ManejadorUsuario manusu = Manejadores.ManejadorUsuario.getInstancia();
		DtArtistaConsulta h = manusu.MostrarArtista(nickname);
		return h;
	}
	
	public DtEspectadorConsulta MostrarEspectador(String nickname) {
		ManejadorUsuario manusu = Manejadores.ManejadorUsuario.getInstancia();
		DtEspectadorConsulta h = manusu.MostrarEspectador(nickname);
		return h;
	}
	
	public void ModificarArtista(String Nickname, String Nombre, String Apellido, Date Nacimiento, String Descripcion, String Biografia, String Link) {
		try {
		ManejadorUsuario manusu = Manejadores.ManejadorUsuario.getInstancia();	
		manusu.ModificarArtista(Nickname,Nombre,Apellido,Nacimiento,Descripcion,Biografia,Link);
		}
		catch(Exception e) {
			
		}
	}
		
	public void ModificarEspectador(String Nickname, String Nombre, String Apellido, Date Nacimiento) {
		try {
		ManejadorUsuario manusu = Manejadores.ManejadorUsuario.getInstancia();	
		manusu.ModificarEspectador(Nickname,Nombre,Apellido,Nacimiento);
		}
		catch(Exception e) {
		}
	}
	
	public void RelacionarArtistaEspectaculo(String nickArtista,Espectaculo nuevo) {
		ManejadorUsuario manusu = Manejadores.ManejadorUsuario.getInstancia();	
		manusu.RelacionarArtistaEspectaculo(nickArtista,nuevo);
	}
	public Set<DtArtista> listarArtistasNoEspectaculo(String nombreEspectaculo){
		ManejadorUsuario manusu = Manejadores.ManejadorUsuario.getInstancia();
		Set<DtArtista> h = manusu.listarArtistasNoEspectaculo(nombreEspectaculo);
		return h;
	}
	
	public void RelacionarArtistaFuncion(String nickArtista, Funcion funcion) {
		ManejadorUsuario manusu = Manejadores.ManejadorUsuario.getInstancia();
		Artista artista = manusu.getArtista(nickArtista);
		artista.anadirFuncion(funcion);
	}
	
	public Set<DtPaquete> listarPaquetesCanjeables(String nickname, String nombreEspectaculo){
		ManejadorUsuario manusu = Manejadores.ManejadorUsuario.getInstancia();
		return manusu.listarPaquetesCanjeables(nickname,nombreEspectaculo);
	}
	
	public void confirmarRegistroFuncionEspectaculo(String nombrePlataforma, String nombreEspectaculo, String nickname, String nombreFuncion,Date fecha,TipoRegistro registro, Integer Registro1, Integer Registro2,Integer Registro3,String NombrePaquete,Double costo) {
		ManejadorUsuario manusu = Manejadores.ManejadorUsuario.getInstancia();
		Espectador espec = manusu.getEspectador(nickname);
		ManejadorPlataforma manplat = Manejadores.ManejadorPlataforma.getInstancia();
		Funcion fun = manplat.getFuncion(nombrePlataforma, nombreEspectaculo, nombreFuncion);
		RegistroFuncion regfun = new RegistroFuncion(espec.getUltimoCodigo() + 1, fecha,registro,fun,espec);
		espec.agregarRegistroFuncion(regfun);
		if(registro == TipoRegistro.Tipo_2) {
			espec.MarcarRegistrosUsados(Registro1, Registro2, Registro3);					
		}
		Fabrica fab = Fabrica.getInstancia();
		Paquete paq = fab.getIPaquete().getPaquete(NombrePaquete);
		if(registro == TipoRegistro.Tipo_3) {
			regfun.canjearPaquete(paq);
			regfun.setCosto(costo * paq.getDescuento());
			regfun.setCanjeable(true);
		}
		else if(registro == TipoRegistro.Tipo_2) {
			regfun.setCosto(0.0);
			regfun.setCanjeable(false);
		}
		else {
			regfun.setCosto(costo);
			regfun.setCanjeable(true);
		}	
	}
	
	public Boolean ExisteRegistroaFuncion(String nickname,String nombreFuncion) {
		ManejadorUsuario manusu = Manejadores.ManejadorUsuario.getInstancia();
		return manusu.ExisteRegistroaFuncion(nickname,nombreFuncion);
	}

	
	public void SeguirUsuario(String NickSeguidor, String NickASeguir) {
		ManejadorUsuario manusu = Manejadores.ManejadorUsuario.getInstancia();
		manusu.SeguirUsuario(NickSeguidor,NickASeguir);
	}

	public void comprarPaquete(String nickname, String nombrePaquete) {
		ManejadorUsuario manusu = Manejadores.ManejadorUsuario.getInstancia();
		manusu.comprarPaquete(nickname, nombrePaquete);
	}
	
	public DtUsuario getUsuarioNickname(String nickname) {
		return ManejadorUsuario.getInstancia().getUsuarioNickname(nickname);
	}
	public DtUsuario getUsuarioEmail(String email) {
		return ManejadorUsuario.getInstancia().getUsuarioEmail(email);
	}
	public Boolean LogueoCorrecto(String login, String password) {
		return ManejadorUsuario.getInstancia().LogueoCorrecto(login, password);
	}
}
