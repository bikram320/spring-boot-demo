package com.example.spring_boot_demo.repositories;

import com.example.spring_boot_demo.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
  }