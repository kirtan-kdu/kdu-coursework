package com.kdu.smarthome.dto.response;

import com.kdu.smarthome.models.DeviceRegistry;
import com.kdu.smarthome.models.Room;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;


@Data
@Builder
@AllArgsConstructor
public class RoomsAndDeviceDTO {
    private List<Room> roomList;
    private List<DeviceRegistry> deviceRegistryList;
}
