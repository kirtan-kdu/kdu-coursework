package org.kdu.homework.services;

import lombok.extern.slf4j.Slf4j;
import org.kdu.homework.entities.ShiftUser;
import org.kdu.homework.repository.ShiftUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class ShiftUserService {
    private ShiftUserRepository shiftUserRepository;

    @Autowired
    public ShiftUserService(ShiftUserRepository shiftUserRepository) {
        this.shiftUserRepository = shiftUserRepository;
    }

    public void addShiftUser(ShiftUser shiftUser){

        shiftUserRepository.addShiftUser(shiftUser);
        log.info("Shift user added: " + shiftUser.toString());
    }

    public List<ShiftUser> getAllShiftUsers(UUID tenantId) {
        return shiftUserRepository.getAllShiftUsers(tenantId);
    }


}
