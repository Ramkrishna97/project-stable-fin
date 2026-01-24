package com.example.finstability.service;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class StableFin {

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
        retire.retirementPlan(balance, 6  , 100,3 , time, 15);


    }
//    public static long beforeRetirementPlan(double balance , double monthlyInvest,
//                                            double investIncrement, double yearlyInterestRate ,double yearsUntilRetirement){
//        double monthlyInterestRate=yearlyInterestRate/1200;
//        double interest=0.0;
//        long finalSaving=0L;
//        balance+=monthlyInvest;
//
//        for(int i=0;i<yearsUntilRetirement;i++){
//            if(i%2==0){monthlyInvest+=investIncrement;}
//            interest += balance* monthlyInterestRate*12;
//            balance+=monthlyInvest;
//        }
//        System.out.println("balance after invest : "+balance+"\n interest after invest: "+interest);
//        return finalSaving+=balance+interest;
//    }
//
//    public static void retirementPlan( double balance ,double interestRate,
//                                       double currentMonthlyExpense ,double inflation , double yearsUntilRetirement,
//                                       double nextTargetYear)
//    {
//        /*
//        -calculates required monthly expense by implying inflation to current monthly expense.
//         no monthly investment, as no income
//        -check monthly interest on available lump-sum balance ,
//        -if interest is more than monthly expense , save extra as investment
//        -otherwise, return that available amount not sustainable: calculate how long it will last
//            - for this , withdraw monthly expense from interest , withdraw extra from balance.
//        */
//        List<String>futureData=new ArrayList<>();
//        futureData.add("\nTotal Lump-sum balance saved till retirement: "+balance);
//
//        double futureMonthlyExpense = (currentMonthlyExpense*12* Math.pow((1+inflation/100),yearsUntilRetirement))/12;
//        futureData.add("\nFuture monthly expense, to maintain as per present expenses:"+futureMonthlyExpense);
//
//        double monthly_Interest_On_Total_Saving=balance*interestRate/1200;
//        futureData.add("\nMonthly interest received from saving as income:"+monthly_Interest_On_Total_Saving);
//        System.out.println("\nfuture monthly expense required calculated as : "+futureMonthlyExpense+" \nmonthly_Interest_On_Total_Saving :"+monthly_Interest_On_Total_Saving);
//
//        if(monthly_Interest_On_Total_Saving>futureMonthlyExpense){
//            for(int i=0;i<nextTargetYear;i++){
//                balance+=monthly_Interest_On_Total_Saving-futureMonthlyExpense;
//                futureData.add("\nAvailable balance and interest is enough to last :"+nextTargetYear+" years");
//            }
//        }
//        else{
//            System.out.println("Available amount not sustainable .");
//            int yearsLeft=0;
//            while(balance>0){
//                balance-=futureMonthlyExpense-monthly_Interest_On_Total_Saving;
//                yearsLeft++;
//            }
//            futureData.add("\nAmount will last only for : "+yearsLeft+"  years");
//        }
//        futureData.add("\n");
//        System.out.println(futureData);
//    }


}
