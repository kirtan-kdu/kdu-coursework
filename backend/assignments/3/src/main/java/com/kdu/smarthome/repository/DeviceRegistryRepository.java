package com.kdu.smarthome.repository;

import com.kdu.smarthome.models.DeviceRegistry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeviceRegistryRepository extends JpaRepository<DeviceRegistry, String> {

    List<DeviceRegistry> findAllByHouse_Id(String houseId);
}