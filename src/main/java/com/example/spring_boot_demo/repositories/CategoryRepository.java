package com.example.spring_boot_demo.repositories;

import com.example.spring_boot_demo.entities.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Byte> {
  }