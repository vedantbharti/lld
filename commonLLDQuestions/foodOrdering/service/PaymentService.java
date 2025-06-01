package commonLLDQuestions.foodOrdering.service;

import commonLLDQuestions.foodOrdering.entity.Payment;
import commonLLDQuestions.foodOrdering.enums.PaymentStatus;
import commonLLDQuestions.foodOrdering.repository.PaymentRepo;

public class PaymentService {

    private final PaymentRepo paymentRepo;

    public PaymentService() {
        this.paymentRepo = PaymentRepo.getInstance();
    }

    public synchronized void addPayment(Payment payment) {
        paymentRepo.addPayment(payment);
    }

    public synchronized Payment makePayment(String customerId, double totalAmount) {
        Payment payment = new Payment(totalAmount,customerId);
        payment.setPaymentStatus(PaymentStatus.COMPLETED);
        addPayment(payment);
        return payment;
    }
}
