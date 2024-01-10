package kdu.Ques2;


import kdu.Ques2.InsurencePlan.PlatinumPlan;

public class Main {
    public static void main(String[] args) {
        HealthInsurancePlan insurancePlan = new PlatinumPlan();
        Patient patient = new Patient();
        patient.setInsurancePlan(insurancePlan);

        double[] payments = Billing.computePaymentAmount(patient, 1000.0);

        System.out.println(payments[0]);
        System.out.println(payments[1]);

    }
}