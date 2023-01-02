package com.bms.hotelbookingsystem.exception;

public class RoomRatingAlreadyExistException extends RuntimeException {
    public RoomRatingAlreadyExistException(String message) {
        super(message);
    }
}
