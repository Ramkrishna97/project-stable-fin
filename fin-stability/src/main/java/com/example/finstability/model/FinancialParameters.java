package com.example.finstability.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class FinancialParameters {
    private double currentBalance = 0;
    private double monthlyInvest = 0;
    private double investIncrement = 0;
    private double yearlyInterestRate = 6.0; // Default
    private int yearsUntilRetirement = 20;  // Default

    // Retirement specific fields (can be expanded)
    private double currentMonthlyExpense = 25000 / 12; // Example conversion for input simplicity
    private double inflationRate = 3.0;
    private int retirementDurationYears = 25;

    // Getters and Setters (Omitted for brevity, but required in a real implementation)
    // Lombok @Data annotation is often used here.

    public void setCurrentBalance(double currentBalance) { this.currentBalance = currentBalance; }
    public double getCurrentBalance() { return currentBalance; }
    // ... setters for all fields
}
