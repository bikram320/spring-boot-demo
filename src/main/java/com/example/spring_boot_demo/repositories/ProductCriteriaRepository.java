package com.example.spring_boot_demo.repositories;

import com.example.spring_boot_demo.entities.Product;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductCriteriaRepository {
    List<Product> findProductsByCriteria(String name , BigDecimal min , BigDecimal max);
}
