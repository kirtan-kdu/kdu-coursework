package com.kdu.smarthome.dto.request;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DeviceRequestDTO {
    private String houseId;

    private String roomId;

    private String kickstonId;
}
