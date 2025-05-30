package com.abid.sinkingship.customException;


import java.util.Date;

public class ErrorResponse {

    private Date timestamp;
    private String message;
    private int httpStatus;
    private String path;

    public ErrorResponse(Date timestamp, String message, int httpStatus, String path) {
        this.timestamp = timestamp;
        this.message = message;
        this.httpStatus = httpStatus;
        this.path = path;
    }

    public Date getTimestamp() {
        return timestamp;
    }


    public String getMessage() {
        return message;
    }

    public int getHttpStatus() {
        return httpStatus;
    }

    public String getPath() {
        return path;
    }
}
