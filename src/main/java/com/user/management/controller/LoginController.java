package com.user.management.controller;

import com.user.management.model.User;
import com.user.management.service.UserManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class LoginController {

    @Autowired
    UserManagementService userManagementService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
       Object response =  userManagementService.userLogin(user);
        return  ResponseEntity.ok(response);

    }

    @GetMapping("/getUsers")
    public ResponseEntity<?> getAllUsers(){
        return ResponseEntity.ok(userManagementService.getAllUser());
    }
}
