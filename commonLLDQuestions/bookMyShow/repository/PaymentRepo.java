package commonLLDQuestions.bookMyShow.repository;

import commonLLDQuestions.bookMyShow.entities.Payment;

import java.util.HashMap;
import java.util.Map;

public class PaymentRepo {

    Map<Integer, Payment> payments;

    private PaymentRepo(){
        this.payments = new HashMap<>();
    }

    private static class Initializer {
        private static final PaymentRepo INSTANCE = new PaymentRepo();
    }

    public static PaymentRepo getInstance() {
        return Initializer.INSTANCE;
    }


}
