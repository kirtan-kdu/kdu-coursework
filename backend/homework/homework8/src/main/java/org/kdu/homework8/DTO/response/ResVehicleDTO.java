package org.kdu.homework8.DTO.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.kdu.homework8.entities.Vehicle;


@Data
@AllArgsConstructor
public class ResVehicleDTO {

    private String message;

    private Vehicle vehicle;

}
