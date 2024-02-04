package com.kdu.smarthome.services;

import com.kdu.smarthome.dto.response.RoomResponseDTO;
import com.kdu.smarthome.exceptions.custom.NotAuthorizedException;
import com.kdu.smarthome.exceptions.custom.UserNotFoundException;
import com.kdu.smarthome.models.Room;
import com.kdu.smarthome.repository.HouseRepository;
import com.kdu.smarthome.repository.RoomRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    private final RoomRepository roomRepository;
    private final HouseUserService houseUserService;
    private final HouseRepository houseRepository;

    public RoomService(RoomRepository roomRepository, HouseUserService houseUserService, HouseRepository houseRepository){
        this.roomRepository = roomRepository;
        this.houseUserService = houseUserService;
        this.houseRepository = houseRepository;
    }

    public RoomResponseDTO addRoomToHouse(String houseId,String roomname){
        try {
            if (!houseUserService.isAdmin(houseId)){
                throw new NotAuthorizedException("You are not authorized to add room to this house");
            }
            Room room = Room.builder().roomName(roomname).house(houseRepository.getReferenceById(houseId)).build();
            roomRepository.save(room);
            return new RoomResponseDTO(room, "Successfully added room", HttpStatus.OK);
        }
        catch (Exception ex){
            throw new UserNotFoundException("Room already exists with given name");
        }
    }

    public Room getRoom(String roomId){
        try {
            return roomRepository.getReferenceById(roomId);
        }
        catch (Exception ex){
            throw new UserNotFoundException("Error while fetching room with given id");
        }
    }

    public List<Room> getAllRooms(String houseId){
        try {
            return roomRepository.findAllByHouse_Id(houseId);
        }
        catch (Exception ex){
            throw new UserNotFoundException("Error while fetching list of rooms");
        }
    }
}
