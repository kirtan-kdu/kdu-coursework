package com.kdu.smarthome.controllers;

import com.kdu.smarthome.dto.request.DeviceRequestDTO;
import com.kdu.smarthome.dto.response.DeviceRegistryResponseDTO;
import com.kdu.smarthome.models.DeviceRegistry;
import com.kdu.smarthome.services.DeviceRegistryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/device")
public class DeviceController {

    private final DeviceRegistryService deviceRegistryService;

    public DeviceController(DeviceRegistryService deviceRegistryService){
        this.deviceRegistryService = deviceRegistryService;
    }
    @PostMapping("/register")
    public ResponseEntity<DeviceRegistryResponseDTO> registerDevice(@RequestHeader(required = false) String jwtToken, @RequestBody DeviceRegistry deviceRegistry) {
        return ResponseEntity.ok(new DeviceRegistryResponseDTO("Device registered successfully",deviceRegistryService.registerDevice(deviceRegistry), HttpStatus.CREATED));
    }
    @PostMapping("/add")
    public ResponseEntity<DeviceRegistryResponseDTO> addDeviceToHouse(@RequestHeader(required = false) String jwtToken, @RequestBody DeviceRequestDTO deviceRequestDTO) {

        return ResponseEntity.ok(new DeviceRegistryResponseDTO("Device added to house successfully",deviceRegistryService.addDeviceToHouse(deviceRequestDTO), HttpStatus.CREATED));
    }
}