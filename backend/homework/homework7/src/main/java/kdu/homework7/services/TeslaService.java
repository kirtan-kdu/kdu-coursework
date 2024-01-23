package kdu.homework7.services;

import kdu.homework7.data.VehiclesInventory;
import kdu.homework7.entities.Vehicle;
import kdu.homework7.utils.RandomNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class TeslaService extends VehicleService {

    @Autowired
    @Qualifier("teslaInventory")
    public VehiclesInventory teslaInventory;

    @Bean
    @Override
    public Vehicle generateVehicle(){
        Vehicle vehicle = new Vehicle();
        vehicle.setSpeaker(speakerService.generateSpeaker());
        vehicle.setTyre(tyreService.generateTyre());
        vehicle.setPriceTag((int) ((RandomNumber.generate(10_000_000) + 100_000)* 1.4));
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
        teslaInventory.setListOfAllVehicles(vehicles);
    }

}
