package org.kdu.homework8.services;


import org.kdu.homework8.entities.Vehicle;

public interface IVehicleService {

    public void generateVehicleList();
    public Vehicle generateVehicle();

    public double getTax();

    public Vehicle mostExpensive();

    public Vehicle leastExpensive();

}
