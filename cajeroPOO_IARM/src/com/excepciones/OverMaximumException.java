package com.excepciones;

public class OverMaximumException extends RuntimeException{
    public OverMaximumException(String message) {
        super(message);
    }
}
