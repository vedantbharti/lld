package commonLLDQuestions.rideBooking.service;

import commonLLDQuestions.rideBooking.entity.Payment;
import commonLLDQuestions.rideBooking.enums.PaymentStatus;
import commonLLDQuestions.rideBooking.repository.PaymentRepo;
import commonLLDQuestions.rideBooking.strategies.PaymentStrategy;

public class PaymentService {

    private final PaymentRepo paymentRepo;

    public PaymentService(){
        this.paymentRepo = PaymentRepo.getInstance();
    }

    public PaymentStatus makePayment(double amount, String bookingId, PaymentStrategy paymentStrategy){
        Payment payment = paymentStrategy.makePayment(amount, bookingId);
        paymentRepo.addPayment(payment);
        return payment.getPaymentStatus();
    }
}
