package com.webapp.webservice.ver1;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ver1 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetAOQuotation_QNAME = new QName("http://myservice/", "getAOQuotation");
    private final static QName _GetCascoQuotationResponse_QNAME = new QName("http://myservice/", "getCascoQuotationResponse");
    private final static QName _GetHouseholdQuotationResponse_QNAME = new QName("http://myservice/", "getHouseholdQuotationResponse");
    private final static QName _GetHouseholdQuotation_QNAME = new QName("http://myservice/", "getHouseholdQuotation");
    private final static QName _GetAccidentQuotation_QNAME = new QName("http://myservice/", "getAccidentQuotation");
    private final static QName _GetAccidentQuotationResponse_QNAME = new QName("http://myservice/", "getAccidentQuotationResponse");
    private final static QName _GetAOQuotationResponse_QNAME = new QName("http://myservice/", "getAOQuotationResponse");
    private final static QName _GetTravelQuotationResponse_QNAME = new QName("http://myservice/", "getTravelQuotationResponse");
    private final static QName _GetTravelQuotation_QNAME = new QName("http://myservice/", "getTravelQuotation");
    private final static QName _GetCascoQuotation_QNAME = new QName("http://myservice/", "getCascoQuotation");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ver1
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetHouseholdQuotation }
     * 
     */
    public GetHouseholdQuotation createGetHouseholdQuotation() {
        return new GetHouseholdQuotation();
    }

    /**
     * Create an instance of {@link GetHouseholdQuotationResponse }
     * 
     */
    public GetHouseholdQuotationResponse createGetHouseholdQuotationResponse() {
        return new GetHouseholdQuotationResponse();
    }

    /**
     * Create an instance of {@link GetAOQuotation }
     * 
     */
    public GetAOQuotation createGetAOQuotation() {
        return new GetAOQuotation();
    }

    /**
     * Create an instance of {@link GetCascoQuotationResponse }
     * 
     */
    public GetCascoQuotationResponse createGetCascoQuotationResponse() {
        return new GetCascoQuotationResponse();
    }

    /**
     * Create an instance of {@link GetAccidentQuotationResponse }
     * 
     */
    public GetAccidentQuotationResponse createGetAccidentQuotationResponse() {
        return new GetAccidentQuotationResponse();
    }

    /**
     * Create an instance of {@link GetAccidentQuotation }
     * 
     */
    public GetAccidentQuotation createGetAccidentQuotation() {
        return new GetAccidentQuotation();
    }

    /**
     * Create an instance of {@link GetTravelQuotationResponse }
     * 
     */
    public GetTravelQuotationResponse createGetTravelQuotationResponse() {
        return new GetTravelQuotationResponse();
    }

    /**
     * Create an instance of {@link GetAOQuotationResponse }
     * 
     */
    public GetAOQuotationResponse createGetAOQuotationResponse() {
        return new GetAOQuotationResponse();
    }

    /**
     * Create an instance of {@link GetCascoQuotation }
     * 
     */
    public GetCascoQuotation createGetCascoQuotation() {
        return new GetCascoQuotation();
    }

    /**
     * Create an instance of {@link GetTravelQuotation }
     * 
     */
    public GetTravelQuotation createGetTravelQuotation() {
        return new GetTravelQuotation();
    }

    /**
     * Create an instance of {@link AccidentInfo }
     * 
     */
    public AccidentInfo createAccidentInfo() {
        return new AccidentInfo();
    }

    /**
     * Create an instance of {@link QuotationResponse }
     * 
     */
    public QuotationResponse createQuotationResponse() {
        return new QuotationResponse();
    }

    /**
     * Create an instance of {@link TravelInfo }
     * 
     */
    public TravelInfo createTravelInfo() {
        return new TravelInfo();
    }

    /**
     * Create an instance of {@link CascoInfo }
     * 
     */
    public CascoInfo createCascoInfo() {
        return new CascoInfo();
    }

    /**
     * Create an instance of {@link HouseholdInfo }
     * 
     */
    public HouseholdInfo createHouseholdInfo() {
        return new HouseholdInfo();
    }

    /**
     * Create an instance of {@link AoInfo }
     * 
     */
    public AoInfo createAoInfo() {
        return new AoInfo();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAOQuotation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://myservice/", name = "getAOQuotation")
    public JAXBElement<GetAOQuotation> createGetAOQuotation(GetAOQuotation value) {
        return new JAXBElement<GetAOQuotation>(_GetAOQuotation_QNAME, GetAOQuotation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCascoQuotationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://myservice/", name = "getCascoQuotationResponse")
    public JAXBElement<GetCascoQuotationResponse> createGetCascoQuotationResponse(GetCascoQuotationResponse value) {
        return new JAXBElement<GetCascoQuotationResponse>(_GetCascoQuotationResponse_QNAME, GetCascoQuotationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHouseholdQuotationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://myservice/", name = "getHouseholdQuotationResponse")
    public JAXBElement<GetHouseholdQuotationResponse> createGetHouseholdQuotationResponse(GetHouseholdQuotationResponse value) {
        return new JAXBElement<GetHouseholdQuotationResponse>(_GetHouseholdQuotationResponse_QNAME, GetHouseholdQuotationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHouseholdQuotation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://myservice/", name = "getHouseholdQuotation")
    public JAXBElement<GetHouseholdQuotation> createGetHouseholdQuotation(GetHouseholdQuotation value) {
        return new JAXBElement<GetHouseholdQuotation>(_GetHouseholdQuotation_QNAME, GetHouseholdQuotation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAccidentQuotation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://myservice/", name = "getAccidentQuotation")
    public JAXBElement<GetAccidentQuotation> createGetAccidentQuotation(GetAccidentQuotation value) {
        return new JAXBElement<GetAccidentQuotation>(_GetAccidentQuotation_QNAME, GetAccidentQuotation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAccidentQuotationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://myservice/", name = "getAccidentQuotationResponse")
    public JAXBElement<GetAccidentQuotationResponse> createGetAccidentQuotationResponse(GetAccidentQuotationResponse value) {
        return new JAXBElement<GetAccidentQuotationResponse>(_GetAccidentQuotationResponse_QNAME, GetAccidentQuotationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAOQuotationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://myservice/", name = "getAOQuotationResponse")
    public JAXBElement<GetAOQuotationResponse> createGetAOQuotationResponse(GetAOQuotationResponse value) {
        return new JAXBElement<GetAOQuotationResponse>(_GetAOQuotationResponse_QNAME, GetAOQuotationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTravelQuotationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://myservice/", name = "getTravelQuotationResponse")
    public JAXBElement<GetTravelQuotationResponse> createGetTravelQuotationResponse(GetTravelQuotationResponse value) {
        return new JAXBElement<GetTravelQuotationResponse>(_GetTravelQuotationResponse_QNAME, GetTravelQuotationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTravelQuotation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://myservice/", name = "getTravelQuotation")
    public JAXBElement<GetTravelQuotation> createGetTravelQuotation(GetTravelQuotation value) {
        return new JAXBElement<GetTravelQuotation>(_GetTravelQuotation_QNAME, GetTravelQuotation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCascoQuotation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://myservice/", name = "getCascoQuotation")
    public JAXBElement<GetCascoQuotation> createGetCascoQuotation(GetCascoQuotation value) {
        return new JAXBElement<GetCascoQuotation>(_GetCascoQuotation_QNAME, GetCascoQuotation.class, null, value);
    }

}
