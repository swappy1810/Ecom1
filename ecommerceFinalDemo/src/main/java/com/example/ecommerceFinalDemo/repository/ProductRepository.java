package com.example.ecommerceFinalDemo.repository;

import com.example.ecommerceFinalDemo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {



}
