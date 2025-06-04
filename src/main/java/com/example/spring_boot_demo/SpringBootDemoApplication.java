package com.example.spring_boot_demo;

import com.example.spring_boot_demo.entities.Address;
import com.example.spring_boot_demo.entities.Profile;
import com.example.spring_boot_demo.entities.Tags;
import com.example.spring_boot_demo.entities.User;
import com.example.spring_boot_demo.repositories.UserRepository;
import com.example.spring_boot_demo.services.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBootDemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootDemoApplication.class, args);
//		User user = User.builder()
//				.name("John")
//				.email("john@gmail.com")
//				.password("password")
//				.build();

		var service = context.getBean(UserService.class);
		service.manageProduct();





	}

}
