package com.finartz.booking.exception;

import com.finartz.booking.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AirportException {

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(Exception exception) {
        ErrorResponse userErrorResponse = new ErrorResponse();
        userErrorResponse.setMessage(exception.getMessage());
        userErrorResponse.setStatus(HttpStatus.BAD_REQUEST.value());

        return new ResponseEntity<>(userErrorResponse, HttpStatus.BAD_REQUEST);
    }
}
