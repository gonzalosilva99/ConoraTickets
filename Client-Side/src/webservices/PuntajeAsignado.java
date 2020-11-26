
package webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para puntajeAsignado complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="puntajeAsignado"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="espectaculo" type="{http://webservices/}espectaculo" minOccurs="0"/&gt;
 *         &lt;element name="espectador" type="{http://webservices/}espectador" minOccurs="0"/&gt;
 *         &lt;element name="puntaje" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "puntajeAsignado", propOrder = {
    "espectaculo",
    "espectador",
    "puntaje"
})
public class PuntajeAsignado {

    protected Espectaculo espectaculo;
    protected Espectador espectador;
    protected int puntaje;

    /**
     * Obtiene el valor de la propiedad espectaculo.
     * 
     * @return
     *     possible object is
     *     {@link Espectaculo }
     *     
     */
    public Espectaculo getEspectaculo() {
        return espectaculo;
    }

    /**
     * Define el valor de la propiedad espectaculo.
     * 
     * @param value
     *     allowed object is
     *     {@link Espectaculo }
     *     
     */
    public void setEspectaculo(Espectaculo value) {
        this.espectaculo = value;
    }

    /**
     * Obtiene el valor de la propiedad espectador.
     * 
     * @return
     *     possible object is
     *     {@link Espectador }
     *     
     */
    public Espectador getEspectador() {
        return espectador;
    }

    /**
     * Define el valor de la propiedad espectador.
     * 
     * @param value
     *     allowed object is
     *     {@link Espectador }
     *     
     */
    public void setEspectador(Espectador value) {
        this.espectador = value;
    }

    /**
     * Obtiene el valor de la propiedad puntaje.
     * 
     */
    public int getPuntaje() {
        return puntaje;
    }

    /**
     * Define el valor de la propiedad puntaje.
     * 
     */
    public void setPuntaje(int value) {
        this.puntaje = value;
    }

}
