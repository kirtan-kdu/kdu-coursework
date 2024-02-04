package com.kdu.smarthome.exceptions.custom;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String username){
        super("User not found with username: " + username);
    }
}
