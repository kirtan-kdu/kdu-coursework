package com.kdu.assessment.controller;


import com.kdu.assessment.entities.Inventory;
import com.kdu.assessment.service.InventoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService){
        this.inventoryService = inventoryService;
    }
    @PostMapping()
    public ResponseEntity<String> addInventory(@RequestBody Inventory inventory){
        inventoryService.addItem(inventory);
        return ResponseEntity.ok("Inventory added Successfully");
    }

    @PutMapping("/{inventoryId}")
    public ResponseEntity<String> updateInventory(@PathVariable UUID inventoryId, @RequestBody Inventory inventory){
        inventoryService.updateItem(inventoryId,inventory);
        return ResponseEntity.ok("Inventory updated Successfully");
    }
    @DeleteMapping()
    public ResponseEntity<String> deleteInventory(@RequestBody UUID inventoryId){
        inventoryService.deleteInventory(inventoryId);
        return ResponseEntity.ok("Inventory deleted Successfully");
    }



}
