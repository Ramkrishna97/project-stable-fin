package com.example.finstability.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
class StableFin {
//    static SaveData sdata;

    public static void main(String[] args) {
        System.out.println("*_* Financial Stability Module has Awaken. 0-0 \n");

        InvestmentPlan invest;  // takes data in format -
        // balance , monthlyInvest, investIncrement, yearlyInterestRate , yearsUntilRetirement

        RetirementPlan retire;  //takes data in format -
        // balance , interestRate, currentMonthlyExpense , inflation , yearsUntilRetirement, nextTargetYear

        double r=6.0; // interest rate per year , on investment
        double currentYear=2026, retirementYear=2046;
        double time = retirementYear - currentYear;     //Total years of investment

        invest = new InvestmentPlan();
        long totalSaving=invest.beforeRetirementPlan1(0, 20000,5000, r, time);
        long balance=totalSaving;

        retire=new RetirementPlan();
        List<String> data=retire.retirementPlan(balance, 5  , 185000,3 , time, 15);
//        sdata=new SaveData(data,totalSaving);
        System.out.println(data);

    }

}
