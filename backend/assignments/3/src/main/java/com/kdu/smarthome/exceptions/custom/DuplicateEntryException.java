package com.kdu.smarthome.exceptions.custom;

public class DuplicateEntryException extends RuntimeException {
    public DuplicateEntryException(String message){
        super(message);
    }
}
