package com.example.finstability.service;

import org.springframework.stereotype.Service;

@Service
public class InvestmentPlan {
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

    public double savedAmount(
            long balance,
            double monthlyInvest,
            double investIncrement,
            double yearlyInterestRate,
            double yearsUntilRetirement
            ){
        double total_lump_sum = 0.0;




        return total_lump_sum;
    }
}

