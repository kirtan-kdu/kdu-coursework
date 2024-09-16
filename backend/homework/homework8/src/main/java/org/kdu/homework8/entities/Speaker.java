package org.kdu.homework8.entities;

import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Component;

@Component
public class Speaker {
    @NotNull(message = "Speaker Company cannot be blank")
    private SpeakerCompany speakerCompany;
    @NotNull(message = "Price cannot be blank")
    private int price;


    public SpeakerCompany getSpeakerCompany() {
        return speakerCompany;
    }

    public void setSpeakerCompany(SpeakerCompany speakerCompany) {
        this.speakerCompany = speakerCompany;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
