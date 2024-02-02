package com.kdu.assessment.controller;


import com.kdu.assessment.entities.Address;
import com.kdu.assessment.entities.User;
import com.kdu.assessment.service.AddressService;
import com.kdu.assessment.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserDetailsController {

    UserService userService;
    AddressService addressService;

    public UserDetailsController(UserService userService, AddressService addressService){
        this.userService = userService;
        this.addressService = addressService;
    }
    @PostMapping("/profile")
    public ResponseEntity<String> addUser(@RequestBody User user) {
        userService.addUser(user);
        return new ResponseEntity<>("User added successfully", HttpStatus.OK);
    }

    @GetMapping("/profile")
    public ResponseEntity<String> getAllUser(){
        return new ResponseEntity<>(userService.getAllUsers().toString() , HttpStatus.OK);
    }

    @GetMapping("/address")
    public ResponseEntity<List<Address>> getAddress(@RequestBody UUID userID){
        List<Address> addressList = addressService.getAllAddress(userID);
        return new ResponseEntity<>(addressList, HttpStatus.OK);
    }

    @PostMapping("/address")
    public ResponseEntity<String> addAddress(@RequestBody Address address){
        addressService.addAddress(address);
        return new ResponseEntity<>("Address added successfully", HttpStatus.OK);
    }
}
