package commonLLDQuestions.bookMyShow.service;

import commonLLDQuestions.bookMyShow.repository.PaymentRepo;

public class PaymentService {

    private PaymentRepo paymentRepo;

    public PaymentService(){
        this.paymentRepo = PaymentRepo.getInstance();
    }
}
