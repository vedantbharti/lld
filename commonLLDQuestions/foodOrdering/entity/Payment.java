package commonLLDQuestions.foodOrdering.entity;

import commonLLDQuestions.foodOrdering.enums.PaymentStatus;
import lombok.Data;

import java.util.UUID;

@Data
public class Payment {

    private String paymentId;
    private double amount;
    private String customerId;
    private PaymentStatus paymentStatus;


    public Payment(double amount, String customerId) {
        this.paymentId = UUID.randomUUID().toString();
        this.amount = amount;
        this.customerId = customerId;
        this.paymentStatus = PaymentStatus.ACTIVE;
    }
}
