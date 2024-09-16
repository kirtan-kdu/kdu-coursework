package org.kdu.homework8.services;

import org.springframework.stereotype.Service;


@Service
public class TeslaService extends VehicleService {


    @Override
    public double getTax(){
        return 1.4;
    }

}
