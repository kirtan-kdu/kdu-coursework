package kdu.questhree.InsurencePlan;

import kdu.questhree.HealthInsurancePlan;

public class PlatinumPlan extends HealthInsurancePlan {
    public PlatinumPlan(){
        setCoverage(0.9);
        setDiscount(50.0);
    }

    @Override
    public double computeMonthlyPremium(double salary) {
        return 0.08 * salary;
    }
}
