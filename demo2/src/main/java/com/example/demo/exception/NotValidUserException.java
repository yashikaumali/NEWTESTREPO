package com.example.demo.exception;

public class NotValidUserException extends RuntimeException {
    public NotValidUserException(String message) {
        super(message);
    }
}

