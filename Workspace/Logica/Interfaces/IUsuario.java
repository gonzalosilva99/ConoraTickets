package Interfaces;

import java.util.Date;
import java.util.Set;
import DataTypes.DtUsuario;

public interface IUsuario {
	public void confirmarAltaArtista(String Nickname, String Nombre, String Apellido, String Email, Date Nacimiento, String Descripcion, String Biografia, String Link);
	public void confirmarAltaEspectador(String Nickname, String Nombre, String Apellido, String Email, Date Nacimiento);
	public Set<DtUsuario> listarUsuarios();
}
