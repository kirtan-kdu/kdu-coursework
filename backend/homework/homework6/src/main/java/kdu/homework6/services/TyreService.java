package kdu.homework6.services;

import kdu.homework6.entities.Speaker;
import kdu.homework6.entities.SpeakerCompany;
import kdu.homework6.entities.Tyre;
import kdu.homework6.entities.TyreCompany;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@ComponentScan(basePackages = "kdu.homework6.entities")
public class TyreService {

    @Bean
    Tyre generateTyre(){
        Random random = new Random();
        int tyreCompany = random.nextInt(2) + 1;
        Tyre tyre = new Tyre();
        tyre.setTyreCompany(tyreCompany==1?TyreCompany.MRF:TyreCompany.BRIDGESTONE);
        tyre.setPriceTag(random.nextInt(50_000) + 10_000);
        return tyre;
    }
}
