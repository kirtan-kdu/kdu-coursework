package org.kdu.homework9.exceptions;

import org.kdu.homework9.DTO.ErrorDTO.ErrorDTO;
import org.kdu.homework9.DTO.ErrorDTO.VehicleErrorDTO;

public class VehicleException extends RuntimeException {

    private String vehicleString;

    public String getVehicleString() {
        return vehicleString;
    }

    public void setVehicleString(String vehicleString) {
        this.vehicleString = vehicleString;
    }

    public VehicleException(VehicleErrorDTO vehicleErrorDTO) {
        super(vehicleErrorDTO.getErrorMsg());
        this.vehicleString = vehicleErrorDTO.getVehicle().toString();
    }

    public VehicleException(ErrorDTO errorDTO){
        super(errorDTO.getErrorMsg());
        this.vehicleString = "";
    }

}

