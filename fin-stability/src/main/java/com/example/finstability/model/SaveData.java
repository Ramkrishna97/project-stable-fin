package com.example.finstability.model;

//import jakarta.persistence.Entity;

import java.util.ArrayList;
import java.util.List;

public class SaveData {
    double balance;
    double monthlyInvest;
    double investIncrement;
    double yearlyInterestRate;
    double yearsUntilRetirement;


//    double balance ;
    double interestRate;
    double currentMonthlyExpense ;
    double inflation;
//    double yearsUntilRetirement;
    double nextTargetYear;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getMonthlyInvest() {
        return monthlyInvest;
    }

    public void setMonthlyInvest(double monthlyInvest) {
        this.monthlyInvest = monthlyInvest;
    }

    public double getInvestIncrement() {
        return investIncrement;
    }

    public void setInvestIncrement(double investIncrement) {
        this.investIncrement = investIncrement;
    }

    public double getYearlyInterestRate() {
        return yearlyInterestRate;
    }

    public void setYearlyInterestRate(double yearlyInterestRate) {
        this.yearlyInterestRate = yearlyInterestRate;
    }

    public double getYearsUntilRetirement() {
        return yearsUntilRetirement;
    }

    public void setYearsUntilRetirement(double yearsUntilRetirement) {
        this.yearsUntilRetirement = yearsUntilRetirement;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double getCurrentMonthlyExpense() {
        return currentMonthlyExpense;
    }

    public void setCurrentMonthlyExpense(double currentMonthlyExpense) {
        this.currentMonthlyExpense = currentMonthlyExpense;
    }

    public double getInflation() {
        return inflation;
    }

    public void setInflation(double inflation) {
        this.inflation = inflation;
    }

    public double getNextTargetYear() {
        return nextTargetYear;
    }

    public void setNextTargetYear(double nextTargetYear) {
        this.nextTargetYear = nextTargetYear;
    }

    @Override
    public String toString() {
        return "SaveData{" +
                "balance=" + balance +
                ", monthlyInvest=" + monthlyInvest +
                ", investIncrement=" + investIncrement +
                ", yearlyInterestRate=" + yearlyInterestRate +
                ", yearsUntilRetirement=" + yearsUntilRetirement +
                ", interestRate=" + interestRate +
                ", currentMonthlyExpense=" + currentMonthlyExpense +
                ", inflation=" + inflation +
                ", nextTargetYear=" + nextTargetYear +
                '}';
    }

    public SaveData() {
    }
}
