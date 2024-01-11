package kdu.quesfour.insurenceplan;

import kdu.quesfour.HealthInsurancePlan;

public class BronzePlan extends HealthInsurancePlan {
    public BronzePlan(){
        setCoverage(0.6);
        setDiscount(25.0);
    }

    @Override
    public double computeMonthlyPremium(double salary, int age, boolean smoking) {
        return 0.05 * salary + getOfferedBy().computeMonthlyPremium(this, age, smoking);
    }
}
