package com.kdu.smarthome.exceptions;

import com.kdu.smarthome.exceptions.custom.DuplicateEntryException;
import com.kdu.smarthome.exceptions.custom.NotAuthorizedException;
import com.kdu.smarthome.exceptions.custom.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {UserNotFoundException.class})
    public ResponseEntity<String > handleCustomException(UserNotFoundException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {DuplicateEntryException.class})
    public ResponseEntity<String > handleCustomException(DuplicateEntryException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {NotAuthorizedException.class})
    public ResponseEntity<String > handleCustomException(NotAuthorizedException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<String> allKindOfExceptions(Exception ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
