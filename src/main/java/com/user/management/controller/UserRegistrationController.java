package com.user.management.controller;

import com.user.management.Exception.CustomException;
import com.user.management.model.User;
import com.user.management.service.UserManagementService;
import org.apache.logging.log4j.util.SystemPropertiesPropertySource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserRegistrationController {

    @Autowired
    UserManagementService userManagementService;

    @PostMapping("/creatUser")
    public ResponseEntity<?> CreateUser( @RequestBody User user) {
        System.out.println("User"+user.toString());
        try {
            User returnedUser  =  userManagementService.validateAndRegisterUser(user);
            return  ResponseEntity.ok(returnedUser);
        }
        catch (CustomException ex){
            ex.printStackTrace();
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);

        }

    }
}
