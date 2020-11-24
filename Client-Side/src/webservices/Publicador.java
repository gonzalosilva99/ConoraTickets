
package webservices;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.Action;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "publicador", targetNamespace = "http://webservices/")
@SOAPBinding(style = SOAPBinding.Style.RPC)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface Publicador {


    /**
     * 
     * @param arg0
     * @return
     *     returns webservices.ArrayEspectaculos
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://webservices/publicador/listarEspectaculosAceptadosDePlataformaRequest", output = "http://webservices/publicador/listarEspectaculosAceptadosDePlataformaResponse")
    public ArrayEspectaculos listarEspectaculosAceptadosDePlataforma(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg7
     * @param arg6
     * @param arg9
     * @param arg8
     * @param arg3
     * @param arg2
     * @param arg5
     * @param arg4
     * @param arg13
     * @param arg14
     * @param arg1
     * @param arg0
     * @param arg10
     * @param arg11
     * @param arg12
     */
    @WebMethod
    @Action(input = "http://webservices/publicador/altaEspectaculoRequest", output = "http://webservices/publicador/altaEspectaculoResponse")
    public void altaEspectaculo(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1,
        @WebParam(name = "arg2", partName = "arg2")
        String arg2,
        @WebParam(name = "arg3", partName = "arg3")
        String arg3,
        @WebParam(name = "arg4", partName = "arg4")
        int arg4,
        @WebParam(name = "arg5", partName = "arg5")
        int arg5,
        @WebParam(name = "arg6", partName = "arg6")
        String arg6,
        @WebParam(name = "arg7", partName = "arg7")
        int arg7,
        @WebParam(name = "arg8", partName = "arg8")
        XMLGregorianCalendar arg8,
        @WebParam(name = "arg9", partName = "arg9")
        int arg9,
        @WebParam(name = "arg10", partName = "arg10")
        String arg10,
        @WebParam(name = "arg11", partName = "arg11")
        ArrayCategorias arg11,
        @WebParam(name = "arg12", partName = "arg12")
        String arg12,
        @WebParam(name = "arg13", partName = "arg13")
        String arg13,
        @WebParam(name = "arg14", partName = "arg14")
        int arg14);

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @Action(input = "http://webservices/publicador/actualizarUltimoIngresoRequest", output = "http://webservices/publicador/actualizarUltimoIngresoResponse")
    public void actualizarUltimoIngreso(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns webservices.DtEspectaculoDatos
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://webservices/publicador/getDatosEspectaculoRequest", output = "http://webservices/publicador/getDatosEspectaculoResponse")
    public DtEspectaculoDatos getDatosEspectaculo(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1);

    /**
     * 
     * @param arg2
     * @param arg1
     * @param arg0
     */
    @WebMethod
    @Action(input = "http://webservices/publicador/altaPlataformaRequest", output = "http://webservices/publicador/altaPlataformaResponse")
    public void altaPlataforma(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1,
        @WebParam(name = "arg2", partName = "arg2")
        String arg2);

    /**
     * 
     * @return
     *     returns webservices.ArrayPlataformas
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://webservices/publicador/listarPlataformasRequest", output = "http://webservices/publicador/listarPlataformasResponse")
    public ArrayPlataformas listarPlataformas();

    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg5
     * @param arg4
     * @param arg1
     * @param arg0
     * @param arg6
     */
    @WebMethod
    @Action(input = "http://webservices/publicador/confirmarAltaFuncionEspectaculoRequest", output = "http://webservices/publicador/confirmarAltaFuncionEspectaculoResponse")
    public void confirmarAltaFuncionEspectaculo(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1,
        @WebParam(name = "arg2", partName = "arg2")
        String arg2,
        @WebParam(name = "arg3", partName = "arg3")
        XMLGregorianCalendar arg3,
        @WebParam(name = "arg4", partName = "arg4")
        ArrayList arg4,
        @WebParam(name = "arg5", partName = "arg5")
        XMLGregorianCalendar arg5,
        @WebParam(name = "arg6", partName = "arg6")
        String arg6);

    /**
     * 
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://webservices/publicador/existeFuncionRequest", output = "http://webservices/publicador/existeFuncionResponse")
    public boolean existeFuncion(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns webservices.DtEspectaculoDatos
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://webservices/publicador/findDatosEspectaculoRequest", output = "http://webservices/publicador/findDatosEspectaculoResponse")
    public DtEspectaculoDatos findDatosEspectaculo(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://webservices/publicador/getPlataformaDeEspectaculoRequest", output = "http://webservices/publicador/getPlataformaDeEspectaculoResponse")
    public String getPlataformaDeEspectaculo(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns webservices.DtFuncionDatos
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://webservices/publicador/findDatosFuncionRequest", output = "http://webservices/publicador/findDatosFuncionResponse")
    public DtFuncionDatos findDatosFuncion(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://webservices/publicador/puedeAgregarEspectadoresRequest", output = "http://webservices/publicador/puedeAgregarEspectadoresResponse")
    public boolean puedeAgregarEspectadores(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1,
        @WebParam(name = "arg2", partName = "arg2")
        String arg2);

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns webservices.ArrayCategorias
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://webservices/publicador/listarCategoriasDeEspectaculoRequest", output = "http://webservices/publicador/listarCategoriasDeEspectaculoResponse")
    public ArrayCategorias listarCategoriasDeEspectaculo(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1);

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @Action(input = "http://webservices/publicador/aceptarEspectaculoRequest", output = "http://webservices/publicador/aceptarEspectaculoResponse")
    public void aceptarEspectaculo(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns webservices.DtFuncion
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://webservices/publicador/getDtFuncionRequest", output = "http://webservices/publicador/getDtFuncionResponse")
    public DtFuncion getDtFuncion(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns webservices.ArrayList
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://webservices/publicador/sortearPremiosRequest", output = "http://webservices/publicador/sortearPremiosResponse")
    public ArrayList sortearPremios(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1,
        @WebParam(name = "arg2", partName = "arg2")
        String arg2);

    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg5
     * @param arg4
     * @param arg1
     * @param arg0
     * @param arg7
     * @param arg6
     * @param arg9
     * @param arg8
     */
    @WebMethod
    @Action(input = "http://webservices/publicador/confirmarAltaArtistaRequest", output = "http://webservices/publicador/confirmarAltaArtistaResponse")
    public void confirmarAltaArtista(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1,
        @WebParam(name = "arg2", partName = "arg2")
        String arg2,
        @WebParam(name = "arg3", partName = "arg3")
        String arg3,
        @WebParam(name = "arg4", partName = "arg4")
        XMLGregorianCalendar arg4,
        @WebParam(name = "arg5", partName = "arg5")
        String arg5,
        @WebParam(name = "arg6", partName = "arg6")
        String arg6,
        @WebParam(name = "arg7", partName = "arg7")
        String arg7,
        @WebParam(name = "arg8", partName = "arg8")
        String arg8,
        @WebParam(name = "arg9", partName = "arg9")
        String arg9);

    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg5
     * @param arg4
     * @param arg1
     * @param arg0
     * @param arg6
     */
    @WebMethod
    @Action(input = "http://webservices/publicador/confirmarAltaEspectadorRequest", output = "http://webservices/publicador/confirmarAltaEspectadorResponse")
    public void confirmarAltaEspectador(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1,
        @WebParam(name = "arg2", partName = "arg2")
        String arg2,
        @WebParam(name = "arg3", partName = "arg3")
        String arg3,
        @WebParam(name = "arg4", partName = "arg4")
        XMLGregorianCalendar arg4,
        @WebParam(name = "arg5", partName = "arg5")
        String arg5,
        @WebParam(name = "arg6", partName = "arg6")
        String arg6);

    /**
     * 
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://webservices/publicador/esArtistaRequest", output = "http://webservices/publicador/esArtistaResponse")
    public boolean esArtista(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns webservices.DtArtistaPerfil
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://webservices/publicador/perfilArtistaRequest", output = "http://webservices/publicador/perfilArtistaResponse")
    public DtArtistaPerfil perfilArtista(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns webservices.DtEspectadorPerfil
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://webservices/publicador/perfilEspectadorRequest", output = "http://webservices/publicador/perfilEspectadorResponse")
    public DtEspectadorPerfil perfilEspectador(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @return
     *     returns webservices.ArrayArtistas
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://webservices/publicador/listarArtistasRequest", output = "http://webservices/publicador/listarArtistasResponse")
    public ArrayArtistas listarArtistas();

    /**
     * 
     * @param arg0
     * @return
     *     returns webservices.ArrayList
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://webservices/publicador/listarRegistrosSinCanjeaerRequest", output = "http://webservices/publicador/listarRegistrosSinCanjeaerResponse")
    public ArrayList listarRegistrosSinCanjeaer(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg5
     * @param arg4
     * @param arg1
     * @param arg0
     * @param arg10
     * @param arg7
     * @param arg6
     * @param arg9
     * @param arg8
     */
    @WebMethod
    @Action(input = "http://webservices/publicador/confirmarRegistroFuncionEspectaculoRequest", output = "http://webservices/publicador/confirmarRegistroFuncionEspectaculoResponse")
    public void confirmarRegistroFuncionEspectaculo(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1,
        @WebParam(name = "arg2", partName = "arg2")
        String arg2,
        @WebParam(name = "arg3", partName = "arg3")
        String arg3,
        @WebParam(name = "arg4", partName = "arg4")
        XMLGregorianCalendar arg4,
        @WebParam(name = "arg5", partName = "arg5")
        TipoRegistro arg5,
        @WebParam(name = "arg6", partName = "arg6")
        int arg6,
        @WebParam(name = "arg7", partName = "arg7")
        int arg7,
        @WebParam(name = "arg8", partName = "arg8")
        int arg8,
        @WebParam(name = "arg9", partName = "arg9")
        String arg9,
        @WebParam(name = "arg10", partName = "arg10")
        double arg10);

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://webservices/publicador/existeRegistroaFuncionRequest", output = "http://webservices/publicador/existeRegistroaFuncionResponse")
    public boolean existeRegistroaFuncion(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1);

    /**
     * 
     * @param arg1
     * @param arg0
     */
    @WebMethod
    @Action(input = "http://webservices/publicador/seguirUsuarioRequest", output = "http://webservices/publicador/seguirUsuarioResponse")
    public void seguirUsuario(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1);

    /**
     * 
     * @param arg0
     * @return
     *     returns webservices.DtUsuario
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://webservices/publicador/getUsuarioNicknameRequest", output = "http://webservices/publicador/getUsuarioNicknameResponse")
    public DtUsuario getUsuarioNickname(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns webservices.DtUsuario
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://webservices/publicador/getUsuarioEmailRequest", output = "http://webservices/publicador/getUsuarioEmailResponse")
    public DtUsuario getUsuarioEmail(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://webservices/publicador/logueoCorrectoRequest", output = "http://webservices/publicador/logueoCorrectoResponse")
    public boolean logueoCorrecto(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1);

    /**
     * 
     * @param arg2
     * @param arg1
     * @param arg0
     */
    @WebMethod
    @Action(input = "http://webservices/publicador/comprarPaqueteRequest", output = "http://webservices/publicador/comprarPaqueteResponse")
    public void comprarPaquete(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1,
        @WebParam(name = "arg2", partName = "arg2")
        XMLGregorianCalendar arg2);

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://webservices/publicador/existeCompraPaqueteRequest", output = "http://webservices/publicador/existeCompraPaqueteResponse")
    public boolean existeCompraPaquete(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1);

    /**
     * 
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://webservices/publicador/existeNicknameRequest", output = "http://webservices/publicador/existeNicknameResponse")
    public boolean existeNickname(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg1
     * @param arg0
     */
    @WebMethod
    @Action(input = "http://webservices/publicador/dejarSeguirUsuarioRequest", output = "http://webservices/publicador/dejarSeguirUsuarioResponse")
    public void dejarSeguirUsuario(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1);

    /**
     * 
     * @param arg0
     * @return
     *     returns webservices.DtArtista
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://webservices/publicador/getDtArtistaNicknameRequest", output = "http://webservices/publicador/getDtArtistaNicknameResponse")
    public DtArtista getDtArtistaNickname(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg5
     * @param arg4
     * @param arg1
     * @param arg0
     * @param arg7
     * @param arg6
     */
    @WebMethod
    @Action(input = "http://webservices/publicador/modificarArtistaCompletoRequest", output = "http://webservices/publicador/modificarArtistaCompletoResponse")
    public void modificarArtistaCompleto(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1,
        @WebParam(name = "arg2", partName = "arg2")
        String arg2,
        @WebParam(name = "arg3", partName = "arg3")
        XMLGregorianCalendar arg3,
        @WebParam(name = "arg4", partName = "arg4")
        String arg4,
        @WebParam(name = "arg5", partName = "arg5")
        String arg5,
        @WebParam(name = "arg6", partName = "arg6")
        String arg6,
        @WebParam(name = "arg7", partName = "arg7")
        String arg7);

    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg4
     * @param arg1
     * @param arg0
     */
    @WebMethod
    @Action(input = "http://webservices/publicador/modificarEspectadorCompletoRequest", output = "http://webservices/publicador/modificarEspectadorCompletoResponse")
    public void modificarEspectadorCompleto(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1,
        @WebParam(name = "arg2", partName = "arg2")
        String arg2,
        @WebParam(name = "arg3", partName = "arg3")
        XMLGregorianCalendar arg3,
        @WebParam(name = "arg4", partName = "arg4")
        String arg4);

    /**
     * 
     * @param arg0
     * @return
     *     returns webservices.ArrayList
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://webservices/publicador/listarRegistrosRequest", output = "http://webservices/publicador/listarRegistrosResponse")
    public ArrayList listarRegistros(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg1
     * @param arg0
     */
    @WebMethod
    @Action(input = "http://webservices/publicador/marcarFavoritoRequest", output = "http://webservices/publicador/marcarFavoritoResponse")
    public void marcarFavorito(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1);

    /**
     * 
     * @param arg1
     * @param arg0
     */
    @WebMethod
    @Action(input = "http://webservices/publicador/desmarcarFavoritoRequest", output = "http://webservices/publicador/desmarcarFavoritoResponse")
    public void desmarcarFavorito(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1);

    /**
     * 
     * @param arg0
     * @return
     *     returns webservices.ArrayList
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://webservices/publicador/listarEspectaculosParaPuntuarRequest", output = "http://webservices/publicador/listarEspectaculosParaPuntuarResponse")
    public ArrayList listarEspectaculosParaPuntuar(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg2
     * @param arg1
     * @param arg0
     */
    @WebMethod
    @Action(input = "http://webservices/publicador/valorarEspectaculoRequest", output = "http://webservices/publicador/valorarEspectaculoResponse")
    public void valorarEspectaculo(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1,
        @WebParam(name = "arg2", partName = "arg2")
        int arg2);

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://webservices/publicador/getPuntajeEspectaculoRequest", output = "http://webservices/publicador/getPuntajeEspectaculoResponse")
    public int getPuntajeEspectaculo(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1);

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @Action(input = "http://webservices/publicador/altaCategoriaRequest", output = "http://webservices/publicador/altaCategoriaResponse")
    public void altaCategoria(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns webservices.DtCategoria
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://webservices/publicador/getDtCategoriaRequest", output = "http://webservices/publicador/getDtCategoriaResponse")
    public DtCategoria getDtCategoria(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns webservices.Categoria
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://webservices/publicador/getCategoriaRequest", output = "http://webservices/publicador/getCategoriaResponse")
    public Categoria getCategoria(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns webservices.ArrayList
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://webservices/publicador/listarEspectaculosAceptadosDeCategoriaRequest", output = "http://webservices/publicador/listarEspectaculosAceptadosDeCategoriaResponse")
    public ArrayList listarEspectaculosAceptadosDeCategoria(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @return
     *     returns webservices.ArrayCategorias
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://webservices/publicador/listarCategoriasRequest", output = "http://webservices/publicador/listarCategoriasResponse")
    public ArrayCategorias listarCategorias();

    /**
     * 
     * @return
     *     returns webservices.ArrayList
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://webservices/publicador/listarPaquetesRequest", output = "http://webservices/publicador/listarPaquetesResponse")
    public ArrayList listarPaquetes();

    /**
     * 
     * @param arg2
     * @param arg1
     * @param arg0
     */
    @WebMethod
    @Action(input = "http://webservices/publicador/confirmarAgregarEspectaculoPaqueteRequest", output = "http://webservices/publicador/confirmarAgregarEspectaculoPaqueteResponse")
    public void confirmarAgregarEspectaculoPaquete(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1,
        @WebParam(name = "arg2", partName = "arg2")
        String arg2);

    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg5
     * @param arg4
     * @param arg1
     * @param arg0
     * @param arg6
     */
    @WebMethod
    @Action(input = "http://webservices/publicador/confirmarAltaPaqueteRequest", output = "http://webservices/publicador/confirmarAltaPaqueteResponse")
    public void confirmarAltaPaquete(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1,
        @WebParam(name = "arg2", partName = "arg2")
        XMLGregorianCalendar arg2,
        @WebParam(name = "arg3", partName = "arg3")
        XMLGregorianCalendar arg3,
        @WebParam(name = "arg4", partName = "arg4")
        double arg4,
        @WebParam(name = "arg5", partName = "arg5")
        XMLGregorianCalendar arg5,
        @WebParam(name = "arg6", partName = "arg6")
        String arg6);

    /**
     * 
     * @param arg0
     * @return
     *     returns webservices.DtPaqueteDatos
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://webservices/publicador/getPaqueteDatosRequest", output = "http://webservices/publicador/getPaqueteDatosResponse")
    public DtPaqueteDatos getPaqueteDatos(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns webservices.Paquete
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://webservices/publicador/getPaqueteRequest", output = "http://webservices/publicador/getPaqueteResponse")
    public Paquete getPaquete(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns webservices.SetPaquetes
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://webservices/publicador/filtrarPaquetesRequest", output = "http://webservices/publicador/filtrarPaquetesResponse")
    public SetPaquetes filtrarPaquetes(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns webservices.SetEspectaculos
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://webservices/publicador/filtrarEspectaculosRequest", output = "http://webservices/publicador/filtrarEspectaculosResponse")
    public SetEspectaculos filtrarEspectaculos(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns webservices.SetUsuarios
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://webservices/publicador/filtrarUsuariosRequest", output = "http://webservices/publicador/filtrarUsuariosResponse")
    public SetUsuarios filtrarUsuarios(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @return
     *     returns webservices.EstadoSesion
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://webservices/publicador/paraQueAndeEstadoSesionRequest", output = "http://webservices/publicador/paraQueAndeEstadoSesionResponse")
    public EstadoSesion paraQueAndeEstadoSesion();

}
