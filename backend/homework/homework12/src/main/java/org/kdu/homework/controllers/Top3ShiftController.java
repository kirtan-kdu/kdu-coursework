package org.kdu.homework.controllers;


import org.kdu.homework.entities.Shift;
import org.kdu.homework.services.ShiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/top-shift")
public class Top3ShiftController {

    private final ShiftService shiftService;

    @Autowired
    public Top3ShiftController(ShiftService shiftController){
        this.shiftService = shiftController;
    }
    @GetMapping()
    public ResponseEntity<List<Shift>> getTop3ShiftsByDateRange() {
        List<Shift> shifts = shiftService.getTop3ShiftsByDateRange();
        return ResponseEntity.ok(shifts);
    }
}
