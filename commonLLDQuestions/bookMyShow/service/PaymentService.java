package commonLLDQuestions.bookMyShow.service;

import commonLLDQuestions.bookMyShow.repository.PaymentRepo;

public class PaymentService {

    private PaymentRepo paymentRepo;

    public PaymentService(){
        this.paymentRepo = PaymentRepo.getInstance();
    }

    public synchronized boolean makePayment(double amount) {

        //not implementing this since this is not the core of the problem
        System.out.println("payment is successful");
        return true;
    }
}
