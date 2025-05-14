package commonLLDQuestions.carRental.service;

import commonLLDQuestions.carRental.entities.Payment;
import commonLLDQuestions.carRental.enums.PaymentStatus;
import commonLLDQuestions.carRental.repository.PaymentRepository;

public class PaymentService {

    private PaymentRepository paymentRepository;

    public PaymentService() {
        this.paymentRepository = PaymentRepository.getInstance();
    }

    public void addPayment(Payment payment){
        paymentRepository.addPayment(payment);
    }

    public boolean completePayment(Payment payment) {
        paymentRepository.addPayment(payment);
        return paymentRepository.completePayment(payment.getPaymentId());
    }

    public void refundAmount(String paymentId) {
        paymentRepository.getPaymentDetail(paymentId).setPaymentStatus(PaymentStatus.REFUNDED);
    }

    public Payment getPaymentDetails(String paymentId) {
        return paymentRepository.getPaymentDetail(paymentId);
    }
}
