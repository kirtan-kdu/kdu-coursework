package kdu.homework7;

import kdu.homework7.config.AppConfig;
import kdu.homework7.data.VehiclesInventory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

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

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        VehiclesInventory tataInventory = (VehiclesInventory) context.getBean("tataInventory");
        VehiclesInventory teslaInventory = (VehiclesInventory) context.getBean("teslaInventory");

        logger.warn("\n\n\nHello! Its Kirtan here.");
        logger.info("The size of Tata inventory: " + tataInventory.getListOfAllVehicles().size());
        logger.info("The size of Tesla inventory: " + teslaInventory.getListOfAllVehicles().size());

        logger.warn("\n\nFor Tesla inventory max and min vehicles are as below,");
        logger.info(teslaInventory.getVehicleWithMaxPrice().toString());
        logger.info(teslaInventory.getVehicleWithMinPrice().toString());

        logger.warn("\n\nFor Tata inventory max and min vehicles are as below,");
        logger.info(tataInventory.getVehicleWithMaxPrice().toString());
        logger.info(tataInventory.getVehicleWithMinPrice().toString());


    }
}