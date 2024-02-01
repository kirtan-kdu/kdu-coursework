package org.kdu.homework.services;

import lombok.extern.slf4j.Slf4j;
import org.kdu.homework.entities.Shift;
import org.kdu.homework.entities.ShiftUser;
import org.kdu.homework.exceptions.custom.CustomException;
import org.kdu.homework.repository.ShiftUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class ShiftUserService {
    private ShiftUserRepository shiftUserRepository;

    @Autowired
    public ShiftUserService(ShiftUserRepository shiftUserRepository) {
        this.shiftUserRepository = shiftUserRepository;
    }

    public void addShiftUser(ShiftUser shiftUser) {
        try {
            shiftUserRepository.save(shiftUser);
            log.info("Shift user added successfully!");
        } catch (Exception e) {
            throw new CustomException("Invalid input.");
        }
    }

    public List<ShiftUser> getAllShiftUsers(UUID tenantId) {
        List<ShiftUser> shiftUserList;
        try {
            shiftUserList = shiftUserRepository.findAllByTenantId(tenantId);
        } catch (Exception e) {
            throw new CustomException("Error while fetching shift user");
        }
        return shiftUserList;
    }

    public void deleteShiftUser(UUID shiftUserId){
        Optional<ShiftUser> shiftUserOptional = shiftUserRepository.findById(shiftUserId);
        if (shiftUserOptional.isPresent()) {
            ShiftUser shiftUser = shiftUserOptional.get();
            Shift shift = shiftUser.getShift();
            LocalTime time = LocalTime.of(23,0,0);
            if (shift != null && shift.getEndTime().toLocalTime().equals(time)) {
                shiftUserRepository.delete(shiftUser);
                log.info("Shifts with end time as 23:00 UTC deleted successfully");
            } else {
                throw new CustomException("No shift matched with given end time of 23:00 UTC");
            }
        } else {
            throw new CustomException("Invalid shift user id");
        }
    }

}
