package com.kdu.smarthome.models;

import com.kdu.smarthome.entities.BaseEntity;
import com.kdu.smarthome.entities.UserRole;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "house_user")
public class HouseUser extends BaseEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String houseUserId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    private House house;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "username", nullable = false)
    private User user;

    @Column(name = "user_role", nullable = false)
    private UserRole userRole;

}
