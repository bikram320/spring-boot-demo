package com.example.spring_boot_demo.services;

import com.example.spring_boot_demo.entities.User;
import com.example.spring_boot_demo.repositories.UserRepository;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;
    private EntityManager entityManager;

    @Transactional
    public void showEntitiesState(){

        User user = User.builder()
                .name("John")
                .email("john@gmail.com")
                .password("password")
                .build();


        if(entityManager.contains(user)){
            System.out.println("persistent");
        }else{
            System.out.println("Transient / Detached");
        }
        //This is Transaction(group of Operation)
        userRepository.save(user);

        if(entityManager.contains(user)){
            System.out.println("persistent");
        }else{
            System.out.println("Transient / Detached");
        }


    }
}
