package com.kdu.smarthome.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.service.ResponseMessage;

@RestController
@RequestMapping("/api/v1/device")
public class DeviceController {
    @Autowired
    private DeviceService deviceService;
    @PostMapping("/register")
    public ResponseEntity<?> registerDevice(@RequestBody DeviceDTO deviceDTO) {
        deviceService.registerDevice(deviceDTO);
        return ResponseEntity.ok(new ResponseMessage("Device registered successfully"));
    }
    @PostMapping("/add")
    public ResponseEntity<?> addDeviceToHouse(@RequestBody AddDeviceDTO addDeviceDTO) {
        deviceService.addDeviceToHouse(addDeviceDTO);
        return ResponseEntity.ok(new ResponseMessage("Device added to house successfully"));
    }
}