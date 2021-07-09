package com.example.demo.Exceptions;

public class SameSenderLimit extends RuntimeException {
    public SameSenderLimit(String message) {
        super(message);
    }
}
