package com.sebastian.service;

public class ProductInExistenceException extends RuntimeException {
    public ProductInExistenceException(String message){
        super(message);
    }
}
