package kdu.ques4;


public class BlueCrossBlueShield implements InsuranceBrand {

    public double computeMonthlyPremium(HealthInsurancePlan insurancePlan, int age, boolean smoking){
        double premium = 0;

        if( age > 55 ){
            if(insurancePlan instanceof PlatinumPlan)premium+=200;
            else if(insurancePlan instanceof GoldPlan)premium+=150;
            else if(insurancePlan instanceof SilverPlan)premium+=100;
            else if(insurancePlan instanceof BronzePlan)premium+=50;
        }

        if(smoking){
            if(insurancePlan instanceof PlatinumPlan)premium+=100;
            else if(insurancePlan instanceof GoldPlan)premium+=90;
            else if(insurancePlan instanceof SilverPlan)premium+=80;
            else if(insurancePlan instanceof BronzePlan)premium+=70;
        }

        return premium;
    }
}
