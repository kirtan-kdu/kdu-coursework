package com.kdu.smarthome.exceptions.custom;



public class NotAuthorizedException extends RuntimeException {
    public NotAuthorizedException(String message){
        super(message);
    }
}
