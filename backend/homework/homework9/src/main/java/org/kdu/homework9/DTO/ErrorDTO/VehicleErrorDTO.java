package org.kdu.homework9.DTO.ErrorDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.kdu.homework9.entities.Vehicle;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class VehicleErrorDTO {

    private Vehicle vehicle;
    private String errorMsg;
    private HttpStatus status;

}
