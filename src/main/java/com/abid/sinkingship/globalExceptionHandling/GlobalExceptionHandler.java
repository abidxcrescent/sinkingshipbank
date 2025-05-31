package com.abid.sinkingship.globalExceptionHandling;

import com.abid.sinkingship.customException.CustomException;
import com.abid.sinkingship.customException.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

/*
    A centralized place for storing all @ExceptionalHandler.
    Priority will be given to local @ExceptionalHandler
    Priority will be given to Child Exception
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<?> handleCustomException(CustomException ex, HttpServletRequest request) {

        ErrorResponse errorResponse = new ErrorResponse(new Date(), ex.getMessage(), ex.getHttpStatus().value(),request.getRequestURI());
        return new ResponseEntity<>(errorResponse, ex.getHttpStatus());

    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> handleGlobalException(RuntimeException ex, HttpServletRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(new Date(), ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value(), request.getRequestURI());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
