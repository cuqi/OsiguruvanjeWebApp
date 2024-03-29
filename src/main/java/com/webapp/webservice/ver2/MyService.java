package com.webapp.webservice.ver2;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.datatype.XMLGregorianCalendar;
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
     * @param travelInfo
     * @param sessionID
     * @return
     *     returns ver2.QuotationResponse
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getTravelQuotation", targetNamespace = "http://myservice/", className = "ver2.GetTravelQuotation")
    @ResponseWrapper(localName = "getTravelQuotationResponse", targetNamespace = "http://myservice/", className = "ver2.GetTravelQuotationResponse")
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
     *     returns ver2.QuotationResponse
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getAOQuotation", targetNamespace = "http://myservice/", className = "ver2.GetAOQuotation")
    @ResponseWrapper(localName = "getAOQuotationResponse", targetNamespace = "http://myservice/", className = "ver2.GetAOQuotationResponse")
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
     * @param cascoInfo
     * @param sessionID
     * @return
     *     returns ver2.QuotationResponse
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getCascoQuotation", targetNamespace = "http://myservice/", className = "ver2.GetCascoQuotation")
    @ResponseWrapper(localName = "getCascoQuotationResponse", targetNamespace = "http://myservice/", className = "ver2.GetCascoQuotationResponse")
    @Action(input = "http://myservice/MyService/getCascoQuotationRequest", output = "http://myservice/MyService/getCascoQuotationResponse")
    public QuotationResponse getCascoQuotation(
        @WebParam(name = "CascoInfo", targetNamespace = "")
        CascoInfo cascoInfo,
        @WebParam(name = "sessionID", targetNamespace = "")
        String sessionID);

    /**
     * 
     * @param accidentInfo
     * @param sessionID
     * @return
     *     returns ver2.QuotationResponse
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getAccidentQuotation", targetNamespace = "http://myservice/", className = "ver2.GetAccidentQuotation")
    @ResponseWrapper(localName = "getAccidentQuotationResponse", targetNamespace = "http://myservice/", className = "ver2.GetAccidentQuotationResponse")
    @Action(input = "http://myservice/MyService/getAccidentQuotationRequest", output = "http://myservice/MyService/getAccidentQuotationResponse")
    public QuotationResponse getAccidentQuotation(
        @WebParam(name = "AccidentInfo", targetNamespace = "")
        AccidentInfo accidentInfo,
        @WebParam(name = "sessionID", targetNamespace = "")
        String sessionID);

    /**
     * 
     * @param accidentInfo
     * @param insured
     * @param sessionID
     * @return
     *     returns ver2.BookResponse
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "bookAccidentPolicy", targetNamespace = "http://myservice/", className = "ver2.BookAccidentPolicy")
    @ResponseWrapper(localName = "bookAccidentPolicyResponse", targetNamespace = "http://myservice/", className = "ver2.BookAccidentPolicyResponse")
    @Action(input = "http://myservice/MyService/bookAccidentPolicyRequest", output = "http://myservice/MyService/bookAccidentPolicyResponse")
    public BookResponse bookAccidentPolicy(
        @WebParam(name = "AccidentInfo", targetNamespace = "")
        AccidentInfo accidentInfo,
        @WebParam(name = "Insured", targetNamespace = "")
        InsuredInfo insured,
        @WebParam(name = "sessionID", targetNamespace = "")
        String sessionID);

    /**
     * 
     * @param sessionID
     * @param householdInfo
     * @return
     *     returns ver2.QuotationResponse
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getHouseholdQuotation", targetNamespace = "http://myservice/", className = "ver2.GetHouseholdQuotation")
    @ResponseWrapper(localName = "getHouseholdQuotationResponse", targetNamespace = "http://myservice/", className = "ver2.GetHouseholdQuotationResponse")
    @Action(input = "http://myservice/MyService/getHouseholdQuotationRequest", output = "http://myservice/MyService/getHouseholdQuotationResponse")
    public QuotationResponse getHouseholdQuotation(
        @WebParam(name = "HouseholdInfo", targetNamespace = "")
        HouseholdInfo householdInfo,
        @WebParam(name = "sessionID", targetNamespace = "")
        String sessionID);

    /**
     * 
     * @param insured
     * @param sessionID
     * @param householdInfo
     * @param startDate
     * @return
     *     returns ver2.BookResponse
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "bookHouseholdPolicy", targetNamespace = "http://myservice/", className = "ver2.BookHouseholdPolicy")
    @ResponseWrapper(localName = "bookHouseholdPolicyResponse", targetNamespace = "http://myservice/", className = "ver2.BookHouseholdPolicyResponse")
    @Action(input = "http://myservice/MyService/bookHouseholdPolicyRequest", output = "http://myservice/MyService/bookHouseholdPolicyResponse")
    public BookResponse bookHouseholdPolicy(
        @WebParam(name = "HouseholdInfo", targetNamespace = "")
        HouseholdInfo householdInfo,
        @WebParam(name = "Insured", targetNamespace = "")
        InsuredInfo insured,
        @WebParam(name = "startDate", targetNamespace = "")
        XMLGregorianCalendar startDate,
        @WebParam(name = "sessionID", targetNamespace = "")
        String sessionID);

    /**
     * 
     * @param owner
     * @param insured
     * @param bookTravelInfo
     * @param sessionID
     * @param startDate
     * @return
     *     returns ver2.BookResponse
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "bookTravelPolicy", targetNamespace = "http://myservice/", className = "ver2.BookTravelPolicy")
    @ResponseWrapper(localName = "bookTravelPolicyResponse", targetNamespace = "http://myservice/", className = "ver2.BookTravelPolicyResponse")
    @Action(input = "http://myservice/MyService/bookTravelPolicyRequest", output = "http://myservice/MyService/bookTravelPolicyResponse")
    public BookResponse bookTravelPolicy(
        @WebParam(name = "BookTravelInfo", targetNamespace = "")
        TravelInfo bookTravelInfo,
        @WebParam(name = "Owner", targetNamespace = "")
        InsuredInfo owner,
        @WebParam(name = "Insured", targetNamespace = "")
        InsuredInfo insured,
        @WebParam(name = "sessionID", targetNamespace = "")
        String sessionID,
        @WebParam(name = "startDate", targetNamespace = "")
        XMLGregorianCalendar startDate);

    /**
     * 
     * @param insured
     * @param cascoInfo
     * @param sessionID
     * @param startDate
     * @return
     *     returns ver2.BookResponse
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "bookCascoPolicy", targetNamespace = "http://myservice/", className = "ver2.BookCascoPolicy")
    @ResponseWrapper(localName = "bookCascoPolicyResponse", targetNamespace = "http://myservice/", className = "ver2.BookCascoPolicyResponse")
    @Action(input = "http://myservice/MyService/bookCascoPolicyRequest", output = "http://myservice/MyService/bookCascoPolicyResponse")
    public BookResponse bookCascoPolicy(
        @WebParam(name = "CascoInfo", targetNamespace = "")
        CascoInfo cascoInfo,
        @WebParam(name = "Insured", targetNamespace = "")
        InsuredInfo insured,
        @WebParam(name = "startDate", targetNamespace = "")
        XMLGregorianCalendar startDate,
        @WebParam(name = "sessionID", targetNamespace = "")
        String sessionID);

    /**
     * 
     * @param insured
     * @param aoInfo
     * @param sessionID
     * @param startDate
     * @return
     *     returns ver2.BookResponse
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "bookAOPolicy", targetNamespace = "http://myservice/", className = "ver2.BookAOPolicy")
    @ResponseWrapper(localName = "bookAOPolicyResponse", targetNamespace = "http://myservice/", className = "ver2.BookAOPolicyResponse")
    @Action(input = "http://myservice/MyService/bookAOPolicyRequest", output = "http://myservice/MyService/bookAOPolicyResponse")
    public BookResponse bookAOPolicy(
        @WebParam(name = "AOInfo", targetNamespace = "")
        AoInfo aoInfo,
        @WebParam(name = "Insured", targetNamespace = "")
        InsuredInfo insured,
        @WebParam(name = "startDate", targetNamespace = "")
        XMLGregorianCalendar startDate,
        @WebParam(name = "sessionID", targetNamespace = "")
        String sessionID);

}
