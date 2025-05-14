package commonLLDQuestions.carRental.entities;

import commonLLDQuestions.carRental.enums.PaymentStatus;

public class Payment {

    private String paymentId;
    private double totalAmount;
    private PaymentStatus paymentStatus;

    public Payment(String paymentId, double totalAmount){
        this.paymentId = paymentId;
        this.totalAmount = totalAmount;
        this.paymentStatus = PaymentStatus.PENDING;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
