package com.akshay.microservices.ProductService.exception;

import com.akshay.microservices.ProductService.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ProductServiceCustomException.class)
    public ResponseEntity<ErrorResponse> handleProductServiceException(ProductServiceCustomException exception){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorCode(exception.getErrorCode());
        errorResponse.setErrorMessage(exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

}
