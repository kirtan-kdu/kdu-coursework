package org.kdu.homework9.services;


import org.kdu.homework9.DTO.ErrorDTO.ErrorDTO;
import org.kdu.homework9.DTO.ErrorDTO.VehicleErrorDTO;
import org.kdu.homework9.DTO.request.UpdateVehicleDTO;
import org.kdu.homework9.DTO.request.VehicleDTO;
import org.kdu.homework9.DTO.request.VehicleIdDTO;
import org.kdu.homework9.DTO.request.VehicleOperatoinDTO;
import org.kdu.homework9.DTO.response.ResMessageDTO;
import org.kdu.homework9.DTO.response.ResVehicleDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.kdu.homework9.entities.Vehicle;
import org.kdu.homework9.exceptions.VehicleException;
import org.kdu.homework9.repository.VehicleRepository;
import org.kdu.homework9.utils.RandomNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.util.*;

@Service
@Import({TataService.class, TeslaService.class})
@ComponentScan(basePackages = { "kdu.homework9.entities", "kdu.homework9.services"})
public class VehicleService implements IVehicleService{

    private final Logger logger = LoggerFactory.getLogger(VehicleService.class);

    @Value("${spring.profiles.active:}")
    private String activeProfile;

    @Autowired
    public VehicleRepository vehicleRepository;
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
    private void generateVehicles(){
        if(activeProfile.equalsIgnoreCase("prod"))generateVehicleListForProd();
        else generateVehicleListForDev();
    }
    public void generateVehicleListForDev(){
        List<Vehicle> vehicles = new ArrayList<>();
        for(int i=1;i<=200;i++){
            vehicles.add(generateVehicle());
        }
        vehicleRepository.addAllVehicles(vehicles);
        logger.debug("Vehicles generated successfully!");
    }

    public void generateVehicleListForProd(){
        List<Vehicle> vehicles = new ArrayList<>();
        for(int i=1;i<=20;i++){
            vehicles.add(generateVehicle());
        }
        vehicleRepository.addAllVehicles(vehicles);
        logger.debug("Vehicles generated successfully!");

    }




    public Vehicle mostExpensive(){
        return vehicleRepository.getAllvehicles().stream().max(Comparator.comparing(Vehicle::getPriceTag)).orElse(new Vehicle());
    }

    public Vehicle leastExpensive(){
        return vehicleRepository.getAllvehicles().stream().min(Comparator.comparing(Vehicle::getPriceTag)).orElse(new Vehicle());
    }

    public ResVehicleDTO addVehicle(VehicleDTO vehicleDTO){
        try {
            vehicleRepository.addVehicle(vehicleDTO);
            logger.info("Vehicle added successfully!");
            return new ResVehicleDTO("Successfully added vehicle", vehicleDTO.getVehicle());
        }
        catch (Exception ex){
            logger.error("Exception while adding vehicle");
            throw new VehicleException(new VehicleErrorDTO(vehicleDTO.getVehicle(),"Error while adding vehicle", HttpStatus.INSUFFICIENT_STORAGE));
        }
    }

    public ResVehicleDTO getVehicle(int id){
        if (vehicleRepository.getSize()<=id) throw new VehicleException(new ErrorDTO( "Invalid id " + id + " is passed", HttpStatus.BAD_REQUEST));
        return new ResVehicleDTO("Successful retrieval", vehicleRepository.getVehicle(id));
    }

    public ResMessageDTO updateVehicle(UpdateVehicleDTO updateVehicleDTO){
        try{
            vehicleRepository.updateVehicle(updateVehicleDTO);
            logger.info("Updated vehicle list");
            return new ResMessageDTO("Successfully updated vehicle list");
        }
        catch (Exception ex){
            logger.error("Exception thrown while updating vehicle");
            throw new VehicleException(new ErrorDTO("Error while updating vehicle", HttpStatus.CONFLICT));
        }
    }

    public ResMessageDTO deleteVehicle(VehicleIdDTO vehicleIdDTO){
        try {
            vehicleRepository.deleteVehicle(vehicleIdDTO);
            logger.info("Vehicle deleted successfully!");
            return new ResMessageDTO("Successfully deleted vehicle");
        }
        catch (Exception ex){
            logger.error("Exception while adding vehicle");
            throw new VehicleException(new ErrorDTO("Invalid vehicle Id", HttpStatus.BAD_REQUEST));
        }
    }

    public ResVehicleDTO performOperation(VehicleOperatoinDTO operatoinDTO){
        if (operatoinDTO.getOperation().equalsIgnoreCase("min"))return new ResVehicleDTO("Vehicle with minimum price is as shown below: ", leastExpensive());
        else if(operatoinDTO.getOperation().equalsIgnoreCase("max"))return new ResVehicleDTO("vehicle with maximum price is as shown below: ", mostExpensive());
        logger.error("Exception while fetching min-max priced vehicle");
        throw new VehicleException(new ErrorDTO("Invalid operation is selected", HttpStatus.BAD_REQUEST));
    }

}
