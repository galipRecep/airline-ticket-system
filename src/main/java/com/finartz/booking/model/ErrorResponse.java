package com.finartz.booking.model;

public class ErrorResponse {

    private int status;
    private String message;

    public ErrorResponse() {
    }

    public int getStatus() {
        return status;
    }

    public ErrorResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}