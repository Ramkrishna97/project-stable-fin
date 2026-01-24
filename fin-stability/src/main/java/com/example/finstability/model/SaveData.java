package com.example.finstability.model;

import java.util.ArrayList;
import java.util.List;

public class SaveData {
    static List<String> futureData = new ArrayList<>();
    long balance_After_Investment;
//    double initialBalance , monthlyInvest, investIncrement, yearlyInterestRate , yearsUntilRetirement;
//    double finalBalance ,interestRate,currentMonthlyExpense ,inflation ,yearsUntilRetirement2,nextTargetYear;

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

    public SaveData() {
    }
}
