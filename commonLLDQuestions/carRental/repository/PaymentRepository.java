package commonLLDQuestions.carRental.repository;

import commonLLDQuestions.carRental.entities.Payment;
import commonLLDQuestions.carRental.enums.PaymentStatus;

import java.util.HashMap;
import java.util.Map;

public class PaymentRepository {

    private Map<String, Payment> payments;

    private PaymentRepository(){
        payments = new HashMap<>();
    }

    private static class Initializer {
        private static final PaymentRepository INSTANCE = new PaymentRepository();
    }

    public static PaymentRepository getInstance() {
        return Initializer.INSTANCE;
    }

    public void addPayment(Payment payment){
        payments.put(payment.getPaymentId(),payment);
    }

    public boolean completePayment(String paymentId) {
        payments.get(paymentId).setPaymentStatus(PaymentStatus.COMPLETED);
        return true;
    }

    public Payment getPaymentDetail(String paymentId) {
        return payments.get(paymentId);
    }
}
