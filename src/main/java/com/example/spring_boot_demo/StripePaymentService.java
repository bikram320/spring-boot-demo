package com.example.spring_boot_demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import java.util.List;

//@Service("stripe")
//@Primary
public class StripePaymentService implements PaymentService {

    @Value("${stripe.api-url}")
    private String apiUrl;

    @Value("${stripe.timeout}")
    private int timeOut ;

    @Value("${stripe.api-enabled}")
    private boolean apiEnabled;

    @Value("${stripe.currencies}")
    private List<String> currencies;
    @Override
    public void processPayment(double amount){
        System.out.println("STRIPE");
        System.out.println("ApiUrl : "+apiUrl);
        System.out.println("ApiEnabled : "+apiEnabled);
        System.out.println("TimeOut : "+timeOut);
        System.out.println("Currencies :"+currencies);
        System.out.println("Amount : "+amount);

    }
}
