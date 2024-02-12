package com.kdu.smarthome.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InventoryrequestDTO {
    @JsonProperty("kickston_id")
    private String kickstoneId;

    @JsonProperty("device_username")
    private String deviceUsername;

    @JsonProperty("device_password")
    private String devicePassword;

    @JsonProperty("manufacture_date_time")
    private String manufactureDateTime;

    @JsonProperty("manufacture_factory_place")
    private String manufactureFactoryPlace;

}
