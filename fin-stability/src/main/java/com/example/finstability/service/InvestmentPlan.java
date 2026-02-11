package com.example.finstability.service;


import org.springframework.stereotype.Service;

@Service
public class InvestmentPlan {
//    public com.example.finstability.model.SaveData data;
//    public static long beforeRetirementPlan(double balance , double monthlyInvest,
//                                            double investIncrement, double yearlyInterestRate ,
//                                            double yearsUntilRetirement)
//    {
//        double monthlyInterestRate=yearlyInterestRate/1200;
//        double interest=0.0;
//        long finalSaving=0L;
//        balance+=monthlyInvest;
//
//        for(int i=0;i<yearsUntilRetirement;i++){
//            if(i%2==0){monthlyInvest+=investIncrement;}
//            interest += balance* monthlyInterestRate*12;
//            balance+=monthlyInvest;
//        }
//        System.out.println("balance after invest : "+balance+"\n interest after invest: "+interest);
//        finalSaving+=balance+interest;
////        System.out.println("Final saving received: "+finalSaving);
////        data.setBalance_After_Investment(finalSaving);
//        return finalSaving;
//    }

    public static long beforeRetirementPlan1(
            long balance,
            double monthlyInvest,
            double investIncrement,
            double yearlyInterestRate,
            double yearsUntilRetirement) {

        for (int year = 1; year <= yearsUntilRetirement; year++) {
            balance += monthlyInvest * 12;
            balance *= (1 + yearlyInterestRate / 100.0);
            if (year % 2 == 0) {
                monthlyInvest += investIncrement;
            }
        }
        long finalSaving = (long) balance;
        System.out.println("Total saving before retirement : " + finalSaving);
        return finalSaving;
    }
}

