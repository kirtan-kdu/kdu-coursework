package kdu.homework7.services;


import kdu.homework7.data.VehiclesInventory;
import kdu.homework7.entities.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

@Service
@Import({TataService.class, TeslaService.class})
@ComponentScan(basePackages = { "kdu.homework7.entities", "kdu.homework7.services"})
public class VehicleService implements IVehicleService{

    @Autowired
    public VehiclesInventory vehiclesInventory;

    @Autowired
    public TyreService tyreService;

    @Autowired
    public SpeakerService speakerService;

    Random random = new Random();


    @Bean
    public Vehicle generateVehicle(){
        Vehicle vehicle = new Vehicle();
        vehicle.setSpeaker(speakerService.generateSpeaker());
        vehicle.setTyre(tyreService.generateTyre());
        vehicle.setPriceTag(random.nextInt(10_000_000) + 100_000);
        return vehicle;
    }

    @PostConstruct
    @Bean(name = "vehicleGenerator")
    public void generateVehicleList(){
        List<Vehicle> vehicles = new ArrayList<>();
        for(int i=1;i<=20;i++){
            vehicles.add(generateVehicle());
        }
        vehiclesInventory.setListOfAllVehicles(vehicles);
    }

    @Bean(name = "mostExpensiveVehicle")
    public Vehicle mostExpensive(List<Vehicle> vehicleList){
        return vehicleList.stream().max(Comparator.comparing(Vehicle::getPriceTag)).orElse(new Vehicle());
    }
}
