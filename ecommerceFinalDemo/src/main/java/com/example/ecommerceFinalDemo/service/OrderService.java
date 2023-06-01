package com.example.ecommerceFinalDemo.service;

import com.example.ecommerceFinalDemo.dto.OrderDto;
import com.example.ecommerceFinalDemo.entity.Order;

import java.util.List;


public interface OrderService {

    OrderDto createCart(OrderDto cartDto, Integer orderId, Integer userId);

    Order updateCart(OrderDto cartDto, Integer orderId);

    void deleteCart(Integer orderId);

    List<OrderDto> getAllCart();

    OrderDto getCartById(Integer orderId);

    List<OrderDto> getCartByProduct(Integer productId);

    List<OrderDto> getPostByUser(Integer userId);

    List<OrderDto> searchPosts(String keyword);

}
