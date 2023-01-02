package com.bms.hotelbookingsystem.exception;

public class BookingDateAlreadyExistException extends RuntimeException {
    public BookingDateAlreadyExistException(String message) {
        super(message);
    }
}
