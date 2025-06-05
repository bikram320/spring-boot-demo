package com.example.spring_boot_demo.repositories;

import com.example.spring_boot_demo.entities.Product;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {

  //String
  List<Product> findByName(String name);
  List<Product> findByNameLike(String name);
  List<Product> findByNameNotLike(String name);
  List<Product> findByNameContaining(String name);
  List<Product> findByNameContainingIgnoreCase(String name);
  List<Product> findByNameStartingWith(String name);
  List<Product> findByNameEndingWith(String name);

  //numbers
  List<Product> findByPrice(BigDecimal price);
  List<Product> findByPriceBetween(BigDecimal min, BigDecimal max);
  List<Product> findByPriceGreaterThan(BigDecimal price);
  List<Product> findByPriceLessThan(BigDecimal price);
  List<Product> findByPriceBetweenAndPriceGreaterThan(BigDecimal min, BigDecimal max, BigDecimal price);


  //null
  List<Product> findByDescriptionNull(String description);
  List<Product> findByDescriptionNotNull(String description);

  //multiple condition
  List<Product> findByDescriptionNullAndNameNotNull(String description,String name);

  //sort(orderBy)
  List<Product> findByNameOrderByPriceDesc(String name);

  //Limit(top/bottom)
  List<Product> findTop5ByNameOrderByPriceDesc(String name);




}