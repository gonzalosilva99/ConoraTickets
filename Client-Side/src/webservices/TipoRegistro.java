
package webservices;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para tipoRegistro.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="tipoRegistro">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Tipo_1"/>
 *     &lt;enumeration value="Tipo_2"/>
 *     &lt;enumeration value="Tipo_3"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tipoRegistro")
@XmlEnum
public enum TipoRegistro {

    @XmlEnumValue("Tipo_1")
    TIPO_1("Tipo_1"),
    @XmlEnumValue("Tipo_2")
    TIPO_2("Tipo_2"),
    @XmlEnumValue("Tipo_3")
    TIPO_3("Tipo_3");
    private final String value;

    TipoRegistro(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TipoRegistro fromValue(String v) {
        for (TipoRegistro c: TipoRegistro.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
