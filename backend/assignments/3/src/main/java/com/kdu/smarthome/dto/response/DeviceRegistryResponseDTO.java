package com.kdu.smarthome.dto.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeviceRegistryResponseDTO {
    private String message;
    private String deviceRegistry;
    private HttpStatus httpStatus;
}
