package com.example.ecommerceFinalDemo.entity;

import com.example.ecommerceFinalDemo.dto.ProductDto;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;
    @Column(name = "date")
    private Date addedDate;
    private int quantity;
    private String orderStatus;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    @ManyToOne
    private User user;

}
