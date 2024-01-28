package com.kdu.caching.dto.request;


import com.kdu.caching.entities.Coordinate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestCoordinateDTO {
    
    private Coordinate coordinate;
    
}
