package com.user.management.Exception;

public class CustomException extends  Exception{

    public CustomException(String message) {
        super(message);
    }

    public CustomException(String message, Throwable cause) {
        super(message, cause);
    }
}
