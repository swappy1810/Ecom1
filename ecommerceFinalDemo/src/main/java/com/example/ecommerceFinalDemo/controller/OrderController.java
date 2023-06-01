package com.example.ecommerceFinalDemo.controller;

import com.example.ecommerceFinalDemo.dto.OrderDto;
import com.example.ecommerceFinalDemo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService cartService;

    @PostMapping("/users/{userId}/product/{productId}/orders")
    public ResponseEntity<OrderDto> createCart(@RequestBody OrderDto cartDto, @PathVariable Integer productId, @PathVariable Integer userId){
        OrderDto createCart = this.cartService.createCart(cartDto,productId,userId);
        return new ResponseEntity<OrderDto>(createCart, HttpStatus.CREATED);
    }

    @GetMapping("users/{userId}/order")
    public ResponseEntity<List<OrderDto>> getByUser(@PathVariable Integer userId){
        List<OrderDto> cartDtos = this.cartService.getPostByUser(userId);
        return new ResponseEntity<List<OrderDto>>(cartDtos,HttpStatus.OK);
    }

    @GetMapping("product/{productId}/order")
    public ResponseEntity<List<OrderDto>> getByCategory(@PathVariable Integer productId){
        List<OrderDto> cartDtos = this.cartService.getCartByProduct(productId);
        return new ResponseEntity<List<OrderDto>>(cartDtos,HttpStatus.OK);
    }

}
