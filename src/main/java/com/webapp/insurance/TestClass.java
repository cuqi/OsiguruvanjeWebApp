package com.webapp.insurance;

import com.webapp.classes.travelInsurance.TravelInfoModel;
import com.webapp.classes.travelInsurance.TravelInfoModel.*;
import com.webapp.webservice.ver1.*;

import java.io.UnsupportedEncodingException;

import javax.xml.ws.Endpoint;

//import com.webapp.insurance.soapService.MyService;
//import com.webapp.insurance.soapService.MyServiceService;

//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TestClass {
    

    public static void main (String[] args) throws UnsupportedEncodingException {

        // TravelInfoModel travelInfoModel = new TravelInfoModel();
        // travelInfoModel.setType(TypeTravelPolicyModel.BUSINESS);

        // TypeTravelPolicy tp = TypeTravelPolicy.valueOf(travelInfoModel.getType().toString());
        // System.out.println(tp.value());


        // MyServiceService service = new MyServiceService();
        // MyService port = service.getMyServicePort();

        // TravelInfo travelInfo2 = new TravelInfo();
        // travelInfo2.setType(TypeTravelPolicy.valueOf("INDIVIDUAL"));
        // travelInfo2.setCover(TypeCover.CLASSIC);
        // travelInfo2.setDays(travelInfoModel.getDays());
        // travelInfo2.setNumPeople(1);
        // travelInfo2.setCountry("Greece");

        // QuotationResponse qr = port.getTravelQuotation(travelInfo2, "");

        // System.out.println("code: " + qr.getCode() + ", premium: " + qr.getPremium());

        // //model.addAttribute("travelInfo", travelInfoModel);
        // System.out.println(travelInfoModel.getDays() + " " + travelInfoModel.getCountry() + " " + travelInfoModel.getCover());

    }
    
}
