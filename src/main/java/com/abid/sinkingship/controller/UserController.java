package com.abid.sinkingship.controller;

import com.abid.sinkingship.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/getUsers")
    public String getUser() {
        //System.out.println("Getting users");

        // Need an interceptor now for this method call.
        userService.giveUser();

        return "Abid";
    }

    @PostMapping("/saveUsers")
    public String saveUser(){

        return "Saving User";
    }

    @DeleteMapping("/deleteUser")
    public String deleteUser(){
        System.out.println("Deleting user");
        return "Deleting User";
    }

    @PutMapping("/updateUser")
    public String updateUser(){
        System.out.println("Updating user");
        return "Updating User";
    }

}
