package com.exceptions;

public class AlreadyPaidExceptio extends RuntimeException{
    public AlreadyPaidExceptio(String message) {
        super(message);
    }
}
