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
//		User user = new User();
//		user.setName("John");
//		user.setEmail("john@gmail.com");
//		user.setPassword("password");

		//using builder pattern
//		User user = User.builder()
//				.name("John")
//				.email("john@gmail.com")
//				.password("password")
//				.build();

		var service = context.getBean(UserService.class);
		service.showEntitiesState();
		//Saving user
//		repository.save(user);

		//Searching User
//		repository.findAll().forEach(User -> System.out.println(user.getName()));
//		var user1 = repository.findById(1L).orElseThrow();
//		System.out.println(user1.getId()+user1.getEmail());

		//Deleting User
//		repository.deleteById(1L);
//		repository.deleteAll();

//		Address address = Address.builder()
//				.id(1L)
//				.street("Jana Jyoti street")
//				.city("Devchuli")
//				.state("Gandaki")
//				.zip("123122")
//				.build();
//
//		user.addAddress(address);
//		var tag = new Tags("tag1");
//		user.addTag(tag);
//		var profile = Profile.builder()
//						.bio("Bio")
//								.phone_number("555-555-5555")
//				.build();
//
//		user.setProfile(profile);
//		profile.setUser(user);
//
//		System.out.println(user);




	}

}
