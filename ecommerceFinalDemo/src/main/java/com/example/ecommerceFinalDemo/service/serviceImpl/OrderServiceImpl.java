package com.example.ecommerceFinalDemo.service.serviceImpl;

import com.example.ecommerceFinalDemo.dto.OrderDto;
import com.example.ecommerceFinalDemo.entity.Order;
import com.example.ecommerceFinalDemo.entity.Product;
import com.example.ecommerceFinalDemo.entity.User;
import com.example.ecommerceFinalDemo.exception.ResourceNotFoundException;
import com.example.ecommerceFinalDemo.repository.OrderRepository;
import com.example.ecommerceFinalDemo.repository.ProductRepository;
import com.example.ecommerceFinalDemo.repository.UserRepository;
import com.example.ecommerceFinalDemo.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository cartRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public OrderDto createCart(OrderDto cartDto, Integer productId, Integer userId) {
        User user =  this.userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("user not found with this id" +userId));

        Product product =  this.productRepository.findById(productId).orElseThrow(()->new ResourceNotFoundException("product not found with this id" +productId));

        Order cart = this.modelMapper.map(cartDto, Order.class);
        cart.setAddedDate(new Date());
        cart.setOrderStatus(cartDto.getStatus());
        cart.setQuantity(cartDto.getQuantity());
        cart.setAddedDate(cartDto.getAddedDate());
        cart.setProduct(product);
        cart.setUser(user);

        Order newCart = this.cartRepository.save(cart);
        return this.modelMapper.map(newCart, OrderDto.class);
    }

    @Override
    public Order updateCart(OrderDto cartDto, Integer orderId) {
        return null;
    }

    @Override
    public void deleteCart(Integer orderId) {

    }

    @Override
    public List<OrderDto> getAllCart() {
        return null;
    }

    @Override
    public OrderDto getCartById(Integer cartId) {
        return null;
    }

    @Override
    public List<OrderDto> getCartByProduct(Integer productId) {
        Product product= this.productRepository.findById(productId).orElseThrow(()->new ResourceNotFoundException("Product with cart not found with this id "+productId));
        List<Order> carts = this.cartRepository.findByProduct(product);
        List<OrderDto> cartDtos = carts.stream().map((x) -> this.modelMapper.map(x, OrderDto.class)).collect(Collectors.toList());
        return cartDtos;
    }


    @Override
    public List<OrderDto> getPostByUser(Integer userId) {
        User user = this.userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("post category not found with this id "+userId));
        List<Order> carts = this.cartRepository.findByUser(user);
        List<OrderDto> cartDtos = carts.stream().map((x) -> this.modelMapper.map(x, OrderDto.class)).collect(Collectors.toList());
        return cartDtos;
    }

    @Override
    public List<OrderDto> searchPosts(String keyword) {
        return null;
    }
}
