package org.kdu.homework.services;


import lombok.extern.slf4j.Slf4j;
import org.kdu.homework.dto.request.RequestGlobalDTO;
import org.kdu.homework.exceptions.custom.CustomException;
import org.kdu.homework.util.GlobalToEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Slf4j
@Service
public class GlobalService {

    UserService userService;
    ShiftService shiftService;
    ShiftUserService shiftUserService;

    ShiftTypeService shiftTypeService;

    @Autowired
    public GlobalService(UserService userService, ShiftService shiftService, ShiftUserService shiftUserService, ShiftTypeService shiftTypeService){
        this.shiftService = shiftService;
        this.shiftTypeService = shiftTypeService;
        this.userService = userService;
        this.shiftUserService = shiftUserService;
    }

    /**
     * This method adds all entities in one transaction. It takes a RequestGlobalDTO object as input,
     * converts it to User, ShiftType, Shift, and ShiftUser entities, and adds them to the database with newly generated ids.
     * If any exception occurs during this process, a CustomException is thrown.
     * @param requestGlobalDTO The RequestGlobalDTO object containing the data for the new entities.
     * @throws CustomException Thrown when an error occurs while adding the entities.
     */
    @Transactional
    public void addAllEntities(RequestGlobalDTO requestGlobalDTO){

        try {
            UUID userId = userService.addUser(GlobalToEntity.GlobalToUser(requestGlobalDTO));
            requestGlobalDTO.setUserId(userId);
            UUID shiftTypeId = shiftTypeService.addShiftType(GlobalToEntity.GlobalToShiftType(requestGlobalDTO));
            requestGlobalDTO.setShiftTypeId(shiftTypeId);
            UUID shiftId = shiftService.addShift(GlobalToEntity.GlobalToShift(requestGlobalDTO));
            requestGlobalDTO.setShiftId(shiftId);
            shiftUserService.addShiftUser(GlobalToEntity.GlobalToShiftUser(requestGlobalDTO));
            log.debug("Successfully added all entities in one go");
        }
        catch (Exception ex){
            throw new CustomException("Error while adding all entities in one go because of invalid entities");
        }
    }

}
