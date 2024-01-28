package com.kdu.caching.exceptions.custom;


import com.kdu.caching.dto.error.ErrorDTO;

public class InvalidArgumentsException extends RuntimeException {

    public InvalidArgumentsException(ErrorDTO errorDTO) {
        super(errorDTO.getMessage());
    }

}
