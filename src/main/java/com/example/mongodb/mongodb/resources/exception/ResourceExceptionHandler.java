package com.example.mongodb.mongodb.resources.exception;

public class ResourceExceptionHandler extends RuntimeException{
    public static final long serialVersionUid = 1L;
    public ResourceExceptionHandler(String msg){
        super(msg);
    }
}
