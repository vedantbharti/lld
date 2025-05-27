package commonLLDQuestions.rideBooking.entity;

import commonLLDQuestions.rideBooking.enums.PaymentStatus;
import commonLLDQuestions.rideBooking.enums.PaymentType;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
public class Payment {

    private final int paymentId;
    private final int bookingId;
    private final double amount;
    private PaymentStatus paymentStatus;
    private PaymentType paymentType;

    public Payment(int paymentId, int bookingId, double amount, PaymentType paymentType) {
        this.paymentId = paymentId;
        this.bookingId = bookingId;
        this.amount = amount;
        this.paymentStatus = PaymentStatus.ACTIVE;
        this.paymentType = paymentType;
    }



}
