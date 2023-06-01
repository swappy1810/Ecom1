package com.example.ecommerceFinalDemo.service.serviceImpl;

import com.example.ecommerceFinalDemo.dto.CategoryDto;
import com.example.ecommerceFinalDemo.dto.ProductDto;
import com.example.ecommerceFinalDemo.entity.Category;
import com.example.ecommerceFinalDemo.entity.Product;
import com.example.ecommerceFinalDemo.exception.ResourceNotFoundException;
import com.example.ecommerceFinalDemo.repository.CategoryRepository;
import com.example.ecommerceFinalDemo.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CategoryDto createProduct(CategoryDto categoryDto) {
        Category category = this.dtoToCategory(categoryDto);
        Category savedProduct = this.categoryRepository.save(category);
        return this.categoryToDto(savedProduct);
    }

    @Override
    public CategoryDto updateProduct(CategoryDto categoryDto, Integer categoryId) {
        Category category = this.categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category not found with this id " + categoryDto));
        category.setCatName(categoryDto.getCatName());
        Category updateCategory = this.categoryRepository.save(category);
        CategoryDto productDto1 = this.categoryToDto(updateCategory);
        return productDto1;
    }

    @Override
    public CategoryDto getProductById(Integer categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category not found with this id " + categoryId));
        return this.categoryToDto(category);
    }

    @Override
    public List<CategoryDto> getAllProduct() {
        List<Category> categories = this.categoryRepository.findAll();
        List<CategoryDto> productDtos = categories.stream().map(product -> this.categoryToDto(product)).collect(Collectors.toList());
        return productDtos;
    }

    @Override
    public ResponseEntity<CategoryDto> deleteProduct(Integer categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category not found with this id " + categoryId));
        this.categoryRepository.deleteById(categoryId);
        return null;
    }


    private Category dtoToCategory(CategoryDto categoryDto) {
        Category category = modelMapper.map(categoryDto,Category.class);
        return category;
    }

    private CategoryDto categoryToDto(Category category) {
        CategoryDto categoryDto = modelMapper.map(category,CategoryDto.class);
        return  categoryDto;
    }
}
