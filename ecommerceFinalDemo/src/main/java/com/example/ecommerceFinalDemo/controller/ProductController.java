package com.example.ecommerceFinalDemo.controller;

import com.example.ecommerceFinalDemo.dto.ProductDto;
import com.example.ecommerceFinalDemo.exception.ApiResponse;
import com.example.ecommerceFinalDemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/save")
    public ResponseEntity<ProductDto> createProduct(@Valid @RequestBody ProductDto productDto){
        ProductDto createProductDto = this.productService.createProduct(productDto);
        return new ResponseEntity<>(createProductDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> updateProduct(@Valid @RequestBody ProductDto productDto, @PathVariable Integer id){
        ProductDto updatedProduct = this.productService.updateProduct(productDto,id);
        updatedProduct.setProduct_name(productDto.getProduct_name());
        updatedProduct.setProduct_desc(productDto.getProduct_desc());
        updatedProduct.setProduct_price(productDto.getProduct_price());
        updatedProduct.setProduct_image(productDto.getProduct_image());
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteProduct(@PathVariable("id") Integer id){
        this.productService.deleteProduct(id);
        return new ResponseEntity<ApiResponse>(new ApiResponse("Product Deleted Successfully",true), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<ProductDto>> getAllProducts(){
        return ResponseEntity.ok(this.productService.getAllProduct());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductBYId(@PathVariable("id") Integer id){
        return ResponseEntity.ok(this.productService.getProductById(id));
    }


}
