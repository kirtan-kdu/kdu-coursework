package org.kdu.homework8.services;


import org.kdu.homework8.DTO.request.UpdateVehicleDTO;
import org.kdu.homework8.DTO.request.VehicleDTO;
import org.kdu.homework8.DTO.request.VehicleIdDTO;
import org.kdu.homework8.DTO.request.VehicleOperatoinDTO;
import org.kdu.homework8.DTO.response.ResMessageDTO;
import org.kdu.homework8.DTO.response.ResVehicleDTO;
import org.kdu.homework8.data.VehiclesInventory;
import org.kdu.homework8.entities.Vehicle;
import org.kdu.homework8.exceptions.CustomException;
import org.kdu.homework8.utils.RandomNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.util.*;

@Service
@Import({TataService.class, TeslaService.class})
@ComponentScan(basePackages = { "kdu.homework8.entities", "kdu.homework8.services"})
public class VehicleService implements IVehicleService{

    @Autowired
    public VehiclesInventory vehiclesInventory;

    @Autowired
    public TyreService tyreService;

    @Autowired
    public SpeakerService speakerService;

    public double getTax(){
        return 1;
    }

    public Vehicle generateVehicle(){
        Vehicle vehicle = new Vehicle();
        vehicle.setSpeaker(speakerService.generateSpeaker());
        vehicle.setTyre(tyreService.generateTyre());
        vehicle.setPriceTag((int) ((RandomNumber.generate(10_000_000) + 100_000) * getTax()));
        return vehicle;
    }

    @PostConstruct
    public void generateVehicleList(){
        List<Vehicle> vehicles = new ArrayList<>();
        for(int i=1;i<=20;i++){
            vehicles.add(generateVehicle());
        }
        vehiclesInventory.setListOfAllVehicles(vehicles);
    }

    public Vehicle mostExpensive(){
        return this.vehiclesInventory.getListOfAllVehicles().stream().max(Comparator.comparing(Vehicle::getPriceTag)).orElse(new Vehicle());
    }

    public Vehicle leastExpensive(){
        return this.vehiclesInventory.getListOfAllVehicles().stream().min(Comparator.comparing(Vehicle::getPriceTag)).orElse(new Vehicle());
    }

    public ResVehicleDTO addVehicle(VehicleDTO vehicleDTO){
        try {
            this.vehiclesInventory.getListOfAllVehicles().add(vehicleDTO.getVehicle());
            return new ResVehicleDTO("Successfully added vehicle", vehicleDTO.getVehicle());
        }
        catch (Exception ex){
            throw new CustomException("Error while adding vehicle");
        }
    }

    public ResVehicleDTO getVehicle(int id){
        if (vehiclesInventory.getListOfAllVehicles().size()<=id) throw new CustomException("Invalid id is passed");
        return new ResVehicleDTO("Successful retrieval", vehiclesInventory.getListOfAllVehicles().get(id));
    }

    public ResMessageDTO updateVehicle(UpdateVehicleDTO updateVehicleDTO){
        try{
            this.vehiclesInventory.getListOfAllVehicles().set(updateVehicleDTO.getOldVehicleId(),updateVehicleDTO.getNewVehicle());
            return new ResMessageDTO("Succfully updated vehicle list");
        }
        catch (Exception ex){
            throw new CustomException("Error while updating vehicle");
        }
    }

    public ResMessageDTO deleteVehicle(VehicleIdDTO vehicleIdDTO){
        try {
            vehiclesInventory.getListOfAllVehicles().remove(vehicleIdDTO.getVehicleID());
            return new ResMessageDTO("Successfully deleted vehicle");
        }
        catch (Exception ex){
            throw new CustomException("Invalid vehicle Id");
        }
    }

    public ResVehicleDTO performOperation(VehicleOperatoinDTO operatoinDTO){
        if (operatoinDTO.getOperation().equalsIgnoreCase("min"))return new ResVehicleDTO("Vehicle with minimum price is as shown below: ", leastExpensive());
        else if(operatoinDTO.getOperation().equalsIgnoreCase("max"))return new ResVehicleDTO("vehicle with maximum price is as shown below: ", mostExpensive());

        throw new CustomException("Invalid operation is selected");
    }

}
