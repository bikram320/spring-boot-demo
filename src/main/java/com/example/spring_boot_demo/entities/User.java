package com.example.spring_boot_demo.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(unique = true, nullable = false , name = "name")
    private String name;
    @Column(unique = true,nullable = false,name = "email")
    private String email;
    @Column(unique = true, nullable = false , name = "password")
    private String password;

    @OneToMany(mappedBy = "user" , cascade = {CascadeType.PERSIST, CascadeType.REMOVE} , orphanRemoval = true)
    @Builder.Default
    @ToString.Exclude
    private List<Address> addresses = new ArrayList<>();

    public void addAddress(Address address) {
        this.addresses.add(address);
        address.setUser(this);
    }
    public void removeAddress(Address address) {
        this.addresses.remove(address);
        address.setUser(null);
    }

    @ManyToMany()
    @JoinTable(
            name = "user_tags",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    @Builder.Default
    @ToString.Exclude
    private Set<Tags> tags = new HashSet<>();

    public void addTag(Tags tag) {
        this.tags.add(tag);
        tag.getUsers().add(this);
    }

    @OneToOne(mappedBy = "user" , cascade = CascadeType.REMOVE)
    private Profile profile;

    @ManyToMany
    @JoinTable(
            name = "wishlist",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private Set<Product> wishlist = new HashSet<>();
}
