package com.example.finstability.model;

//import jakarta.persistence.Entity;

import java.util.ArrayList;
import java.util.List;

public class SaveData {

    private int id;
    static List<String> futureData = new ArrayList<>();
    long balance_After_Investment;
    double initialBalance , monthlyInvest, investIncrement, yearlyInterestRate , yearsUntilRetirement;
    double finalBalance ,interestRate,currentMonthlyExpense ,inflation ,yearsUntilRetirement2,nextTargetYear;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getInitialBalance() {
        return initialBalance;
    }

    public void setInitialBalance(double initialBalance) {
        this.initialBalance = initialBalance;
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

    public double getFinalBalance() {
        return finalBalance;
    }

    public void setFinalBalance(double finalBalance) {
        this.finalBalance = finalBalance;
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

    public double getYearsUntilRetirement2() {
        return yearsUntilRetirement2;
    }

    public void setYearsUntilRetirement2(double yearsUntilRetirement2) {
        this.yearsUntilRetirement2 = yearsUntilRetirement2;
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
                "FutureData=" + futureData +
                ", balance_After_Investment=" + balance_After_Investment +
                '}';
    }

    public List<String> getFutureData() {
        return futureData;
    }

    public void setFutureData(List<String> futureData) {
        futureData = futureData;
    }

    public long getBalance_After_Investment() {
        return balance_After_Investment;
    }

    public void setBalance_After_Investment(long balance_After_Investment) {
        this.balance_After_Investment = balance_After_Investment;
    }

    public SaveData(List<String> futureData, long balance_After_Investment) {
        futureData = futureData;
        this.balance_After_Investment = balance_After_Investment;
    }

//    @Override
//    public String toString() {
//        return "SaveData{" +
//                "id=" + id +
//                ", balance_After_Investment=" + balance_After_Investment +
//                ", initialBalance=" + initialBalance +
//                ", monthlyInvest=" + monthlyInvest +
//                ", investIncrement=" + investIncrement +
//                ", yearlyInterestRate=" + yearlyInterestRate +
//                ", yearsUntilRetirement=" + yearsUntilRetirement +
//                ", finalBalance=" + finalBalance +
//                ", interestRate=" + interestRate +
//                ", currentMonthlyExpense=" + currentMonthlyExpense +
//                ", inflation=" + inflation +
//                ", yearsUntilRetirement2=" + yearsUntilRetirement2 +
//                ", nextTargetYear=" + nextTargetYear +
//                '}';
//    }

    public SaveData() {
    }
}
