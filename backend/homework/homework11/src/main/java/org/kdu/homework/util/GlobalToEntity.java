package org.kdu.homework.util;

import org.kdu.homework.dto.request.RequestGlobalDTO;
import org.kdu.homework.entities.Shift;
import org.kdu.homework.entities.ShiftType;
import org.kdu.homework.entities.ShiftUser;
import org.kdu.homework.entities.User;

public class GlobalToEntity {

    public static User GlobalToUser(RequestGlobalDTO globalDTO){
        User user = new User();
        user.setUserName(globalDTO.getUserName());
        user.setTenantId(globalDTO.getTenantId());
        user.setCreatedBy(globalDTO.getCreatedBy());
        user.setLoggedIn(globalDTO.getLoggedIn());
        user.setTimeZone(globalDTO.getTimeZone());
        return user;
    }

    public static ShiftUser GlobalToShiftUser(RequestGlobalDTO globalDTO){
        ShiftUser shiftUser = new ShiftUser();
        shiftUser.setCreatedBy(globalDTO.getCreatedBy());
        shiftUser.setTenantId(globalDTO.getTenantId());
        shiftUser.setUserId(globalDTO.getUserId());
        shiftUser.setShiftId(globalDTO.getShiftId());
        return shiftUser;
    }

    public static Shift GlobalToShift(RequestGlobalDTO globalDTO){
        Shift shift = new Shift();
        shift.setTenantId(globalDTO.getTenantId());
        shift.setCreatedBy(globalDTO.getCreatedBy());
        shift.setName(globalDTO.getShiftName());
        shift.setStartDate(globalDTO.getStartDate());
        shift.setEndDate(globalDTO.getEndDate());
        shift.setStartTime(globalDTO.getStartTime());
        shift.setEndTime(globalDTO.getEndTime());
        shift.setTimezone(globalDTO.getTimeZone());
        shift.setShiftTypeId(globalDTO.getShiftTypeId());
        return shift;
    }

    public static ShiftType GlobalToShiftType(RequestGlobalDTO globalDTO){
        ShiftType shiftType = new ShiftType();
        shiftType.setUniqueName(globalDTO.getShiftTypeName());
        shiftType.setCreatedBy(globalDTO.getCreatedBy());
        shiftType.setTenantId(globalDTO.getTenantId());
        shiftType.setDescription(globalDTO.getDescription());
        shiftType.setActive(globalDTO.isActive());
        shiftType.setCreatedBy(globalDTO.getCreatedBy());
        shiftType.setTimeZone(globalDTO.getTimeZone());
        return shiftType;
    }
}
