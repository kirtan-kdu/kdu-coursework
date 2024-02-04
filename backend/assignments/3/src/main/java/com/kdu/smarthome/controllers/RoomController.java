package com.kdu.smarthome.controllers;

import com.kdu.smarthome.dto.response.RoomResponseDTO;
import com.kdu.smarthome.services.RoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/room")
public class RoomController {
    private final RoomService roomService;

    public RoomController(RoomService roomService){
        this.roomService = roomService;
    }
    @PostMapping
    public ResponseEntity<RoomResponseDTO> addRoomToHouse(@RequestHeader(required = false) String jwtToken, @RequestParam String houseId, @RequestBody String roomName) {
        return ResponseEntity.ok(roomService.addRoomToHouse(houseId, roomName));
    }
}