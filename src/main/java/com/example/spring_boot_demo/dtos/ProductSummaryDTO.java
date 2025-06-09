package com.example.spring_boot_demo.dtos;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class ProductSummaryDTO {
    private long id;
    private String name;
}
