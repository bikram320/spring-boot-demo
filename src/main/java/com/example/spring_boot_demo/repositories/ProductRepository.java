package com.example.spring_boot_demo.repositories;

import com.example.spring_boot_demo.dtos.ProductSummary;
import com.example.spring_boot_demo.dtos.ProductSummaryDTO;
import com.example.spring_boot_demo.entities.Category;
import com.example.spring_boot_demo.entities.Product;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {
//
//  //String
//  List<Product> findByName(String name);
//  List<Product> findByNameLike(String name);
//  List<Product> findByNameNotLike(String name);
//  List<Product> findByNameContaining(String name);
//  List<Product> findByNameContainingIgnoreCase(String name);
//  List<Product> findByNameStartingWith(String name);
//  List<Product> findByNameEndingWith(String name);
//
//  //numbers
//  List<Product> findByPrice(BigDecimal price);
//  List<Product> findByPriceBetween(BigDecimal min, BigDecimal max);
//  List<Product> findByPriceGreaterThan(BigDecimal price);
//  List<Product> findByPriceLessThan(BigDecimal price);
//  List<Product> findByPriceBetweenAndPriceGreaterThan(BigDecimal min, BigDecimal max, BigDecimal price);
//
//
//  //null
////  List<Product> findByDescriptionNull(String description);
////  List<Product> findByDescriptionNotNull(String description);
//
//  //multiple condition
//  List<Product> findByDescriptionNullAndNameNotNull(String description,String name);
//
//  //sort(orderBy)
//  List<Product> findByNameOrderByPriceDesc(String name);
//
//  //Limit(top/bottom)
//  List<Product> findTop5ByNameOrderByPriceDesc(String name);

  //jPQL
  //now using procedure
  @Procedure("findProductsByPrice")
  List<Product> findByPriceBetweenOrderByName(BigDecimal min,BigDecimal max);

  @Query("SELECT  COUNT(*) FROM Product p  WHERE p.price between :min and :max  order by p.name")
  long countProducts(@Param("min") BigDecimal min, @Param("max") BigDecimal max);

    @Modifying
    @Query("update Product p set p.price = :newPrice WHERE p.category.id = :categoryId")
    void updatePriceByCategory(BigDecimal newPrice, byte categoryId);


    @Modifying
    @Query("update Product p set p.name=:name WHERE p.category.id=:categoryId")
    void updateProductNameByCategory(String name, byte categoryId);

    @Modifying
    @Query("update Product p set p.description=:description WHERE p.name=:name")
    void updateDescriptionByName(String description, String name);

    @Query("select new com.example.spring_boot_demo.dtos.ProductSummaryDTO(p.id,p.name) from Product p where p.category = ?1")
    List<ProductSummaryDTO> findByCategory(Category category);
}