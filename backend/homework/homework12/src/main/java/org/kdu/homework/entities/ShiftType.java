package org.kdu.homework.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "shift_type")
@Entity
public class ShiftType extends UpdateTime {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "unique_name")
    private String uniqueName;

    private String description;

    private boolean active;

    @Column(name = "time_zone")
    private String timeZone;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tenant_id")
    private Tenant tenant;

}