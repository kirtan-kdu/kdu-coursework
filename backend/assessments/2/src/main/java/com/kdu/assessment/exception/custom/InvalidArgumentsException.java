package com.kdu.assessment.exception.custom;

public class InvalidArgumentsException extends RuntimeException {
    public InvalidArgumentsException(String message){
        super(message);
    }
}
