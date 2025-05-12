package commonLLDQuestions.bookMyShow.service;

import commonLLDQuestions.bookMyShow.entities.Show;
import commonLLDQuestions.bookMyShow.entities.Ticket;
import commonLLDQuestions.bookMyShow.enums.SeatStatus;
import commonLLDQuestions.bookMyShow.exceptions.SeatAlreadyBookedException;
import commonLLDQuestions.bookMyShow.exceptions.TicketGenerationFailedException;
import commonLLDQuestions.bookMyShow.models.Seat;
import commonLLDQuestions.bookMyShow.repository.TicketRepo;

import java.util.List;

public class TicketService {

    private TicketRepo ticketRepo;
    private PaymentService paymentService;


    public TicketService() {
        this.ticketRepo = TicketRepo.getInstance();
        this.paymentService = new PaymentService();
    }

    public synchronized Ticket bookTicket(Show show, List<Seat> seats) {
        double totalCost = seats.stream().map(seat -> seat.getSeatType().getPrice()).reduce(0.0,Double::sum);
        boolean occupied = seats.stream().anyMatch(seat -> seat.getSeatStatus()==SeatStatus.BOOKED);
        if(occupied) {
            System.out.println("seat combination is already booked!");
            throw new SeatAlreadyBookedException("Some of the seats are already booked!");
        }
        seats.stream().forEach(seat -> {
            seat.setSeatStatus(SeatStatus.BOOKED);
            show.getScreen().getBookedSeats().add(seat);
        });
        boolean paymentStatus = paymentService.makePayment(totalCost);
        if(paymentStatus) {
            Ticket ticket = new Ticket(1,show,seats,totalCost);
            //this step can be avoided if we don't want to store all the tickets generated
            //if that's the case, make Ticket a normal class rather than an entity, and remove id field from it
            ticketRepo.addTicket(ticket);
            return ticket;
        } else {
            seats.stream().forEach(seat -> {
                seat.setSeatStatus(SeatStatus.AVAILABLE);
                show.getScreen().getBookedSeats().remove(seat);
            });
            throw new TicketGenerationFailedException("Ticket could not be generated!");
        }

    }
}
