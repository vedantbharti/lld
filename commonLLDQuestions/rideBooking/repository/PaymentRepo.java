package commonLLDQuestions.rideBooking.repository;

import commonLLDQuestions.rideBooking.entity.Payment;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PaymentRepo {

    private Map<String, Payment> payments;

    private PaymentRepo() {
        this.payments = new ConcurrentHashMap<>();
    }

    private static class Initializer {
        private static final PaymentRepo INSTANCE = new PaymentRepo();
    }

    public static PaymentRepo getInstance(){
        return PaymentRepo.Initializer.INSTANCE;
    }

    public void addPayment(Payment payment) {
        payments.put(payment.getPaymentId(),payment);
    }
}
