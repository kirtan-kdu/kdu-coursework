package org.kdu.homework8.services;

import org.kdu.homework8.entities.Speaker;
import org.kdu.homework8.entities.SpeakerCompany;
import org.kdu.homework8.utils.RandomNumber;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

@Service
@ComponentScan(basePackages = "kdu.homework8.entities")
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
