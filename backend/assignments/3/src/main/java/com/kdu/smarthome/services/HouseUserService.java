package com.kdu.smarthome.services;


import com.kdu.smarthome.entities.UserRole;
import com.kdu.smarthome.exceptions.custom.DuplicateEntryException;
import com.kdu.smarthome.exceptions.custom.UserNotFoundException;
import com.kdu.smarthome.models.HouseUser;
import com.kdu.smarthome.models.User;
import com.kdu.smarthome.repository.HouseUserRepository;
import com.kdu.smarthome.security.CustomAuthManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HouseUserService {

    private final HouseUserRepository houseUserRepository;


    public HouseUserService(HouseUserRepository houseUserRepository){
        this.houseUserRepository = houseUserRepository;
    }

    public HouseUser getByUserName(String userName){
        try {
            return houseUserRepository.findByUser_Username(userName);
        }
        catch (Exception e){
            throw new UserNotFoundException(userName);
        }
    }


    public void addHouseUser(HouseUser houseUser){
        try {
            houseUserRepository.save(houseUser);
        }
        catch (Exception exception){
            throw new DuplicateEntryException("Error while adding house-user entry");
        }
    }

    public boolean isAdmin(String houseID){
        HouseUser houseUser = houseUserRepository.findByHouse_IdAndUser_Username(houseID, CustomAuthManager.getUserName());
        return houseUser!=null && houseUser.getUserRole().equals(UserRole.ADMIN_ROLE);
    }

    public List<User> getAllUsers(String houseId){
        try {
            List<HouseUser> listOfHouseUsers = houseUserRepository.findAllByHouse_Id(houseId);
            return listOfHouseUsers.stream()
                    .map(HouseUser::getUser)
                    .collect(Collectors.toList());
        }
        catch (Exception exception){
            throw new UserNotFoundException("Error while fetching users of house");
        }
    }


}
