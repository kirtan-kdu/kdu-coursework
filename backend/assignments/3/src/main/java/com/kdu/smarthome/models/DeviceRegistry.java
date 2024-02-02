package com.kdu.smarthome.models;


import com.kdu.smarthome.entities.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "device_registry")
public class DeviceRegistry extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int deviceId;

    @Column(name = "device_username", nullable = false)
    private String deviceUsername;

    @Column(name = "device_password", nullable = false)
    private String devicePassword;

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;

    @ManyToOne
    @JoinColumn(name = "house_id", nullable = false)
    private House house;
}
