package com.example.mongodb.mongodb.resources.exception;

public class StandardErrorException extends RuntimeException {
    public static final long serialVersionUid = 1L;
    public StandardErrorException(String msg){
        super(msg);
    }
}
