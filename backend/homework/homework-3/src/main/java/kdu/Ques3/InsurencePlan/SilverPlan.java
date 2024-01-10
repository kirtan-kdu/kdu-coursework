package kdu.Ques3.InsurencePlan;

import kdu.Ques3.HealthInsurancePlan;

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
