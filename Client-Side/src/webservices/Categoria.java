
package webservices;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para categoria complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="categoria">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="espectaculos" type="{http://webservices/}espectaculo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="nomCategoria" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nomcategoria" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "categoria", propOrder = {
    "espectaculos",
    "nomCategoria",
    "nomcategoria"
})
public class Categoria {

    @XmlElement(nillable = true)
    protected List<Espectaculo> espectaculos;
    protected String nomCategoria;
    protected String nomcategoria;

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
     * Obtiene el valor de la propiedad nomCategoria.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomCategoria() {
        return nomCategoria;
    }

    /**
     * Define el valor de la propiedad nomCategoria.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomCategoria(String value) {
        this.nomCategoria = value;
    }

    /**
     * Obtiene el valor de la propiedad nomcategoria.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomcategoria() {
        return nomcategoria;
    }

    /**
     * Define el valor de la propiedad nomcategoria.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomcategoria(String value) {
        this.nomcategoria = value;
    }

}
