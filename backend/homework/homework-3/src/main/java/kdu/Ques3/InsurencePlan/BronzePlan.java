package kdu.Ques3.InsurencePlan;

import kdu.Ques3.HealthInsurancePlan;

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
