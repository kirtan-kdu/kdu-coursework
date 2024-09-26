package kdu.homework7.config;


import kdu.homework7.data.VehiclesInventory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"kdu.homework7.services","kdu.homework7.entities","kdu.homework7.data"})
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
