package kdu.homework6.services;

import kdu.homework6.entities.Speaker;
import kdu.homework6.entities.SpeakerCompany;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@ComponentScan(basePackages = "kdu.homework6.entities")
public class SpeakerService {

    @Bean
    Speaker generateSpeaker(){
        Random random = new Random();
        int speakerCompany = random.nextInt(2) + 1;
        Speaker speaker = new Speaker();
        speaker.setSpeakerCompany(speakerCompany==1?SpeakerCompany.SONY:SpeakerCompany.BOSE);
        speaker.setPrice(random.nextInt(10_000) + 1_000);
        return speaker;
    }

}
