package com.kdu.smarthome.dto.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class HouseListResponseDTO {
    private String houses;
    private String message;
    private HttpStatus httpStatus;
}
