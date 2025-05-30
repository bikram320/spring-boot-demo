package com.example.spring_boot_demo.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private double price;

    @Column(name = "category_id")
    private byte categoryId;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

}
