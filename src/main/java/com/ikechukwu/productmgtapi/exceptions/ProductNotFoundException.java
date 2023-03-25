package com.ikechukwu.productmgtapi.exceptions;

public class ProductNotFoundException extends RuntimeException{

    public ProductNotFoundException(String message){
        super(message);
    }

}
