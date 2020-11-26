
package webservices;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para espectador complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="espectador"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://webservices/}usuario"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="espectaculosFavoritos"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="entry" maxOccurs="unbounded" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="key" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                             &lt;element name="value" type="{http://webservices/}espectaculo" minOccurs="0"/&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="puntajesAsignados" type="{http://webservices/}puntajeAsignado" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "espectador", propOrder = {
    "espectaculosFavoritos",
    "puntajesAsignados"
})
public class Espectador
    extends Usuario
{

    @XmlElement(required = true)
    protected Espectador.EspectaculosFavoritos espectaculosFavoritos;
    @XmlElement(nillable = true)
    protected List<PuntajeAsignado> puntajesAsignados;

    /**
     * Obtiene el valor de la propiedad espectaculosFavoritos.
     * 
     * @return
     *     possible object is
     *     {@link Espectador.EspectaculosFavoritos }
     *     
     */
    public Espectador.EspectaculosFavoritos getEspectaculosFavoritos() {
        return espectaculosFavoritos;
    }

    /**
     * Define el valor de la propiedad espectaculosFavoritos.
     * 
     * @param value
     *     allowed object is
     *     {@link Espectador.EspectaculosFavoritos }
     *     
     */
    public void setEspectaculosFavoritos(Espectador.EspectaculosFavoritos value) {
        this.espectaculosFavoritos = value;
    }

    /**
     * Gets the value of the puntajesAsignados property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the puntajesAsignados property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPuntajesAsignados().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PuntajeAsignado }
     * 
     * 
     */
    public List<PuntajeAsignado> getPuntajesAsignados() {
        if (puntajesAsignados == null) {
            puntajesAsignados = new ArrayList<PuntajeAsignado>();
        }
        return this.puntajesAsignados;
    }


    /**
     * <p>Clase Java para anonymous complex type.
     * 
     * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="entry" maxOccurs="unbounded" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="key" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
     *                   &lt;element name="value" type="{http://webservices/}espectaculo" minOccurs="0"/&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "entry"
    })
    public static class EspectaculosFavoritos {

        protected List<Espectador.EspectaculosFavoritos.Entry> entry;

        /**
         * Gets the value of the entry property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the entry property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getEntry().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Espectador.EspectaculosFavoritos.Entry }
         * 
         * 
         */
        public List<Espectador.EspectaculosFavoritos.Entry> getEntry() {
            if (entry == null) {
                entry = new ArrayList<Espectador.EspectaculosFavoritos.Entry>();
            }
            return this.entry;
        }


        /**
         * <p>Clase Java para anonymous complex type.
         * 
         * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *       &lt;sequence&gt;
         *         &lt;element name="key" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
         *         &lt;element name="value" type="{http://webservices/}espectaculo" minOccurs="0"/&gt;
         *       &lt;/sequence&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "key",
            "value"
        })
        public static class Entry {

            protected String key;
            protected Espectaculo value;

            /**
             * Obtiene el valor de la propiedad key.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getKey() {
                return key;
            }

            /**
             * Define el valor de la propiedad key.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setKey(String value) {
                this.key = value;
            }

            /**
             * Obtiene el valor de la propiedad value.
             * 
             * @return
             *     possible object is
             *     {@link Espectaculo }
             *     
             */
            public Espectaculo getValue() {
                return value;
            }

            /**
             * Define el valor de la propiedad value.
             * 
             * @param value
             *     allowed object is
             *     {@link Espectaculo }
             *     
             */
            public void setValue(Espectaculo value) {
                this.value = value;
            }

        }

    }

}
