package commonLLDQuestions.foodOrdering.entity;

import lombok.Data;

import java.util.UUID;

@Data
public class Payment {

    private String paymentId;
    private double amount;
    private String orderId;


    public Payment(double amount, String orderId) {
        this.paymentId = UUID.randomUUID().toString();
        this.amount = amount;
        this.orderId = orderId;
    }
}
