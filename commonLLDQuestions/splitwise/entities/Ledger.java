package commonLLDQuestions.splitwise.entities;

import java.util.UUID;

public class Ledger {

    private String ledgerId;
    private int userId;
    private int owedFromUserId;
    private double owedAmount;

    public Ledger(int userId, int owedFromUserId, double owedAmount) {
        this.ledgerId = UUID.randomUUID().toString();
        this.userId = userId;
        this.owedFromUserId = owedFromUserId;
        this.owedAmount = owedAmount;
    }

    public String getLedgerId() {
        return ledgerId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getOwedFromUserId() {
        return owedFromUserId;
    }

    public void setOwedFromUserId(int owedFromUserId) {
        this.owedFromUserId = owedFromUserId;
    }

    public double getOwedAmount() {
        return owedAmount;
    }

    public void setOwedAmount(double owedAmount) {
        this.owedAmount = owedAmount;
    }
}
