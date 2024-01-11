package kdu.questhree.InsurencePlan;

import kdu.questhree.HealthInsurancePlan;

public class SilverPlan extends HealthInsurancePlan {
    public SilverPlan(){
        setCoverage(0.7);
        setDiscount(30.0);
    }

    @Override
    public double computeMonthlyPremium(double salary) {
        return 0.06 * salary;
    }
}
