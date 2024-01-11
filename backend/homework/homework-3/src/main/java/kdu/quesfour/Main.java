package kdu.quesfour;

import kdu.ConsoleLogger;
import kdu.quesfour.InsurencePlan.PlatinumPlan;

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
