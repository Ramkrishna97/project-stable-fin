package com.example.finplanner.model;

/** Combined result of both the before-retirement and at-retirement calculations. */
public class PlanResponse {

    // --- before retirement ---
    private double totalInvestedPrincipal;   // sum of every rupee actually contributed
    private double balanceAtRetirement;      // final balance when you stop working

    // --- at / after retirement ---
    private double futureMonthlyExpense;     // today's expense, inflated forward to retirement day
    private boolean sustainableIndefinitely; // true if interest always covered expenses in the projection
    private double yearsFundsWillLast;       // years simulated (fractional) before the projection ended or money ran out
    private double finalBalanceAfterProjection;

    public double getTotalInvestedPrincipal() { return totalInvestedPrincipal; }
    public void setTotalInvestedPrincipal(double v) { this.totalInvestedPrincipal = v; }

    public double getBalanceAtRetirement() { return balanceAtRetirement; }
    public void setBalanceAtRetirement(double v) { this.balanceAtRetirement = v; }

    public double getFutureMonthlyExpense() { return futureMonthlyExpense; }
    public void setFutureMonthlyExpense(double v) { this.futureMonthlyExpense = v; }

    public boolean isSustainableIndefinitely() { return sustainableIndefinitely; }
    public void setSustainableIndefinitely(boolean v) { this.sustainableIndefinitely = v; }

    public double getYearsFundsWillLast() { return yearsFundsWillLast; }
    public void setYearsFundsWillLast(double v) { this.yearsFundsWillLast = v; }

    public double getFinalBalanceAfterProjection() { return finalBalanceAfterProjection; }
    public void setFinalBalanceAfterProjection(double v) { this.finalBalanceAfterProjection = v; }
}