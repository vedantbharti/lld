package commonLLDQuestions.rideBooking.strategies;

import commonLLDQuestions.rideBooking.entity.Payment;
import commonLLDQuestions.rideBooking.enums.PaymentStatus;
import commonLLDQuestions.rideBooking.enums.PaymentType;

public class CardPaymentStrategy implements PaymentStrategy{


    @Override
    public Payment makePayment(double amount, String bookingId) {
        Payment payment = new Payment(bookingId, amount, PaymentType.CARD);
        payment.setPaymentStatus(PaymentStatus.COMPLETED);

        return payment;
    }
}
