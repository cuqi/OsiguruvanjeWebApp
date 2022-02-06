
package com.webapp.webservice.ver3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for accidentInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="accidentInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="startDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="isStudent" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="pack" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "accidentInfo", propOrder = {
    "startDate",
    "isStudent",
    "pack"
})
public class AccidentInfo {

    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar startDate;
    protected boolean isStudent;
    protected int pack;

    /**
     * Gets the value of the startDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getStartDate() {
        return startDate;
    }

    /**
     * Sets the value of the startDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setStartDate(XMLGregorianCalendar value) {
        this.startDate = value;
    }

    /**
     * Gets the value of the isStudent property.
     * 
     */
    public boolean isIsStudent() {
        return isStudent;
    }

    /**
     * Sets the value of the isStudent property.
     * 
     */
    public void setIsStudent(boolean value) {
        this.isStudent = value;
    }

    /**
     * Gets the value of the pack property.
     * 
     */
    public int getPack() {
        return pack;
    }

    /**
     * Sets the value of the pack property.
     * 
     */
    public void setPack(int value) {
        this.pack = value;
    }

}
