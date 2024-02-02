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
@Table(name = "inventory")
public class Inventory extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int inventoryId;

    @Column(nullable = false, length = 6)
    private String kickstonId;

    @Column(nullable = false)
    private String deviceUsername;

    @Column(nullable = false)
    private String devicePassword;

    private String manufactureDateTime;

    private String manufactureFactoryPlace;
}
