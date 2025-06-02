package com.example.spring_boot_demo.services;

import com.example.spring_boot_demo.entities.User;
import com.example.spring_boot_demo.repositories.AddressRepository;
import com.example.spring_boot_demo.repositories.ProfileRepository;
import com.example.spring_boot_demo.repositories.UserRepository;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class UserService {

    private final AddressRepository addressRepository;
    private UserRepository userRepository;
    private final ProfileRepository profileRepository;
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
    @Transactional
    public void showRelatedEntities(){
        var profile= profileRepository.findById( 1L).orElseThrow();
        System.out.println(profile.getUser().getName());
    }
    @Transactional
    public void  fetchAddress(){
        var address =addressRepository.findById(1L).orElseThrow();
        System.out.println(address.getState());
    }
}
