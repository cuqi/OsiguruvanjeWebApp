package com.webapp.webservice.ver1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getAccidentQuotation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getAccidentQuotation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AccidentInfo" type="{http://myservice/}accidentInfo" minOccurs="0"/>
 *         &lt;element name="sessionID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getAccidentQuotation1", propOrder = {
    "accidentInfo",
    "sessionID"
})
public class GetAccidentQuotation {

    @XmlElement(name = "AccidentInfo")
    protected AccidentInfo accidentInfo;
    protected String sessionID;

    /**
     * Gets the value of the accidentInfo property.
     * 
     * @return
     *     possible object is
     *     {@link AccidentInfo }
     *     
     */
    public AccidentInfo getAccidentInfo() {
        return accidentInfo;
    }

    /**
     * Sets the value of the accidentInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link AccidentInfo }
     *     
     */
    public void setAccidentInfo(AccidentInfo value) {
        this.accidentInfo = value;
    }

    /**
     * Gets the value of the sessionID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSessionID() {
        return sessionID;
    }

    /**
     * Sets the value of the sessionID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSessionID(String value) {
        this.sessionID = value;
    }

}
