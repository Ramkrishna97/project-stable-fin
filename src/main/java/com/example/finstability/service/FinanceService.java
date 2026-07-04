package com.example.finstability.service;

import com.example.finstability.model.FinancialParameters;
import com.example.finstability.model.RetirementResult;
import org.springframework.stereotype.Service;

@Service
public class FinanceService {

    // Logic extracted from beforeRetirementPlan
    public long calculateSaving(FinancialParameters params) {
        double balance = params.getCurrentBalance();
        double monthlyInvest = params.getMonthlyInvest();
        double investIncrement = params.getInvestIncrement();
        double yearlyInterestRate = params.getYearlyInterestRate();
        int yearsUntilRetirement = params.getYearsUntilRetirement();

        for (int year = 1; year <= yearsUntilRetirement; year++) {
            balance += monthlyInvest * 12;
            balance *= (1 + yearlyInterestRate / 100.0);
            if (year % 2 == 0) {
                monthlyInvest += investIncrement;
            }
        }
        return (long) balance;
    }

    // Logic extracted from retirementPlan
    public RetirementResult simulateRetirement(FinancialParameters params, long finalBalanceBeforeRetirement) {
        RetirementResult result = new RetirementResult();
        params.setCurrentBalance(finalBalanceBeforeRetirement); // Start with the calculated saving
        double balance = finalBalanceBeforeRetirement;

        // 1. Calculate future expenses adjusted for inflation
        double futureMonthlyExpense = (params.getCurrentMonthlyExpense() * 12 * Math.pow((1 + params.getInflationRate() / 100.0), params.getYearsUntilRetirement())) / 12;
        result.setFutureMonthlyExpense(futureMonthlyExpense);

        // 2. Calculate interest income based on current balance and rate
        double monthlyInterestOnTotalSaving = balance * (params.getYearlyInterestRate() / 100.0) / 12.0;
        result.setMonthlyInterestIncome(monthlyInterestOnTotalSaving);

        // 3. Check sustainability
        if (monthlyInterestOnTotalSaving > futureMonthlyExpense) {
            // Sustainable - logic simplified to report success for demonstration
            result.setSustainabilityStatus("Sustainable: Interest income covers expenses.");
            // In a real app, you'd loop through yearsUntilRetirement here
            result.setYearsLasts(params.getRetirementDurationYears());
        } else {
            // Not sustainable - calculate how long it lasts
            double deficit = futureMonthlyExpense - monthlyInterestOnTotalSaving;
            int yearsLeft = 0;
            while (balance > 0) {
                balance -= (futureMonthlyExpense - monthlyInterestOnTotalSaving);
                yearsLeft++;
            }
            result.setSustainabilityStatus("Not Sustainable: Running on principal depletion.");
            result.setYearsLasts(Math.max(1, yearsLeft)); // Ensure it lasts at least 1 year if balance > 0 initially
        }

        return result;
    }
}
