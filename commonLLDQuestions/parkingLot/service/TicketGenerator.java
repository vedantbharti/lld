package commonLLDQuestions.parkingLot.service;

import commonLLDQuestions.parkingLot.dao.Ticket;
import commonLLDQuestions.parkingLot.dao.Vehicle;

public interface TicketGenerator {

    public Ticket generateTicket(Vehicle vehicle, int ticketId);
}
