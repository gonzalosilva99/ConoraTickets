
package webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para dtCategoria complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="dtCategoria"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="nomCategoria" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dtCategoria", propOrder = {
    "nomCategoria"
})
public class DtCategoria {

    protected String nomCategoria;

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

}
