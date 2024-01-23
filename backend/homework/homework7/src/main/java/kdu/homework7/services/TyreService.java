package kdu.homework7.services;


import kdu.homework7.entities.Tyre;
import kdu.homework7.entities.TyreCompany;
import kdu.homework7.utils.RandomNumber;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

@Service
@ComponentScan(basePackages = "kdu.homework7.entities")
public class TyreService {
    @Bean
    Tyre generateTyre(){
        int tyreCompany = RandomNumber.generate(2) + 1;
        Tyre tyre = new Tyre();
        tyre.setTyreCompany(tyreCompany==1?TyreCompany.MRF:TyreCompany.BRIDGESTONE);
        tyre.setPriceTag(RandomNumber.generate(50_000) + 10_000);
        return tyre;
    }
}
