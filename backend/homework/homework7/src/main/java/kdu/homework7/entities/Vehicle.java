package kdu.homework7.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Vehicle {

    @Override
    public String toString(){
        return "Vehicle - [ tyre company: " + tyre.getTyreCompany() + ", speaker company: " + speaker.getSpeakerCompany() + ", price: " + priceTag + "]";
    }
    public Vehicle(){

    }
    @Autowired
    private Tyre tyre;

    @Autowired
    private Speaker speaker;

    private int priceTag;

    public Vehicle(Tyre tyre, Speaker speaker, int priceTag) {
        this.tyre = tyre;
        this.speaker = speaker;
        this.priceTag = priceTag;
    }

    public Tyre getTyre() {
        return tyre;
    }

    public void setTyre(Tyre tyre) {
        this.tyre = tyre;
    }

    public Speaker getSpeaker() {
        return speaker;
    }

    public void setSpeaker(Speaker speaker) {
        this.speaker = speaker;
    }

    public int getPriceTag() {
        return priceTag;
    }

    public void setPriceTag(int priceTag) {
        this.priceTag = priceTag;
    }
}
