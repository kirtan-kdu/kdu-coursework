package org.kdu.homework9.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(VehicleException.class)
    public ResponseEntity<String> handleCustomException(VehicleException ex) {
        // You can customize the error response as per your needs
        return new ResponseEntity<>(ex.getMessage() + "\n" + ex.getVehicleString(), HttpStatus.BAD_REQUEST);
    }

}

