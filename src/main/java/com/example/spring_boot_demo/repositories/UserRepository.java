package com.example.spring_boot_demo.repositories;

import com.example.spring_boot_demo.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

}
