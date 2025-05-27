package commonLLDQuestions.rideBooking.strategies;

import commonLLDQuestions.rideBooking.enums.PaymentStatus;

public class CashPaymentStrategy implements PaymentStrategy{


    @Override
    public PaymentStatus makePayment(int amount, int bookingId) {
        return null;
    }
}
