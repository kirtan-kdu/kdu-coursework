package kdu.homework6;

import kdu.homework6.entities.Vehicle;
import kdu.homework6.services.VehicleService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Optional;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        AnnotationConfigApplicationContext vehicleContext = new AnnotationConfigApplicationContext(VehicleService.class);

        List<Vehicle> vehicleList = (List<Vehicle>) vehicleContext.getBean("vehicleGenerator");

        System.out.println("Here is the list of generated vehicles,");
        vehicleList.forEach(vehicle -> System.out.println(vehicle.toString()));

        Optional<Vehicle> mostExpenciveVehicle = (Optional<Vehicle>) vehicleContext.getBean("mostExpenciveVehicle", vehicleList);
        System.out.println("\n\nMost expensice vehicle is: " + mostExpenciveVehicle.get().toString());
    }
}