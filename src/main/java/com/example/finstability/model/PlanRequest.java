package com.example.finplanner.model;

/**
 * All the numbers needed to run both calculations:
 * saving up until retirement, and spending after retirement.
 * Every field has a sensible default so the endpoint works even if
 * you don't pass every parameter.
 */
public class PlanRequest {

    // --- before retirement ---
    private double startingBalance = 0;
    private double monthlyInvestment = 5000;
    private double investmentIncrement = 500;      // added to monthlyInvestment every 2 years
    private double beforeRetirementInterestRate = 8; // % per year, while saving
    private double yearsUntilRetirement = 20;

    // --- at / after retirement ---
    private double afterRetirementInterestRate = 6;  // % per year, while withdrawing
    private double currentMonthlyExpense = 25000;     // in today's money
    private double inflationRate = 6;                 // % per year, to project expense forward
    private double yearsToProject = 25;               // how many post-retirement years to check

    public double getStartingBalance() { return startingBalance; }
    public void setStartingBalance(double v) { this.startingBalance = v; }

    public double getMonthlyInvestment() { return monthlyInvestment; }
    public void setMonthlyInvestment(double v) { this.monthlyInvestment = v; }

    public double getInvestmentIncrement() { return investmentIncrement; }
    public void setInvestmentIncrement(double v) { this.investmentIncrement = v; }

    public double getBeforeRetirementInterestRate() { return beforeRetirementInterestRate; }
    public void setBeforeRetirementInterestRate(double v) { this.beforeRetirementInterestRate = v; }

    public double getYearsUntilRetirement() { return yearsUntilRetirement; }
    public void setYearsUntilRetirement(double v) { this.yearsUntilRetirement = v; }

    public double getAfterRetirementInterestRate() { return afterRetirementInterestRate; }
    public void setAfterRetirementInterestRate(double v) { this.afterRetirementInterestRate = v; }

    public double getCurrentMonthlyExpense() { return currentMonthlyExpense; }
    public void setCurrentMonthlyExpense(double v) { this.currentMonthlyExpense = v; }

    public double getInflationRate() { return inflationRate; }
    public void setInflationRate(double v) { this.inflationRate = v; }

    public double getYearsToProject() { return yearsToProject; }
    public void setYearsToProject(double v) { this.yearsToProject = v; }
}