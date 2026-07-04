package com.example.finstability.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.Year;

@Getter
@Setter
@RequiredArgsConstructor
public class FinancialParameters {
    private double currentBalance = 0;
    private double monthlyInvest = 0;
    private double investIncrement = 0;
    private double yearlyInterestRate = 6.0; // Default
    private int yearsUntilRetirement = 60 -  Year.now().getValue();  // Default

    // Retirement specific fields (can be expanded)
    private double currentMonthlyExpense = 180000 / 12; // Example conversion for input simplicity
    private double inflationRate = 4.0;     // average rate of yearly inflation in India
    private int retirementDurationYears = 25;   // expected years to last after retirement : till age of 85

    public void setCurrentBalance(double currentBalance) { this.currentBalance = currentBalance; }
    public double getCurrentBalance() { return currentBalance; }
}
