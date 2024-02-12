package com.kdu.caching.controllers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.kdu.caching.dto.request.RequestAddressDTO;
import com.kdu.caching.dto.request.RequestCoordinateDTO;
import com.kdu.caching.dto.response.ResponseAddressDTO;
import com.kdu.caching.dto.response.ResponseCoordinateDTO;
import com.kdu.caching.entities.Coordinate;
import com.kdu.caching.services.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GeocodingController {

    private CacheService cacheService;

    @Autowired
    public GeocodingController(CacheService cacheService){
        this.cacheService = cacheService;
    }

    /**
     * API end-point for getting Co-ordinates from the given location
     * @param address of the location
     * @returns Co-ordinates of that location
     * @throws JsonProcessingException
     */
    @GetMapping("/geocoding")
    public ResponseEntity<String> geoCodingRequest(@RequestParam("address") String address) throws JsonProcessingException {
        ResponseCoordinateDTO coordinateDTO = cacheService.getCoordinate(new RequestAddressDTO(address));
        return new ResponseEntity<>(coordinateDTO.getCoordinate(), coordinateDTO.getHttpStatus());
    }

    /**
     * API end-point for converting co-ordinates to exact address location
     * @param latitude of a location
     * @param longitude of a location
     * @return
     */
    @GetMapping("/reverse-geocoding")
    public ResponseEntity<String> geoCodingRequest(@RequestParam("latitude") double latitude, @RequestParam("longitude") double longitude){
        ResponseAddressDTO addressDTO = cacheService.getAddress(new RequestCoordinateDTO(new Coordinate(longitude, latitude)));
        return new ResponseEntity<>(addressDTO.getAddress(), addressDTO.getHttpStatus());
    }

}
