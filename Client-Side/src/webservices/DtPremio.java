
package webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para dtPremio complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="dtPremio">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="descripcion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fechaSorteo" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="nombreEspectaculo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nombreFuncion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dtPremio", propOrder = {
    "descripcion",
    "fechaSorteo",
    "nombreEspectaculo",
    "nombreFuncion"
})
public class DtPremio {

    protected String descripcion;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaSorteo;
    protected String nombreEspectaculo;
    protected String nombreFuncion;

    /**
     * Obtiene el valor de la propiedad descripcion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Define el valor de la propiedad descripcion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcion(String value) {
        this.descripcion = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaSorteo.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaSorteo() {
        return fechaSorteo;
    }

    /**
     * Define el valor de la propiedad fechaSorteo.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaSorteo(XMLGregorianCalendar value) {
        this.fechaSorteo = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreEspectaculo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreEspectaculo() {
        return nombreEspectaculo;
    }

    /**
     * Define el valor de la propiedad nombreEspectaculo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreEspectaculo(String value) {
        this.nombreEspectaculo = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreFuncion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreFuncion() {
        return nombreFuncion;
    }

    /**
     * Define el valor de la propiedad nombreFuncion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreFuncion(String value) {
        this.nombreFuncion = value;
    }

}
