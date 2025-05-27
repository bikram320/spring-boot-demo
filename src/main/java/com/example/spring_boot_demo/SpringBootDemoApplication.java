package com.example.spring_boot_demo;

import com.example.spring_boot_demo.entities.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);
//		var orderService = new OrderService(new PaypalPaymentService())
// 		var orderService = new OrderService();
//		orderService.setPaymentService(new PaypalPaymentService());
		//Spring IoC
//		ConfigurableApplicationContext context = SpringApplication.run(SpringBootDemoApplication.class, args);
//		OrderService orderService = context.getBean(OrderService.class);
//		context.getBean(HeavyResource.class);
//		orderService.placeOrder();
//		context.close();
//		User user = new User();
//		user.setName("John");
//		user.setEmail("john@gmail.com");
//		user.setPassword("password");

		//using builder pattern
		User user = User.builder()
				.name("John")
				.email("john@gmail.com")
				.password("password")
				.build();
	}

}
