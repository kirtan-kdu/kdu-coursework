package com.kdu.smarthome.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.service.ResponseMessage;

@RestController
@RequestMapping("/api/v1/house")
public class HouseController {

    @PostMapping()
    public ResponseEntity<String> addHouse(){
        return new ResponseEntity<>("House Added successfully", HttpStatus.OK);
    }

    @PostMapping("/{houseId}/add-user")
    public ResponseEntity<?> addUserToHouse(@PathVariable("houseId") int houseId, @RequestBody AddUserDTO addUserDTO) {
        houseService.addUserToHouse(houseId, addUserDTO.getUsername());
        return ResponseEntity.ok(new ResponseMessage("User added to house successfully"));
    }


    @GetMapping
    public ResponseEntity<?> getAllHouses(@RequestParam(defaultValue = "0") int pageNumber,
                                          @RequestParam(defaultValue = "100") int pageSize) {
        List<HouseDTO> houses = houseService.getAllHouses(pageNumber, pageSize);
        return ResponseEntity.ok(new HouseListResponse("Houses retrieved successfully", houses, HttpStatus.OK));
    }
    @PutMapping
    public ResponseEntity<?> updateHouseAddress(@RequestParam int houseId, @RequestParam String newAddress) {
        houseService.updateHouseAddress(houseId, newAddress);
        return ResponseEntity.ok(new ResponseMessage("House address updated successfully"));
    }
    @GetMapping("/{houseId}")
    public ResponseEntity<?> getHouseDetails(@PathVariable("houseId") int houseId) {
        HouseDetailsDTO houseDetailsDTO = houseService.getHouseDetails(houseId);
        return ResponseEntity.ok(new HouseDetailsResponse("House details retrieved successfully", houseDetailsDTO, HttpStatus.OK));
    }


}
