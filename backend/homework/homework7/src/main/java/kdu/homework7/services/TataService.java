package kdu.homework7.services;

import kdu.homework7.data.VehiclesInventory;
import kdu.homework7.entities.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class TataService extends VehicleService {

    @Autowired
    @Qualifier("tataInventory")
    public VehiclesInventory tataInventory;

    @Bean
    @Override
    public Vehicle generateVehicle(){
        Vehicle vehicle = new Vehicle();
        vehicle.setSpeaker(speakerService.generateSpeaker());
        vehicle.setTyre(tyreService.generateTyre());
        vehicle.setPriceTag((int) ((random.nextInt(10_000_000) + 100_000)* 1.1));
        return vehicle;
    }

    @Override
    @PostConstruct
    @Bean(name = "vehicleGenerator")
    public void generateVehicleList(){
        List<Vehicle> vehicles = new ArrayList<>();
        for(int i=1;i<=20;i++){
            vehicles.add(generateVehicle());
        }
        tataInventory.setListOfAllVehicles(vehicles);
    }



}
