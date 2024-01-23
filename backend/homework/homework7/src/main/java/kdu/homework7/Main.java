package kdu.homework7;

import kdu.homework7.config.appconfig;
import kdu.homework7.data.VehiclesInventory;
import kdu.homework7.entities.Vehicle;
import kdu.homework7.services.VehicleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Condition;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");


        /*
         * Homework - 6
         */

         final Logger logger = LoggerFactory.getLogger(Main.class);

//        AnnotationConfigApplicationContext vehicleContext = new AnnotationConfigApplicationContext(VehicleService.class);
//
//        List<Vehicle> vehicleList = (List<Vehicle>) vehicleContext.getBean("vehicleGenerator");
//
//        ConsoleLogger.warnMethod("Here is the list of generated vehicles,");
//        vehicleList.forEach(vehicle -> ConsoleLogger.infoMethod(vehicle.toString()));
//
//        Vehicle mostExpenciveVehicle = (Vehicle) vehicleContext.getBean("mostExpensiveVehicle", vehicleList);
//        ConsoleLogger.warnMethod("\n\nMost expensive vehicle is: " + mostExpenciveVehicle.getPriceTag());


        /**
         * Homework - 7
         */

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(appconfig.class);

        VehiclesInventory tataInventory = (VehiclesInventory) context.getBean("TataInventory");
        VehiclesInventory teslaInventory = (VehiclesInventory) context.getBean("TeslaInventory");

        logger.warn("\n\n\nHello! Its Kirtan here.");
        logger.info("The size of Tata inventory: " + tataInventory.getListOfAllVehicles().size());
        logger.info("The size of Tesla inventory: " + teslaInventory.getListOfAllVehicles().size());

        logger.warn("\n\nFor Tesla inventory,");
        System.out.println("Max priced" + teslaInventory.getVehicleWithMaxPrice().toString());
        System.out.println("Min priced" + teslaInventory.getVehicleWithMinPrice().toString());

        logger.warn("\n\nFor Tata inventory,");
        System.out.println("Max priced" + tataInventory.getVehicleWithMaxPrice().toString());
        System.out.println("Min priced" + tataInventory.getVehicleWithMinPrice().toString());


    }
}