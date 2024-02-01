package org.kdu.homework.controllers.saveEntities;

import org.kdu.homework.dto.request.RequestTenantDTO;
import org.kdu.homework.entities.ShiftUser;
import org.kdu.homework.services.ShiftUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shift-user")
public class ShiftUserController {
    private final ShiftUserService shiftUserService;

    @Autowired
    public ShiftUserController(ShiftUserService shiftUserService) {
        this.shiftUserService = shiftUserService;
    }

    @PostMapping()
    public ResponseEntity<String> addShift(@RequestBody ShiftUser shiftUser) {
        shiftUserService.addShiftUser(shiftUser);
        return ResponseEntity.ok("Shift-user saved successfully");
    }

    @GetMapping()
    public ResponseEntity<List<ShiftUser>> getAllShiftUsers(@RequestBody RequestTenantDTO requestDTO) {
        List<ShiftUser> shiftUsers = shiftUserService.getAllShiftUsers(requestDTO.getTenantId());
        return ResponseEntity.ok(shiftUsers);
    }
}
