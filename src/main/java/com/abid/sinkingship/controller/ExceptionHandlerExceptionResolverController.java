package com.abid.sinkingship.controller;

import com.abid.sinkingship.customException.CustomException;
import com.abid.sinkingship.customException.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/api/v1")
public class ExceptionHandlerExceptionResolverController {

    private final HttpServletRequest httpServletRequest;

    public ExceptionHandlerExceptionResolverController(HttpServletRequest httpServletRequest) {
        this.httpServletRequest = httpServletRequest;
    }

    /*
            Instead of handling exceptions using try catch and creating response everytime.
            We can use @ExceptionalHandler(AnyException.class)
         */
    @GetMapping("/getUser1")
    public ResponseEntity<?> handleException(){
        // Simulates the code which can generate a Custom exception.
        throw new CustomException(HttpStatus.BAD_REQUEST, "Something is wrong");
    }

    @GetMapping("/getUSer2")
    public ResponseEntity<?> handleIAException(){
        throw new IllegalArgumentException("inappropriate exception");
    }

    /*
        This @ExceptionalHandler will take care of any CustomException thrown anywhere in this controller.
     */
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<?> handleCustomException(CustomException customException, HttpServletRequest request){
        ErrorResponse errorResponse = new ErrorResponse(new Date(),customException.getMessage(),customException.getHttpStatus().value(),httpServletRequest.getRequestURI());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    /*
        This will take care of IllegalArgumentException throw anywhere in this controller.
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> handleIAException(IllegalArgumentException illegalException, HttpServletRequest request){
        ErrorResponse errorResponse = new ErrorResponse(new Date(),illegalException.getMessage(),HttpStatus.BAD_REQUEST.value(),httpServletRequest.getRequestURI());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    /*
        Exceptions can be passed as a list of {Exception1, Exception2}
     */

}
