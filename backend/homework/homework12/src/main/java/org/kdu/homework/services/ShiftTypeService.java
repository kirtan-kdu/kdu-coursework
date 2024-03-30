package org.kdu.homework.services;

import lombok.extern.slf4j.Slf4j;
import org.kdu.homework.entities.Shift;
import org.kdu.homework.entities.ShiftType;
import org.kdu.homework.exceptions.custom.CustomException;
import org.kdu.homework.repository.ShiftRepository;
import org.kdu.homework.repository.ShiftTypeRepository;
import org.springframework.beans.InvalidPropertyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
@Slf4j
public class ShiftTypeService {
    private final ShiftTypeRepository shiftTypeRepository;

    @Autowired
    public ShiftTypeService(ShiftTypeRepository shiftTypeRepository) {
        this.shiftTypeRepository = shiftTypeRepository;
    }

    public void addShiftType(ShiftType shiftType) {
        if (!(Objects.equals(shiftType.getUniqueName(), "Morning") ||
                Objects.equals(shiftType.getUniqueName(), "Afternoon") ||
                Objects.equals(shiftType.getUniqueName(), "Night"))) {
            throw new CustomException("Unique name should be Morning, Afternoon, or Night");
        }
        try {
            shiftTypeRepository.save(shiftType);
            log.info("Shift type added successfully.");
        } catch (Exception e) {
            throw new CustomException("Error while fetching given shift type");
        }
    }

    public List<ShiftType> getAllShiftTypes(UUID tenantId) {
        List<ShiftType> shiftTypeList;
        try {
            shiftTypeList = shiftTypeRepository.findAllByTenantId(tenantId);
            log.info("Shift types fetched successfully");
        } catch (Exception e) {
            throw new CustomException("Error while fetching given shift type");
        }
        return shiftTypeList;
    }
}
