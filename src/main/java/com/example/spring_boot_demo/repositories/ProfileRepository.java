package com.example.spring_boot_demo.repositories;

import com.example.spring_boot_demo.entities.Profile;
import org.springframework.data.repository.CrudRepository;

public interface ProfileRepository extends CrudRepository<Profile, Long> {
}