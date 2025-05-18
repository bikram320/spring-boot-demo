package com.example.spring_boot_demo;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class HeavyResource {
    /*
    this is an example for lazy initialization
    that means creating the object only when it needed to be created otherwise remain lazy
     */
    public HeavyResource() {
        System.out.println("HeavyResource Created");
    }
}
