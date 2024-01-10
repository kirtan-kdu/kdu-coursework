package kdu.ques3.InsurencePlan;

import kdu.ques3.HealthInsurancePlan;

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
