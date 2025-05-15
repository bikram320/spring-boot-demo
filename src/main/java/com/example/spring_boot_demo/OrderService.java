package com.example.spring_boot_demo;

public class OrderService {

    PaymentService paymentService;

    public OrderService(PaymentService paymentService){
        this.paymentService=paymentService;
    }
    public void placeOrder(){
        paymentService.processPayment(10);
    }
}
