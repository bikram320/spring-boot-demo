package com.example.spring_boot_demo.repositories;

import com.example.spring_boot_demo.entities.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {
    
}