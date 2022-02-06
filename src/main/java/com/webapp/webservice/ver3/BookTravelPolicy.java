package com.webapp.webservice.ver3;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for bookTravelPolicy complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="bookTravelPolicy">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BookTravelInfo" type="{http://myservice/}travelInfo" minOccurs="0"/>
 *         &lt;element name="Owner" type="{http://myservice/}insuredInfo" minOccurs="0"/>
 *         &lt;element name="Insured" type="{http://myservice/}insuredInfo" minOccurs="0"/>
 *         &lt;element name="sessionID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="startDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bookTravelPolicy", propOrder = {
    "bookTravelInfo",
    "owner",
    "insured",
    "sessionID",
    "startDate"
})
public class BookTravelPolicy {

    @XmlElement(name = "BookTravelInfo")
    protected TravelInfo bookTravelInfo;
    @XmlElement(name = "Owner")
    protected InsuredInfo owner;
    @XmlElement(name = "Insured")
    protected InsuredInfo insured;
    protected String sessionID;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar startDate;

    /**
     * Gets the value of the bookTravelInfo property.
     * 
     * @return
     *     possible object is
     *     {@link TravelInfo }
     *     
     */
    public TravelInfo getBookTravelInfo() {
        return bookTravelInfo;
    }

    /**
     * Sets the value of the bookTravelInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link TravelInfo }
     *     
     */
    public void setBookTravelInfo(TravelInfo value) {
        this.bookTravelInfo = value;
    }

    /**
     * Gets the value of the owner property.
     * 
     * @return
     *     possible object is
     *     {@link InsuredInfo }
     *     
     */
    public InsuredInfo getOwner() {
        return owner;
    }

    /**
     * Sets the value of the owner property.
     * 
     * @param value
     *     allowed object is
     *     {@link InsuredInfo }
     *     
     */
    public void setOwner(InsuredInfo value) {
        this.owner = value;
    }

    /**
     * Gets the value of the insured property.
     * 
     * @return
     *     possible object is
     *     {@link InsuredInfo }
     *     
     */
    public InsuredInfo getInsured() {
        return insured;
    }

    /**
     * Sets the value of the insured property.
     * 
     * @param value
     *     allowed object is
     *     {@link InsuredInfo }
     *     
     */
    public void setInsured(InsuredInfo value) {
        this.insured = value;
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

}
