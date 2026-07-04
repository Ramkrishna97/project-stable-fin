package com.example.finstability.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RetirementPlan {
    public static List<String> retirementPlan(long balance , double interestRate,
                                              double currentMonthlyExpense , double inflation ,
                                              double yearsUntilRetirement,
                                              double nextTargetYear)
    {
        /*
        -calculates required monthly expense by implying inflation to current monthly expense.
         no monthly investment, as no income
        -check monthly interest on available lump-sum balance ,
        -if interest is more than monthly expense , save extra as investment
        -otherwise, return that available amount not sustainable: calculate how long it will last
            - for this , withdraw monthly expense from interest , withdraw extra from balance.
        */

        List<String> futureData=new ArrayList<>();
        futureData.add("\nTotal Lump-sum balance saved till retirement: "+balance);

        double futureMonthlyExpense = (currentMonthlyExpense*12* Math.pow((1+inflation/100),yearsUntilRetirement))/12;
        futureData.add("\nFuture monthly expense, to maintain as per present expenses:"+futureMonthlyExpense);

        double monthly_Interest_On_Total_Saving=balance*interestRate/1200;
        futureData.add("\nMonthly interest received from saving as income:"+monthly_Interest_On_Total_Saving);
        System.out.println("\nfuture monthly expense required calculated as : "+futureMonthlyExpense+" \nmonthly_Interest_On_Total_Saving :"+monthly_Interest_On_Total_Saving);

        if(monthly_Interest_On_Total_Saving>futureMonthlyExpense){
            for(int i=0;i<nextTargetYear;i++){
                balance+=monthly_Interest_On_Total_Saving-futureMonthlyExpense;
//                futureData.add("\nAvailable balance and interest is enough to last :"+nextTargetYear+" years");
            }
            System.out.println("Balance left/accumulated after - "+nextTargetYear+" years is: "+balance);
        }
        else{
            System.out.println("Available amount not sustainable .");
            int yearsLeft=0;
            while(balance>0){
                balance-=futureMonthlyExpense-monthly_Interest_On_Total_Saving;
                yearsLeft++;
            }
            futureData.add("\nAmount will last only for : "+yearsLeft+"  years");
        }
        futureData.add("\n");
        return futureData;
    }
}
