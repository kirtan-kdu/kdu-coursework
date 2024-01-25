package org.kdu.homework9.data;



import org.kdu.homework9.entities.Vehicle;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.List;


@Component
@Scope("prototype")
public class VehiclesInventory {

    private List<Vehicle> listOfAllVehicles;

    public Vehicle getVehicleWithMaxPrice(){
        return listOfAllVehicles.stream().max(Comparator.comparingDouble(Vehicle::getPriceTag)).orElse(null);
    }

    public Vehicle getVehicleWithMinPrice(){
        return listOfAllVehicles.stream().min(Comparator.comparingDouble(Vehicle::getPriceTag)).orElse(null);
    }
    public VehiclesInventory(){
        listOfAllVehicles = new ArrayList<>();
    }

    public List<Vehicle> getListOfAllVehicles() {
        return listOfAllVehicles;
    }

    public void setListOfAllVehicles(List<Vehicle> listOfAllVehicles) {
        this.listOfAllVehicles = listOfAllVehicles;
    }
}
