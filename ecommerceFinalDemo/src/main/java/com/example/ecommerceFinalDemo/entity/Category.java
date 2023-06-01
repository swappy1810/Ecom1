package com.example.ecommerceFinalDemo.entity;

import com.example.ecommerceFinalDemo.dto.ProductDto;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int catId;
    @Column(name = "categoryName",nullable = false,unique = true)
    private String catName;

    @OneToMany(mappedBy = "category")
    private List<Product> product= new ArrayList<>();

}
