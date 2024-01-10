package kdu.Ques3.InsurencePlan;

import kdu.Ques3.HealthInsurancePlan;

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
