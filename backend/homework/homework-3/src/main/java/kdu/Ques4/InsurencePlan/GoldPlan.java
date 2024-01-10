package kdu.Ques4.InsurencePlan;

import kdu.Ques4.HealthInsurancePlan;

public class GoldPlan extends HealthInsurancePlan {
    public GoldPlan(){
        setCoverage(0.8);
        setDiscount(40.0);
    }
    @Override
    public double computeMonthlyPremium(double salary, int age, boolean smoking) {
        return 0.07 * salary + getOfferedBy().computeMonthlyPremium(this, age, smoking);
    }
}
