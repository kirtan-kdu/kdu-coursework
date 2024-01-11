package kdu.questwo.insurenceplan;

import kdu.questwo.HealthInsurancePlan;

public class GoldPlan extends HealthInsurancePlan {
    public GoldPlan(){
        setCoverage(0.8);
        setDiscount(40.0);
    }
}
