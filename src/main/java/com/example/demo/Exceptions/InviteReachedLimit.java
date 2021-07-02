package com.example.demo.Exceptions;

public class InviteReachedLimit  extends RuntimeException {

    public InviteReachedLimit(String message) {
        super(message);
    }
}
