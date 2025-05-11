package commonLLDQuestions.bookMyShow.repository;

import commonLLDQuestions.bookMyShow.entities.Ticket;

import java.util.HashMap;
import java.util.Map;

public class TicketRepo {

    Map<Integer, Ticket> tickets;

    private TicketRepo(){
        this.tickets = new HashMap<>();
    }

    private static class Initializer {
        private static final TicketRepo INSTANCE = new TicketRepo();
    }

    public static TicketRepo getInstance() {
        return TicketRepo.Initializer.INSTANCE;
    }
}
