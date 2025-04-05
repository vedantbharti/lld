package commonLLDQuestions.parkingLot.service;

import commonLLDQuestions.parkingLot.dao.Ticket;

public interface PaymentService {

    public int makePayment(int ticketId);
}
