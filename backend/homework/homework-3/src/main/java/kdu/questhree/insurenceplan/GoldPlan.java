package kdu.questhree.insurenceplan;

import kdu.questhree.HealthInsurancePlan;

public class GoldPlan extends HealthInsurancePlan {
    public GoldPlan(){
        setCoverage(0.8);
        setDiscount(40.0);
    }
    @Override
    public double computeMonthlyPremium(double salary) {
        return 0.07 * salary;
    }
}
