package com.kdu.smarthome.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.service.ResponseMessage;

@RestController
@RequestMapping("/api/v1/inventory")
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;
    @GetMapping
    public ResponseEntity<?> getInventoryItems() {
        List<InventoryItemDTO> inventoryItems = inventoryService.getInventoryItems();
        return ResponseEntity.ok(new InventoryResponse("Inventory items retrieved successfully", inventoryItems, HttpStatus.OK));
    }
    @PostMapping
    public ResponseEntity<?> addInventoryItem(@RequestBody InventoryItemDTO inventoryItemDTO) {
        inventoryService.addInventoryItem(inventoryItemDTO);
        return ResponseEntity.ok(new ResponseMessage("Inventory item added successfully"));
    }
}