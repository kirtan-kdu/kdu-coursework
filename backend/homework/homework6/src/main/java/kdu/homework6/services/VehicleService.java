package kdu.homework6.services;


import kdu.homework6.entities.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@ComponentScan(basePackages = { "kdu.homework6.entities", "kdu.homework6.services"})
public class VehicleService {

    @Autowired
    private TyreService tyreService;

    @Autowired
    private SpeakerService speakerService;


    @Bean
    public Vehicle generateVehicle(){
        Random random = new Random();

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
        return vehicleList.stream().reduce((vehicle1,vehicle2) -> vehicle1.getPriceTag()>vehicle2.getPriceTag()?vehicle1:vehicle2);
    }
}
