package org.kdu.homework9.DTO.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.kdu.homework9.entities.Vehicle;

@Data
@AllArgsConstructor
public class VehicleDTO {

    private Vehicle vehicle;
}
