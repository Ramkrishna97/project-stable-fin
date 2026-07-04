package com.example.finstability.service;

import com.example.finplanner.model.PlanRequest;
import com.example.finplanner.model.PlanResponse;
import org.springframework.stereotype.Service;

/**
 * Holds both pieces of the financial-planning logic, extracted from the
 * original StableFinModule methods:
 *   - calculateBeforeRetirement(...)  <- was beforeRetirementPlan(...)
 *   - calculateAtRetirement(...)      <- was retirementPlan(...)
 * <p>
 * Both methods compound monthly (not annually) since money is invested and
 * withdrawn monthly in real life. Compounding once a year after adding all
 * 12 months of contributions at once overstates growth, because a
 * contribution made in month 11 would wrongly earn a full year of interest.
 */
@Service
public class FinancialPlanningService {
    public PlanResponse calculateBeforeRetirement(PlanRequest input, PlanResponse response) {
        double balance = input.getStartingBalance();
        double monthlyInvestment = input.getMonthlyInvestment();
        double totalPrincipalInvested = balance;

        double monthlyRate = input.getBeforeRetirementInterestRate() / 100.0 / 12.0;
        int totalMonths = (int) Math.round(input.getYearsUntilRetirement() * 12);

        for (int month = 1; month <= totalMonths; month++) {
            balance += monthlyInvestment;
            totalPrincipalInvested += monthlyInvestment;

            balance += balance * monthlyRate;

            if (month % 24 == 0) {
                monthlyInvestment += input.getInvestmentIncrement();
            }
        }

        response.setTotalInvestedPrincipal(totalPrincipalInvested);
        response.setBalanceAtRetirement(balance);
        return response;
    }

    /**
     * Projects how long the retirement balance lasts once withdrawals begin,
     * month by month. Each month: earn interest on the current balance; if it
     * covers that month's expense, reinvest the leftover into the balance;
     * otherwise withdraw the shortfall from the balance itself.
     * <p>
     * Note: the original retirementPlan() had a loop that always exited after one
     * iteration (an unconditional break) and computed interest only once up front
     * using the annual rate. This version genuinely loops every month for the
     * requested number of years and recalculates interest against the current
     * balance each time, which is what "apply interest monthly, reinvest the
     * extra" actually requires.
     */
    public PlanResponse calculateAtRetirement(PlanRequest input, PlanResponse response) {
        // Today's expense is inflated forward to a single point in time (retirement day) -
        // this is a one-off projection, not a loop, so annual compounding here is standard.
        double futureMonthlyExpense = input.getCurrentMonthlyExpense()
                * Math.pow(1 + input.getInflationRate() / 100.0, input.getYearsUntilRetirement());

        double balance = response.getBalanceAtRetirement();
        double monthlyRate = input.getAfterRetirementInterestRate() / 100.0 / 12.0;
        int totalMonths = (int) Math.round(input.getYearsToProject() * 12);

        boolean everRanShort = false;
        int monthsSimulated = 0;

        for (int month = 1; month <= totalMonths; month++) {
            double interestForMonth = balance * monthlyRate;

            if (interestForMonth >= futureMonthlyExpense) {
                balance += interestForMonth - futureMonthlyExpense; // reinvest the surplus
            } else {
                balance -= futureMonthlyExpense - interestForMonth; // withdraw the shortfall
                everRanShort = true;
            }

            monthsSimulated = month;
            if (balance <= 0) {
                balance = 0;
                break;
            }
        }

        response.setFutureMonthlyExpense(futureMonthlyExpense);
        response.setYearsFundsWillLast(monthsSimulated / 12.0);
        response.setFinalBalanceAfterProjection(balance);
        response.setSustainableIndefinitely(!everRanShort && balance > 0);
        return response;
    }
}