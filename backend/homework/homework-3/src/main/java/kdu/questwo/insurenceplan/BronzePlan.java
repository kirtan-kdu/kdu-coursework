package kdu.questwo.insurenceplan;

import kdu.questwo.HealthInsurancePlan;

public class BronzePlan extends HealthInsurancePlan {
    public BronzePlan(){
        setCoverage(0.6);
        setDiscount(25.0);
    }
}
