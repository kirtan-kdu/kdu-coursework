package org.kdu.homework.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User extends UpdateTime {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String username;

    @Column(name = "logged_in")
    private int loggedIn;

    @Column(name = "time_zone")
    private String timeZone;

    @ManyToOne(fetch = FetchType.EAGER)
    private Tenant tenant;


}
