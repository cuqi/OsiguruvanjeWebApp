package com.webapp.insurance;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import com.stripe.Stripe;
import com.stripe.exception.ApiConnectionException;
import com.stripe.exception.ApiException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class StripeService {

    @Autowired
    private Environment secretKey;
    
    @PostConstruct
    public void init() {
        System.out.println(secretKey.getRequiredProperty("stripe.secret.id"));
        Stripe.apiKey = secretKey.getRequiredProperty("stripe.secret.id");
    }
    public Charge charge(ChargeRequest chargeRequest) 
      throws StripeException {
        Map<String, Object> chargeParams = new HashMap<>();
        chargeParams.put("amount", chargeRequest.getAmount());
        chargeParams.put("currency", chargeRequest.getCurrency());
        chargeParams.put("description", chargeRequest.getDescription());
        chargeParams.put("source", chargeRequest.getStripeToken());
        return Charge.create(chargeParams);
    }
}
