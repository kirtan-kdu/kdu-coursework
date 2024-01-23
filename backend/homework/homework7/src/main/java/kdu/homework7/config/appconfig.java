package kdu.homework7.config;


import kdu.homework7.data.VehiclesInventory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"kdu.homework7.services","kdu.homework7.entities","kdu.homework7.data"})
public class appconfig {

    @Bean("TataInventory")
    public VehiclesInventory TeslaInventory(){
        return new VehiclesInventory();
    }

    @Bean("TeslaInventory")
    public VehiclesInventory TataInventory(){
        return new VehiclesInventory();
    }

}
