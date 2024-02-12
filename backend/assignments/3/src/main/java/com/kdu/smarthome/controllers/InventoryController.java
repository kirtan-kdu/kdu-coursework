package com.kdu.smarthome.controllers;

import com.kdu.smarthome.dto.request.InventoryrequestDTO;
import com.kdu.smarthome.dto.response.InventoryListResponseDTO;
import com.kdu.smarthome.dto.response.InventoryResponseDTO;
import com.kdu.smarthome.models.Inventory;
import com.kdu.smarthome.services.InventoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/inventory")
public class InventoryController {
    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService){
        this.inventoryService = inventoryService;
    }
    @GetMapping
    public ResponseEntity<InventoryListResponseDTO> getInventoryItems() {
        List<Inventory> inventoryItems = inventoryService.getInventoryItems();
        return ResponseEntity.ok(new InventoryListResponseDTO(inventoryItems.toString(), HttpStatus.OK));
    }
    @PostMapping
    public ResponseEntity<InventoryResponseDTO> addInventoryItem(@RequestHeader(required = false) String jwtToken, @RequestBody InventoryrequestDTO inventoryrequestDTO) {
        return ResponseEntity.ok(inventoryService.addInventoryItem(inventoryrequestDTO));
    }
}