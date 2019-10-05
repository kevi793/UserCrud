package com.sc.interview.crudapp.exception;

public class AddressDoesNotExistException extends Exception {
    public AddressDoesNotExistException(String message) {
        super(message);
    }
}
