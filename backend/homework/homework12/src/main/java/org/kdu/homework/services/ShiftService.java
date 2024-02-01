package org.kdu.homework.services;

import lombok.extern.slf4j.Slf4j;
import org.kdu.homework.entities.Shift;
import org.kdu.homework.entities.User;
import org.kdu.homework.exceptions.custom.CustomException;
import org.kdu.homework.repository.ShiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class ShiftService {
    private final ShiftRepository shiftRepository;

    @Autowired
    public ShiftService(ShiftRepository shiftRepository) {
        this.shiftRepository = shiftRepository;
    }


    public void addShift(Shift shift) {
        try {
            shiftRepository.save(shift);
        } catch (Exception e) {
            throw new CustomException("Error while adding shift");
        }
    }

    public List<Shift> getAllShifts(UUID tenantId) {
        List<Shift> shiftList;
        try {
            shiftList = shiftRepository.findAllByTenantId(tenantId);
        } catch (Exception e) {
            throw new CustomException("Invalid tenant id is given");
        }
        return shiftList;
    }

    public List<Shift> getTop3ShiftsByDateRange(){
        List<Shift> shiftList;
        LocalDate dateStart = LocalDate.of(2023, 1, 1);
        LocalDate dateEnd = LocalDate.of(2023, 1, 25);
        try {
            shiftList = shiftRepository.findTop3ShiftsByDateRange(dateStart,dateEnd);
            log.info("Successfully fetched all shifts with given start and end date");
        } catch (Exception e) {
            throw new CustomException("No shift are available with given start and end date");
        }
        return shiftList;
    }

}
