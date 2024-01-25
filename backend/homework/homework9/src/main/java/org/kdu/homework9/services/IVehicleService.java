package org.kdu.homework9.services;


import org.kdu.homework9.entities.Vehicle;

public interface IVehicleService {

    public Vehicle generateVehicle();

    public double getTax();

    public Vehicle leastExpensive();

    public Vehicle mostExpensive();


}
