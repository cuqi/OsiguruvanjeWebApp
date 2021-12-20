package com.webapp.webservice.ver2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for typeObject.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="typeObject">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="RESIDENCE"/>
 *     &lt;enumeration value="BUSINESS"/>
 *     &lt;enumeration value="PORTABLE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "typeObject")
@XmlEnum
public enum TypeObject {

    RESIDENCE,
    BUSINESS,
    PORTABLE;

    public String value() {
        return name();
    }

    public static TypeObject fromValue(String v) {
        return valueOf(v);
    }

}
