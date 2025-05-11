package commonLLDQuestions.bookMyShow.service;

import commonLLDQuestions.bookMyShow.repository.TicketRepo;

public class TicketService {

    private TicketRepo ticketRepo;


    public TicketService() {
        this.ticketRepo = TicketRepo.getInstance();
    }
}
