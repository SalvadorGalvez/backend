package com.galvez.salvador.backend.models;

import java.util.Date;

public class ErrorResponse {
    private String error;
    private String message;
    private int status;
    private Date timestamp;

    public ErrorResponse() {
        this.timestamp = new Date();
    }

    public ErrorResponse(String title, String message, int status) {
        this.error = title;
        this.message = message;
        this.status = status;
        this.timestamp = new Date();
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getTimestamp() {
        return timestamp;
    }
}
