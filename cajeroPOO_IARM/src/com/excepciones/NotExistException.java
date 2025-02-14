package com.excepciones;

public class NotExistException extends RuntimeException{
    public NotExistException(String message) {
        super(message);
    }
}
