package com.webapp.insurance;

import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.webapp.classes.travelInsurance.TravelInfoModel;
import com.webapp.classes.travelInsurance.TravelInfoModel.*;
import com.webapp.insurance.ChargeRequest.Currency;
import com.webapp.insurance.database.Session;
import com.webapp.insurance.database.SessionRepository;
import com.webapp.webservice.ver1.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.xml.ws.Endpoint;

public class TestClass {
    

    @Autowired
    private static StripeService paymentsService;

/*
    @PostMapping("/charge")
    public String charge(ChargeRequest chargeRequest, Model model)
      throws StripeException {
        chargeRequest.setDescription("Example charge");
        chargeRequest.setCurrency(Currency.EUR);
        Charge charge = paymentsService.charge(chargeRequest);
        model.addAttribute("id", charge.getId());
        model.addAttribute("status", charge.getStatus());
        model.addAttribute("chargeId", charge.getId());
        model.addAttribute("balance_transaction", charge.getBalanceTransaction());
        return "result";
    }

*/
    public static void main (String[] args) throws UnsupportedEncodingException, StripeException {
        ChargeRequest chargeRequest = new ChargeRequest("aa", 100, Currency.EUR, "krstik1212@gmail.com", "1000");
        chargeRequest.setAmount(100);
        Charge charge = paymentsService.charge(chargeRequest);

        System.out.println(charge.getAmount());
    }
}
