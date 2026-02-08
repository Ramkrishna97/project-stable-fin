package com.example.finstability.model;

//import jakarta.persistence.Entity;

import java.util.ArrayList;
import java.util.List;

public class SaveData {
//    double balance;
//    double monthlyInvest;
//    double investIncrement;
//    double yearlyInterestRate;
//    double yearsUntilRetirement;
//
//
////    double balance ;
//    double interestRate;
//    double currentMonthlyExpense ;
//    double inflation;
////    double yearsUntilRetirement;
//    double nextTargetYear;

    //only saves data as which ones are fixed, not variable
    //can include users based data in future.
    List<String>InvestPlanData=new ArrayList<>();
    List<String> retirementPlanData=new ArrayList<>();


    public SaveData() {
    }
}
