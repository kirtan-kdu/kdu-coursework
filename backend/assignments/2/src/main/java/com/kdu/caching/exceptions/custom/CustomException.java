package com.kdu.caching.exceptions.custom;

import com.kdu.caching.dto.error.ErrorDTO;

public class CustomException extends RuntimeException{

    public CustomException(ErrorDTO errorDTO){
        super(errorDTO.getMessage());
    }

}
