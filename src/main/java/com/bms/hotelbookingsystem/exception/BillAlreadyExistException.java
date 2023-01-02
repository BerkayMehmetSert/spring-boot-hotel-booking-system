package com.bms.hotelbookingsystem.exception;

public class BillAlreadyExistException extends RuntimeException {
    public BillAlreadyExistException(String message) {
        super(message);
    }
}
