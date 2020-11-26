
package webservices;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para estadoEspectaculo.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="estadoEspectaculo">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Aceptado"/>
 *     &lt;enumeration value="Ingresado"/>
 *     &lt;enumeration value="Rechazado"/>
 *     &lt;enumeration value="Finalizado"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "estadoEspectaculo")
@XmlEnum
public enum EstadoEspectaculo {

    @XmlEnumValue("Aceptado")
    ACEPTADO("Aceptado"),
    @XmlEnumValue("Ingresado")
    INGRESADO("Ingresado"),
    @XmlEnumValue("Rechazado")
    RECHAZADO("Rechazado"),
    @XmlEnumValue("Finalizado")
    FINALIZADO("Finalizado");
    private final String value;

    EstadoEspectaculo(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EstadoEspectaculo fromValue(String v) {
        for (EstadoEspectaculo c: EstadoEspectaculo.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
