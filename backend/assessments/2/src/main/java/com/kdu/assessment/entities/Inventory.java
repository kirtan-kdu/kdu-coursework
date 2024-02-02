package com.kdu.assessment.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Random;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "inventory")
public class Inventory extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID inventoryId;

    private String name;

    private String description;

    private int price;

    private int quantity;

    private int threshold;

    @PrePersist
    @Override
    public void prePersist() {
        this.threshold = new Random().nextInt(10) + 1;
    }
}
