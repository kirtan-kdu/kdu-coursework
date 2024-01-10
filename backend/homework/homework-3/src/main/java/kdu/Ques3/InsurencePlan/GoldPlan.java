package kdu.Ques3.InsurencePlan;

import kdu.Ques3.HealthInsurancePlan;

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
