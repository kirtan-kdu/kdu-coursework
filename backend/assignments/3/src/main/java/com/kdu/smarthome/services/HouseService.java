package com.kdu.smarthome.services;


import com.kdu.smarthome.dto.response.*;
import com.kdu.smarthome.entities.UserRole;
import com.kdu.smarthome.exceptions.custom.DuplicateEntryException;
import com.kdu.smarthome.exceptions.custom.NotAuthorizedException;
import com.kdu.smarthome.exceptions.custom.UserNotFoundException;
import com.kdu.smarthome.models.*;
import com.kdu.smarthome.repository.HouseRepository;
import com.kdu.smarthome.security.CustomAuthManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class HouseService {
    private final HouseRepository houseRepository;

    private final RoomService roomService;

    private final HouseUserService houseUserService;

    private final DeviceRegistryService deviceRegistryService;

    private final UserService userService;

    public HouseService(HouseRepository houseRepository, RoomService roomService, HouseUserService houseUserService, DeviceRegistryService deviceRegistryService, UserService userService) {
        this.houseRepository = houseRepository;
        this.roomService = roomService;
        this.houseUserService  = houseUserService;
        this.deviceRegistryService = deviceRegistryService;
        this.userService = userService;
    }

    public HouseResponseDTO addHouse(House house){
        try {
            User currUser = userService.getByUserName(CustomAuthManager.getUserName())
                    .orElseThrow(() -> new UserNotFoundException("User not found"));
            houseRepository.save(house);
            HouseUser houseUser = HouseUser.builder().house(house).user(currUser).userRole(UserRole.ADMIN_ROLE).build();
            houseUserService.addHouseUser(houseUser);
            return new HouseResponseDTO(house,"Successfully added house", HttpStatus.OK);
        }
        catch (Exception ex){
            throw new DuplicateEntryException(ex.getMessage());
        }
    }

    public UserResponseDTO addUserToHouse(String houseId, String username){
        try {
            if (!houseUserService.isAdmin(houseId)){
                throw new NotAuthorizedException("You are not authorized to add user");
            }
            User user = userService.getByUserName(username).orElseThrow(() -> new UserNotFoundException("User not found"));
            HouseUser houseUser = HouseUser.builder().userRole(UserRole.USER_ROLE).user(user).house(houseRepository.getReferenceById(houseId)).build();
            houseUserService.addHouseUser(houseUser);
            return new UserResponseDTO(user.getUsername(), "Successfully added User to house", HttpStatus.CREATED);
        }
        catch (Exception ex){
            throw new DuplicateEntryException(ex.getMessage());
        }
    }

    public List<House> getAllHouses(){
        try {
            return houseRepository.findAll();
        }
        catch (Exception ex){
            throw new DuplicateEntryException("Error while adding user ot house");
        }
    }

    public AddressResponseDTO updateHouseAddress(String houseId, String address){

        try {
            House house = houseRepository.getReferenceById(houseId);
            house.setAddress(address);
            houseRepository.save(house);
            return new AddressResponseDTO(house.toString(), "Successfully updated address", HttpStatus.OK);
        }
        catch (Exception ex){
            throw new DuplicateEntryException("Error while updating house address");
        }
    }

    public House getHouse(String houseId){
        try {
            return houseRepository.getReferenceById(houseId);
        }
        catch (Exception ex){
            throw new DuplicateEntryException("Error while fetching house");
        }
    }

    public HouseDetailsResponseDTO getHouseDetails(String houseId){
        try {
            List<Room> roomList = roomService.getAllRooms(houseId);
            List<User> userList = houseUserService.getAllUsers(houseId);
            List<DeviceRegistry> deviceRegistryList = deviceRegistryService.getAllDevices(houseId);
            return new HouseDetailsResponseDTO(userList,roomList.toString()+deviceRegistryList.toString(), HttpStatus.OK);
        }
        catch (Exception ex){
            throw new UserNotFoundException("Error while fetching house");
        }
    }
}
