package controladores;

import java.util.Date;
import java.util.Set;

import Persistencia.SetEspectaculoPersistencia;

import java.util.Map;

import clases.Artista;
import clases.Espectaculo;
import clases.Espectador;
import clases.Funcion;
import clases.Paquete;
import datatypes.DtArtista;
import datatypes.DtArtistaConsulta;
import datatypes.DtArtistaPerfil;
import datatypes.DtEspectaculoDatos;
import datatypes.DtEspectaculo;
import datatypes.DtEspectador;
import datatypes.DtEspectadorConsulta;
import datatypes.DtEspectadorPerfil;
import datatypes.DtPaquete;
import datatypes.DtRegistro;
import datatypes.DtUsuario;
import datatypes.TipoRegistro;
import excepciones.Identidad;
import interfaces.IUsuario;
import manejadores.ManejadorPlataforma;
import manejadores.ManejadorUsuario;
import relaciones.RegistroFuncion;

public class ControladorUsuario implements IUsuario{
	
	public void confirmarAltaArtista(String Nickname, String Nombre, String Apellido, String Email, Date Nacimiento, String imagen, String contrasena,  String Descripcion, String Biografia, String Link) throws Identidad {
		ManejadorUsuario manusu = manejadores.ManejadorUsuario.getInstancia();	
		manusu.confirmarAltaArtista(Nickname, Nombre, Apellido, Email, Nacimiento, imagen, contrasena, Descripcion, Biografia, Link);
	}
		
	public void confirmarAltaEspectador(String Nickname, String Nombre, String Apellido, String Email, Date Nacimiento,  String imagen, String contrasena) throws Identidad{
		ManejadorUsuario manusu = manejadores.ManejadorUsuario.getInstancia();	
		manusu.confirmarAltaEspectador(Nickname, Nombre, Apellido, Email, Nacimiento, imagen, contrasena);
	}
	

	public Set<DtEspectador> listarEspectadores(){
		ManejadorUsuario manusu = manejadores.ManejadorUsuario.getInstancia();
		return manusu.listarEspectadores();
	}
	
	public Set<DtRegistro> listarRegistrosSinCanjeaer(String nickname){
		ManejadorUsuario manusu = manejadores.ManejadorUsuario.getInstancia();
		return manusu.listarRegistrosSinCanjeaer(nickname);
	}
	
	public Set<DtUsuario> filtrarUsuarios(String search){
		ManejadorUsuario manusu = manejadores.ManejadorUsuario.getInstancia();
		return manusu.filtrarUsuarios(search);
	}
	
