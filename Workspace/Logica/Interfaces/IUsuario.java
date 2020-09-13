package Interfaces;

import java.util.Date;
import DataTypes.TipoRegistro;
import DataTypes.DtPaquete;
import java.util.Set;
import DataTypes.DtEspectador;
import DataTypes.DtEspectadorConsulta;
import DataTypes.DtArtistaConsulta;
import DataTypes.DtUsuario;
import Excepciones.Identidad;
import DataTypes.DtArtista;
import Clases.Espectaculo;
import Clases.Funcion;
import DataTypes.DtRegistro;
public interface IUsuario {
	public void confirmarAltaArtista(String Nickname, String Nombre, String Apellido, String Email, Date Nacimiento, String Descripcion, String Biografia, String Link) throws Identidad;
	public void confirmarAltaEspectador(String Nickname, String Nombre, String Apellido, String Email, Date Nacimiento) throws Identidad;
	public Set<DtUsuario> listarUsuarios();
	public Boolean EsArtista(String nickname);
	public DtArtistaConsulta MostrarArtista(String nickname);
	public DtEspectadorConsulta MostrarEspectador(String nickname);
	public Set<DtArtista> listarArtistas();
	public void ModificarArtista(String Nickname, String Nombre, String Apellido, Date Nacimiento, String Descripcion, String Biografia, String Link);
	public void ModificarEspectador(String Nickname, String Nombre, String Apellido, Date Nacimiento);
	public Set<DtEspectador> listarEspectadores();
	public void RelacionarArtistaEspectaculo(String nickArtista,Espectaculo nuevo);
	public void RelacionarArtistaFuncion(String nickArtista, Funcion funcion);
	public Set<DtArtista> listarArtistasNoEspectaculo(String nombreEspectaculo);
	public Set<DtRegistro> listarRegistrosSinCanjeaer(String nickname);
	public Set<DtPaquete> listarPaquetesCanjeables(String nickname, String nombreEspectaculo);
	public void confirmarRegistroFuncionEspectaculo(String nombrePlataforma, String nombreEspectaculo, String nickname, String nombreFuncion,Date fecha,TipoRegistro registro, Integer Registro1, Integer Registro2,Integer Registro3,String NombrePaquete,Double costo);
}
