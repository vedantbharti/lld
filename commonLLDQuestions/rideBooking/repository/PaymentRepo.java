package commonLLDQuestions.rideBooking.repository;

import commonLLDQuestions.rideBooking.entity.Payment;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PaymentRepo {

    private Map<Integer, Payment> payments;

    private PaymentRepo() {
        this.payments = new ConcurrentHashMap<>();
    }

    private static class Initializer {
        private static final PaymentRepo INSTANCE = new PaymentRepo();
    }

    public static PaymentRepo getInstance(){
        return PaymentRepo.Initializer.INSTANCE;
    }
}
