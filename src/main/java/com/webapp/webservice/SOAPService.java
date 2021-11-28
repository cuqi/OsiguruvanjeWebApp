package com.webapp.webservice;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;


@WebService
public class SOAPService {

    @WebMethod
    public double converter(@WebParam(name = "EUR") String evra) {
        return Integer.valueOf(evra) * 61.5;
    }

    

}