package com.example.spring_boot_demo.services;

import com.example.spring_boot_demo.dtos.ProductSummaryDTO;
import com.example.spring_boot_demo.entities.Address;
import com.example.spring_boot_demo.entities.Category;
import com.example.spring_boot_demo.entities.Product;
import com.example.spring_boot_demo.entities.User;
import com.example.spring_boot_demo.repositories.*;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@AllArgsConstructor
public class UserService {

    private final AddressRepository addressRepository;
    private UserRepository userRepository;
    private final ProfileRepository profileRepository;
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private EntityManager entityManager;


    @Transactional
    public void showEntitiesState(){

        User user = User.builder()
                .name("John")
                .email("john@gmail.com")
                .password("password")
                .build();


        if(entityManager.contains(user)){
            System.out.println("persistent");
        }else{
            System.out.println("Transient / Detached");
        }
        //This is Transaction(group of Operation)
        userRepository.save(user);

        if(entityManager.contains(user)){
            System.out.println("persistent");
        }else{
            System.out.println("Transient / Detached");
        }


    }
    @Transactional
    public void showRelatedEntities(){
        var profile= profileRepository.findById( 1L).orElseThrow();
        System.out.println(profile.getUser().getName());
    }
    @Transactional
    public void  fetchAddress(){
        var address =addressRepository.findById(1L).orElseThrow();
        System.out.println(address.getState());
    }

    public void persistRelated(){
        var user = User.builder()
                .name("John")
                .email("john@gmail.com")
                .password("password")
                .build();

        var address =  Address.builder()
                .zip("1232")
                .state("state")
                .city("city")
                .street("street")
                .build();

        user.addAddress(address);
        userRepository.save(user);

    }
    @Transactional
    public void deleteData(){
//        userRepository.deleteById(3L);
        var user = userRepository.findById(4L).orElseThrow();
        var address =  user.getAddresses().getFirst();
        user.removeAddress(address);
        userRepository.save(user);

    }
    @Transactional
    public void manageProduct(){

        //delete product by id
        productRepository.deleteById(1L);



        //adding all product into a user wishlist
//        var user = userRepository.findById(4L).orElseThrow();
//        var product = productRepository.findAll();
//        product.forEach(user::addWishlist);
//        userRepository.save(user);
        //Inserting product table into along with category
//        var category = new Category("Category 1");
//
//        var product = Product.builder()
//                .name("Keyboard")
//                .price(BigDecimal.valueOf(1232))
//                .category(category)
//                .description("Keyboard" )
//                .build();
//
//        productRepository.save(product);

        //fetching same category and adding another product on it
//        var category = categoryRepository.findById((byte)1).orElseThrow();
//
//        var product = Product.builder()
//                .name("mouse")
//                .price(BigDecimal.valueOf(232))
//                .category(category)
//                .description("mouse " )
//                .build();
//
//        productRepository.save(product);

    }
    @Transactional
    public void updateProductPrice(BigDecimal price, byte categoryId) {
        productRepository.updatePriceByCategory(price, categoryId);
    }
    @Transactional
    public void updateProductName(String name , byte categoryId) {
        productRepository.updateProductNameByCategory(name, categoryId);
    }

    @Transactional
    public void updateProductDescription(String description,String name) {
        productRepository.updateDescriptionByName(description, name);
    }

    public void fetchByCategory(){
        var products =productRepository.findByCategory(new Category((byte) 1));
        products.forEach(System.out::println);
    }

    @Transactional
    public void fetchUser(){
       var user = userRepository.findByEmail("john@gmail.com").orElseThrow();
        System.out.println(user);
    }

    @Transactional
    public void fetchAll(){
        var users = userRepository.findAllByAddresses();
        users.forEach(u->{
            System.out.println(u);
            u.getAddresses().forEach(System.out::println);
        });
    }
    @Transactional
    public void findProductByPrice(){
        var products = productRepository.findByPriceBetweenOrderByName(BigDecimal.valueOf(1), BigDecimal.valueOf(2000));
        products.forEach(System.out::println);
    }

    @Transactional
    public void findProfileByLoyaltyPoint(){
        var users = userRepository.findLoyalUser(10);
        users.forEach(u->{
            System.out.println(u.getId()+": "+u.getEmail());
        });
    }
    @Transactional
    public void fetchProductByMatching(){
        var product = new Product();

        product.setName("keyboard");

        var matcher = ExampleMatcher.matching()
                                            .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example<Product> example = Example.of(product, matcher);
        var products = productRepository.findAll(example);
        products.forEach(System.out::println);
    }
}
