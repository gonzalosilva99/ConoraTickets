
package webservices;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para artista complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="artista">
 *   &lt;complexContent>
 *     &lt;extension base="{http://webservices/}usuario">
 *       &lt;sequence>
 *         &lt;element name="biografia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descripcionGeneral" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="espectaculos" type="{http://webservices/}espectaculo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="funcionesInvitado" type="{http://webservices/}funcion" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="URL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "artista", propOrder = {
    "biografia",
    "descripcionGeneral",
    "espectaculos",
    "funcionesInvitado",
    "url"
})
public class Artista
    extends Usuario
{

    protected String biografia;
    protected String descripcionGeneral;
    @XmlElement(nillable = true)
    protected List<Espectaculo> espectaculos;
    @XmlElement(nillable = true)
    protected List<Funcion> funcionesInvitado;
    @XmlElement(name = "URL")
    protected String url;

    /**
     * Obtiene el valor de la propiedad biografia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBiografia() {
        return biografia;
    }

    /**
     * Define el valor de la propiedad biografia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBiografia(String value) {
        this.biografia = value;
    }

    /**
     * Obtiene el valor de la propiedad descripcionGeneral.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcionGeneral() {
        return descripcionGeneral;
    }

    /**
     * Define el valor de la propiedad descripcionGeneral.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcionGeneral(String value) {
        this.descripcionGeneral = value;
    }

    /**
     * Gets the value of the espectaculos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the espectaculos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEspectaculos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Espectaculo }
     * 
     * 
     */
    public List<Espectaculo> getEspectaculos() {
        if (espectaculos == null) {
            espectaculos = new ArrayList<Espectaculo>();
        }
        return this.espectaculos;
    }

    /**
     * Gets the value of the funcionesInvitado property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the funcionesInvitado property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFuncionesInvitado().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Funcion }
     * 
     * 
     */
    public List<Funcion> getFuncionesInvitado() {
        if (funcionesInvitado == null) {
            funcionesInvitado = new ArrayList<Funcion>();
        }
        return this.funcionesInvitado;
    }

    /**
     * Obtiene el valor de la propiedad url.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getURL() {
        return url;
    }

    /**
     * Define el valor de la propiedad url.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setURL(String value) {
        this.url = value;
    }

}
