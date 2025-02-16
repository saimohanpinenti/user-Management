package com.user.management.service;

import com.user.management.Exception.CustomException;
import com.user.management.Utility.UserRegistrationUtility;
import com.user.management.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManagementService {


    @Autowired
    UserRegistrationUtility userRegistrationUtility;

    public User validateAndRegisterUser(User user) throws CustomException {
        if(user != null){
            userRegistrationUtility.userValidator(user);
            userRegistrationUtility.createNewUser(user);
            return user;

        }
        else {
            throw  new CustomException("Something went wrong");
        }


    }

    public Object userLogin(User user){

        return userRegistrationUtility.checkLoggedInUser(user);
    }

    public List<User> getAllUser(){

        return  userRegistrationUtility.getAllUsers();
    }
}
