package com.example.spring_boot_demo.repositories;

import com.example.spring_boot_demo.entities.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    @EntityGraph(attributePaths = "tags")
    Optional<User> findByEmail(String email);

}
