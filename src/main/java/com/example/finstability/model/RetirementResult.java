package com.example.finstability.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class RetirementResult {
    private long finalSavingBeforeRetirement = 0;
    private double futureMonthlyExpense = 0;
    private double monthlyInterestIncome = 0;
    private String sustainabilityStatus = "";
    private int yearsLasts = 0;

    // Getters and Setters (Omitted for brevity)

    @Override
    public String toString() {
        return "Results:\n" +
                "Total saving before retirement: " + finalSavingBeforeRetirement + "\n" +
                "Future monthly expense: " + futureMonthlyExpense + "\n" +
                "Monthly interest income: " + monthlyInterestIncome + "\n" +
                "Status: " + sustainabilityStatus + "\n" +
                (yearsLasts > 0 ? "Will last for: " + yearsLasts + " years." : "");
    }
}
