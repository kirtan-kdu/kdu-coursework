package org.kdu.homework9.services;


import org.springframework.stereotype.Service;
@Service
public class TataService extends VehicleService {

    @Override
    public double getTax(){
        return 1.1;
    }

}
