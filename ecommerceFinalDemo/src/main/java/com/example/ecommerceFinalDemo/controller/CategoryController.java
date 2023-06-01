package com.example.ecommerceFinalDemo.controller;

import com.example.ecommerceFinalDemo.dto.CategoryDto;
import com.example.ecommerceFinalDemo.dto.ProductDto;
import com.example.ecommerceFinalDemo.exception.ApiResponse;
import com.example.ecommerceFinalDemo.service.CategoryService;
import com.example.ecommerceFinalDemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/save")
    public ResponseEntity<CategoryDto> createProduct(@Valid @RequestBody CategoryDto categoryDto){
        CategoryDto createCategoryDto = this.categoryService.createProduct(categoryDto);
        return new ResponseEntity<>(createCategoryDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryDto> updateProduct(@Valid @RequestBody CategoryDto categoryDto, @PathVariable Integer id){
        CategoryDto updatedCategory = this.categoryService.updateProduct(categoryDto,id);
        updatedCategory.setCatName(categoryDto.getCatName());
        return ResponseEntity.ok(updatedCategory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteProduct(@PathVariable("id") Integer id){
        this.categoryService.deleteProduct(id);
        return new ResponseEntity<ApiResponse>(new ApiResponse("Category Deleted Successfully",true), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<CategoryDto>> getAllProducts(){
        return ResponseEntity.ok(this.categoryService.getAllProduct());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> getProductBYId(@PathVariable("id") Integer id){
        return ResponseEntity.ok(this.categoryService.getProductById(id));
    }

}
