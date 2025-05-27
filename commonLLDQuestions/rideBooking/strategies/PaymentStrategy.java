package commonLLDQuestions.rideBooking.strategies;

import commonLLDQuestions.rideBooking.enums.PaymentStatus;

public interface PaymentStrategy {

    public PaymentStatus makePayment(int amount, int bookingId);
}
