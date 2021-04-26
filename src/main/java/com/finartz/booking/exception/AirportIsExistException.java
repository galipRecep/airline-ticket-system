package com.finartz.booking.exception;

public class AirportIsExistException extends RuntimeException {

    public AirportIsExistException(String message) {
        super(message);
    }

    public AirportIsExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public AirportIsExistException(Throwable cause) {
        super(cause);
    }
}
