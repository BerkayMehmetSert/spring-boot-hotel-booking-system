package com.bms.hotelbookingsystem.exception;

public class RoomTypeNotFoundException extends RuntimeException {
    public RoomTypeNotFoundException(String message) {
        super(message);
    }
}
