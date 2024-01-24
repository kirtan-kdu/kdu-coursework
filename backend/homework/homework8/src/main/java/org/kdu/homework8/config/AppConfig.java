package org.kdu.homework8.config;


import org.kdu.homework8.data.VehiclesInventory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"kdu.homework8.services","kdu.homework8.entities","kdu.homework8.data"})
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
