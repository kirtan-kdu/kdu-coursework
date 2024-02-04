package com.kdu.smarthome.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.kdu.smarthome.entities.BaseEntity;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "inventory")
public class Inventory extends BaseEntity {
    @Id
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
