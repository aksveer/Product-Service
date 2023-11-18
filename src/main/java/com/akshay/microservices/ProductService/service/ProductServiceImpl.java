package com.akshay.microservices.ProductService.service;

import com.akshay.microservices.ProductService.entity.Product;
import com.akshay.microservices.ProductService.exception.ProductServiceCustomException;
import com.akshay.microservices.ProductService.model.ProductRequest;
import com.akshay.microservices.ProductService.model.ProductResponse;
import com.akshay.microservices.ProductService.repository.ProductRespository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.springframework.beans.BeanUtils.*;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRespository productRespository;
    @Override
    public long addProduct(ProductRequest productRequest) {
        log.info("Adding Product");

        Product product = Product.builder()
                .productName(productRequest.getName())
                .price(productRequest.getPrice())
                .quantity(productRequest.getQuantity())
                .build();
        productRespository.save(product);

        log.info("Product Added");
        return product.getProductId();
    }

    @Override
    public ProductResponse getProductById(Long productId) {
        log.info("Getting Product By Id");
        Product product = productRespository.findById(productId)
                .orElseThrow(() -> new ProductServiceCustomException("Product Not Found", "Product Not Found"));
        ProductResponse productResponse = new ProductResponse();
        copyProperties(product, productResponse);
        return productResponse;
    }
}
