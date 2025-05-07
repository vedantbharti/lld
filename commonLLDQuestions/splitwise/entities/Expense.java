package commonLLDQuestions.splitwise.entities;

import commonLLDQuestions.splitwise.enums.SettlementStatus;

import java.util.List;
import java.util.Map;

public class Expense {

    private int expenseId;
    private int paidByUserId;
    private double amount;
//    private List<Integer> ledgers;
    private SettlementStatus settlementStatus;
    private Map<Integer,Double> expenseDistribution;
    private List<Integer> involvedUserIds;

    public Expense(int expenseId, int paidByUserId, List<Integer> involvedUserIds, int amount, Map<Integer,Double> expenseDistribution) {
        this.expenseId = expenseId;
        this.paidByUserId = paidByUserId;
        this.amount = amount;
        this.expenseDistribution = expenseDistribution;
//        this.ledgers = ledgers;
        this.settlementStatus = SettlementStatus.CREATED;
        this.involvedUserIds = involvedUserIds;
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

    public SettlementStatus getExpenseStatus() {
        return settlementStatus;
    }

    public void setExpenseStatus(SettlementStatus settlementStatus) {
        this.settlementStatus = settlementStatus;
    }

    public Map<Integer, Double> getExpenseDistribution() {
        return expenseDistribution;
    }

    public void setExpenseDistribution(Map<Integer, Double> expenseDistribution) {
        this.expenseDistribution = expenseDistribution;
    }

    public List<Integer> getInvolvedUserIds() {
        return involvedUserIds;
    }

    public void setInvolvedUserIds(List<Integer> involvedUserIds) {
        this.involvedUserIds = involvedUserIds;
    }
}
