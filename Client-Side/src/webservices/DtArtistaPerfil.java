
package webservices;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para dtArtistaPerfil complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="dtArtistaPerfil">
 *   &lt;complexContent>
 *     &lt;extension base="{http://webservices/}dtArtistaConsulta">
 *       &lt;sequence>
 *         &lt;element name="espectaculosNOaceptados" type="{http://webservices/}dtEspectaculo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="funcionesinvitado" type="{http://webservices/}dtFuncion" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ultimoIngreso" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dtArtistaPerfil", propOrder = {
    "espectaculosNOaceptados",
    "funcionesinvitado",
    "ultimoIngreso"
})
public class DtArtistaPerfil
    extends DtArtistaConsulta
{

    @XmlElement(nillable = true)
    protected List<DtEspectaculo> espectaculosNOaceptados;
    @XmlElement(nillable = true)
    protected List<DtFuncion> funcionesinvitado;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar ultimoIngreso;

    /**
     * Gets the value of the espectaculosNOaceptados property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the espectaculosNOaceptados property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEspectaculosNOaceptados().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DtEspectaculo }
     * 
     * 
     */
    public List<DtEspectaculo> getEspectaculosNOaceptados() {
        if (espectaculosNOaceptados == null) {
            espectaculosNOaceptados = new ArrayList<DtEspectaculo>();
        }
        return this.espectaculosNOaceptados;
    }

    /**
     * Gets the value of the funcionesinvitado property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the funcionesinvitado property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFuncionesinvitado().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DtFuncion }
     * 
     * 
     */
    public List<DtFuncion> getFuncionesinvitado() {
        if (funcionesinvitado == null) {
            funcionesinvitado = new ArrayList<DtFuncion>();
        }
        return this.funcionesinvitado;
    }

    /**
     * Obtiene el valor de la propiedad ultimoIngreso.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getUltimoIngreso() {
        return ultimoIngreso;
    }

    /**
     * Define el valor de la propiedad ultimoIngreso.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setUltimoIngreso(XMLGregorianCalendar value) {
        this.ultimoIngreso = value;
    }

}
