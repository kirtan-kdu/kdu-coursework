package kdu.questwo;

public class Billing {
    public static double[] computePaymentAmount(Patient patient, double amount) {
        double[] payments = new double[2];

        HealthInsurancePlan patientInsurancePlan = patient.getInsurancePlan();

        // your logic

        double coverage = 0 ;
        double discount = 20;

        if(patientInsurancePlan != null){
            coverage = patientInsurancePlan.getCoverage();
            discount = patientInsurancePlan.getDiscount();
        }


        payments[0] = amount * coverage;
        payments[1] = amount * (1 - coverage) - discount;

        return payments;
    }
}