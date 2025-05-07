package commonLLDQuestions.splitwise.entities;

import commonLLDQuestions.splitwise.enums.SettlementStatus;

import java.util.UUID;

public class Ledger {

    private String ledgerId;
    private int creditorId;
    private int debitorId;
    private double owedAmount;
    private SettlementStatus settlementStatus;

    public Ledger(int creditorId, int debitorId, double owedAmount) {
        this.ledgerId = UUID.randomUUID().toString();
        this.creditorId = creditorId;
        this.debitorId = debitorId;
        this.owedAmount = owedAmount;
        this.settlementStatus = SettlementStatus.CREATED;
    }

    public String getLedgerId() {
        return ledgerId;
    }

    public int getCreditorId() {
        return creditorId;
    }

    public void setCreditorId(int creditorId) {
        this.creditorId = creditorId;
    }

    public int getDebitorId() {
        return debitorId;
    }

    public void setDebitorId(int debitorId) {
        this.debitorId = debitorId;
    }

    public double getOwedAmount() {
        return owedAmount;
    }

    public void setOwedAmount(double owedAmount) {
        this.owedAmount = owedAmount;
    }

    public SettlementStatus getSettlementStatus() {
        return settlementStatus;
    }

    public void setSettlementStatus(SettlementStatus settlementStatus) {
        this.settlementStatus = settlementStatus;
    }


}
