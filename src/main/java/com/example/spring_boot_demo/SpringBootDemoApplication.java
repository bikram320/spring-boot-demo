package com.example.spring_boot_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootDemoApplication {

	public static void main(String[] args) {

//		var orderService = new OrderService(new PaypalPaymentService())
// 		var orderService = new OrderService();
//		orderService.setPaymentService(new PaypalPaymentService());
		//Spring IoC
		ApplicationContext context = SpringApplication.run(SpringBootDemoApplication.class, args);
		OrderService orderService = context.getBean(OrderService.class);
		context.getBean(HeavyResource.class);
		orderService.placeOrder();
	}

}
