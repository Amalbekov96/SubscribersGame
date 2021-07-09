package com.example.demo.Exceptions;

public class ReceiverAlreadyActivated extends RuntimeException{
    public ReceiverAlreadyActivated(String message) {
        super(message);
    }
}
