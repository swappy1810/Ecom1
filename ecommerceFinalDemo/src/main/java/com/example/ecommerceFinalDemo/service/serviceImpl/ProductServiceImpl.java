package com.example.ecommerceFinalDemo.service.serviceImpl;

import com.example.ecommerceFinalDemo.dto.ProductDto;
import com.example.ecommerceFinalDemo.entity.Product;
import com.example.ecommerceFinalDemo.exception.ResourceNotFoundException;
import com.example.ecommerceFinalDemo.repository.ProductRepository;
import com.example.ecommerceFinalDemo.repository.UserRepository;
import com.example.ecommerceFinalDemo.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        Product product = this.dtoToProduct(productDto);
        Product savedProduct = this.productRepository.save(product);
        return this.productToDto(savedProduct);
    }

    @Override
    public ProductDto updateProduct(@RequestBody ProductDto productDto, @PathVariable Integer id) {
        Product product = this.productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found with this id " + id));
        product.setProduct_name(productDto.getProduct_name());
        product.setProduct_desc(productDto.getProduct_desc());
        product.setProduct_price(productDto.getProduct_price());
        product.setProduct_image(productDto.getProduct_image());

        Product updateProduct = this.productRepository.save(product);
        ProductDto productDto1 = this.productToDto(updateProduct);
        return productDto1;
    }


    @Override
    public ProductDto getProductById(Integer id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found with this id " + id));
        return this.productToDto(product);
    }

    @Override
    public List<ProductDto> getAllProduct() {
        List<Product> products = this.productRepository.findAll();
        List<ProductDto> productDtos = products.stream().map(product -> this.productToDto(product)).collect(Collectors.toList());
        return productDtos;
    }

    @Override
    public ResponseEntity<ProductDto> deleteProduct(@PathVariable Integer id) {
        Product Product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found with this id " + id));
        this.productRepository.deleteById(id);
        return null;
    }

    private Product dtoToProduct(ProductDto productDto) {
        Product product = modelMapper.map(productDto,Product.class);
        return product;
    }

    private ProductDto productToDto(Product product) {
        ProductDto productDto = modelMapper.map(product,ProductDto.class);
        return  productDto;
    }
}
