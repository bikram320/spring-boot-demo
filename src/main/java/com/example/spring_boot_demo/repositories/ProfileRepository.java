package com.example.spring_boot_demo.repositories;

import com.example.spring_boot_demo.dtos.UserSummary;
import com.example.spring_boot_demo.entities.Profile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProfileRepository extends CrudRepository<Profile, Long> {

}