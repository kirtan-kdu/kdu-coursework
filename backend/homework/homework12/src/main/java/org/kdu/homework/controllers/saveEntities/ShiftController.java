package org.kdu.homework.controllers.saveEntities;

import org.kdu.homework.dto.request.RequestTenantDTO;
import org.kdu.homework.entities.Shift;
import org.kdu.homework.services.ShiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shift")
public class ShiftController {
    private final ShiftService shiftService;

    @Autowired
    public ShiftController(ShiftService shiftService) {
        this.shiftService = shiftService;
    }

    @PostMapping()
    public ResponseEntity<String> addShift(@RequestBody Shift shift) {
        shiftService.addShift(shift);
        return ResponseEntity.ok("Shift saved successfully");
    }

    @GetMapping()
    public ResponseEntity<List<Shift>> getAllShifts(@RequestBody RequestTenantDTO requestTenantDTO) {
        List<Shift> shifts = shiftService.getAllShifts(requestTenantDTO.getTenantId());
        return ResponseEntity.ok(shifts);
    }
}
