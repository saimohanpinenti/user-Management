package com.user.management.Utility;

import com.user.management.Exception.CustomException;
import com.user.management.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Component
public class UserRegistrationUtility {

    List<User> users  = new ArrayList();
    double latestEmployeeId = 100000;

    public boolean userValidator(User user) throws CustomException {

        if((user != null) && user.getName() != null && user.getEmail() != null &&
        user.getPassword() != null ){
            if(!emailValidator(user.getEmail())){
                throw new CustomException("Invalid Email Id");
            }
            if (!isValidPassword(user.getPassword())){
                throw new CustomException("Weak Password");
            }

            //add email validator as well.
            //check if DB already contain the same email. and throw
            // error if the DB contain the same email address and ask to change the email address.
            //Throw Custom exceptions for Invalid user name password and if email already exists.


            return true;
        }
        else{
            throw new CustomException("Invalid User details");
        }

    }

    public boolean emailValidator(String email){
        String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
        return Pattern.matches(emailRegex, email);
    }

    public  boolean isValidPassword(String password) {
        String passwordRegex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
        return Pattern.matches(passwordRegex, password);
    }

    public void createNewUser(User user) {
        user.setEmployeeId(latestEmployeeId++);;
     this.users.add(user);
    }

//    public double generateEmployeeId(){
//        return
//    }
}
