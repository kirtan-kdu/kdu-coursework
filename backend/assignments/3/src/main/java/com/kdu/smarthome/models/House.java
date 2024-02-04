package com.kdu.smarthome.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kdu.smarthome.entities.BaseEntity;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "house")
@Builder
public class House extends BaseEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    private String address;

    @JsonProperty("house_name")
    private String houseName;

}
