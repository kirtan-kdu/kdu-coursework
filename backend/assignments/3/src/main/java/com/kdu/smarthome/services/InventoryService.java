package com.kdu.smarthome.services;

import com.kdu.smarthome.dto.request.InventoryrequestDTO;
import com.kdu.smarthome.dto.response.InventoryResponseDTO;
import com.kdu.smarthome.exceptions.custom.DuplicateEntryException;
import com.kdu.smarthome.exceptions.custom.UserNotFoundException;
import com.kdu.smarthome.models.DeviceRegistry;
import com.kdu.smarthome.models.Inventory;
import com.kdu.smarthome.repository.InventoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository){
        this.inventoryRepository = inventoryRepository;
    }

    public List<Inventory> getInventoryItems(){
        try {
            return inventoryRepository.findAll();
        }
        catch (Exception exception){
            throw new DuplicateEntryException("Error while fetching inventory");
        }
    }

    public InventoryResponseDTO addInventoryItem(InventoryrequestDTO inventoryrequestDTO){
        try {
            Inventory inventory = Inventory.builder().deviceUsername(inventoryrequestDTO.getDeviceUsername())
                            .devicePassword(inventoryrequestDTO.getDevicePassword())
                                    .kickstoneId(inventoryrequestDTO.getKickstoneId())
                                            .manufactureFactoryPlace(inventoryrequestDTO.getManufactureFactoryPlace())
                                                    .manufactureDateTime(inventoryrequestDTO.getManufactureDateTime()).build();
            inventoryRepository.save(inventory);
            return new InventoryResponseDTO(inventory.toString(), "Successfully added inventory", HttpStatus.CREATED);
        }
        catch (Exception exception){
            throw new UserNotFoundException(exception.getMessage());
        }
    }

    public boolean isPresent(DeviceRegistry deviceRegistry){
        try {
            Optional<Inventory> inventory = inventoryRepository.findById(deviceRegistry.getKickstonId());
            return inventory.isPresent() && inventory.get().getDeviceUsername().equals(deviceRegistry.getDeviceUsername()) && inventory.get().getDevicePassword().equals(deviceRegistry.getDevicePassword());
        }
        catch (Exception ex){
            throw new UserNotFoundException("Error while accessing inventory");
        }
    }

}
