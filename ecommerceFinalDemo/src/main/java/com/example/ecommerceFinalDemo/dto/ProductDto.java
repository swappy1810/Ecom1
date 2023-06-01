package com.example.ecommerceFinalDemo.dto;


import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductDto {

    @NotNull
    private int product_id;
    @NotNull
    private String product_image;
    @NotBlank
    private String product_name;
    @NotBlank
    private String product_desc;
    @NotNull
    private int product_price;

    private CategoryDto category;


}
