package com.example.spring_boot_demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class OrderService {


    PaymentService paymentService;

    //constructor injection is preferred and commonly used for dependencies injection
    @Autowired
    public OrderService(@Qualifier("stripe") PaymentService paymentService){
        this.paymentService=paymentService;
    }
//    public void setPaymentService(PaymentService paymentService) {
//        this.paymentService = paymentService;
//    }
    public void placeOrder(){
        paymentService.processPayment(10);
    }
}
