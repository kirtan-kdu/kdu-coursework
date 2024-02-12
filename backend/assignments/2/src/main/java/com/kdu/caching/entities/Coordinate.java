package com.kdu.caching.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Coordinate implements Serializable {
    private double longitude;
    private double latitude;

    public Coordinate(String latitude, String longitude){
        this.longitude = Double.parseDouble(longitude);
        this.latitude = Double.parseDouble(latitude);
    }

    @Override
    public String toString(){
        return "longitude: " + longitude + ", latitude: " + latitude;
    }

}
