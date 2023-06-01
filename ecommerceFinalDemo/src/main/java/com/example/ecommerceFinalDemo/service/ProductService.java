package com.example.ecommerceFinalDemo.service;

import com.example.ecommerceFinalDemo.dto.ProductDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService {

    ProductDto createProduct(ProductDto productDto);

    ProductDto updateProduct(ProductDto productDto,Integer id);

    ProductDto getProductById(Integer id);

    List<ProductDto> getAllProduct();

    ResponseEntity<ProductDto> deleteProduct(Integer id);


}
