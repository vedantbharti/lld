package commonLLDQuestions.splitwise.entities;

import commonLLDQuestions.splitwise.enums.ExpenseStatus;

import java.util.List;
import java.util.Map;

public class Expense {

    private int expenseId;
    private int paidByUserId;
    private double amount;
//    private List<Integer> ledgers;
    private ExpenseStatus expenseStatus;
    private Map<Integer,Double> expenseDistribution;

    public Expense(int expenseId, int paidByUserId, double amount, Map<Integer,Double> expenseDistribution) {
        this.expenseId = expenseId;
        this.paidByUserId = paidByUserId;
        this.amount = amount;
        this.expenseDistribution = expenseDistribution;
//        this.ledgers = ledgers;
        this.expenseStatus = ExpenseStatus.CREATED;
    }

    public int getExpenseId() {
        return expenseId;
    }

    public int getPaidByUserId() {
        return paidByUserId;
    }

    public void setPaidByUserId(int paidByUserId) {
        this.paidByUserId = paidByUserId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    //    public List<Integer> getLedgers() {
//        return ledgers;
//    }
//
//    public void setLedgers(List<Integer> ledgers) {
//        this.ledgers = ledgers;
//    }

    public ExpenseStatus getExpenseStatus() {
        return expenseStatus;
    }

    public void setExpenseStatus(ExpenseStatus expenseStatus) {
        this.expenseStatus = expenseStatus;
    }

    public Map<Integer, Double> getExpenseDistribution() {
        return expenseDistribution;
    }

    public void setExpenseDistribution(Map<Integer, Double> expenseDistribution) {
        this.expenseDistribution = expenseDistribution;
    }
}
