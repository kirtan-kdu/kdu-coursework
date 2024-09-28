package kdu.homework6.entities;

import org.springframework.stereotype.Component;

@Component
public class Tyre {

    private TyreCompany tyreCompany;

    private int priceTag;

    public TyreCompany getTyreCompany() {
        return tyreCompany;
    }

    public void setTyreCompany(TyreCompany tyreCompany) {
        this.tyreCompany = tyreCompany;
    }

    public int getPriceTag() {
        return priceTag;
    }

    public void setPriceTag(int priceTag) {
        this.priceTag = priceTag;
    }
}
