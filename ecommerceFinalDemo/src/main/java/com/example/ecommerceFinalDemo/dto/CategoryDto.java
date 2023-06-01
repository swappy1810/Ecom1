package com.example.ecommerceFinalDemo.dto;

import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {

    private int catId;
    private String catName;
    private ProductDto product;

}
