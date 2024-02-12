package com.kdu.caching.dto.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseCoordinateDTO {

    private String coordinate;
    private HttpStatus httpStatus;

}
