package com.kdu.smarthome.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;



@Data
@Builder
public class DeviceRequestDTO {

    private String houseId;

    private String roomId;

    private String kickstonId;

    @JsonProperty("device_username")
    private String deviceUsername;

    @JsonProperty("device_password")
    private String devicePassword;

}
