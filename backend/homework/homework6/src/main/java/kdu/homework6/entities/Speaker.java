package kdu.homework6.entities;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Speaker {

    private SpeakerCompany speakerCompany;
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
