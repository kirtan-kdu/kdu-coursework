package kdu.ques2;


import kdu.ConsoleLogger;
import kdu.ques2.InsurencePlan.PlatinumPlan;

public class Main {
    public static void main(String[] args) {
        HealthInsurancePlan insurancePlan = new PlatinumPlan();
        Patient patient = new Patient();
        patient.setInsurancePlan(insurancePlan);

        double[] payments = Billing.computePaymentAmount(patient, 1000.0);

        ConsoleLogger.infoMethod(""+payments[0]);
        ConsoleLogger.infoMethod(""+payments[1]);

    }
}