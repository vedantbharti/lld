package commonLLDQuestions.rideBooking.entity;

import commonLLDQuestions.rideBooking.enums.PaymentStatus;
import commonLLDQuestions.rideBooking.enums.PaymentType;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Data
public class Payment {

    private final String paymentId;
    private final String bookingId;
    private final double amount;
    private PaymentStatus paymentStatus;
    private PaymentType paymentType;

    public Payment(String bookingId, double amount, PaymentType paymentType) {
        this.paymentId = UUID.randomUUID().toString();
        this.bookingId = bookingId;
        this.amount = amount;
        this.paymentStatus = PaymentStatus.ACTIVE;
        this.paymentType = paymentType;
    }



}
