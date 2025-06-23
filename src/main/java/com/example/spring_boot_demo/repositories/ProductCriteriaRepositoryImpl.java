package com.example.spring_boot_demo.repositories;

import com.example.spring_boot_demo.entities.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductCriteriaRepositoryImpl implements ProductCriteriaRepository {

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Product> findProductsByCriteria(String name, BigDecimal min, BigDecimal max) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> criteria = builder.createQuery(Product.class);
        Root<Product> product = criteria.from(Product.class);

        List<Predicate> predicates = new ArrayList<Predicate>();
        if(name != null) {
            predicates.add(builder.like(product.get("name"), "%"+ name.toLowerCase() +"%"));
        }
        if(min != null) {
            predicates.add(builder.greaterThanOrEqualTo(product.get("price"), min));
        }
        if(max != null) {
            predicates.add(builder.lessThanOrEqualTo(product.get("price"), max));
        }

        criteria.select(product).where(predicates.toArray(new Predicate[predicates.size()]));
        return entityManager.createQuery(criteria).getResultList();
    }
}
