package com.kdu.smarthome.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.service.ResponseMessage;

@RestController
@RequestMapping("/api/v1/room")
public class RoomController {
    @Autowired
    private RoomService roomService;
    @PostMapping
    public ResponseEntity<?> addRoomToHouse(@RequestParam int houseId, @RequestBody RoomDTO roomDTO) {
        roomService.addRoomToHouse(houseId, roomDTO);
        return ResponseEntity.ok(new ResponseMessage("Room added to house successfully"));
    }
}