package commonLLDQuestions.carRental.util;

import commonLLDQuestions.carRental.entities.Booking;
import commonLLDQuestions.carRental.entities.Payment;
import commonLLDQuestions.carRental.exception.PaymentFailedException;
import commonLLDQuestions.carRental.service.PaymentService;

import java.util.UUID;

public class PaymentHandler extends Handler{

    PaymentService paymentService;

    public PaymentHandler(){
        paymentService = new PaymentService();
    }
    @Override
    public boolean handleBooking(Booking booking) {

        UUID uuid = UUID.randomUUID();
        String paymentId = uuid.toString();

        Payment payment = new Payment(paymentId,1000.0);
        booking.setPaymentId(payment.getPaymentId());
        if(!paymentService.completePayment(payment)){
            throw new PaymentFailedException("Payment failed!");
        }

        return true;
    }

    @Override
    public void handleCancellation(Booking booking) {

        paymentService.refundAmount(booking.getPaymentId());

        return;
    }
}
