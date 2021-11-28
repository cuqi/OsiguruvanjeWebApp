
package com.webapp.webservice.converterClient;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "SOAPService", targetNamespace = "http://webservice.webapp.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface SOAPService {


    /**
     * 
     * @param eur
     * @return
     *     returns double
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "converter", targetNamespace = "http://webservice.webapp.com/", className = "converterClient.Converter")
    @ResponseWrapper(localName = "converterResponse", targetNamespace = "http://webservice.webapp.com/", className = "converterClient.ConverterResponse")
    @Action(input = "http://webservice.webapp.com/SOAPService/converterRequest", output = "http://webservice.webapp.com/SOAPService/converterResponse")
    public double converter(
        @WebParam(name = "EUR", targetNamespace = "")
        String eur);

}
