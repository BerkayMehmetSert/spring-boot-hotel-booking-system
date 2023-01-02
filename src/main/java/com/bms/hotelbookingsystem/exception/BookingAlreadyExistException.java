package com.bms.hotelbookingsystem.exception;

public class BookingAlreadyExistException extends RuntimeException {
    public BookingAlreadyExistException(String message) {
        super(message);
    }
}
