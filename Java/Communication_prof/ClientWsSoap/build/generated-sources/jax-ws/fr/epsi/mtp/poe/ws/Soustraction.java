
package fr.epsi.mtp.poe.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour soustraction complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="soustraction">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="a" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="b" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "soustraction", propOrder = {
    "a",
    "b"
})
public class Soustraction {

    protected double a;
    protected double b;

    /**
     * Obtient la valeur de la propri�t� a.
     * 
     */
    public double getA() {
        return a;
    }

    /**
     * D�finit la valeur de la propri�t� a.
     * 
     */
    public void setA(double value) {
        this.a = value;
    }

    /**
     * Obtient la valeur de la propri�t� b.
     * 
     */
    public double getB() {
        return b;
    }

    /**
     * D�finit la valeur de la propri�t� b.
     * 
     */
    public void setB(double value) {
        this.b = value;
    }

}
