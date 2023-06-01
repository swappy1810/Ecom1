package com.example.ecommerceFinalDemo.dto;

import com.example.ecommerceFinalDemo.entity.Product;
import lombok.*;

import java.util.Date;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {

    private int orderId;

    private Date addedDate;

    private String status;

    private int quantity;

    private Product product;

    private UserDto user;

}
