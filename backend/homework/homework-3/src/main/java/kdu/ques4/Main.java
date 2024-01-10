package kdu.ques4;

import kdu.ConsoleLogger;
import kdu.ques4.InsurencePlan.PlatinumPlan;

public class Main {
    public static void main(String[] args){
        User staff = new User();
        InsuranceBrand insuranceBrand = new BlueCrossBlueShield();
        HealthInsurancePlan insurancePlan = new PlatinumPlan();

        insurancePlan.setOfferedBy(insuranceBrand);
        staff.setInsurancePlan(insurancePlan);

        ConsoleLogger.infoMethod(""+insurancePlan.computeMonthlyPremium(5000, 56, true));
    }
}
