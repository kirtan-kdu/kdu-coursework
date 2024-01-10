package kdu.ques3;

public abstract class HealthInsurancePlan {
public abstract double computeMonthlyPremium(double salary);
    private double coverage;
    private double discount;

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getCoverage() {
        return coverage;
    }

    public void setCoverage(double coverage) {
        this.coverage = coverage;
    }

}
