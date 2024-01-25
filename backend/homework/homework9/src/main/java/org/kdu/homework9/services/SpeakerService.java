package org.kdu.homework9.services;

import org.kdu.homework9.entities.Speaker;
import org.kdu.homework9.entities.SpeakerCompany;
import org.kdu.homework9.utils.RandomNumber;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

@Service
@ComponentScan(basePackages = "kdu.homework9.entities")
public class SpeakerService {

    @Bean
    Speaker generateSpeaker(){
        int speakerCompany = RandomNumber.generate(2) + 1;
        Speaker speaker = new Speaker();
        speaker.setSpeakerCompany(speakerCompany==1?SpeakerCompany.SONY: SpeakerCompany.BOSE);
        speaker.setPrice(RandomNumber.generate(10_000) + 1_000);
        return speaker;
    }

}
