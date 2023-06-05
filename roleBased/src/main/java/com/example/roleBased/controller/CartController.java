package com.example.roleBased.controller;

import com.example.roleBased.serviceImpl.CartServiceImpl;
import com.example.roleBased.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("carts")
public class CartController {

    @Autowired
    private CartServiceImpl cartService;

    @Autowired
    private UserServiceImpl userService;

    //get added cart item
    @GetMapping("/addtocart/{productId}")
    public void addToCart(@PathVariable(name = "productId") Integer productId){

    }


}
