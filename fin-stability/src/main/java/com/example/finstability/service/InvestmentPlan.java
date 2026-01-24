package com.example.finstability.service;

import org.springframework.stereotype.Service;

@Service
public class InvestmentPlan {
    public static long beforeRetirementPlan(double balance , double monthlyInvest,
                                            double investIncrement, double yearlyInterestRate ,
                                            double yearsUntilRetirement)
    {
        double monthlyInterestRate=yearlyInterestRate/1200;
        double interest=0.0;
        long finalSaving=0L;
        balance+=monthlyInvest;

        for(int i=0;i<yearsUntilRetirement;i++){
            if(i%2==0){monthlyInvest+=investIncrement;}
            interest += balance* monthlyInterestRate*12;
            balance+=monthlyInvest;
        }
        System.out.println("balance after invest : "+balance+"\n interest after invest: "+interest);
        return finalSaving+=balance+interest;
    }

    public InvestmentPlan() {
    }
}
