package com.abid.sinkingship.customException;

import org.springframework.http.HttpStatus;

public class CustomException extends RuntimeException {

    HttpStatus httpStatus;
    String message;

    public CustomException(HttpStatus httpStatus, String message) {
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
