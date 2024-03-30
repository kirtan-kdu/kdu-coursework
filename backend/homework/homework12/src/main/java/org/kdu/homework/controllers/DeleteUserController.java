package org.kdu.homework.controllers;


import org.kdu.homework.services.ShiftUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/user")
public class DeleteUserController {

    private final ShiftUserService shiftUserService;

    public DeleteUserController(ShiftUserService shiftUserService){
        this.shiftUserService = shiftUserService;
    }

    @DeleteMapping("/{shiftUserId}")
    public ResponseEntity<String> deleteShiftUser(@PathVariable UUID shiftUserId) {
        shiftUserService.deleteShiftUser(shiftUserId);
        return ResponseEntity.ok("Shift-user deleted successfully");
    }
}
