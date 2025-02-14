package com.exceptions;

public class AlreadyPaidException extends RuntimeException {
    public AlreadyPaidException(String message) {

        super(message);
    }
}
