package com.example.ecommerceFinalDemo.entity;

import com.example.ecommerceFinalDemo.service.CategoryService;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int product_id;
    @Lob
    private String product_image;
    @Column(unique = true,nullable = false)
    private String product_name;
    @Column(nullable = false)
    private String product_desc;
    @Column(nullable = false)
    private int product_price;

   @ManyToOne
   @JoinColumn(name = "cat_id")
    private Category category;


}
