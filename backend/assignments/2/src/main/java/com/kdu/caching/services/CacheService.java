package com.kdu.caching.services;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kdu.caching.constants.APIConstants;
import com.kdu.caching.dto.request.RequestAddressDTO;
import com.kdu.caching.dto.request.RequestCoordinateDTO;
import com.kdu.caching.dto.response.ResponseAddressDTO;
import com.kdu.caching.dto.response.ResponseCoordinateDTO;
import com.kdu.caching.repository.CacheRepo;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class CacheService {

    private final CacheRepo cacheRepo;

    private final GeocodingService geocodingService;

    private final Logger logger = LoggerFactory.getLogger(CacheService.class);
    @Autowired
    public CacheService(CacheRepo cacheRepo, GeocodingService geocodingService){
        this.cacheRepo = cacheRepo;
        this.geocodingService = geocodingService;
    }

    /**
     * Primary service which first checks in cache or else calls the Geocoding Service API
     * @param coordinateDTO
     * @return
     */
    public ResponseAddressDTO getAddress(RequestCoordinateDTO coordinateDTO){

        if (Boolean.TRUE.equals(cacheRepo.isStored(APIConstants.REV_CACHE, coordinateDTO.getCoordinate().toString()))) {
            logger.debug("Coordinates are already stored in cache");
            return new ResponseAddressDTO(cacheRepo.get(APIConstants.REV_CACHE, coordinateDTO.getCoordinate().toString()), HttpStatus.OK);
        }

        JSONObject address = geocodingService.revGeoCodingAPICall(coordinateDTO.getCoordinate());

        logger.debug("Called geocoding api for response,");

        if(logger.isInfoEnabled())logger.info(address.toString());

        if(!address.get("region").toString().equalsIgnoreCase("Goa")){
            logger.warn("Saved response in cache");
            cacheRepo.put(APIConstants.REV_CACHE,coordinateDTO.getCoordinate().toString(),address.get("label").toString());
        }

        return new ResponseAddressDTO(address.get("label").toString(), HttpStatus.OK);
    }

    /**
     * Primary service which first checks for cached address or else calls Reverse-Geocoding API
     * @param addressDTO
     * @return
     */
    public ResponseCoordinateDTO getCoordinate(RequestAddressDTO addressDTO) throws JsonProcessingException {

        if(Boolean.TRUE.equals(cacheRepo.isStored(APIConstants.GEO_CACHE, addressDTO.getAddress()))){
            logger.debug("Address is already stored in cache");
            return new ResponseCoordinateDTO(cacheRepo.get(APIConstants.GEO_CACHE, addressDTO.getAddress()), HttpStatus.OK);
        }

        JSONObject coordinate = geocodingService.geoCodingAPICall(addressDTO.getAddress());
        Map<String , Double> map = new HashMap<>();
        map.put("longitude",Double.parseDouble(coordinate.get("longitude").toString()));
        map.put("latitude",Double.parseDouble(coordinate.get("latitude").toString()));

        logger.debug("Called reverse-geocoding api for response,");
        if(logger.isInfoEnabled())logger.info(map.toString());

        if(!coordinate.get("region").toString().equalsIgnoreCase("Goa")){
            logger.warn("Saved response in cache");
            cacheRepo.put(APIConstants.GEO_CACHE,addressDTO.getAddress(),map.toString());
        }

        return new ResponseCoordinateDTO(new ObjectMapper().writeValueAsString(map), HttpStatus.OK);
    }
}
