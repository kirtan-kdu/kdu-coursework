package kdu.ques4.InsurencePlan;

import kdu.ques4.HealthInsurancePlan;

public class SilverPlan extends HealthInsurancePlan {
    public SilverPlan(){
        setCoverage(0.7);
        setDiscount(30.0);
    }

    @Override
    public double computeMonthlyPremium(double salary, int age, boolean smoking) {
        return 0.06 * salary + getOfferedBy().computeMonthlyPremium(this, age, smoking);
    }
}
