package com.webapp.insurance.client;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for typeCover.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="typeCover">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CLASSIC"/>
 *     &lt;enumeration value="VISA"/>
 *     &lt;enumeration value="VIP"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "typeCover1")
@XmlEnum
public enum TypeCover {

    CLASSIC,
    VISA,
    VIP;

    public String value() {
        return name();
    }

    public static TypeCover fromValue(String v) {
        return valueOf(v);
    }

}
