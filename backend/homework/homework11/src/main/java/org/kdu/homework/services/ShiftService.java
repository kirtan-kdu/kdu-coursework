package org.kdu.homework.services;

import lombok.extern.slf4j.Slf4j;
import org.kdu.homework.entities.Shift;
import org.kdu.homework.repository.ShiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class ShiftService {
    private ShiftRepository shiftRepository;

    @Autowired
    public ShiftService(ShiftRepository shiftRepository) {
        this.shiftRepository = shiftRepository;
    }

    public UUID addShift(Shift shift){
        log.info("Shift added: " + shift.toString());
        return shiftRepository.addShift(shift);
    }

    public List<Shift> getAllShifts(UUID tenantId) {
        return shiftRepository.getAllShifts(tenantId);
    }
}
