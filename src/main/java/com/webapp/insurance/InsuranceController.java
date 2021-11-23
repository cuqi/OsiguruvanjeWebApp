package com.webapp.insurance;

import com.webapp.classes.TravelInfo;

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
    
    @GetMapping(path = "/travel")
    public String showTravelInsurance(Model model) {
        model.addAttribute("travelInfo", new TravelInfo());
        return "travel_form";
    }

    @PostMapping(path = "/travelHealth")
    public String processTravelHealth(@ModelAttribute TravelInfo travelInfo, Model model) {
        model.addAttribute("travelInfo", travelInfo);
        System.out.println(travelInfo.getDays() + " " + travelInfo.getCountry() + " " + travelInfo.getCover());

        return "tra_calculate_premium";
    }
    
}
