package com.kdu.smarthome.services;


import com.kdu.smarthome.dto.request.DeviceRequestDTO;
import com.kdu.smarthome.exceptions.custom.UserNotFoundException;
import com.kdu.smarthome.models.DeviceRegistry;
import com.kdu.smarthome.repository.DeviceRegistryRepository;
import com.kdu.smarthome.repository.HouseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeviceRegistryService {

    private final DeviceRegistryRepository deviceRegistryRepository;

    private final HouseRepository houseRepository;

    private final InventoryService inventoryService;

    private final RoomService roomService;

    public DeviceRegistryService(DeviceRegistryRepository deviceRegistryRepository, HouseRepository houseRepository, InventoryService inventoryService, RoomService roomService){
        this.deviceRegistryRepository = deviceRegistryRepository;
        this.houseRepository = houseRepository;
        this.inventoryService = inventoryService;
        this.roomService = roomService;
    }

    public String registerDevice(DeviceRegistry deviceRegistry){
        try {
            if (!inventoryService.isPresent(deviceRegistry)){
                throw new UserNotFoundException("Device is not present in inventory");
            }
            deviceRegistryRepository.save(deviceRegistry);
            return deviceRegistry.toString();
        }
        catch (Exception e){
            throw new UserNotFoundException(e.getMessage());
        }
    }

    public String addDeviceToHouse(DeviceRequestDTO deviceRequestDTO){
        try {
            Optional<DeviceRegistry> deviceRegistry = deviceRegistryRepository.findById(deviceRequestDTO.getKickstonId());
            if (deviceRegistry.isEmpty()){
                throw new UserNotFoundException("Device is not present to add");
            }
            deviceRegistry.get().setHouse(houseRepository.getReferenceById(deviceRequestDTO.getHouseId()));
            deviceRegistry.get().setRoom(roomService.getRoom(deviceRequestDTO.getRoomId()));
            deviceRegistryRepository.save(deviceRegistry.get());
            return deviceRegistry.toString();
        }
        catch (Exception e){
            throw new UserNotFoundException("Error while adding device");
        }
    }

    public List<DeviceRegistry> getAllDevices(String houseId){
        try {
            return deviceRegistryRepository.findAllByHouse_Id(houseId);
        }
        catch (Exception e){
            throw new UserNotFoundException("Error while adding device");
        }
    }

}
