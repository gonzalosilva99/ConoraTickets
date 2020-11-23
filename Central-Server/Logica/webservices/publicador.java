/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package webservices;
import controladores.Fabrica;
import datatypes.DtArtista;
import datatypes.DtArtistaConsulta;
import datatypes.DtArtistaPerfil;
import datatypes.DtCategoria;
import datatypes.DtEspectaculo;
import datatypes.DtEspectaculoDatos;
import datatypes.DtEspectador;
import datatypes.DtEspectadorConsulta;
import datatypes.DtEspectadorPerfil;
import datatypes.DtFuncion;
import datatypes.DtFuncionDatos;
import datatypes.DtPaquete;
import datatypes.DtPaqueteDatos;
import datatypes.DtPlataforma;
import datatypes.DtRegistro;
import datatypes.DtUsuario;
import datatypes.TipoRegistro;
import excepciones.Identidad;
import interfaces.ICategoria;
import interfaces.IPlataforma;
import interfaces.IUsuario;
import interfaces.IPaquete;

import java.util.Date;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

import clases.Categoria;
import clases.Espectaculo;
import clases.Funcion;
import clases.Paquete;
/**
 *
 * @author Pablo
 */
@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class publicador {
    Fabrica fab = Fabrica.getInstancia();
	IUsuario iusuario = fab.getIUsuario();
	IPlataforma iplataforma = fab.getIPlataforma();
	ICategoria icategoria = fab.getICategoria();
	IPaquete ipaquete = fab.getIPaquete();
    private Endpoint endpoint = null;
    //Constructor
    public publicador(){}

    //Operaciones las cuales quiero publicar

    @WebMethod(exclude = true)
    public void publicar(){
         endpoint = Endpoint.publish("http://localhost:9105/publicador", this);
    }

    @WebMethod(exclude = true)
    public Endpoint getEndpoint() {
            return endpoint;
    }

    @WebMethod
    public void altaEspectaculo(String nomPlat, String nickArtista, String nomEspectaculo, String descripcion, Integer minEsp, Integer maxEsp, String url, Integer costo, Date fecha, Integer duracion, String imagen, ArrayList<String> categorias,  String urlVideo, String premio, int cantPremios) {
    	try {
    	Set<String> cat = new HashSet<String>(categorias);
        iplataforma.altaEspectaculo(nomPlat, nickArtista, nomEspectaculo, descripcion, minEsp, maxEsp, url, costo, fecha, duracion, imagen, cat, urlVideo, premio, cantPremios);
    	}
    	catch(Exception e) {
    		
    	}
    	
    }
    @WebMethod
    public void actualizarUltimoIngreso(String nickname) {
    	iusuario.actualizarUltimoIngreso(nickname);
    }
    
    @WebMethod
    public DtEspectaculoDatos getDatosEspectaculo(String nombrePlataforma, String nombreEspectaculo) {
    	return iplataforma.getDatosEspectaculo(nombrePlataforma, nombreEspectaculo);
    }
    
    @WebMethod
	public ArrayList<DtEspectaculo> listarEspectaculosAceptadosDePlataforma(String Nombre){
    	ArrayList<DtEspectaculo> set = new ArrayList<DtEspectaculo>(iplataforma.listarEspectaculosAceptadosDePlataforma(Nombre));
    	return set;
    }
    
    @WebMethod
    public void altaPlataforma(String nombre, String Descripcion, String Url) {
    	try {
    		iplataforma.altaPlataforma(nombre, Descripcion, Url);
    	}
    	catch(Exception e) {
    		
    	}
    	
    }
    
    @WebMethod   
    public ArrayList<DtPlataforma> listarPlataformas(){
    	ArrayList<DtPlataforma> set = new ArrayList<DtPlataforma>(iplataforma.listarPlataformas());
    	return set;
    }
    
    @WebMethod
	public void confirmarAltaFuncionEspectaculo(String nombrePlataforma, String nombreEspectaculo, String nombre, Date inicio, ArrayList<String> artistas, Date alta, String imagen) {
    	Set<String> art = new HashSet<String>(artistas);
    	iplataforma.confirmarAltaFuncionEspectaculo(nombrePlataforma, nombreEspectaculo, nombre, inicio, art, alta, imagen);
    }

    @WebMethod
    public boolean existeFuncion(String nombreFuncion) {
    	return iplataforma.existeFuncion(nombreFuncion);
    }
	
    @WebMethod
	public DtEspectaculoDatos findDatosEspectaculo(String nombreEspectaculo) {
    	return iplataforma.findDatosEspectaculo(nombreEspectaculo);
    }
    @WebMethod
	public String getPlataformaDeEspectaculo(String esp) {
    	return iplataforma.getPlataformaDeEspectaculo(esp);
    }
    
    @WebMethod
	public DtFuncionDatos findDatosFuncion(String nombre) {
    	return iplataforma.findDatosFuncion(nombre);
    }
    @WebMethod
	public Boolean puedeAgregarEspectadores(String nombrePlataforma, String nombreEspectaculo, String nombreFuncion) {
    	return iplataforma.puedeAgregarEspectadores(nombrePlataforma, nombreEspectaculo, nombreFuncion);
    }
    @WebMethod
	public ArrayList<DtCategoria> listarCategoriasDeEspectaculo(String Plataforma, String Espectaculo){
    	ArrayList<DtCategoria> set = new ArrayList<DtCategoria>(iplataforma.listarCategoriasDeEspectaculo(Plataforma, Espectaculo));
    	return set;
    }
    @WebMethod
	public void aceptarEspectaculo(String nomEspectaculo) {
    	iplataforma.aceptarEspectaculo(nomEspectaculo);
    }
    @WebMethod
	public ArrayList<DtEspectaculoDatos> filtrarEspectaculos(String search){
    	ArrayList<DtEspectaculoDatos> ret = new ArrayList<DtEspectaculoDatos>(iplataforma.filtrarEspectaculos(search));
    	return ret;
    }
    @WebMethod
	public DtFuncion getDtFuncion(String nombreFuncion) {
    	return iplataforma.getDtFuncion(nombreFuncion);
    }
    @WebMethod
	public ArrayList<DtEspectador> sortearPremios(String nombrePlataforma, String nombreEspectaculo, String nombreFuncion){
    	ArrayList<DtEspectador> ret = new ArrayList<DtEspectador>(iplataforma.sortearPremios(nombrePlataforma, nombreEspectaculo, nombreFuncion));
    	return ret;
    }
    @WebMethod    
	public void confirmarAltaArtista(String Nickname, String Nombre, String Apellido, String Email, Date Nacimiento, String imagen, String contrasena, String Descripcion, String Biografia, String Link) {
    	try {
    		iusuario.confirmarAltaArtista(Nickname, Nombre, Apellido, Email, Nacimiento, imagen, contrasena, Descripcion, Biografia, Link);
    	}
    	catch(Exception e) {
    		
    	}
    }
    
    @WebMethod
	public void confirmarAltaEspectador(String Nickname, String Nombre, String Apellido, String Email, Date Nacimiento,  String imagen, String contrasena){
    	try {
    		iusuario.confirmarAltaEspectador(Nickname, Nombre, Apellido, Email, Nacimiento, imagen, contrasena);
    	}
    	catch(Exception e) {
    		
    	}
    }
    @WebMethod
	public Boolean esArtista(String nickname) {
    	return iusuario.esArtista(nickname);
    }
    @WebMethod
	public DtArtistaPerfil perfilArtista(String nickname) {
    	return iusuario.perfilArtista(nickname);
    }
    @WebMethod
	public DtEspectadorPerfil perfilEspectador(String nickname) {
    	return iusuario.perfilEspectador(nickname);
    }
    @WebMethod
	public ArrayList<DtArtista> listarArtistas(){
    	ArrayList<DtArtista> ret = new ArrayList<DtArtista>(iusuario.listarArtistas());
    	return ret;
    }
    @WebMethod
	public ArrayList<DtRegistro> listarRegistrosSinCanjeaer(String nickname){
    	ArrayList<DtRegistro> ret = new ArrayList<DtRegistro>(iusuario.listarRegistrosSinCanjeaer(nickname));
    	return ret;
    }
    @WebMethod
	public void confirmarRegistroFuncionEspectaculo(String nombrePlataforma, String nombreEspectaculo, String nickname, String nombreFuncion, Date fecha, TipoRegistro registro, Integer Registro1, Integer Registro2, Integer Registro3, String NombrePaquete, Double costo) {
    	iusuario.confirmarRegistroFuncionEspectaculo(nombrePlataforma, nombreEspectaculo, nickname, nombreFuncion, fecha, registro, Registro1, Registro2, Registro3, NombrePaquete, costo);
    }
    @WebMethod
	public Boolean existeRegistroaFuncion(String nickname, String nombreFuncion) {
    	return iusuario.existeRegistroaFuncion(nickname, nombreFuncion);
    }
    @WebMethod
	public void seguirUsuario(String NickSeguidor, String NickASeguir) {
    	iusuario.seguirUsuario(NickSeguidor, NickASeguir);
    }
    @WebMethod
	public DtUsuario getUsuarioNickname(String nickname) {
    	return iusuario.getUsuarioNickname(nickname);
    }
    @WebMethod
	public DtUsuario getUsuarioEmail(String email) {
    	return iusuario.getUsuarioEmail(email);
    }
    @WebMethod
	public Boolean logueoCorrecto(String login, String password) {
    	return iusuario.logueoCorrecto(login, password);
    }
    @WebMethod
	public void comprarPaquete(String nickname, String nombrePaquete, Date fecha) {
    	iusuario.comprarPaquete(nickname, nombrePaquete, fecha);
    }
    @WebMethod
	public Boolean existeCompraPaquete(String nickname, String nombrePaquete) {
    	return iusuario.existeCompraPaquete(nickname, nombrePaquete);
    }
    @WebMethod
	public Boolean existeNickname(String nickname) {
    	return iusuario.existeNickname(nickname);
    }
    @WebMethod
	public ArrayList<DtUsuario> filtrarUsuarios(String search){
    	ArrayList<DtUsuario> ret = new ArrayList<DtUsuario>(iusuario.filtrarUsuarios(search));
    	return ret;
    }
    @WebMethod
	public void dejarSeguirUsuario(String NickSeguidor, String NickDejarSeguir) {
    	iusuario.dejarSeguirUsuario(NickSeguidor, NickDejarSeguir);
    }
    @WebMethod
	public DtArtista getDtArtistaNickname(String nickname) {
    	return iusuario.getDtArtistaNickname(nickname);
    }
    @WebMethod
	public void modificarArtistaCompleto(String Nickname, String Nombre, String Apellido, Date Nacimiento, String Descripcion, String Biografia, String Link, String Imagen) {
    	iusuario.modificarArtistaCompleto(Nickname, Nombre, Apellido, Nacimiento, Descripcion, Biografia, Link, Imagen);
    }
    @WebMethod
	public void modificarEspectadorCompleto(String Nickname, String Nombre, String Apellido, Date Nacimiento, String Imagen) {
    	iusuario.modificarEspectadorCompleto(Nickname, Nombre, Apellido, Nacimiento, Imagen);
    }
    @WebMethod
	public ArrayList<DtRegistro> listarRegistros(String Nickname){
    	ArrayList<DtRegistro> ret = new ArrayList<DtRegistro>(iusuario.listarRegistros(Nickname));
    	return ret;
    }
    @WebMethod
	public void marcarFavorito(String nickname, String nomEsp) {
    	iusuario.marcarFavorito(nickname, nomEsp);
    }
    @WebMethod
	public void desmarcarFavorito(String nickname, String nomEsp) {
    	iusuario.desmarcarFavorito(nickname, nomEsp);
    }
    @WebMethod
	public ArrayList<DtEspectaculo> listarEspectaculosParaPuntuar(String nickname){
    	ArrayList<DtEspectaculo> ret = new ArrayList<DtEspectaculo>(iusuario.listarEspectaculosParaPuntuar(nickname));
    	return ret;
    }
    @WebMethod
	public void valorarEspectaculo(String nickname, String nomEsp, int valoracion) {
    	iusuario.valorarEspectaculo(nickname, nomEsp, valoracion);
    }
    @WebMethod
	public int getPuntajeEspectaculo(String nickname, String nomEspectaculo) {
    	return iusuario.getPuntajeEspectaculo(nickname, nomEspectaculo);
    }	
    @WebMethod
	public void altaCategoria(String Nombre) {
    	try {
    		icategoria.altaCategoria(Nombre);
    	}
    	catch(Exception e) {
    		
    	}
    }
    @WebMethod
	public Categoria getCategoria(String nombre){
    	return icategoria.getCategoria(nombre);
}
    @WebMethod
	public ArrayList<DtEspectaculo> listarEspectaculosAceptadosDeCategoria(String nombreCat){
    	ArrayList<DtEspectaculo> ret = new ArrayList<DtEspectaculo>(icategoria.listarEspectaculosAceptadosDeCategoria(nombreCat));
    	return ret;
    }
    @WebMethod
	public ArrayList<DtCategoria> listarCategorias(){
    	ArrayList<DtCategoria> ret = new ArrayList<DtCategoria>(icategoria.listarCategorias());
    	return ret;
    }
    @WebMethod	
	public ArrayList<DtPaquete> listarPaquetes(){
    	ArrayList<DtPaquete> ret = new ArrayList<DtPaquete>(ipaquete.listarPaquetes());
    	return ret;
    }
    @WebMethod
	public void confirmarAgregarEspectaculoPaquete(String NombrePaquete, String NombrePlataforma, String NombreEspectaculo) {
    	ipaquete.confirmarAgregarEspectaculoPaquete(NombrePaquete, NombrePlataforma, NombreEspectaculo);
    }
    @WebMethod
	public void confirmarAltaPaquete(String NombrePaquete, String Descripcion, Date inicio, Date fin, Double Descuento, Date alta, String imagen) {
    	try {
    		ipaquete.confirmarAltaPaquete(NombrePaquete, Descripcion, inicio, fin, Descuento, alta, imagen);
    	}
    	catch(Exception e) {
    		
    	}
    }
    @WebMethod
	public DtPaqueteDatos getPaqueteDatos(String nombrePaquete) {
    	return ipaquete.getPaqueteDatos(nombrePaquete);
    }
    @WebMethod
	public Paquete getPaquete(String nombrePaquete) {
    	return ipaquete.getPaquete(nombrePaquete);
    }
    @WebMethod
	public ArrayList<DtPaqueteDatos> filtrarPaquetes(String search){
    	ArrayList<DtPaqueteDatos> ret = new ArrayList<DtPaqueteDatos>(ipaquete.filtrarPaquetes(search));
    	return ret;
    }

}