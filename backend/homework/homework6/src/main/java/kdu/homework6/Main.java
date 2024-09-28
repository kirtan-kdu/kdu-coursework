package kdu.homework6;

import kdu.homework6.entities.Vehicle;
import kdu.homework6.services.VehicleService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        ConsoleLogger.warnMethod("Hello and welcome!");

        AnnotationConfigApplicationContext vehicleContext = new AnnotationConfigApplicationContext(VehicleService.class);

        List<Vehicle> vehicleList = (List<Vehicle>) vehicleContext.getBean("vehicleGenerator");

        ConsoleLogger.warnMethod("Here is the list of generated vehicles,");
        vehicleList.forEach(vehicle -> ConsoleLogger.infoMethod(vehicle.toString()));

        Vehicle mostExpenciveVehicle = (Vehicle) vehicleContext.getBean("mostExpenciveVehicle", vehicleList);
        ConsoleLogger.warnMethod("\n\nMost expensice vehicle is: " + mostExpenciveVehicle.getPriceTag());
    }
}