package org.kdu.homework8.entities;


import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Component;

@Component
public class Tyre {

    @NotNull(message = "Tyre Company cannot be blank")
    private TyreCompany tyreCompany;

    @NotNull(message = "priveTag cannot be blank")
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
