package com.webapp.webservice.ver1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for travelInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="travelInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="type" type="{http://myservice/}typeTravelPolicy" minOccurs="0"/>
 *         &lt;element name="cover" type="{http://myservice/}typeCover" minOccurs="0"/>
 *         &lt;element name="days" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="country" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numPeople" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="isbelow18" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="isabove65" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "travelInfo", propOrder = {
    "type",
    "cover",
    "days",
    "country",
    "numPeople",
    "isbelow18",
    "isabove65"
})
public class TravelInfo {

    @XmlSchemaType(name = "string")
    protected TypeTravelPolicy type;
    @XmlSchemaType(name = "string")
    protected TypeCover cover;
    protected int days;
    protected String country;
    protected int numPeople;
    protected boolean isbelow18;
    protected boolean isabove65;

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link TypeTravelPolicy }
     *     
     */
    public TypeTravelPolicy getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link TypeTravelPolicy }
     *     
     */
    public void setType(TypeTravelPolicy value) {
        this.type = value;
    }

    /**
     * Gets the value of the cover property.
     * 
     * @return
     *     possible object is
     *     {@link TypeCover }
     *     
     */
    public TypeCover getCover() {
        return cover;
    }

    /**
     * Sets the value of the cover property.
     * 
     * @param value
     *     allowed object is
     *     {@link TypeCover }
     *     
     */
    public void setCover(TypeCover value) {
        this.cover = value;
    }

    /**
     * Gets the value of the days property.
     * 
     */
    public int getDays() {
        return days;
    }

    /**
     * Sets the value of the days property.
     * 
     */
    public void setDays(int value) {
        this.days = value;
    }

    /**
     * Gets the value of the country property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the value of the country property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountry(String value) {
        this.country = value;
    }

    /**
     * Gets the value of the numPeople property.
     * 
     */
    public int getNumPeople() {
        return numPeople;
    }

    /**
     * Sets the value of the numPeople property.
     * 
     */
    public void setNumPeople(int value) {
        this.numPeople = value;
    }

    /**
     * Gets the value of the isbelow18 property.
     * 
     */
    public boolean isIsbelow18() {
        return isbelow18;
    }

    /**
     * Sets the value of the isbelow18 property.
     * 
     */
    public void setIsbelow18(boolean value) {
        this.isbelow18 = value;
    }

    /**
     * Gets the value of the isabove65 property.
     * 
     */
    public boolean isIsabove65() {
        return isabove65;
    }

    /**
     * Sets the value of the isabove65 property.
     * 
     */
    public void setIsabove65(boolean value) {
        this.isabove65 = value;
    }

}
