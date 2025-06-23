package com.example.spring_boot_demo.repositories.specification;

import com.example.spring_boot_demo.entities.Product;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;

public class ProductSpec {
    public static Specification<Product> hasName( String name) {
        return (root, query, criteriaBuilder)
                -> criteriaBuilder.like(root .get("name"), "%"+ name.toLowerCase() +"%");
    }
    public static Specification<Product> hasPriceGreaterThanOrEqualTo( BigDecimal price) {
        return (root, query, criteriaBuilder) -> (criteriaBuilder.greaterThanOrEqualTo(root.get("price"), price));
    }
    public static Specification<Product> hasPriceLessThanOrEqualTo( BigDecimal price) {
        return (root, query, criteriaBuilder) -> (criteriaBuilder.lessThan(root.get("price"), price)) ;

    }
}
