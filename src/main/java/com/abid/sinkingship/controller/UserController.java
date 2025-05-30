package com.abid.sinkingship.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @GetMapping("/getUsers")
    public String getUser() {
        System.out.println("Getting users");
        return "Abid";
    }

    @PostMapping("/saveUsers")
    public String saveUser(){
        System.out.println("Saving user");
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
