package commonLLDQuestions.rideBooking.strategies;

import commonLLDQuestions.rideBooking.entity.Payment;
import commonLLDQuestions.rideBooking.enums.PaymentStatus;

public interface PaymentStrategy {

    public Payment makePayment(double amount, String bookingId);
}
