package com.example.mongodb.mongodb.services.exception;

public class UserNotFoundException extends RuntimeException{
    public static final long serialVersionUid = 1L;
    public UserNotFoundException(String msg){
        super(msg);
    }
}
