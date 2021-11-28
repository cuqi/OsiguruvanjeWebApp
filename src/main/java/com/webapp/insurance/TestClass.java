package com.webapp.insurance;

import com.webapp.webservice.SOAPService;
import com.webapp.webservice.converterClient.SOAPServiceService;

import javax.xml.ws.Endpoint;

//import com.webapp.insurance.soapService.MyService;
//import com.webapp.insurance.soapService.MyServiceService;

//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TestClass {
    

    public static void main (String[] args) {

        final String url = "http://localhost:8000/myservice";
        System.out.println("Publishing Service at endpoint " + url);
        
        Endpoint.publish(url, new SOAPService());
        
        SOAPServiceService service = new SOAPServiceService();
        System.out.println("SERVICE NAME: " + service.getServiceName());

        com.webapp.webservice.converterClient.SOAPService port = service.getSOAPServicePort();
        System.out.println("SERVICE NAME: " + port.toString());

        System.out.println(port.converter("20"));
        /*
        MyServiceService service = new MyServiceService();
        System.out.println("SERVICE NAME: " + service.getServiceName());
        MyService port = service.getMyServicePort();
        System.out.println("SERVICE NAME: " + port.toString());
        */
    }
    
}
