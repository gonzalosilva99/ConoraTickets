package interfaces;

import java.util.Date;
import java.util.Set;

import Persistencia.SetEspectaculoPersistencia;

import java.util.Map;

import clases.Espectaculo;
import clases.Funcion;
import datatypes.DtArtista;
import datatypes.DtArtistaConsulta;
import datatypes.DtArtistaPerfil;
import datatypes.DtEspectador;
import datatypes.DtEspectadorConsulta;
import datatypes.DtEspectadorPerfil;
import datatypes.DtPaquete;
import datatypes.DtRegistro;
import datatypes.DtUsuario;
import datatypes.TipoRegistro;
import excepciones.Identidad;
import datatypes.DtEspectaculo;
public interface IUsuario {
	public void confirmarAltaArtista(String Nickname, String Nombre, String Apellido, String Email, Date Nacimiento, String imagen, String contrasena, String Descripcion, String Biografia, String Link) throws Identidad;
	public void confirmarAltaEspectador(String Nickname, String Nombre, String Apellido, String Email, Date Nacimiento,  String imagen, String contrasena) throws Identidad;
	public Set<DtUsuario> listarUsuarios();
	public Boolean esArtista(String nickname);
	public DtArtistaPerfil perfilArtista(String nickname);
	public DtEspectadorPerfil perfilEspectador(String nickname);
	public DtArtistaConsulta mostrarArtista(String nickname);
	public DtEspectadorConsulta mostrarEspectador(String nickname);
	public Set<DtArtista> listarArtistas();
	public void modificarArtista(String Nickname, String Nombre, String Apellido, Date Nacimiento, String Descripcion, String Biografia, String Link);
	public void modificarEspectador(String Nickname, String Nombre, String Apellido, Date Nacimiento);
	public Set<DtEspectador> listarEspectadores();
	public void actualizarUltimoIngreso(String nickname);
	public void relacionarArtistaEspectaculo(String nickArtista, Espectaculo nuevo);
	public void relacionarArtistaFuncion(String nickArtista, Funcion funcion);
	public Set<DtArtista> listarArtistasNoEspectaculo(String nombreEspectaculo);
	public Set<DtRegistro> listarRegistrosSinCanjeaer(String nickname);
	public Set<DtPaquete> listarPaquetesCanjeables(String nickname, String nombreEspectaculo);
	public void confirmarRegistroFuncionEspectaculo(String nombrePlataforma, String nombreEspectaculo, String nickname, String nombreFuncion, Date fecha, TipoRegistro registro, Integer Registro1, Integer Registro2, Integer Registro3, String NombrePaquete, Double costo);
	public Boolean existeRegistroaFuncion(String nickname, String nombreFuncion);
	public void seguirUsuario(String NickSeguidor, String NickASeguir);
	public DtUsuario getUsuarioNickname(String nickname);
	public DtUsuario getUsuarioEmail(String email);
	public Boolean logueoCorrecto(String login, String password);
	public void comprarPaquete(String nickname, String nombrePaquete, Date fecha);
	public Boolean existeCompraPaquete(String nickname, String nombrePaquete);
	public Boolean existeNickname(String nickname);
	public Set<DtUsuario> filtrarUsuarios(String search);
	public void dejarSeguirUsuario(String NickSeguidor, String NickDejarSeguir);
	public DtArtista getDtArtistaNickname(String nickname);
	public void modificarArtistaCompleto(String Nickname, String Nombre, String Apellido, Date Nacimiento, String Descripcion, String Biografia, String Link, String Imagen);
	public void modificarEspectadorCompleto(String Nickname, String Nombre, String Apellido, Date Nacimiento, String Imagen);
	public Set<DtRegistro> listarRegistros(String Nickname);
	public SetEspectaculoPersistencia listarEspectaculosFinalizados(String nickname);
	public void marcarFavorito(String nickname, String nomEsp);
	public void desmarcarFavorito(String nickname, String nomEsp);
	public Set<DtEspectaculo> listarEspectaculosParaPuntuar(String nickname);
	public void valorarEspectaculo(String nickname, String nomEsp, int valoracion);
	public int getPuntajeEspectaculo(String nickname, String nomEspectaculo);
	public Set<DtEspectaculo> listarEspectaculosAceptadosArtistaPlataforma(String nickname, String nombrePlataforma);

}
