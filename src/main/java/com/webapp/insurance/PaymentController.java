package com.webapp.insurance;

import java.util.prefs.Preferences;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class PaymentController {

    @Autowired
    private Environment secretKey;

    @RequestMapping("/checkout")
    public String checkout(Model model) {
        int amount = 50;
        if (model.containsAttribute("payment")) {
            System.out.print("there is payment attr");
        }
        model.addAttribute("amount", amount * 100); // in cents
        model.addAttribute("stripePublicKey", secretKey.getRequiredProperty("stripe.key.id"));
        model.addAttribute("currency", ChargeRequest.Currency.EUR);
        return "checkout";
    }
}