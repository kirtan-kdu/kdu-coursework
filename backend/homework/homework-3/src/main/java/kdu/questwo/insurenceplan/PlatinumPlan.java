package kdu.questwo.insurenceplan;

import kdu.questwo.HealthInsurancePlan;

public class PlatinumPlan extends HealthInsurancePlan {
    public PlatinumPlan(){
        setCoverage(0.9);
        setDiscount(50.0);
    }
}
