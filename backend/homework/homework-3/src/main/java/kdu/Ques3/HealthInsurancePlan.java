package kdu.Ques3;

public abstract class HealthInsurancePlan {
//    private InsuranceBrand offeredBy;
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

//    public InsuranceBrand getOfferedBy() {
//        return offeredBy;
//    }
//    public void setOfferedBy(InsuranceBrand offeredBy) {
//        this.offeredBy = offeredBy;
//    }
}
