package org.kdu.homework8.DTO.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.kdu.homework8.entities.Vehicle;

@Data
@AllArgsConstructor
public class VehicleDTO {

    private Vehicle vehicle;
}
