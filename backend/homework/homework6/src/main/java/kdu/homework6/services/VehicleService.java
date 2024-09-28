package kdu.homework6.services;


import kdu.homework6.entities.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@ComponentScan(basePackages = { "kdu.homework6.entities", "kdu.homework6.services"})
public class VehicleService {

    @Autowired
    private TyreService tyreService;

    @Autowired
    private SpeakerService speakerService;

    Random random = new Random();


    @Bean
    public Vehicle generateVehicle(){
        Vehicle vehicle = new Vehicle();
        vehicle.setSpeaker(speakerService.generateSpeaker());
        vehicle.setTyre(tyreService.generateTyre());
        vehicle.setPriceTag(random.nextInt(10_000_000) + 100_000);

        return vehicle;
    }
    @Bean(name = "vehicleGenerator")
    public List<Vehicle> generateVehicleList(){
        List<Vehicle> vehicles = new ArrayList<>();
        for(int i=1;i<=20;i++){
            vehicles.add(generateVehicle());
        }

        return vehicles;
    }

    @Bean(name = "mostExpenciveVehicle")
    public Vehicle mostExpecive(List<Vehicle> vehicleList){
        return vehicleList.stream().max(Comparator.comparing(Vehicle::getPriceTag)).orElse(new Vehicle());
    }
}
