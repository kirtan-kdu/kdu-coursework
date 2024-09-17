package com.kdu.assessment.service;


import com.kdu.assessment.entities.Inventory;
import com.kdu.assessment.exception.custom.InvalidArgumentsException;
import com.kdu.assessment.repository.InventoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class InventoryService {
    InventoryRepository inventoryRepository;

    @Autowired
    public InventoryService(InventoryRepository inventoryRepository){
        this.inventoryRepository = inventoryRepository;
    }


    public void addItem(Inventory inventory){
        try {
            inventoryRepository.save(inventory);
            log.info("Inventory added Successfully");
        }
        catch (Exception exception){
            throw new InvalidArgumentsException("Inventory details are invalid");
        }
    }

    public Inventory getItem(UUID inventoryId){
        try {
            return inventoryRepository.getReferenceById(inventoryId);
        }
        catch (Exception exception){
            throw new InvalidArgumentsException("Inventory details are invalid");
        }
    }

    public void updateItem(UUID inventoryId, Inventory inventory){
        try {
            if (inventoryRepository.updateDetails(inventoryId, inventory.getName(),inventory.getDescription(), inventory.getPrice(), inventory.getQuantity(), inventory.getThreshold())==0){
                throw new InvalidArgumentsException("Invalid inventory id");
            }
            log.info("Inventory updated Successfully");
        }
        catch (Exception exception){
            throw new InvalidArgumentsException("Error while updating inventory");
        }
    }


    public void deleteInventory(UUID inventoryId){
        try{
            inventoryRepository.delete(inventoryRepository.getReferenceById(inventoryId));
            log.info("Inventory deleted Successfully");
            verifyThreshold(inventoryId);
        }
        catch (Exception exception){
            throw new InvalidArgumentsException("Inventory id is invalid");
        }
    }

    private void verifyThreshold(UUID inventoryId){
        try{
            Inventory inventory = inventoryRepository.getReferenceById(inventoryId);
            inventoryRepository.updateQuantity(inventoryId,inventory.getThreshold());
            log.info("Inventory threshold verified Successfully");
        }
        catch (Exception exception){
            throw new InvalidArgumentsException("Inventory id is invalid");
        }
    }
}
