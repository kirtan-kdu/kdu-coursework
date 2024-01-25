package org.kdu.homework9.controller;


import jakarta.validation.Valid;
import org.kdu.homework9.DTO.ErrorDTO.ErrorDTO;
import org.kdu.homework9.DTO.request.UpdateVehicleDTO;
import org.kdu.homework9.DTO.request.VehicleDTO;
import org.kdu.homework9.DTO.request.VehicleIdDTO;
import org.kdu.homework9.DTO.request.VehicleOperatoinDTO;
import org.kdu.homework9.DTO.response.ResMessageDTO;
import org.kdu.homework9.DTO.response.ResVehicleDTO;
import org.kdu.homework9.entities.Vehicle;
import org.kdu.homework9.exceptions.VehicleException;
import org.kdu.homework9.services.TataService;
import org.kdu.homework9.services.TeslaService;
import org.kdu.homework9.services.VehicleService;
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

    /**
     * takes string of company name as argument and returns appropriate inventory
     * @param company
     * @return
     */
    private VehicleService getCorrectService(String company){
        if(company.equalsIgnoreCase("tesla"))return teslaService;
        else if(company.equalsIgnoreCase("tata"))return tataService;
        throw new VehicleException(new ErrorDTO("Invalid company name", HttpStatus.BAD_REQUEST));
    }

    private final Logger logger = LoggerFactory.getLogger(InventoryController.class);


    private void logCurrentInventory(){
        logger.warn("---------------------------------Tata Inventory --------------------------------------");
        tataService.vehicleRepository.getAllvehicles().forEach(v -> logger.info(v.toString()));
        logger.warn("---------------------------------Tesla Inventory--------------------------------------");
        teslaService.vehicleRepository.getAllvehicles().forEach(v -> logger.info(v.toString()));
    }


    /**
     * takes company name in arg and adds vehicle object to its inventory
     * @param company whether it is "Tesla" or "Tata"
     * @param vehicle object which needs to be added
     * @return
     */
    @PostMapping("/{company}/addvehicle")
    public ResponseEntity<ResVehicleDTO> addVehicle(@PathVariable String company,@Valid @RequestBody Vehicle vehicle){

        ResVehicleDTO vehicleDTO = getCorrectService(company).addVehicle(new VehicleDTO(vehicle));

        logCurrentInventory();

        return new ResponseEntity<>(vehicleDTO, HttpStatus.CREATED);
    }

    /**
     * Fetches vehicle with its id as index from path variable
     * @param company
     * @param id
     * @return
     */
    @GetMapping("/{company}/getvehicle/{id}")
    public ResponseEntity<ResVehicleDTO> getVehicle(@PathVariable String company,@PathVariable int id){
        ResVehicleDTO vehicle = getCorrectService(company).getVehicle(id);

        logCurrentInventory();

        return new ResponseEntity<>(vehicle,HttpStatus.OK);
    }

    /**
     * takes old vehicle id and new vehicle object which are wrapped in updateVehicleDTO
     * @param company
     * @param updateVehicleDTO
     * @return
     */
    @PutMapping("/{company}/updatevehicle")
    public ResponseEntity<ResMessageDTO> updatevehicle(@PathVariable String company, @RequestBody UpdateVehicleDTO updateVehicleDTO){
        ResMessageDTO messageDTO = getCorrectService(company).updateVehicle(updateVehicleDTO);

        logCurrentInventory();

        return new ResponseEntity<>(messageDTO,HttpStatus.OK);
    }


    /**
     * deletes vehicle from appropriate inventory using its id
     * @param company
     * @param id
     * @return
     */
    @DeleteMapping("/{company}/deletevehicle/{id}")
    public ResponseEntity<ResMessageDTO> delateVehicle(@PathVariable String company, @PathVariable int id){
        ResMessageDTO messageDTO = getCorrectService(company).deleteVehicle(new VehicleIdDTO(id));

        logCurrentInventory();

        return new ResponseEntity<>(messageDTO, HttpStatus.OK);
    }

    /**
     * Calls most or least methods as per the path variables
     * @param company
     * @param op can be of type "min" or "max"
     * @return
     */
    @GetMapping("/{company}/{op}")
    public ResponseEntity<ResVehicleDTO> performOp(@PathVariable String company, @PathVariable String op){
        ResVehicleDTO vehicle = getCorrectService(company).performOperation(new VehicleOperatoinDTO(op));

        logCurrentInventory();

        return new ResponseEntity<>(vehicle,HttpStatus.OK);
    }

}
