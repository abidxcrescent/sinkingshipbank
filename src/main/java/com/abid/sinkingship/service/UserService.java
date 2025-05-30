package com.abid.sinkingship.service;

import com.abid.sinkingship.customAnnotations.MyCustomAnnotation;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @MyCustomAnnotation(value = "user")
    public void giveUser(){
        System.out.println("Giving User");
    }

}
