package org.kdu.homework9.config;


import org.kdu.homework9.data.VehiclesInventory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"kdu.homework9.services","kdu.homework9.entities","kdu.homework9.data"})
public class AppConfig {

    @Bean("tataInventory")
    public VehiclesInventory teslaInventory(){
        return new VehiclesInventory();
    }

    @Bean("teslaInventory")
    public VehiclesInventory tataInventory(){
        return new VehiclesInventory();
    }

}
