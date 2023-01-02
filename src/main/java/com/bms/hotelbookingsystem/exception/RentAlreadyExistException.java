package com.bms.hotelbookingsystem.exception;

public class RentAlreadyExistException extends RuntimeException {
    public RentAlreadyExistException(String message) {
        super(message);
    }
}
