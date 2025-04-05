package commonLLDQuestions.parkingLot.service;

import commonLLDQuestions.parkingLot.dao.Ticket;

public interface TicketGenerator {

    public Ticket generateTicket(String vehicleNo, int spotId, int ticketId);
}
