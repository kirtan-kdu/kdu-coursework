package kdu.ques4;

import kdu.ques4.InsurencePlan.BronzePlan;
import kdu.ques4.InsurencePlan.GoldPlan;
import kdu.ques4.InsurencePlan.PlatinumPlan;
import kdu.ques4.InsurencePlan.SilverPlan;

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
