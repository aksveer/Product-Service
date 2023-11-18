package com.akshay.microservices.ProductService.exception;

public class ProductServiceCustomException extends RuntimeException{
    private String errorCode;

    public ProductServiceCustomException(String errorCode, String message){
        super(message);
        this.errorCode = errorCode;
    }
}
