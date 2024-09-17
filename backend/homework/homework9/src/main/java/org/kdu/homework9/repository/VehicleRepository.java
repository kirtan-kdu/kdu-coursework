package org.kdu.homework9.repository;


import org.kdu.homework9.DTO.request.UpdateVehicleDTO;
import org.kdu.homework9.DTO.request.VehicleDTO;
import org.kdu.homework9.DTO.request.VehicleIdDTO;
import org.kdu.homework9.data.VehiclesInventory;
import org.kdu.homework9.entities.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VehicleRepository {

    @Autowired
    private VehiclesInventory vehiclesInventory;

    public VehiclesInventory getVehiclesInventory() {
        return vehiclesInventory;
    }

    public void setVehiclesInventory(VehiclesInventory vehiclesInventory) {
        this.vehiclesInventory = vehiclesInventory;
    }

    public Vehicle getVehicle(int id){
        return vehiclesInventory.getListOfAllVehicles().get(id);
    }
    public List<Vehicle> getAllvehicles(){
        return vehiclesInventory.getListOfAllVehicles();
    }

    public void addVehicle(VehicleDTO vehicleDTO){
        vehiclesInventory.getListOfAllVehicles().add(vehicleDTO.getVehicle());
    }

    public void addAllVehicles(List<Vehicle> vehicleList){
        vehiclesInventory.setListOfAllVehicles(vehicleList);
    }

    public void updateVehicle(UpdateVehicleDTO updateVehicleDTO){
        vehiclesInventory.getListOfAllVehicles().set(updateVehicleDTO.getOldVehicleId(), updateVehicleDTO.getNewVehicle());
    }

    public int getSize(){
        return vehiclesInventory.getListOfAllVehicles().size();
    }

    public void deleteVehicle(VehicleIdDTO vehicleIdDTO){
        vehiclesInventory.getListOfAllVehicles().remove(vehicleIdDTO.getVehicleID());
    }

}
