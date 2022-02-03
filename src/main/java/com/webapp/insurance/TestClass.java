package com.webapp.insurance;

import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.webapp.classes.travelInsurance.TravelInfoModel;
import com.webapp.classes.travelInsurance.TravelInfoModel.*;
import com.webapp.insurance.ChargeRequest.Currency;
import com.webapp.insurance.database.Session;
import com.webapp.insurance.database.SessionRepository;
import com.webapp.webservice.ver1.*;

import org.apache.commons.codec.binary.StringUtils;
import org.apache.http.entity.StringEntity;
import org.bouncycastle.util.encoders.UTF8;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.codec.Utf8;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
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

        String x = "лдфлањлдањд";
        System.out.println(new String(x.getBytes("UTF-8"), "UTF-16"));
        // byte[] bytes = StringUtils.getBytesIso8859_1(x);
        // String y = Utf8.decode(bytes);
        //String newx = StringUtils.newStringIso8859_1(bytes);
        // System.out.println(y);
        
        // String input_password = "pass123";
        // String encoded_password = "";
        // SecureRandom random = new SecureRandom();
        // byte[] salt = new byte[16];
        // random.nextBytes(salt);

        // KeySpec spec = new PBEKeySpec(input_password.toCharArray(), salt, 65536, 128);
        // try {
        //     SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        //     byte[] hash = factory.generateSecret(spec).getEncoded();
        //     encoded_password = String.valueOf(hash);
        // } catch (NoSuchAlgorithmException e) {
        //     e.printStackTrace();
        // } catch (InvalidKeySpecException e) {
        //     e.printStackTrace();
        // }
        
        // System.out.println(encoded_password);
    }
}
