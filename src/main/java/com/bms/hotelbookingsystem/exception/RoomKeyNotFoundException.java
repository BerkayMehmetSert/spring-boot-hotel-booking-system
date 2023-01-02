package com.bms.hotelbookingsystem.exception;

public class RoomKeyNotFoundException extends RuntimeException {
    public RoomKeyNotFoundException(String message) {
        super(message);
    }
}
