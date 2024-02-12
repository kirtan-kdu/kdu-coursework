package com.kdu.smarthome.dto.request;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisterRequestDTO {

    private String houseId;

    private String roomId;

    @JsonProperty("kickston_id")
    private String kickstonId;

    @JsonProperty("device_username")
    private String deviceUsername;

    @JsonProperty("device_password")
    private String devicePassword;
}
