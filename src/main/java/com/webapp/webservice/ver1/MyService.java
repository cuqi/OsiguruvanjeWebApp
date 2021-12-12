package com.webapp.webservice.ver1;

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
@WebService(name = "MyService", targetNamespace = "http://myservice/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface MyService {


    /**
     * 
     * @param sessionID
     * @param householdInfo
     * @return
     *     returns ver1.QuotationResponse
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getHouseholdQuotation", targetNamespace = "http://myservice/", className = "ver1.GetHouseholdQuotation")
    @ResponseWrapper(localName = "getHouseholdQuotationResponse", targetNamespace = "http://myservice/", className = "ver1.GetHouseholdQuotationResponse")
    @Action(input = "http://myservice/MyService/getHouseholdQuotationRequest", output = "http://myservice/MyService/getHouseholdQuotationResponse")
    public QuotationResponse getHouseholdQuotation(
        @WebParam(name = "HouseholdInfo", targetNamespace = "")
        HouseholdInfo householdInfo,
        @WebParam(name = "sessionID", targetNamespace = "")
        String sessionID);

    /**
     * 
     * @param travelInfo
     * @param sessionID
     * @return
     *     returns ver1.QuotationResponse
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getTravelQuotation", targetNamespace = "http://myservice/", className = "ver1.GetTravelQuotation")
    @ResponseWrapper(localName = "getTravelQuotationResponse", targetNamespace = "http://myservice/", className = "ver1.GetTravelQuotationResponse")
    @Action(input = "http://myservice/MyService/getTravelQuotationRequest", output = "http://myservice/MyService/getTravelQuotationResponse")
    public QuotationResponse getTravelQuotation(
        @WebParam(name = "travelInfo", targetNamespace = "")
        TravelInfo travelInfo,
        @WebParam(name = "sessionID", targetNamespace = "")
        String sessionID);

    /**
     * 
     * @param aoInfo
     * @param sessionID
     * @param ssn
     * @return
     *     returns ver1.QuotationResponse
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getAOQuotation", targetNamespace = "http://myservice/", className = "ver1.GetAOQuotation")
    @ResponseWrapper(localName = "getAOQuotationResponse", targetNamespace = "http://myservice/", className = "ver1.GetAOQuotationResponse")
    @Action(input = "http://myservice/MyService/getAOQuotationRequest", output = "http://myservice/MyService/getAOQuotationResponse")
    public QuotationResponse getAOQuotation(
        @WebParam(name = "AOInfo", targetNamespace = "")
        AoInfo aoInfo,
        @WebParam(name = "ssn", targetNamespace = "")
        String ssn,
        @WebParam(name = "sessionID", targetNamespace = "")
        String sessionID);

    /**
     * 
     * @param accidentInfo
     * @param sessionID
     * @return
     *     returns ver1.QuotationResponse
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getAccidentQuotation", targetNamespace = "http://myservice/", className = "ver1.GetAccidentQuotation")
    @ResponseWrapper(localName = "getAccidentQuotationResponse", targetNamespace = "http://myservice/", className = "ver1.GetAccidentQuotationResponse")
    @Action(input = "http://myservice/MyService/getAccidentQuotationRequest", output = "http://myservice/MyService/getAccidentQuotationResponse")
    public QuotationResponse getAccidentQuotation(
        @WebParam(name = "AccidentInfo", targetNamespace = "")
        AccidentInfo accidentInfo,
        @WebParam(name = "sessionID", targetNamespace = "")
        String sessionID);

    /**
     * 
     * @param cascoInfo
     * @param sessionID
     * @return
     *     returns ver1.QuotationResponse
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getCascoQuotation", targetNamespace = "http://myservice/", className = "ver1.GetCascoQuotation")
    @ResponseWrapper(localName = "getCascoQuotationResponse", targetNamespace = "http://myservice/", className = "ver1.GetCascoQuotationResponse")
    @Action(input = "http://myservice/MyService/getCascoQuotationRequest", output = "http://myservice/MyService/getCascoQuotationResponse")
    public QuotationResponse getCascoQuotation(
        @WebParam(name = "CascoInfo", targetNamespace = "")
        CascoInfo cascoInfo,
        @WebParam(name = "sessionID", targetNamespace = "")
        String sessionID);

}
