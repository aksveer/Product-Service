package com.akshay.microservices.ProductService.service;

import com.akshay.microservices.ProductService.model.ProductRequest;
import com.akshay.microservices.ProductService.model.ProductResponse;

public interface ProductService {
    long addProduct(ProductRequest productRequest);

    ProductResponse getProductById(Long productId);
}
