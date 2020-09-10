package Interfaces;

import java.util.Date;
import java.util.Set;
import DataTypes.DtEspectador;
import DataTypes.DtArtista;
import DataTypes.DtUsuario;
import DataTypes.DtArtista;

public interface IUsuario {
	public void confirmarAltaArtista(String Nickname, String Nombre, String Apellido, String Email, Date Nacimiento, String Descripcion, String Biografia, String Link);
	public void confirmarAltaEspectador(String Nickname, String Nombre, String Apellido, String Email, Date Nacimiento);
	public Set<DtUsuario> listarUsuarios();
	public Boolean EsArtista(String nickname);
	public DtArtista MostrarArtista(String nickname);
	public DtEspectador MostrarEspectador(String nickname);
	public Set<DtArtista> listarArtistas();
}
