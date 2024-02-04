package com.kdu.smarthome.controllers;


import com.kdu.smarthome.dto.request.HouseRequestDTO;
import com.kdu.smarthome.dto.request.UsernameRequestDTO;
import com.kdu.smarthome.dto.response.*;
import com.kdu.smarthome.models.House;
import com.kdu.smarthome.services.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/house")
public class HouseController {

    private final HouseService houseService;

    @Autowired
    public HouseController(HouseService houseService){
        this.houseService = houseService;
    }

    @PostMapping()
    public ResponseEntity<HouseResponseDTO> addHouse(@RequestHeader(required = false) String jwtToken, @RequestBody HouseRequestDTO houseRequestDTO){
        return new ResponseEntity<>(houseService.addHouse(houseRequestDTO), HttpStatus.OK);
    }

    @PostMapping("/{houseId}/add-user")
    public ResponseEntity<UserResponseDTO> addUserToHouse(@RequestHeader(required = false) String jwtToken, @PathVariable("houseId") String houseId, @RequestBody UsernameRequestDTO username) {
        return ResponseEntity.ok(houseService.addUserToHouse(houseId, username.getUsername()));
    }

    @GetMapping
    public ResponseEntity<HouseListResponseDTO> getAllHouses(@RequestHeader(required = false) String jwtToken) {
        List<House> houses = houseService.getAllHouses();
        return ResponseEntity.ok(new HouseListResponseDTO(houses.toString(),"Houses retrieved successfully", HttpStatus.OK));
    }
    @PutMapping
    public ResponseEntity<AddressResponseDTO> updateHouseAddress(@RequestHeader(required = false) String jwtToken, @RequestParam String houseId, @RequestBody String newAddress) {
        return ResponseEntity.ok(houseService.updateHouseAddress(houseId, newAddress));
    }
    @GetMapping("/{houseId}")
    public ResponseEntity<HouseDetailsResponseDTO> getHouseDetails(@RequestHeader(required = false) String jwtToken, @PathVariable("houseId") String houseId) {
        return ResponseEntity.ok(houseService.getHouseDetails(houseId));
    }


}
