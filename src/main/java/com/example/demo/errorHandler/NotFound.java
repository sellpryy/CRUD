package com.example.demo.errorHandler;

public class NotFound extends RuntimeException {
    String resourceName;
    String fieldName;
    Object fieldValue;

    public NotFound(String resourceName, String fieldName, Object fieldValue){
        this.resourceName =resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
}}
