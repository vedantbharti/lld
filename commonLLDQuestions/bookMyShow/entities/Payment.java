package commonLLDQuestions.bookMyShow.entities;

import commonLLDQuestions.bookMyShow.enums.PaymentStatus;

public class Payment {

    private int paymentId;
    private PaymentStatus paymentStatus;
    private double amount;

    public Payment(int paymentId, double amount) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.paymentStatus = PaymentStatus.ACTIVE;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
