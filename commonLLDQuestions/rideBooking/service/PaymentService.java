package commonLLDQuestions.rideBooking.service;

import commonLLDQuestions.rideBooking.repository.PaymentRepo;

public class PaymentService {

    private final PaymentRepo paymentRepo;

    public PaymentService(){
        this.paymentRepo = PaymentRepo.getInstance();
    }
}
