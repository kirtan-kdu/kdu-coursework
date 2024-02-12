package com.kdu.smarthome.repository;

import com.kdu.smarthome.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, String> {
    List<Room> findAllByHouse_Id(String houseId);
}