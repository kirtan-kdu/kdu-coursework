package com.kdu.smarthome.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.kdu.smarthome.entities.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "device_registry")
public class DeviceRegistry extends BaseEntity {

    @Id
    @JsonProperty("kickston_id")
    private String kickstonId;

    @Column(name = "device_username", nullable = false)
    @JsonProperty("device_username")
    private String deviceUsername;

    @Column(name = "device_password", nullable = false)
    @JsonProperty("device_password")
    private String devicePassword;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "room_id")
    @JsonProperty("room_id")
    private Room room;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    @JsonProperty("house_id")
    private House house;
}
