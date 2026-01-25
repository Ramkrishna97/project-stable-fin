package com.example.finstability.service;
import com.example.finstability.model.SaveData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class StableFin {
    static SaveData sdata;

    public static void main(String[] args) {
        System.out.println("Financial Stability Module has Awaken.\n");

        /*
        i>.________before retirement_________
        invest monthly / yearly ;
        apply interest monthly / yearly ;
        count balance till retirement.
        increment in invest occur after sometime.

        ii>._______at retirement__________
        balance fixed;
        monthly / yearly withdraw started;
        yearly/monthly interest adds ;      if interest is more that withdraw, re-invest it.

        iii>._______give suggestion________
        if, saved balance doesn't meet expectation , suggest what to do-
         - need to increate investment ?
         - what target investment will give desired result.
        */

        InvestmentPlan invest;  // takes dat in format -
        // balance , monthlyInvest, investIncrement, yearlyInterestRate , yearsUntilRetirement
        RetirementPlan retire;  //takes in format -
        // balance , interestRate, currentMonthlyExpense , inflation , yearsUntilRetirement, nextTargetYear
        double r=6.0; // interest rate per year , on investment
        double currentYear=2026, retirementYear=2046;
        double time = retirementYear - currentYear;

        invest = new InvestmentPlan();
        long totalSaving=invest.beforeRetirementPlan(0.0, 10000,5000, r, time);
        double balance=totalSaving;

        retire=new RetirementPlan();
        List<String> data=retire.retirementPlan(balance, 6  , 100,3 , time, 15);
        sdata=new SaveData(data,totalSaving);
        System.out.println(data);

    }

}
