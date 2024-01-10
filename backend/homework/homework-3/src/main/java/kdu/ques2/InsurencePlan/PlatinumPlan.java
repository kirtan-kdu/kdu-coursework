package kdu.ques2.InsurencePlan;

import kdu.ques2.HealthInsurancePlan;

public class PlatinumPlan extends HealthInsurancePlan {
    public PlatinumPlan(){
        setCoverage(0.9);
        setDiscount(50.0);
    }
}
