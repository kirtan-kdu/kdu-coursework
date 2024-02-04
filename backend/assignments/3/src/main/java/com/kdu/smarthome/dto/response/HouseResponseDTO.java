package com.kdu.smarthome.dto.response;


import com.kdu.smarthome.models.House;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HouseResponseDTO {
    private House house;
    private String resMessage;
    private HttpStatus httpStatus;
}
