
package webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para dtRegistroFuncion complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="dtRegistroFuncion"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="espectador" type="{http://webservices/}dtEspectador" minOccurs="0"/&gt;
 *         &lt;element name="fecha" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="funcion" type="{http://webservices/}dtFuncion" minOccurs="0"/&gt;
 *         &lt;element name="ganoPremio" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dtRegistroFuncion", propOrder = {
    "espectador",
    "fecha",
    "funcion",
    "ganoPremio"
})
public class DtRegistroFuncion {

    protected DtEspectador espectador;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fecha;
    protected DtFuncion funcion;
    protected Boolean ganoPremio;

    /**
     * Obtiene el valor de la propiedad espectador.
     * 
     * @return
     *     possible object is
     *     {@link DtEspectador }
     *     
     */
    public DtEspectador getEspectador() {
        return espectador;
    }

    /**
     * Define el valor de la propiedad espectador.
     * 
     * @param value
     *     allowed object is
     *     {@link DtEspectador }
     *     
     */
    public void setEspectador(DtEspectador value) {
        this.espectador = value;
    }

    /**
     * Obtiene el valor de la propiedad fecha.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFecha() {
        return fecha;
    }

    /**
     * Define el valor de la propiedad fecha.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFecha(XMLGregorianCalendar value) {
        this.fecha = value;
    }

    /**
     * Obtiene el valor de la propiedad funcion.
     * 
     * @return
     *     possible object is
     *     {@link DtFuncion }
     *     
     */
    public DtFuncion getFuncion() {
        return funcion;
    }

    /**
     * Define el valor de la propiedad funcion.
     * 
     * @param value
     *     allowed object is
     *     {@link DtFuncion }
     *     
     */
    public void setFuncion(DtFuncion value) {
        this.funcion = value;
    }

    /**
     * Obtiene el valor de la propiedad ganoPremio.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isGanoPremio() {
        return ganoPremio;
    }

    /**
     * Define el valor de la propiedad ganoPremio.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setGanoPremio(Boolean value) {
        this.ganoPremio = value;
    }

}
