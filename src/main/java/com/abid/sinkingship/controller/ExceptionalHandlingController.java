package com.abid.sinkingship.controller;

import com.abid.sinkingship.customException.CustomException;
import com.abid.sinkingship.customException.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/api")
public class ExceptionalHandlingController {

    @GetMapping("/get-items")
    public String getItems(){
        //return "Hello World";
        throw new NullPointerException("NullPointerException in get-items");
    }

    /*
        If we just throw an exception in SpringBoot without wrapping it around ResponseEntity
        SpringBoot internally wraps it to ResponseEntity with default value as
        InternalServerError 500 code.
     */
    @GetMapping("/get-itemsCE")
    public String getItemsWithCustomException(){
        //return "Hello World";
        throw new CustomException(HttpStatus.OK, "CustomException");
    }

    /*
        To avoid this we can create our own custom response and send it
        as body of ResponseEntity.
        eg.
        {
            "timestamp": "2025-05-30T23:45:37.481+00:00",
            "message": "CustomException",
            "httpStatus": 400,
            "path": "/api/get-itemsRE"
        }
     */
    @GetMapping("/get-itemsRE")
    public ResponseEntity<?> getResponseEntity(HttpServletRequest request){

        try {
            // Code simulating exception trigger
            throw new CustomException(HttpStatus.BAD_REQUEST, "CustomException");

        }catch (CustomException e){
            ErrorResponse errorResponse = new ErrorResponse(new Date(),e.getMessage(),e.getHttpStatus().value(),request.getRequestURI());
            return new ResponseEntity<>(errorResponse, e.getHttpStatus());

        }catch (Exception e){
            ErrorResponse errorResponse = new ErrorResponse(new Date(),e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR.value(),request.getRequestURI());
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }



}
