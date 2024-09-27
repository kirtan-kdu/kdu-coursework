package org.kdu.homework.services;

import lombok.extern.slf4j.Slf4j;
import org.kdu.homework.entities.Shift;
import org.kdu.homework.entities.ShiftType;
import org.kdu.homework.repository.ShiftRepository;
import org.kdu.homework.repository.ShiftTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class ShiftTypeService {
    private ShiftTypeRepository shiftTypeRepository;

    @Autowired
    public ShiftTypeService(ShiftTypeRepository shiftTypeRepository) {
        this.shiftTypeRepository = shiftTypeRepository;
    }

    public UUID addShiftType(ShiftType shiftType){
        log.info("ShiftType added: " + shiftType.toString());
        return shiftTypeRepository.addShiftType(shiftType);
    }

    public List<ShiftType> getAllShiftTypes(UUID tenantId) {
        return shiftTypeRepository.getAllShiftTypes(tenantId);
    }
}
