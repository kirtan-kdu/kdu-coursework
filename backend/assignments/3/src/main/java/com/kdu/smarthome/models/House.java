package com.kdu.smarthome.models;

import com.kdu.smarthome.entities.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "house")
public class House extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int houseId;

    private String address;

    private String houseName;

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;

}
