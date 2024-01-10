package kdu.ques3.InsurencePlan;

import kdu.ques3.HealthInsurancePlan;

public class BronzePlan extends HealthInsurancePlan {
    public BronzePlan(){
        setCoverage(0.6);
        setDiscount(25.0);
    }

    @Override
    public double computeMonthlyPremium(double salary) {
        return 0.05 * salary;
    }
}