	public void modificarArtistaCompleto(String Nickname, String Nombre, String Apellido, Date Nacimiento, String Descripcion, String Biografia, String Link, String Imagen) {
		try {
			ManejadorUsuario manusu = manejadores.ManejadorUsuario.getInstancia();	
			manusu.modificarArtistaCompleto(Nickname, Nombre, Apellido, Nacimiento, Descripcion, Biografia, Link, Imagen);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
	}

	public void modificarEspectadorCompleto(String Nickname, String Nombre, String Apellido, Date Nacimiento, String Imagen) {
		try {
			ManejadorUsuario manusu = manejadores.ManejadorUsuario.getInstancia();	
			manusu.modificarEspectadorCompleto(Nickname, Nombre, Apellido, Nacimiento, Imagen);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
	}
	
	
	public Set<DtUsuario> listarUsuarios(){
		ManejadorUsuario manusu = manejadores.ManejadorUsuario.getInstancia();
		Set<DtUsuario> usu = manusu.listarUsuarios();
		return usu;
	}
	public Set<DtArtista> listarArtistas(){
		ManejadorUsuario manusu = manejadores.ManejadorUsuario.getInstancia();
		Set<DtArtista> art = manusu.listarArtistas();
		return art;
	}
	
	public void actualizarUltimoIngreso(String nickname) {
		manejadores.ManejadorUsuario.getInstancia().actualizarUltimoIngreso(nickname);
	}
	
	public Boolean esArtista(String nickname) {
		ManejadorUsuario manusu = manejadores.ManejadorUsuario.getInstancia();
		Boolean hbol= manusu.esArtista(nickname);
		return hbol;
	}
	
	public DtArtistaPerfil perfilArtista(String nickname) {
		return ManejadorUsuario.getInstancia().perfilArtista(nickname);
	}
	public DtEspectadorPerfil perfilEspectador(String nickname) {
		return ManejadorUsuario.getInstancia().perfilEspectador(nickname);
	}
	
	public DtArtistaConsulta mostrarArtista(String nickname) {
		ManejadorUsuario manusu = manejadores.ManejadorUsuario.getInstancia();
		DtArtistaConsulta art = manusu.mostrarArtista(nickname);
		return art;
	}
	
	public DtEspectadorConsulta mostrarEspectador(String nickname) {
		ManejadorUsuario manusu = manejadores.ManejadorUsuario.getInstancia();
		DtEspectadorConsulta art = manusu.mostrarEspectador(nickname);
		return art;
	}
	
	public void modificarArtista(String Nickname, String Nombre, String Apellido, Date Nacimiento, String Descripcion, String Biografia, String Link) {
		try {
		ManejadorUsuario manusu = manejadores.ManejadorUsuario.getInstancia();	
		manusu.modificarArtista(Nickname, Nombre, Apellido, Nacimiento, Descripcion, Biografia, Link);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			
		}
	}
		
	public void modificarEspectador(String Nickname, String Nombre, String Apellido, Date Nacimiento) {
		try {
		ManejadorUsuario manusu = manejadores.ManejadorUsuario.getInstancia();	
		manusu.modificarEspectador(Nickname, Nombre, Apellido, Nacimiento);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void relacionarArtistaEspectaculo(String nickArtista, Espectaculo nuevo) {
		ManejadorUsuario manusu = manejadores.ManejadorUsuario.getInstancia();	
		manusu.relacionarArtistaEspectaculo(nickArtista, nuevo);
	}
	public Set<DtArtista> listarArtistasNoEspectaculo(String nombreEspectaculo){
		ManejadorUsuario manusu = manejadores.ManejadorUsuario.getInstancia();
		Set<DtArtista> art = manusu.listarArtistasNoEspectaculo(nombreEspectaculo);
		return art;
	}
	
	public void relacionarArtistaFuncion(String nickArtista, Funcion funcion) {
		ManejadorUsuario manusu = manejadores.ManejadorUsuario.getInstancia();
		Artista artista = manusu.getArtista(nickArtista);
		artista.anadirFuncion(funcion);
	}
	
	public Set<DtPaquete> listarPaquetesCanjeables(String nickname, String nombreEspectaculo){
		ManejadorUsuario manusu = manejadores.ManejadorUsuario.getInstancia();
		return manusu.listarPaquetesCanjeables(nickname, nombreEspectaculo);
	}
	
	public void confirmarRegistroFuncionEspectaculo(String nombrePlataforma, String nombreEspectaculo, String nickname, String nombreFuncion, Date fecha, TipoRegistro registro, Integer Registro1, Integer Registro2, Integer Registro3, String NombrePaquete, Double costo) {
		ManejadorUsuario manusu = manejadores.ManejadorUsuario.getInstancia();
		Espectador espec = manusu.getEspectador(nickname);
		ManejadorPlataforma manplat = manejadores.ManejadorPlataforma.getInstancia();
		Funcion fun = manplat.getFuncion(nombrePlataforma, nombreEspectaculo, nombreFuncion);
		RegistroFuncion regfun = new RegistroFuncion(espec.getUltimoCodigo() + 1, fecha, registro, fun, espec);
		espec.agregarRegistroFuncion(regfun);
		if (registro == TipoRegistro.Tipo_2) {
			espec.marcarRegistrosUsados(Registro1, Registro2, Registro3);					
		}
		
		
		if (registro == TipoRegistro.Tipo_3) {
			
			Fabrica fab = Fabrica.getInstancia();
			Paquete paq = fab.getIPaquete().getPaquete(NombrePaquete);
			String prueba = paq.getNombre();
			regfun.canjearPaquete(paq);
			regfun.setCosto(costo - costo * paq.getDescuento() / 100);
			regfun.setCanjeable(true);
		}
		else if (registro == TipoRegistro.Tipo_2) {
			regfun.setCosto(0.0);
			regfun.setCanjeable(false);
		}
		else {
			regfun.setCosto(costo);
			regfun.setCanjeable(true);
		}	
	}
	
	public Boolean existeRegistroaFuncion(String nickname, String nombreFuncion) {
		ManejadorUsuario manusu = manejadores.ManejadorUsuario.getInstancia();
		return manusu.existeRegistroaFuncion(nickname, nombreFuncion);
	}

	
	public void seguirUsuario(String NickSeguidor, String NickASeguir) {
		ManejadorUsuario manusu = manejadores.ManejadorUsuario.getInstancia();
		manusu.seguirUsuario(NickSeguidor, NickASeguir);
	}

	public void comprarPaquete(String nickname, String nombrePaquete, Date fecha) {
		ManejadorUsuario manusu = manejadores.ManejadorUsuario.getInstancia();
		manusu.comprarPaquete(nickname, nombrePaquete, fecha);
	}
	
	public DtUsuario getUsuarioNickname(String nickname) {
		return ManejadorUsuario.getInstancia().getUsuarioNickname(nickname);
	}
	public DtUsuario getUsuarioEmail(String email) {
		return ManejadorUsuario.getInstancia().getUsuarioEmail(email);
	}
	public Boolean logueoCorrecto(String login, String password) {
		return ManejadorUsuario.getInstancia().logueoCorrecto(login, password);
	}
	public Boolean existeNickname(String nickname) {
		return ManejadorUsuario.getInstancia().existeNickname(nickname);
	}
	public void dejarSeguirUsuario(String NickSeguidor, String NickDejarSeguir) {
		ManejadorUsuario.getInstancia().dejarSeguirUsuario(NickSeguidor, NickDejarSeguir);
	}

	public DtArtista getDtArtistaNickname(String nickname) {
		Artista artista = ManejadorUsuario.getInstancia().getArtista(nickname);
		return artista.getDtArtista();
	}
	
	public Boolean existeCompraPaquete(String nickname, String nombrePaquete) {
		return ManejadorUsuario.getInstancia().existeCompraPaquete(nickname, nombrePaquete);
	}
	

	public Set<DtRegistro> listarRegistros(String Nickname){
		return ManejadorUsuario.getInstancia().listarRegistros(Nickname);
	}
	
	public SetEspectaculoPersistencia listarEspectaculosFinalizados(String nickname){
		Artista artista = ManejadorUsuario.getInstancia().getArtista(nickname);
		return artista.getEspectaculosFinzalizados();
	}
	public void marcarFavorito(String nickname, String nomEsp) {
		Espectador espectador = ManejadorUsuario.getInstancia().getEspectador(nickname);
		Espectaculo espectaculo = ManejadorPlataforma.getInstancia().getEspectaculo(nomEsp);
		espectaculo.aumentarFavoritos();
		espectador.anadirFavorito(espectaculo);
	}
	public void desmarcarFavorito(String nickname, String nomEsp) {
		Espectador espectador = ManejadorUsuario.getInstancia().getEspectador(nickname);
		Espectaculo espectaculo = ManejadorPlataforma.getInstancia().getEspectaculo(nomEsp);
		espectaculo.quitarFavoritos();
		espectador.quitarFavorito(espectaculo);
		
	}
	public Set<DtEspectaculo> listarEspectaculosParaPuntuar(String nickname){
		Espectador espectador = ManejadorUsuario.getInstancia().getEspectador(nickname);
		return espectador.getEspectaculosParaPuntuar();
	}
	
	public void valorarEspectaculo(String nickname, String nomEsp, int valoracion) {
		Espectador espectador = ManejadorUsuario.getInstancia().getEspectador(nickname);
		espectador.valorarespectaculo(nomEsp, valoracion);
	}

	public int getPuntajeEspectaculo(String nickname, String nomEspectaculo) {
		Espectador espectador = ManejadorUsuario.getInstancia().getEspectador(nickname);
		return espectador.getPuntajeEspectaculo(nomEspectaculo);
	}
}
