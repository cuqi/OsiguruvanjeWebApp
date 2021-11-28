package com.webapp.insurance;

import com.webapp.classes.TravelInfo;
import com.webapp.insurance.soapService.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;



@Controller 
@RequestMapping(path = "/insurance")
public class InsuranceController {

    private String premium;
    private String convertedPrem;
    
    @GetMapping(path = "/travel")
    public String showTravelInsurance(Model model) {
        model.addAttribute("travelInfo", new TravelInfo());
        model.addAttribute("premium", premium);
        model.addAttribute("convertedPrem", convertedPrem);
        return "travel_form";
    }

    @PostMapping(path = "/travelHealth")
    public String processTravelHealth(@ModelAttribute TravelInfo travelInfo, Model model) {
        premium = "10";
        MyServiceService service = new MyServiceService();
        System.out.println("SERVICE NAME: " + service.getServiceName());
        MyService port = service.getMyServicePort();
        System.out.println("SERVICE NAME: " + port.toString());
        convertedPrem = String.valueOf(port.converter("10")); 
        //port.getTravelQuotation(travelInfo, sessionID);
        // try {
        //     System.out.println(port.loginMethod("test_user", "pass123"));
        // } catch (NoSuchAlgorithmException_Exception e) {
        //     e.printStackTrace();
        // }
        model.addAttribute("travelInfo", travelInfo);
        System.out.println(travelInfo.getDays() + " " + travelInfo.getCountry() + " " + travelInfo.getCover());

        return "redirect:/insurance/travel";
    }
    
}
