package com.exception;

public class AlReadyPaidException extends RuntimeException{
    public AlReadyPaidException(String message) {
        super(message);
    }
}
