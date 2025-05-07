package commonLLDQuestions.splitwise.models;

import java.util.HashMap;
import java.util.Map;

public class UserBalanceSheet {

    private Map<Integer, Double> userVsBalance;
    private double totalExpense;
    private double amountOwed;


    public UserBalanceSheet(){
        this.userVsBalance = new HashMap<>();
        this.totalExpense = 0;
        this.amountOwed = 0;

    }

    public Map<Integer, Double> getUserVsBalance() {
        return userVsBalance;
    }

    public void setUserVsBalance(Map<Integer, Double> userVsBalance) {
        this.userVsBalance = userVsBalance;
    }

    public double getTotalExpense() {
        return totalExpense;
    }

    public void setTotalExpense(double totalExpense) {
        this.totalExpense = totalExpense;
    }

    public double getAmountOwed() {
        return amountOwed;
    }

    public void setAmountOwed(double amountOwed) {
        this.amountOwed = amountOwed;
    }

}
