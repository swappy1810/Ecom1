package com.example.ecommerceFinalDemo.service;


import com.example.ecommerceFinalDemo.dto.CategoryDto;
import com.example.ecommerceFinalDemo.dto.ProductDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CategoryService {

    CategoryDto createProduct(CategoryDto categoryDto);

    CategoryDto updateProduct(CategoryDto categoryDto,Integer categoryId);

    CategoryDto getProductById(Integer categoryId);

    List<CategoryDto> getAllProduct();

    ResponseEntity<CategoryDto> deleteProduct(Integer categoryId);

}
