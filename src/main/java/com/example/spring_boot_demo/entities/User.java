package com.example.spring_boot_demo.entities;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false , name = "name")
    private String name;
    @Column(unique = true,nullable = false,name = "email")
    private String email;
    @Column(unique = true, nullable = false , name = "password")
    private String password;

}
