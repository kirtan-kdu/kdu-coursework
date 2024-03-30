package org.kdu.homework.controllers.saveentities;

import org.kdu.homework.dto.request.RequestTenantDTO;
import org.kdu.homework.entities.ShiftType;
import org.kdu.homework.services.ShiftTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shift-type")
public class ShiftTypeController {
    private final ShiftTypeService shiftTypeService;

    @Autowired
    public ShiftTypeController(ShiftTypeService shiftTypeService) {
        this.shiftTypeService = shiftTypeService;
    }

    @PostMapping()
    public ResponseEntity<String> addShift(@RequestBody ShiftType shiftType) {
        shiftTypeService.addShiftType(shiftType);
        return ResponseEntity.ok("Shift-type saved successfully");
    }

    @GetMapping()
    public ResponseEntity<List<ShiftType>> getAllShifts(@RequestBody RequestTenantDTO requestTenantDTO) {
        List<ShiftType> shiftTypes = shiftTypeService.getAllShiftTypes(requestTenantDTO.getTenantId());
        return ResponseEntity.ok(shiftTypes);
    }
}
