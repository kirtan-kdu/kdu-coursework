package org.kdu.homework8.controller;


import jakarta.validation.Valid;
import org.kdu.homework8.DTO.request.UpdateVehicleDTO;
import org.kdu.homework8.DTO.request.VehicleDTO;
import org.kdu.homework8.DTO.request.VehicleIdDTO;
import org.kdu.homework8.DTO.request.VehicleOperatoinDTO;
import org.kdu.homework8.DTO.response.ResMessageDTO;
import org.kdu.homework8.DTO.response.ResVehicleDTO;
import org.kdu.homework8.entities.Vehicle;
import org.kdu.homework8.exceptions.CustomException;
import org.kdu.homework8.services.TataService;
import org.kdu.homework8.services.TeslaService;
import org.kdu.homework8.services.VehicleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private TataService tataService;
    @Autowired
    private TeslaService teslaService;

    private VehicleService getCorrectService(String company){
        if(company.equalsIgnoreCase("tesla"))return teslaService;
        else if(company.equalsIgnoreCase("tata"))return tataService;
        throw new CustomException("Invalid company name");
    }

    private final Logger logger = LoggerFactory.getLogger(InventoryController.class);


    private void logCurrentInventory(){
        logger.warn("---------------------------------Tata Inventory--------------------------------------");
        tataService.vehiclesInventory.getListOfAllVehicles().forEach(v -> logger.info(v.toString()));
        logger.warn("---------------------------------Tesla Inventory--------------------------------------");
        teslaService.vehiclesInventory.getListOfAllVehicles().forEach(v -> logger.info(v.toString()));
    }



    @PostMapping("/{company}/addvehicle")
    public ResponseEntity<ResVehicleDTO> addVehicle(@PathVariable String company,@Valid @RequestBody Vehicle vehicle){

        ResVehicleDTO vehicleDTO = getCorrectService(company).addVehicle(new VehicleDTO(vehicle));

        logCurrentInventory();

        return new ResponseEntity<>(vehicleDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{company}/getvehicle/{id}")
    public ResponseEntity<ResVehicleDTO> getVehicle(@PathVariable String company,@PathVariable int id){
        ResVehicleDTO vehicle = getCorrectService(company).getVehicle(id);

        logCurrentInventory();

        return new ResponseEntity<>(vehicle,HttpStatus.OK);
    }

    @PutMapping("/{company}/updatevehicle")
    public ResponseEntity<ResMessageDTO> updatevehicle(@PathVariable String company, @RequestBody UpdateVehicleDTO updateVehicleDTO){
        ResMessageDTO messageDTO = getCorrectService(company).updateVehicle(updateVehicleDTO);

        logCurrentInventory();

        return new ResponseEntity<>(messageDTO,HttpStatus.OK);
    }


    @DeleteMapping("/{company}/deletevehicle/{id}")
    public ResponseEntity<ResMessageDTO> delateVehicle(@PathVariable String company, @PathVariable int id){
        ResMessageDTO messageDTO = getCorrectService(company).deleteVehicle(new VehicleIdDTO(id));

        logCurrentInventory();

        return new ResponseEntity<>(messageDTO, HttpStatus.OK);
    }

    @GetMapping("/{company}/{op}")
    public ResponseEntity<ResVehicleDTO> performOp(@PathVariable String company, @PathVariable String op){
        ResVehicleDTO vehicle = getCorrectService(company).performOperation(new VehicleOperatoinDTO(op));

        logCurrentInventory();

        return new ResponseEntity<>(vehicle,HttpStatus.OK);
    }

}
