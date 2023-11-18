package com.akshay.microservices.ProductService.repository;

import com.akshay.microservices.ProductService.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRespository extends JpaRepository<Product, Long> {
}
